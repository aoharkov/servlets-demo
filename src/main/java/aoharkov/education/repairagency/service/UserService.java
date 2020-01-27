package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.domain.User;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);
}
