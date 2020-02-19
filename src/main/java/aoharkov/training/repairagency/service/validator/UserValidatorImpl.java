package aoharkov.training.repairagency.service.validator;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.exception.validation.InvalidEmailException;
import aoharkov.training.repairagency.service.exception.validation.InvalidPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements Validator<User> {
    private static final String ATOM = "[\\w!#$%&'*+-\\/=?^`{|}~]+";
    private static final String LOCAL_PART = ATOM + "(\\." + ATOM + ")*";
    private static final String LABEL = "[a-zA-Z0-9]+(-[a-zA-Z0-9]+)*";
    private static final String DOMAIN = LABEL + "(\\." + LABEL + ")*";
    private static final String EMAIL_REGEX = "^" + LOCAL_PART + "@" + DOMAIN + "$";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 60;
    private static final String PASSWORD_IS_TOO_SHORT
            = String.format("password is shorter than %d symbols", MIN_PASSWORD_LENGTH);
    private static final String PASSWORD_IS_TOO_LONG
            = String.format("password is longer than %d 60 symbols", MAX_PASSWORD_LENGTH);

    @Override
    public void validate(User entity) {
        validateEmail(entity.getEmail());
        validatePassword(entity.getPassword());
    }

    @Override
    public void validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new InvalidEmailException();
        }
    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new InvalidPasswordException(PASSWORD_IS_TOO_SHORT);
        }
        if (password.length() > MAX_PASSWORD_LENGTH) {
            throw new InvalidPasswordException(PASSWORD_IS_TOO_LONG);
        }
    }
}
