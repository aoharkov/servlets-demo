package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.FeedbackDao;
import aoharkov.training.repairagency.dao.OrderDao;
import aoharkov.training.repairagency.dao.RefusalDao;
import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.mapper.FeedbackMapper;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RefusalMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.ManagerService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Page<RequestEntity> requestEntityPage = requestDao.findAll(page, itemsPerPage);
        List<Request> requestList = requestEntityPage.getContent().stream()
                .map(requestMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<Request>builder()
                .withContent(requestList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(requestEntityPage.getTotalPages())
                .build();
    }

    @Override
    public Page<Order> findAllOrders(int page, int itemsPerPage) {
        Page<OrderEntity> orderEntityPage = orderDao.findAll(page, itemsPerPage);
        List<Order> orderList = orderEntityPage.getContent().stream()
                .map(orderMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<Order>builder()
                .withContent(orderList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(orderEntityPage.getTotalPages())
                .build();
    }

    @Override
    public Page<Refusal> findAllRefusals(int page, int itemsPerPage) {
        Page<RefusalEntity> refusalEntityPage = refusalDao.findAll(page, itemsPerPage);
        List<Refusal> refusalList = refusalEntityPage.getContent().stream()
                .map(refusalMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<Refusal>builder()
                .withContent(refusalList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(refusalEntityPage.getTotalPages())
                .build();
    }

    @Override
    public boolean acceptRequest(Order order) {
        Optional<RequestEntity> requestEntity = requestDao.findById(order.getRequest().getId());
        if (requestEntity.isPresent()) {
            Request request = requestMapper.mapEntityToDomain(requestEntity.get());
            request.setViewed(true);
            request.setAccepted(true);
            requestDao.update(requestMapper.mapDomainToEntity(request));
            orderDao.save(orderMapper.mapDomainToEntity(order));
            return true;
        }
        return false;
    }

    @Override
    public boolean declineRequest(Refusal refusal) {
        Optional<RequestEntity> requestEntity = requestDao.findById(refusal.getRequest().getId());
        if (requestEntity.isPresent()) {
            Request request = requestMapper.mapEntityToDomain(requestEntity.get());
            request.setViewed(true);
            request.setViewed(false);
            requestDao.update(requestMapper.mapDomainToEntity(request));
            refusalDao.save(refusalMapper.mapDomainToEntity(refusal));
            return true;
        }
        return false;
    }

    @Override
    public Page<Feedback> findAllFeedback(int page, int itemsPerPage) {
        Page<FeedbackEntity> feedbackEntityPage = feedbackDao.findAll(page, itemsPerPage);
        List<Feedback> feedbackList = feedbackEntityPage.getContent().stream()
                .map(feedbackMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<Feedback>builder()
                .withContent(feedbackList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(feedbackEntityPage.getTotalPages())
                .build();
    }
}
