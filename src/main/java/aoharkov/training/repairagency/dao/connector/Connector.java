package aoharkov.training.repairagency.dao.connector;

import java.sql.Connection;

public interface Connector {

    Connection getConnection();
}
