package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.UserService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.education.repairagency.service.exception.EntityNotFoundException;
import aoharkov.education.repairagency.service.validator.Validator;

import java.util.Objects;

public class UserServiceImpl implements UserService {
    protected final UserDao userDao;
    private final Encoder encoder;
    private final Validator<User> userValidator;
    protected final RequestDao requestDao;
    protected final OrderDao orderDao;
    protected final RepairStageDao repairStageDao;
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
        return userDao.findByEmail(email)
                .filter(x -> Objects.equals(x.getPassword(), encryptedPassword))
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

    @Override
    public boolean logout() {
        //todo
        return false;
    }

    @Override
    public String setLang(String lang) {
        //todo
        return "en";
    }
}
