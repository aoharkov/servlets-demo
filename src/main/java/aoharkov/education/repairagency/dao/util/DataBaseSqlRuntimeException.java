package aoharkov.education.repairagency.dao.util;

public class DataBaseSqlRuntimeException extends RuntimeException {

    public DataBaseSqlRuntimeException() {
    }

    public DataBaseSqlRuntimeException(String message) {
        super(message);
    }

    public DataBaseSqlRuntimeException(String message, Exception cause) {
        super(message, cause);
    }
}
