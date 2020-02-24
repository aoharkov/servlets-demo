package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.FeedbackDao;
import aoharkov.training.repairagency.dao.OrderDao;
import aoharkov.training.repairagency.dao.RefusalDao;
import aoharkov.training.repairagency.dao.RepairStageDao;
import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.mapper.FeedbackMapper;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RefusalMapper;
import aoharkov.training.repairagency.mapper.RepairStageMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.ClientService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientServiceImpl extends UserServiceImpl implements ClientService {
    private final RequestDao requestDao;
    private final RefusalDao refusalDao;
    private final OrderDao orderDao;
    private final RepairStageDao repairStageDao;
    private final FeedbackDao feedbackDao;
    private final RequestMapper requestMapper;
    private final RefusalMapper refusalMapper;
    private final OrderMapper orderMapper;
    private final RepairStageMapper repairStageMapper;
    private final FeedbackMapper feedbackMapper;

    public ClientServiceImpl(Encoder encoder, Validator<User> userValidator,
                             UserDao userDao, RequestDao requestDao, RefusalDao refusalDao,
                             OrderDao orderDao, RepairStageDao repairStageDao, FeedbackDao feedbackDao,
                             UserMapper userMapper, RequestMapper requestMapper, RefusalMapper refusalMapper,
                             OrderMapper orderMapper, RepairStageMapper repairStageMapper, FeedbackMapper feedbackMapper) {
        super(encoder, userValidator, userDao, userMapper);
        this.requestDao = requestDao;
        this.refusalDao = refusalDao;
        this.orderDao = orderDao;
        this.repairStageDao = repairStageDao;
        this.feedbackDao = feedbackDao;
        this.requestMapper = requestMapper;
        this.refusalMapper = refusalMapper;
        this.orderMapper = orderMapper;
        this.repairStageMapper = repairStageMapper;
        this.feedbackMapper = feedbackMapper;
    }

    @Override
    public void saveRequest(Request request) {
        requestDao.save(requestMapper.mapDomainToEntity(request));
    }

    @Override
    public Page<Request> findOwnRequests(int page, int itemsPerPage, Integer clientId) {
        Page<RequestEntity> requestEntityPage = requestDao.findAllByClientId(page, itemsPerPage, clientId);
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
    public Request findRequest(Integer id) {
        Optional<RequestEntity> requestEntity = requestDao.findById(id);
        if (requestEntity.isPresent()) {
            return requestMapper.mapEntityToDomain(requestEntity.get());
        }
        throw new EntityNotFoundException();
    }

    @Override
    public Order findOrder(Integer requestId) {
        Optional<OrderEntity> orderEntity = orderDao.findByRequestId(requestId);
        if (orderEntity.isPresent()) {
            return orderMapper.mapEntityToDomain(orderEntity.get());
        }
        throw new EntityNotFoundException();
    }

    @Override
    public Refusal findRefusal(Integer requestId) {
        Optional<RefusalEntity> refusalEntity = refusalDao.findByRequestId(requestId);
        if (refusalEntity.isPresent()) {
            return refusalMapper.mapEntityToDomain(refusalEntity.get());
        }
        throw new EntityNotFoundException();
    }

    @Override
    public void saveFeedback(Feedback feedback) {
        feedbackDao.save(feedbackMapper.mapDomainToEntity(feedback));
    }

    @Override
    public RepairStage findRepairStage(Integer requestId) {
        Integer repairStageId = findOrder(requestId).getRepairStage().getId();
        Optional<RepairStageEntity> repairStageEntity = repairStageDao.findById(repairStageId);
        if (repairStageEntity.isPresent()) {
            return repairStageMapper.mapEntityToDomain(repairStageEntity.get());
        }
        throw new EntityNotFoundException();
    }
}
