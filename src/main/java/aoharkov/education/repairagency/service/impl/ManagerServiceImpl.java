package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ManagerService;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

public class ManagerServiceImpl extends UserServiceImpl implements ManagerService {

    public ManagerServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        super(userDao, encoder, userValidator);
    }

    @Override
    public void transformRequestIntoOrder(Integer requestId) {

    }

    @Override
    public void transformRequestIntoRefusal(Integer requestId) {

    }
}
