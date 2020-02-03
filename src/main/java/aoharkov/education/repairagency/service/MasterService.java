package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.entity.RepairStage;

public interface MasterService extends UserService {

    RepairStage updateRepairStage(Integer orderId);
}
