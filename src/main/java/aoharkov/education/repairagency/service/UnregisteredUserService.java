package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.entity.User;

public interface UnregisteredUserService extends AbstractUserService {

    User login(String email, String password);

    User register(User user);
}
