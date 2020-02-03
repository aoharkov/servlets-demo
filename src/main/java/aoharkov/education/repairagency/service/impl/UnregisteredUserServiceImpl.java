package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.UnregisteredUserService;
import aoharkov.education.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.education.repairagency.service.exception.EntityNotFoundException;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

import java.util.Objects;

public class UnregisteredUserServiceImpl extends AbstractUserServiceImpl implements UnregisteredUserService {
    private final Encoder encoder;
    private final Validator<User> userValidator;

    public UnregisteredUserServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        super(userDao);
        this.encoder = encoder;
        this.userValidator = userValidator;
    }

    @Override
    public User login(String email, String password) {
        //todo validate login with email and password
        String encryptedPassword = encoder.encode(password);
        return userDao.findByEmail(email)
                .filter(user -> Objects.equals(user.getPassword(), encryptedPassword))
                .orElseThrow(() -> new EntityNotFoundException());
    }

    @Override
    public User register(User user) {
        userValidator.validate(user);
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new EntityAlreadyExistException();
        }
        userDao.save(user);
        return user;
    }
}
