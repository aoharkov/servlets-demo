package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.entity.User;

public interface UserService {
    User login(String email, String password);

    User register(User user);

    boolean logout();

    String setLang(String lang);
}
