package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.entity.User;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);
}
