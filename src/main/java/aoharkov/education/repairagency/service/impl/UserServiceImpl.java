package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.UserService;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

public abstract class UserServiceImpl implements UserService {
    public static final String USER_EMAIL_COLLISION = "user is already present with such email";

    private final UserDao userDao;
    private final Encoder encoder;
    private final Validator<User> userValidator;

    public UserServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        this.userDao = userDao;
        this.encoder = encoder;
        this.userValidator = userValidator;
    }

    @Override
    public boolean login(String email, String password) {
        //login validate with email and password
        String encryptedPassword = encoder.encode(password);
        return userDao.findByEmail(email)
                .map(user -> user.getPassword())
                .filter(userPass -> userPass.equals(encryptedPassword))
                .isPresent();
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException(USER_EMAIL_COLLISION);
        }
        userDao.save(user);
        return user;
    }
}
