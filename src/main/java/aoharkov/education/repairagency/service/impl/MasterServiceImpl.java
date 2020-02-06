package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.MasterService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class MasterServiceImpl extends UserServiceImpl implements MasterService {
    private final OrderDao orderDao;
    private final RepairStageDao repairStageDao;

    public MasterServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                             OrderDao orderDao, RepairStageDao repairStageDao) {
        super(userDao, encoder, userValidator);
        this.orderDao = orderDao;
        this.repairStageDao = repairStageDao;
    }

    @Override
    public Page<Order> findAllOrders(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public void updateRepairStage(Integer orderId) {

    }
}
