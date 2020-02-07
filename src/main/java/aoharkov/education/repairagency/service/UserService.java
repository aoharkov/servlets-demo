package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.domain.User;

public interface UserService {

    User login(String email, String password);

    void register(User user);

}
