package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Order;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.MasterService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.validator.Validator;

public class MasterServiceImpl extends UserServiceImpl implements MasterService {

    public MasterServiceImpl(UserDao userDao, Encoder encoder, Validator<User> userValidator,
                             RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao) {
        super(userDao, encoder, userValidator, requestDao, orderDao, repairStageDao);
    }

    @Override
    public Page<Order> findAllOrders(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public void updateRepairStage(Integer orderId) {

    }
}
