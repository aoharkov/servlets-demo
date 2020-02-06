package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.UserService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.education.repairagency.service.exception.EntityNotFoundException;
import aoharkov.education.repairagency.service.validator.Validator;

import java.util.Objects;

public class UserServiceImpl implements UserService {
    protected final UserDao userDao;
    protected final RequestDao requestDao;
    protected final OrderDao orderDao;
    protected final RepairStageDao repairStageDao;
    private final Encoder encoder;
    private final Validator<User> userValidator;
    protected User user;

    public UserServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                           RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao) {
        this.userDao = userDao;
        this.requestDao = requestDao;
        this.encoder = encoder;
        this.userValidator = userValidator;
        this.orderDao = orderDao;
        this.repairStageDao = repairStageDao;
    }

    @Override
    public User login(String email, String password) {
        String encryptedPassword = encoder.encode(password);
        /*return userDao.findByEmail(email)
                .filter(x -> Objects.equals(x.getPassword(), encryptedPassword))
                .orElseThrow(() -> new EntityNotFoundException());*/
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
