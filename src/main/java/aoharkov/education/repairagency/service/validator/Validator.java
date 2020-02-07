package aoharkov.education.repairagency.service.validator;

public interface Validator<E> {

    void validate(E entity);

    void validateEmail(String email);
}
