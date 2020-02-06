package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.mapper.OrderMapper;
import aoharkov.education.repairagency.mapper.RepairStageMapper;
import aoharkov.education.repairagency.mapper.RequestMapper;
import aoharkov.education.repairagency.mapper.UserMapper;
import aoharkov.education.repairagency.service.MasterService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

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
        return null;
    }

    @Override
    public String getRequestDescription(Integer orderId) {
        return null;
    }

    @Override
    public void updateRepairStage(Integer orderId) {

    }
}
