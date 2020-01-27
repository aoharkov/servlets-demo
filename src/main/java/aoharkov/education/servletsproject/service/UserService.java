package aoharkov.education.servletsproject.service;

import aoharkov.education.servletsproject.domain.User;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);
}
