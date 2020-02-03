package aoharkov.education.repairagency.service.impl;

import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.entity.RepairStage;
import aoharkov.education.repairagency.service.MasterService;

public class MasterServiceImpl extends RegisteredUserServiceImpl implements MasterService {

    public MasterServiceImpl(UserDao userDao, RequestDao requestDao, OrderDao orderDao, RepairStageDao repairStageDao) {
        super(userDao, requestDao, orderDao, repairStageDao);
    }

    @Override
    public RepairStage updateRepairStage(Integer orderId) {
        //todo
        return null;
    }

}
