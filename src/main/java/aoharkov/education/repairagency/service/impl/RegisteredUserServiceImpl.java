package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.RegisteredUserService;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

public abstract class RegisteredUserServiceImpl extends AbstractUserServiceImpl implements RegisteredUserService {
    public static final String USER_EMAIL_COLLISION = "user is already present with such email";

    private final UserDao userDao;
    private final Encoder encoder;
    private final Validator<User> userValidator;

    public RegisteredUserServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        this.userDao = userDao;
        this.encoder = encoder;
        this.userValidator = userValidator;
    }

    @Override
    public boolean logout() {
        //todo
        return false;
    }
}
