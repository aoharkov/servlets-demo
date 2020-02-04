package aoharkov.education.repairagency.dao.connector;

import aoharkov.education.repairagency.dao.exception.DataBaseSqlRuntimeException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class HikariCP implements Connector {
    private static final Logger LOGGER = LogManager.getLogger(HikariCP.class);
    private final HikariDataSource dataSource;

    public HikariCP(String configFileName) {
        ResourceBundle resource = PropertyResourceBundle.getBundle(configFileName);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(resource.getString("db.url"));
        config.setUsername(resource.getString("db.user"));
        config.setPassword(resource.getString("db.password"));
        dataSource = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error("no connection", e);
            throw new DataBaseSqlRuntimeException("no connection");
        }
    }
}
