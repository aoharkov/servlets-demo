package aoharkov.education.repairagency.service.exception.validation;

public class ValidateException extends RuntimeException {

    ValidateException() {
    }

    ValidateException(String message) {
        super(message);
    }
}
