package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.UserEntity;
import aoharkov.education.repairagency.mapper.UserMapper;
import aoharkov.education.repairagency.service.AdminService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminServiceImpl extends UserServiceImpl implements AdminService {

    public AdminServiceImpl(Encoder encoder, Validator<User> userValidator,
                            UserDao userDao, UserMapper userMapper) {
        super(encoder, userValidator, userDao, userMapper);
    }

    @Override
    public List<User> findAllUsers(int page, int itemsPerPage) {
        Page<UserEntity> userEntityPage = userDao.findAll(page, itemsPerPage);
        return userEntityPage.getItems().stream()
                .map(userMapper::mapEntityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void setRoleToUser(User user, Role role) {
        Optional<UserEntity> userEntity = userDao.findById(user.getId());
        if (userEntity.isPresent()) {
            user.setRole(role);
            userDao.save(userMapper.mapDomainToEntity(user));
        }
    }
}
