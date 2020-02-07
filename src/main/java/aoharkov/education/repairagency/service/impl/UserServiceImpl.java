package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.UserEntity;
import aoharkov.education.repairagency.mapper.UserMapper;
import aoharkov.education.repairagency.service.UserService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.exception.EntityAlreadyExistException;
import aoharkov.education.repairagency.service.exception.InvalidEmailException;
import aoharkov.education.repairagency.service.exception.InvalidPasswordException;
import aoharkov.education.repairagency.service.validator.Validator;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    final UserDao userDao;
    final UserMapper userMapper;
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
        String encryptedPassword = encoder.encode(password);
        Optional<UserEntity> userEntity = userDao.findByEmail(email);
        if (userEntity.isPresent()) {
            User user = userMapper.mapEntityToDomain(userEntity.get());
            if (encryptedPassword.equals(user.getPassword())) {
                return user;
            } else {
                throw new InvalidPasswordException();
            }
        }
        throw new InvalidEmailException();
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
