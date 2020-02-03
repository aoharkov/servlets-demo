package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.service.UserService;

public class UserServiceImpl implements UserService {
    protected final UserDao userDao;
    protected String lang;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String setLang(String lang) {
        this.lang = lang;
        return lang;
    }
}
