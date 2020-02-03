package aoharkov.education.repairagency.service.validator;

public interface Validator<E> {

    void validate(E entity) throws ValidateException;

    void validateEmail(String email) throws ValidateException;
}
