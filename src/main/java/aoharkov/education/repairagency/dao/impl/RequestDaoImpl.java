package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.util.connector.Connector;
import aoharkov.education.repairagency.entity.Request;
import aoharkov.education.repairagency.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDaoImpl extends AbstractCrudPageableDaoImpl<Request> implements RequestDao {
    private static final String SAVE_QUERY =
            "INSERT INTO requests (id, client_id, description, viewed, accepted) values(?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM requests WHERE id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM requests LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM requests";
    private static final String UPDATE_QUERY =
            "UPDATE requests SET client_id = ?, description = ?, viewed = ?, accepted = ?, WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM requests WHERE id = ?";

    public RequestDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, Request entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setInt(2, entity.getClient().getId());
        preparedStatement.setString(3, entity.getDescription());
        preparedStatement.setBoolean(4, entity.getViewed());
        preparedStatement.setBoolean(5, entity.getAccepted());
    }

    @Override
    protected Request mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Request.builder()
                .withId(resultSet.getInt("id"))
                .withClient(getUserById(resultSet.getInt("client_id")))
                .withDescription(resultSet.getString("description"))
                .withViewed(resultSet.getBoolean("viewed"))
                .withAccepted(resultSet.getBoolean("accepted"))
                .build();
    }

    private User getUserById(Integer id) {
        //todo
        return null;
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, Request entity) throws SQLException {
        preparedStatement.setInt(1, entity.getClient().getId());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setBoolean(3, entity.getViewed());
        preparedStatement.setBoolean(4, entity.getAccepted());
        preparedStatement.setInt(5, entity.getId());
    }

    @Override
    protected void fillPreparedStatementForDeleteByIdQuery(PreparedStatement preparedStatement, Request entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
    }
}
