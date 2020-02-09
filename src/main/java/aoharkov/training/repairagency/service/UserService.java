package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.User;

public interface UserService {

    User login(String email, String password);

    void register(User user);

}
