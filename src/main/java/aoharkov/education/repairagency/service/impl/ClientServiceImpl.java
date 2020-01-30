package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ClientService;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.validator.Validator;

public class ClientServiceImpl extends UserServiceImpl implements ClientService {

    public ClientServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator) {
        super(userDao, encoder, userValidator);
    }

    @Override
    public void makeRequest() {

    }

    @Override
    public void leaveFeedback(Integer requestId) {

    }
}
