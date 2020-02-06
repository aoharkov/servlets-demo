package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.RepairStage;

import java.util.List;

public interface MasterService extends UserService {

    List<Order> findAllOrders(int page, int itemsPerPage);

    String getRequestDescription(Integer orderId);

    boolean updateRepairStage(Order order, RepairStage repairStage);
}
