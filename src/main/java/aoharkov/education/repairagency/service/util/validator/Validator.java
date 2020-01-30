package aoharkov.education.repairagency.service.util.validator;

public interface Validator<E> {

    void validate(E entity) throws ValidateException;
}
