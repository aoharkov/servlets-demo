package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.entity.OrderEntity;

import java.util.Optional;

public interface OrderDao extends CrudPageableDao<OrderEntity> {

    Optional<OrderEntity> findByRequestId(Integer requestId);
}
