package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;

public class OrderMapper implements Mapper<OrderEntity, Order> {

    @Override
    public OrderEntity mapDomainToEntity(Order order) {
        return OrderEntity.builder()
                .withId(order.getId())
                .withManagerId(order.getManager().getId())
                .withMasterId(order.getMaster().getId())
                .withPrice(order.getPrice())
                .withRepairStageId(order.getRepairStage().getId())
                .withRequestId(order.getRequest().getId())
                .build();
    }

    @Override
    public Order mapEntityToDomain(OrderEntity orderEntity) {
        return Order.builder()
                .withId(orderEntity.getId())
                .withManager(User.builder().withId(orderEntity.getManagerId()).build())
                .withMaster(User.builder().withId(orderEntity.getMasterId()).build())
                .withPrice(orderEntity.getPrice())
                .withRepairStage(RepairStage.builder().withId(orderEntity.getRepairStageId()).build())
                .withRequest(Request.builder().withId(orderEntity.getRequestId()).build())
                .build();
    }
}
