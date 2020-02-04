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
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ClientService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class ClientServiceImpl extends UserServiceImpl implements ClientService {
    private final RefusalDao refusalDao;
    private final FeedbackDao feedbackDao;

    public ClientServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                             RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao,
                             RefusalDao refusalDao, FeedbackDao feedbackDao) {
        super(userDao, encoder, userValidator, requestDao, orderDao, repairStageDao);
        this.refusalDao = refusalDao;
        this.feedbackDao = feedbackDao;
    }

    @Override
    public void saveRequest(Request request) {

    }

    @Override
    public Page<Request> findOwnRequests(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public Order findOrder(Integer requestId) {
        return null;
    }

    @Override
    public Refusal findRefusal(Integer requestId) {
        return null;
    }

    @Override
    public void saveFeedback(Feedback feedback) {

    }
}
