package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.entity.RepairStage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepairStageDaoImpl extends AbstractCrudPageableDaoImpl<RepairStage> implements RepairStageDao {
    private static final String SAVE_QUERY = "INSERT INTO repair_stages (name) values(?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM repair_stages WHERE id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM repair_stages LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM repair_stages";
    private static final String UPDATE_QUERY = "UPDATE repair_stages SET name = ? WHERE id = ?";

    public RepairStageDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, RepairStage entity) throws SQLException {
        preparedStatement.setString(1, entity.getName());
    }

    @Override
    protected RepairStage mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new RepairStage(resultSet.getInt("id"), resultSet.getString("name"));
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, RepairStage entity) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setInt(2, entity.getId());
    }
}
