package aoharkov.training.repairagency.dao.impl;

import aoharkov.training.repairagency.dao.RefusalDao;
import aoharkov.training.repairagency.dao.connector.Connector;
import aoharkov.training.repairagency.entity.RefusalEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RefusalDaoImpl extends AbstractCrudPageableDaoImpl<RefusalEntity> implements RefusalDao {
    private static final String SAVE_QUERY =
            "INSERT INTO refusals (request_id, explanation, manager_id) values(?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM refusals WHERE id = ?";
    private static final String FIND_BY_REQUEST_ID_QUERY = "SELECT * FROM refusals WHERE request_id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM refusals LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM refusals";
    private static final String UPDATE_QUERY =
            "UPDATE refusals SET request_id = ?, explanation = ?, manager_id = ? WHERE id = ?";

    public RefusalDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY);
    }

    @Override
    public Optional<RefusalEntity> findByRequestId(Integer requestId) {
        return findByParam(requestId, FIND_BY_REQUEST_ID_QUERY, INT_PARAM_SETTER);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, RefusalEntity entity) throws SQLException {
        preparedStatement.setInt(1, entity.getRequestId());
        preparedStatement.setString(2, entity.getExplanation());
        preparedStatement.setInt(3, entity.getManagerId());
    }

    @Override
    protected RefusalEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return RefusalEntity.builder()
                .withId(resultSet.getInt("id"))
                .withRequestId(resultSet.getInt("request_id"))
                .withExplanation(resultSet.getString("explanation"))
                .withManagerId(resultSet.getInt("manager_id"))
                .build();
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, RefusalEntity entity) throws SQLException {
        preparedStatement.setInt(1, entity.getRequestId());
        preparedStatement.setString(2, entity.getExplanation());
        preparedStatement.setInt(3, entity.getManagerId());
        preparedStatement.setInt(4, entity.getId());
    }
}
