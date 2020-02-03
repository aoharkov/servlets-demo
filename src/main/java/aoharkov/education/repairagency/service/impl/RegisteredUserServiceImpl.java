package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.RegisteredUserService;

public abstract class RegisteredUserServiceImpl extends AbstractUserServiceImpl implements RegisteredUserService {
    protected final RequestDao requestDao;
    protected final OrderDao orderDao;
    protected final RepairStageDao repairStageDao;
    protected User user;

    public RegisteredUserServiceImpl(UserDao userDao, RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao) {
        super(userDao);
        this.requestDao = requestDao;
        this.orderDao = orderDao;
        this.repairStageDao = repairStageDao;
    }

    @Override
    public boolean logout() {
        //todo
        return false;
    }
}
