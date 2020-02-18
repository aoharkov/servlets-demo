package aoharkov.training.repairagency.service;

import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;

public interface MasterService {

    Page<Order> findAllOrders(int page, int itemsPerPage);

    Request getRequest(Integer orderId);

    boolean updateRepairStage(Order order, RepairStage repairStage);

    Page<RepairStage> findAllRepairStages(int page, int itemsPerPage);
}
