package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.domain.Order;

public interface MasterService extends UserService {

    Page<Order> findAllOrders(int page, int itemsPerPage);

    String getRequestDescription(Integer orderId);

    void updateRepairStage(Integer orderId);
}
