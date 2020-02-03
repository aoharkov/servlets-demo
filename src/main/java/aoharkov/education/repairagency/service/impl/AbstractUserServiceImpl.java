package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.service.AbstractUserService;

public class AbstractUserServiceImpl implements AbstractUserService {
    protected final UserDao userDao;
    protected String lang;

    public AbstractUserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String setLang(String lang) {
        this.lang = lang;
        return lang;
    }
}
