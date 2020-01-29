package aoharkov.education.repairagency.dao.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class HikariCPImpl {
    private static final Logger LOGGER = LogManager.getLogger(HikariCPImpl.class);

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    private static ResourceBundle resource = PropertyResourceBundle.getBundle("database");

    static {
        config.setJdbcUrl(resource.getString("db.url"));
        config.setUsername(resource.getString("db.user"));
        config.setPassword(resource.getString("db.password"));
        config.addDataSourceProperty("cachePrepStmts", resource.getString("db.cachePrepStmts"));
        config.addDataSourceProperty("prepStmtCacheSize", resource.getString("db.prepStmtCacheSize"));
        config.addDataSourceProperty("prepStmtCacheSqlLimit", resource.getString("db.prepStmtCacheSqlLimit"));
        ds = new HikariDataSource(config);
    }

    public Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
