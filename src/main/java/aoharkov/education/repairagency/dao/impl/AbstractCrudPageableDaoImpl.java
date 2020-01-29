package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.CrudPageableDao;
import aoharkov.education.repairagency.dao.domain.Pageable;
import aoharkov.education.repairagency.dao.domain.PageableImpl;
import aoharkov.education.repairagency.dao.util.HikariCPImpl;
import aoharkov.education.repairagency.dao.util.DataBaseSqlRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;

public abstract class AbstractCrudPageableDaoImpl<E> implements CrudPageableDao<E> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractCrudPageableDaoImpl.class);

    protected static final BiConsumer<PreparedStatement, Integer> INT_PARAM_SETTER = ((preparedStatement, integer) -> {
        try {
            preparedStatement.setInt(1, integer);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    });

    protected static final BiConsumer<PreparedStatement, String> STRING_PARAM_SETTER = ((preparedStatement, str) -> {
        try {
            preparedStatement.setString(1, str);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    });

    protected final HikariCPImpl connector;
    private final String saveQuery;
    private final String findByIdQuery;
    private final String findAllAtPageQuery;
    private final String countQuery;
    private final String updateQuery;
    private final String deleteQuery;

    public AbstractCrudPageableDaoImpl(HikariCPImpl connector, String saveQuery, String findByIdQuery, String findAllAtPageQuery, String countQuery, String updateQuery, String deleteQuery) {
        this.connector = connector;
        this.saveQuery = saveQuery;
        this.findByIdQuery = findByIdQuery;
        this.findAllAtPageQuery = findAllAtPageQuery;
        this.countQuery = countQuery;
        this.updateQuery = updateQuery;
        this.deleteQuery = deleteQuery;
    }

    @Override
    public void save(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveQuery)) {

            fillPreparedStatementForSaveQuery(preparedStatement, entity);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    protected abstract void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, E entity) throws SQLException;

    @Override
    public Optional<E> findById(Integer id) {
        return findByParam(id, findByIdQuery, INT_PARAM_SETTER);
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    protected <P> Optional<E> findByParam(P param, String sqlQuery,
                                          BiConsumer<PreparedStatement, P> designedParamSetting) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(sqlQuery)) {

            designedParamSetting.accept(preparedStatement, param);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public Pageable<E> findAll(int pageNumber, int itemsPerPage) {
        int maxPageNumber = (count() + itemsPerPage - 1) / itemsPerPage;
        if (pageNumber > maxPageNumber) {
            pageNumber = maxPageNumber;
        }
        if (pageNumber < 1) {
            pageNumber = 1;
        }
        int offset = (pageNumber - 1) * itemsPerPage;

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(findAllAtPageQuery)) {

            preparedStatement.setInt(1, offset);
            preparedStatement.setInt(2, itemsPerPage);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<E> entities = new ArrayList<>();
                while (resultSet.next()) {
                    entities.add(mapResultSetToEntity(resultSet));
                }
                return PageableImpl.<E>builder()
                        .withItems(entities)
                        .withPageNumber(pageNumber)
                        .withItemsNumberPerPage(itemsPerPage)
                        .withMaxPageNumber(maxPageNumber)
                        .build();
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public int count() {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(countQuery)) {

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.getInt("rowcount");
            }

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public void update(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

            fillPreparedStatementForUpdateQuery(preparedStatement, entity);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            throw new DataBaseSqlRuntimeException(e.getMessage(), e);
        }
    }

    protected abstract void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, E entity) throws SQLException;

    @Override
    public void deleteById(Integer id) {
        Optional<E> entity = findById(id);
        if (entity.isPresent()) {
            try (Connection connection = connector.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                fillPreparedStatementForDeleteByIdQuery(preparedStatement, entity.get());
                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                LOGGER.error(e.getMessage());
                throw new DataBaseSqlRuntimeException(e.getMessage(), e);
            }
        }
    }

    protected abstract void fillPreparedStatementForDeleteByIdQuery(PreparedStatement preparedStatement, E entity) throws SQLException;
}
