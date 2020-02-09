package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.UserService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.exception.IncorrectPasswordException;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    protected final UserDao userDao;
    protected final UserMapper userMapper;
    private final Encoder encoder;
    private final Validator<User> userValidator;

    public UserServiceImpl(Encoder encoder, Validator<User> userValidator,
                           UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.encoder = encoder;
        this.userValidator = userValidator;
        this.userMapper = userMapper;
    }

    @Override
    public User login(String email, String password) {
        userValidator.validateEmail(email);
        Optional<UserEntity> userEntity = userDao.findByEmail(email);
        if (userEntity.isPresent()) {
            String encryptedPassword = encoder.encode(password);
            if (encryptedPassword.equals(userEntity.get().getPassword())) {
                return userMapper.mapEntityToDomain(userEntity.get());
            } else {
                throw new IncorrectPasswordException();
            }
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void register(User user) {
        userValidator.validate(user);
        if (userDao.findByEmail(user.getEmail()).isPresent()) {
            throw new EntityAlreadyExistException();
        }
        userDao.save(userMapper.mapDomainToEntity(user));
    }
}
