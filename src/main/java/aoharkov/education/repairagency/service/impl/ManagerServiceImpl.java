package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RefusalDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.mapper.FeedbackMapper;
import aoharkov.education.repairagency.mapper.OrderMapper;
import aoharkov.education.repairagency.mapper.RefusalMapper;
import aoharkov.education.repairagency.mapper.RequestMapper;
import aoharkov.education.repairagency.mapper.UserMapper;
import aoharkov.education.repairagency.service.ManagerService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class ManagerServiceImpl extends UserServiceImpl implements ManagerService {
    private final RequestDao requestDao;
    private final RefusalDao refusalDao;
    private final OrderDao orderDao;
    private final FeedbackDao feedbackDao;
    private final RequestMapper requestMapper;
    private final RefusalMapper refusalMapper;
    private final OrderMapper orderMapper;
    private final FeedbackMapper feedbackMapper;

    public ManagerServiceImpl(Encoder encoder, Validator<User> userValidator,
                              UserDao userDao, RequestDao requestDao, RefusalDao refusalDao,
                              OrderDao orderDao, FeedbackDao feedbackDao,
                              UserMapper userMapper, RequestMapper requestMapper, RefusalMapper refusalMapper,
                              OrderMapper orderMapper, FeedbackMapper feedbackMapper) {
        super(encoder, userValidator, userDao, userMapper);
        this.requestDao = requestDao;
        this.refusalDao = refusalDao;
        this.orderDao = orderDao;
        this.feedbackDao = feedbackDao;
        this.requestMapper = requestMapper;
        this.refusalMapper = refusalMapper;
        this.orderMapper = orderMapper;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public Page<Request> findAllRequests(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public Order acceptRequest(Integer requestId) {
        return null;
    }

    @Override
    public Refusal declineRequest(Integer requestId) {
        return null;
    }

    @Override
    public Page<Feedback> findAllFeedback(int page, int itemsPerPage) {
        return null;
    }
}
