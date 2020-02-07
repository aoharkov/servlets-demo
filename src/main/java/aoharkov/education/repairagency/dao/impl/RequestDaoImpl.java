package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.entity.RequestEntity;
import aoharkov.education.repairagency.entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class RequestDaoImpl extends AbstractCrudPageableDaoImpl<RequestEntity> implements RequestDao {
    private static final String SAVE_QUERY =
            "INSERT INTO requests (client_id, description, viewed, accepted) values(?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM requests WHERE id = ?";
    private static final String FIND_BY_CLIENT_ID_QUERY = "SELECT * FROM requests WHERE client_id = ? LIMIT ?, ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM requests LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM requests";
    private static final String COUNT_QUERY_FORMAT = "SELECT COUNT(id) AS rowcount FROM requests WHERE client_id = %d";
    private static final String UPDATE_QUERY =
            "UPDATE requests SET client_id = ?, description = ?, viewed = ?, accepted = ? WHERE id = ?";

    public RequestDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY);
    }

    @Override
    public Page<RequestEntity> findAllByClientId(int pageNumber, int itemsPerPage, int clientId) {
        String countQuery = String.format(COUNT_QUERY_FORMAT, clientId);
        return findAllByForeignId(pageNumber, itemsPerPage, clientId, FIND_BY_CLIENT_ID_QUERY, countQuery);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, RequestEntity entity) throws SQLException {
        preparedStatement.setInt(1, entity.getClientId());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setBoolean(3, entity.getViewed());
        preparedStatement.setBoolean(4, entity.getAccepted());
    }

    @Override
    protected RequestEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return RequestEntity.builder()
                .withId(resultSet.getInt("id"))
                .withClientId(resultSet.getInt("client_id"))
                .withDescription(resultSet.getString("description"))
                .withViewed(resultSet.getBoolean("viewed"))
                .withAccepted(resultSet.getBoolean("accepted"))
                .build();
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, RequestEntity entity) throws SQLException {
        preparedStatement.setInt(1, entity.getClientId());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setBoolean(3, entity.getViewed());
        preparedStatement.setBoolean(4, entity.getAccepted());
        preparedStatement.setInt(5, entity.getId());
    }
}
