package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RefusalDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.AdminService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class AdminServiceImpl extends UserServiceImpl implements AdminService {
    private final RefusalDao refusalDao;
    private final FeedbackDao feedbackDao;

    public AdminServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                            RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao,
                            RefusalDao refusalDao, FeedbackDao feedbackDao) {
        super(userDao, encoder, userValidator, requestDao, orderDao, repairStageDao);
        this.refusalDao = refusalDao;
        this.feedbackDao = feedbackDao;
    }

    @Override
    public Page<User> findAllUsers(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public void setRoleToUser(Role role, Integer id) {

    }
}
