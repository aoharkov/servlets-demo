package aoharkov.training.repairagency.dao.impl;

import aoharkov.training.repairagency.dao.connector.Connector;
import aoharkov.training.repairagency.dao.exception.DataBaseSqlRuntimeException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class TestDBLoader {
    private static final Logger LOGGER = LogManager.getLogger(TestDBLoader.class);
    private static final String SCHEME_PATH = "D:\\Projects\\ServletsRepairAgency\\src\\test\\resources\\sql\\schema_test.sql";
    private static final String DATA_PATH = "D:\\Projects\\ServletsRepairAgency\\src\\test\\resources\\sql\\data_test.sql";
    private static final String FAIL_TO_LOAD_SCHEME = "Fail to load scheme from file for testing";
    private static final String FAIL_TO_LOAD_DATA = "Fail to load data from file for testing";
    private static final String FAIL_TO_CONNECT = "Fail to connect to db for testing";

    void reloadTestDB(Connector connector) {
        try (Connection connection = connector.getConnection()) {
            Statement statement = connection.createStatement();
            try {
                statement.executeUpdate(new String(Files.readAllBytes(Paths.get(SCHEME_PATH))));
            } catch (IOException e) {
                LOGGER.error(FAIL_TO_LOAD_SCHEME, e);
                throw new DataBaseSqlRuntimeException(FAIL_TO_LOAD_SCHEME);
            }
            try {
                statement.execute(new String(Files.readAllBytes(Paths.get(DATA_PATH))));
            } catch (IOException e) {
                LOGGER.error(FAIL_TO_LOAD_DATA, e);
                throw new DataBaseSqlRuntimeException(FAIL_TO_LOAD_DATA);
            }
        } catch (SQLException e) {
            LOGGER.error(FAIL_TO_CONNECT, e);
            throw new DataBaseSqlRuntimeException(FAIL_TO_CONNECT);
        }
    }
}
