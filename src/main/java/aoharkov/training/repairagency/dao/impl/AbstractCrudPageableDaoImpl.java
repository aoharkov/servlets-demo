package aoharkov.training.repairagency.dao.impl;

import aoharkov.training.repairagency.dao.CrudPageableDao;
import aoharkov.training.repairagency.dao.connector.Connector;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.dao.exception.DataBaseSqlRuntimeException;
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

import static aoharkov.training.repairagency.dao.util.PageCalculator.calculateMaxPageNumber;
import static aoharkov.training.repairagency.dao.util.PageCalculator.calculateOffset;
import static aoharkov.training.repairagency.dao.util.PageCalculator.fitPageNumber;

public abstract class AbstractCrudPageableDaoImpl<E> implements CrudPageableDao<E> {
    private static final Logger LOGGER = LogManager.getLogger(AbstractCrudPageableDaoImpl.class);

    static final BiConsumer<PreparedStatement, Integer> INT_PARAM_SETTER = ((preparedStatement, integer) -> {
        try {
            preparedStatement.setInt(1, integer);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    });
    static final BiConsumer<PreparedStatement, String> STRING_PARAM_SETTER = ((preparedStatement, str) -> {
        try {
            preparedStatement.setString(1, str);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
    });
    private static final String EXECUTE_QUERY_ERROR = "executeQuery error";
    private static final String DB_CONNECTION_PROBLEM = "db connection problem";
    protected final Connector connector;
    private final String saveQuery;
    private final String findByIdQuery;
    private final String findAllAtPageQuery;
    private final String defaultCountQuery;
    private final String updateQuery;

    AbstractCrudPageableDaoImpl(Connector connector, String saveQuery, String findByIdQuery, String findAllAtPageQuery, String defaultCountQuery, String updateQuery) {
        this.connector = connector;
        this.saveQuery = saveQuery;
        this.findByIdQuery = findByIdQuery;
        this.findAllAtPageQuery = findAllAtPageQuery;
        this.defaultCountQuery = defaultCountQuery;
        this.updateQuery = updateQuery;
    }

    @Override
    public void save(E entity) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(saveQuery)) {

            fillPreparedStatementForSaveQuery(preparedStatement, entity);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.error(DB_CONNECTION_PROBLEM, e);
            throw new DataBaseSqlRuntimeException(DB_CONNECTION_PROBLEM);
        }
    }

    protected abstract void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, E entity) throws SQLException;

    @Override
    public Optional<E> findById(Integer id) {
        return findByParam(id, findByIdQuery, INT_PARAM_SETTER);
    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    <P> Optional<E> findByParam(P param, String sqlQuery,
                                BiConsumer<PreparedStatement, P> designedParamSetting) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(sqlQuery)) {

            designedParamSetting.accept(preparedStatement, param);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            } catch (SQLException e) {
                LOGGER.error(EXECUTE_QUERY_ERROR, e);
                throw new DataBaseSqlRuntimeException(EXECUTE_QUERY_ERROR);
            }

        } catch (SQLException e) {
            LOGGER.error(DB_CONNECTION_PROBLEM, e);
            throw new DataBaseSqlRuntimeException(DB_CONNECTION_PROBLEM);
        }
        return Optional.empty();
    }

    @Override
    public Page<E> findAll(int pageNumber, int itemsPerPage) {
        return findAll(pageNumber, itemsPerPage, findAllAtPageQuery);
    }

    @Override
    public Page<E> findAll(int pageNumber, int itemsPerPage, String query) {
        return findAll(pageNumber, itemsPerPage, query, false, defaultCountQuery);
    }

    @Override
    public Page<E> findAllByForeignId(int pageNumber, int itemsPerPage, int foreignId, String query, String customCountQuery) {
        return findAll(pageNumber, itemsPerPage, query, true, customCountQuery, foreignId);
    }

    private Page<E> findAll(int pageNumber, int itemsPerPage, String query, boolean withForeignId, String queryForCount,
                            Integer... identifiers) {
        int maxPageNumber = calculateMaxPageNumber(itemsPerPage, count(queryForCount));
        pageNumber = fitPageNumber(pageNumber, maxPageNumber);
        int offset = calculateOffset(pageNumber, itemsPerPage);

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (withForeignId) {
                preparedStatement.setInt(1, identifiers[0]);
                preparedStatement.setInt(2, offset);
                preparedStatement.setInt(3, itemsPerPage);
            } else {
                preparedStatement.setInt(1, offset);
                preparedStatement.setInt(2, itemsPerPage);
            }

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<E> entities = new ArrayList<>();
                while (resultSet.next()) {
                    entities.add(mapResultSetToEntity(resultSet));
                }
                return Page.<E>builder()
                        .withItems(entities)
                        .withPageNumber(pageNumber)
                        .withItemsNumberPerPage(itemsPerPage)
                        .withMaxPageNumber(maxPageNumber)
                        .build();
            } catch (SQLException e) {
                LOGGER.error(EXECUTE_QUERY_ERROR, e);
                throw new DataBaseSqlRuntimeException(EXECUTE_QUERY_ERROR);
            }

        } catch (SQLException e) {
            LOGGER.error(DB_CONNECTION_PROBLEM, e);
            throw new DataBaseSqlRuntimeException(DB_CONNECTION_PROBLEM);
        }
    }

    @Override
    public int count() {
        return count(defaultCountQuery);
    }

    @Override
    public int count(String query) {
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                resultSet.next();
                return resultSet.getInt("rowcount");
            } catch (SQLException e) {
                LOGGER.error(EXECUTE_QUERY_ERROR, e);
                throw new DataBaseSqlRuntimeException(EXECUTE_QUERY_ERROR);
            }

        } catch (SQLException e) {
            LOGGER.error(DB_CONNECTION_PROBLEM, e);
            throw new DataBaseSqlRuntimeException(DB_CONNECTION_PROBLEM);
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
}
