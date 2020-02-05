package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserDaoImpl extends AbstractCrudPageableDaoImpl<User> implements UserDao {
    private static final String SAVE_QUERY =
            "INSERT INTO users (name, surname, email, password, role) values(?, ?, ?, ?, ?)";
    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email = ?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id = ?";
    private static final String FIND_ALL_AT_PAGE_QUERY = "SELECT * FROM users LIMIT ?, ?";
    private static final String COUNT_ALL_QUERY = "SELECT COUNT(*) AS rowcount FROM users";
    private static final String UPDATE_QUERY =
            "UPDATE users SET name = ?, surname = ?, email = ?, password = ?, role = ? WHERE id = ?";

    public UserDaoImpl(Connector connector) {
        super(connector, SAVE_QUERY, FIND_BY_ID_QUERY, FIND_ALL_AT_PAGE_QUERY, COUNT_ALL_QUERY, UPDATE_QUERY);
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return User.builder()
                .withId(resultSet.getInt("id"))
                .withName(resultSet.getString("name"))
                .withSurname(resultSet.getString("surname"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withRole(Role.valueOf(resultSet.getString("role")))
                .build();
    }

    @Override
    protected void fillPreparedStatementForSaveQuery(PreparedStatement preparedStatement, User entity) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurname());
        preparedStatement.setString(3, entity.getEmail());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getRole().name());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return findByParam(email, FIND_BY_EMAIL_QUERY, STRING_PARAM_SETTER);
    }

    @Override
    protected void fillPreparedStatementForUpdateQuery(PreparedStatement preparedStatement, User entity) throws SQLException {
        preparedStatement.setString(1, entity.getName());
        preparedStatement.setString(2, entity.getSurname());
        preparedStatement.setString(3, entity.getEmail());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getRole().name());
        preparedStatement.setInt(6, entity.getId());
    }
}
