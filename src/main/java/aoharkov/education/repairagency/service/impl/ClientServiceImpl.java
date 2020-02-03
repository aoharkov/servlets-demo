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
import aoharkov.education.repairagency.service.ClientService;

public class ClientServiceImpl extends RegisteredUserServiceImpl implements ClientService {
    private final RefusalDao refusalDao;
    private final FeedbackDao feedbackDao;

    public ClientServiceImpl(UserDao userDao, RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao,
                             RefusalDao refusalDao, FeedbackDao feedbackDao) {
        super(userDao, requestDao, orderDao, repairStageDao);
        this.refusalDao = refusalDao;
        this.feedbackDao = feedbackDao;
    }

    @Override
    public Request makeRequest(Request request) {
        //todo
        return null;
    }

    @Override
    public Page<Request> listOwnRequests(int page, int itemsPerPage) {
        //todo
        return null;
    }

    @Override
    public Order showOrder(Integer requestId) {
        //todo
        return null;
    }

    @Override
    public Refusal showRefusal(Integer requestId) {
        //todo
        return null;
    }

    @Override
    public Feedback leaveFeedback(Integer requestId) {
        //todo
        return null;
    }
}
