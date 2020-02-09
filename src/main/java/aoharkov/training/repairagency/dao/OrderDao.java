package aoharkov.training.repairagency.dao;

import aoharkov.training.repairagency.entity.OrderEntity;

import java.util.Optional;

public interface OrderDao extends CrudPageableDao<OrderEntity> {

    Optional<OrderEntity> findByRequestId(Integer requestId);
}
