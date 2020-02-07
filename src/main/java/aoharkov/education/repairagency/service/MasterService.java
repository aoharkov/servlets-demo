package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.RepairStage;
import aoharkov.education.repairagency.domain.Request;

import java.util.List;

public interface MasterService extends UserService {

    List<Order> findAllOrders(int page, int itemsPerPage);

    Request getRequest(Integer orderId);

    boolean updateRepairStage(Order order, RepairStage repairStage);

    List<RepairStage> findAllRepairStages(int page, int itemsPerPage);
}
