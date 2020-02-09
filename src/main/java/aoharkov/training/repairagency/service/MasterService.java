package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;

import java.util.List;

public interface MasterService extends UserService {

    List<Order> findAllOrders(int page, int itemsPerPage);

    Request getRequest(Integer orderId);

    boolean updateRepairStage(Order order, RepairStage repairStage);

    List<RepairStage> findAllRepairStages(int page, int itemsPerPage);
}
