package aoharkov.education.repairagency.dao.util.connector;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class HikariCPImpl implements Connector {
    private static final Logger LOGGER = LogManager.getLogger(HikariCPImpl.class);
    private HikariDataSource dataSource;

    public HikariCPImpl(String configFileName) {
        ResourceBundle resource = PropertyResourceBundle.getBundle(configFileName);
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(resource.getString("db.url"));
        config.setUsername(resource.getString("db.user"));
        config.setPassword(resource.getString("db.password"));
        config.addDataSourceProperty("cachePrepStmts", resource.getString("db.cachePrepStmts"));
        config.addDataSourceProperty("prepStmtCacheSize", resource.getString("db.prepStmtCacheSize"));
        config.addDataSourceProperty("prepStmtCacheSqlLimit", resource.getString("db.prepStmtCacheSqlLimit"));
        dataSource = new HikariDataSource(config);
    }

    @Override
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
