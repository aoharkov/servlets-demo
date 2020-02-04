package aoharkov.education.repairagency.service;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Order;

public interface MasterService extends UserService {

    Page<Order> findAllOrders(int page, int itemsPerPage);

    void updateRepairStage(Integer orderId);
}
