package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.entity.RepairStage;

public interface MasterService extends RegisteredUserService {

    RepairStage updateRepairStage(Integer orderId);
}
