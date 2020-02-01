package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.MasterService;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

public class MasterServiceImpl extends RegisteredUserServiceImpl implements MasterService {

    public MasterServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        super(userDao, encoder, userValidator);
    }

    @Override
    public void processOrder(Integer orderId) {

    }

    @Override
    public void updateRoleOfUserWithId(Integer id) {

    }
}
