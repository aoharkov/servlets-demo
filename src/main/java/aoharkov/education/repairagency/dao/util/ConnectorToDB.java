package aoharkov.education.repairagency.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorToDB {
    private final String url;
    private final String user;
    private final String password;

    public ConnectorToDB(String fileName) {
        ResourceBundle resource = ResourceBundle.getBundle(fileName);
        this.url = resource.getString("db.url");
        this.user = resource.getString("db.user");
        this.password = resource.getString("db.password");
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
