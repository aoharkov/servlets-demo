package aoharkov.education.repairagency.service.validator;

public interface Validator<E> {
    void validate(E entity) throws ValidateException;
}
