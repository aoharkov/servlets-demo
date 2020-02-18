package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.AdminService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminServiceImpl extends UserServiceImpl implements AdminService {

    public AdminServiceImpl(Encoder encoder, Validator<User> userValidator,
                            UserDao userDao, UserMapper userMapper) {
        super(encoder, userValidator, userDao, userMapper);
    }

    @Override
    public Page<User> findAllUsers(int page, int itemsPerPage) {
        Page<UserEntity> userEntityPage = userDao.findAll(page, itemsPerPage);
        List<User> userList = userEntityPage.getItems().stream()
                .map(userMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<User>builder()
                .withItems(userList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(userEntityPage.getTotalPages())
                .build();
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
