package aoharkov.education.repairagency.service.validator;

import aoharkov.education.repairagency.domain.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidatorImpl implements Validator<User> {
    private static final String EMAIL_REGEX
            = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String USER_IS_NOT_VALID = "User is not valid: ";
    private static final String EMAIL_IS_NOT_POSITIVE = "email is not positive";
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 60;
    private static final String PASSWORD_IS_TOO_SHORT
            = String.format("password is shorter than %d symbols", MIN_PASSWORD_LENGTH);
    private static final String PASSWORD_IS_TOO_LONG
            = String.format("password is longer than %d 60 symbols", MAX_PASSWORD_LENGTH);

    @Override
    public void validate(User entity){
        try {
            validateEmail(entity.getEmail());
            validatePassword(entity.getPassword());
        } catch (ValidateException e) {
            throw new ValidateException(USER_IS_NOT_VALID + e.getMessage());
        }
    }

    @Override
    public void validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new ValidateException(EMAIL_IS_NOT_POSITIVE);
        }
    }

    private void validatePassword(String password) {
        if (password.length() < MIN_PASSWORD_LENGTH) {
            throw new ValidateException(PASSWORD_IS_TOO_SHORT);
        }
        if (password.length() > MAX_PASSWORD_LENGTH) {
            throw new ValidateException(PASSWORD_IS_TOO_LONG);
        }
    }
}
