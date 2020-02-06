package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.UserService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.education.repairagency.service.validator.Validator;

public class UserServiceImpl implements UserService {
    protected final UserDao userDao;
    private final Encoder encoder;
    private final Validator<User> userValidator;
    protected User user;

    public UserServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        this.userDao = userDao;
        this.encoder = encoder;
        this.userValidator = userValidator;
    }

    @Override
    public User login(String email, String password) {
        /*String encryptedPassword = encoder.encode(password);

        Optional<User> user = userDao.findByEmail(email).map(x -> );

        return userDao.findByEmail(email)
                .map(UserEntity::getPassword)
                .filter(pass -> pass.equals(encryptedPassword))
                .;*/

        throw new UnsupportedOperationException();
    }

    @Override
    public void register(User user) {
        userValidator.validate(user);
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new EntityAlreadyExistException();
        }
        //userDao.save(user);
        throw new UnsupportedOperationException();
    }

    @Override
    public void logout() {

    }

    @Override
    public void setLang(String lang) {

    }
}
