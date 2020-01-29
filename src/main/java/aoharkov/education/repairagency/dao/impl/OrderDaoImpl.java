package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.util.ConnectorToDB;
import aoharkov.education.repairagency.entity.Order;
import aoharkov.education.repairagency.entity.RepairStage;
import aoharkov.education.repairagency.entity.Request;
import aoharkov.education.repairagency.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDaoImpl extends AbstractCrudPageableDaoImpl<Order> implements OrderDao {
    private static final String SAVE_QUERY =
            "INSERT INTO orders (id, request_id, manager_id, price, master_id, repair_stage_id) values(?, ?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM orders WHERE id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM orders LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(id) AS rowcount FROM orders";
    private static final String UPDATE_QUERY =
            "UPDATE orders SET request_id = ?, manager_id = ?, price = ?, master_id = ?, repair_stage_id = ?, WHERE id = ?";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM orders WHERE id = ?";

    public OrderDaoImpl(ConnectorToDB connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY, DELETE_BY_ID_QUERY);
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, Order entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
        preparedStatement.setInt(2, entity.getRequest().getId());
        preparedStatement.setInt(3, entity.getManager().getId());
        preparedStatement.setInt(4, entity.getPrice());
        preparedStatement.setInt(5, entity.getMaster().getId());
        preparedStatement.setInt(6, entity.getRepairStage().getId());
    }

    @Override
    protected Order mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return Order.builder()
                .withId(resultSet.getInt("id"))
                .withRequest(getRequestById(resultSet.getInt("request_id")))
                .withManager(getUserById(resultSet.getInt("manager_id")))
                .withPrice(resultSet.getInt("price"))
                .withMaster(getUserById(resultSet.getInt("master_id")))
                .withRepairStatus(getRepairStageById(resultSet.getInt("repair_stage_id")))
                .build();
    }

    @Override
    public Request getRequestById(Integer id) {
        //todo
        return null;
    }

    private User getUserById(Integer id) {
        //todo
        return null;
    }

    private RepairStage getRepairStageById(Integer id) {
        //todo
        return null;
    }


    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, Order entity) throws SQLException {
        preparedStatement.setInt(1, entity.getRequest().getId());
        preparedStatement.setInt(2, entity.getManager().getId());
        preparedStatement.setInt(3, entity.getPrice());
        preparedStatement.setInt(4, entity.getMaster().getId());
        preparedStatement.setInt(5, entity.getRepairStage().getId());
        preparedStatement.setInt(6, entity.getId());
    }

    @Override
    protected void fillPreparedStatementForDeleteByIdQuery(PreparedStatement preparedStatement, Order entity) throws SQLException {
        preparedStatement.setInt(1, entity.getId());
    }
}
