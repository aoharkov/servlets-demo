package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.entity.User;

public interface UserService {

    User login(String email, String password);

    void register(User user);

    void logout();

    void setLang(String lang);
}
