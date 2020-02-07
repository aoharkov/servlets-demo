package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.entity.FeedbackEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedbackDaoImpl extends AbstractCrudPageableDaoImpl<FeedbackEntity> implements FeedbackDao {
    private static final String SAVE_QUERY = "INSERT INTO feedback (request_id, text, score) values(?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM feedback WHERE id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM feedback LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM feedback";
    private static final String UPDATE_QUERY = "UPDATE feedback SET request_id = ?, text = ?, score = ? WHERE id = ?";

    public FeedbackDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, FeedbackEntity entity) throws SQLException {
        preparedStatement.setInt(1, entity.getRequestId());
        preparedStatement.setString(2, entity.getText());
        preparedStatement.setInt(3, entity.getScore());
    }

    @Override
    protected FeedbackEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return FeedbackEntity.builder()
                .withId(resultSet.getInt("id"))
                .withRequestId(resultSet.getInt("request_id"))
                .withText(resultSet.getString("text"))
                .withScore(resultSet.getInt("score"))
                .build();
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, FeedbackEntity entity) throws SQLException {
        preparedStatement.setInt(1, entity.getRequestId());
        preparedStatement.setString(2, entity.getText());
        preparedStatement.setInt(3, entity.getScore());
        preparedStatement.setInt(4, entity.getId());
    }
}
