package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.OrderDao;
import aoharkov.training.repairagency.dao.RepairStageDao;
import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RepairStageMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.MasterService;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MasterServiceImpl extends UserServiceImpl implements MasterService {
    private final OrderDao orderDao;
    private final RequestDao requestDao;
    private final RepairStageDao repairStageDao;
    private final RequestMapper requestMapper;
    private final OrderMapper orderMapper;
    private final RepairStageMapper repairStageMapper;

    public MasterServiceImpl(Encoder encoder, Validator<User> userValidator,
                             UserDao userDao, RequestDao requestDao,
                             OrderDao orderDao, RepairStageDao repairStageDao,
                             UserMapper userMapper, RequestMapper requestMapper,
                             OrderMapper orderMapper, RepairStageMapper repairStageMapper) {
        super(encoder, userValidator, userDao, userMapper);
        this.requestDao = requestDao;
        this.orderDao = orderDao;
        this.repairStageDao = repairStageDao;
        this.requestMapper = requestMapper;
        this.orderMapper = orderMapper;
        this.repairStageMapper = repairStageMapper;
    }

    @Override
    public Page<Order> findAllOrders(int page, int itemsPerPage) {
        Page<OrderEntity> orderEntityPage = orderDao.findAll(page, itemsPerPage);
        List<Order> orderList = orderEntityPage.getItems().stream()
                .map(orderMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<Order>builder()
                .withItems(orderList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(orderEntityPage.getTotalPages())
                .build();
    }

    @Override
    public Request getRequest(Integer orderId) {
        Optional<OrderEntity> orderEntity = orderDao.findById(orderId);
        if (orderEntity.isPresent()) {
            Optional<RequestEntity> requestEntity = requestDao.findById(orderEntity.get().getRequestId());
            if (requestEntity.isPresent()) {
                return requestMapper.mapEntityToDomain(requestEntity.get());
            }
        }
        throw new EntityNotFoundException();
    }

    @Override
    public boolean updateRepairStage(Order order, RepairStage repairStage) {
        Optional<OrderEntity> orderEntity = orderDao.findById(order.getId());
        if (orderEntity.isPresent()) {
            order.setRepairStage(repairStage);
            orderDao.save(orderMapper.mapDomainToEntity(order));
            return true;
        }
        return false;
    }

    @Override
    public Page<RepairStage> findAllRepairStages(int page, int itemsPerPage) {
        Page<RepairStageEntity> repairStageEntityPage = repairStageDao.findAll(page, itemsPerPage);
        List<RepairStage> repairStageList = repairStageEntityPage.getItems().stream()
                .map(repairStageMapper::mapEntityToDomain)
                .collect(Collectors.toList());
        return Page.<RepairStage>builder()
                .withItems(repairStageList)
                .withPageNumber(page)
                .withItemsNumberPerPage(itemsPerPage)
                .withTotalPages(repairStageEntityPage.getTotalPages())
                .build();
    }
}
