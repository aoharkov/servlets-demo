package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.AdminService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class AdminServiceImpl extends UserServiceImpl implements AdminService {

    public AdminServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        super(userDao, encoder, userValidator);
    }

    @Override
    public Page<User> findAllUsers(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public void setRoleToUser(Role role, Integer id) {

    }
}
