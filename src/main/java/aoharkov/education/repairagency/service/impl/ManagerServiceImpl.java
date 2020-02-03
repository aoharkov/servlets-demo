package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RefusalDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Feedback;
import aoharkov.education.repairagency.entity.Order;
import aoharkov.education.repairagency.entity.Refusal;
import aoharkov.education.repairagency.entity.Request;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ManagerService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class ManagerServiceImpl extends UserServiceImpl implements ManagerService {
    private final RefusalDao refusalDao;
    private final FeedbackDao feedbackDao;

    public ManagerServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                              RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao,
                              RefusalDao refusalDao, FeedbackDao feedbackDao) {
        super(userDao, encoder, userValidator, requestDao, orderDao, repairStageDao);
        this.refusalDao = refusalDao;
        this.feedbackDao = feedbackDao;
    }

    @Override
    public Page<Request> listAllRequests(int page, int itemsPerPage) {
        //todo
        return null;
    }

    @Override
    public Page<Request> listUncheckedRequests(int page, int itemsPerPage) {
        //todo
        return null;
    }

    @Override
    public Order acceptRequest(Integer requestId) {
        //todo
        return null;
    }

    @Override
    public Refusal declineRequest(Integer requestId) {
        //todo
        return null;
    }

    @Override
    public Feedback reviewFeedback(Integer requestId) {
        //todo
        return null;
    }

    @Override
    public Page<User> listAllUsers(int page, int itemsPerPage) {
        //todo
        return null;
    }

    @Override
    public boolean promoteUser(Integer id, Role role) {
        //todo
        return false;
    }
}
