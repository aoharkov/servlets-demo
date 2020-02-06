package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RefusalDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.ClientService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class ClientServiceImpl extends UserServiceImpl implements ClientService {
    private final RequestDao requestDao;
    private final RefusalDao refusalDao;
    private final OrderDao orderDao;
    private final RepairStageDao repairStageDao;
    private final FeedbackDao feedbackDao;

    public ClientServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                             RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao,
                             RefusalDao refusalDao, FeedbackDao feedbackDao) {
        super(userDao, encoder, userValidator);
        this.requestDao = requestDao;
        this.refusalDao = refusalDao;
        this.orderDao = orderDao;
        this.repairStageDao = repairStageDao;
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
