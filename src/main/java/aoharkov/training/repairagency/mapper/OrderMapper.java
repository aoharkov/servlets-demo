package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.OrderEntity;

public class OrderMapper implements Mapper<OrderEntity, Order> {

    @Override
    public OrderEntity mapDomainToEntity(Order item) {
        return OrderEntity.builder()
                .withId(item.getId())
                .withManagerId(item.getManager().getId())
                .withMasterId(item.getMaster().getId())
                .withPrice(item.getPrice())
                .withRepairStageId(item.getRepairStage().getId())
                .withRequestId(item.getRequest().getId())
                .build();
    }

    @Override
    public Order mapEntityToDomain(OrderEntity entity) {
        return Order.builder()
                .withId(entity.getId())
                .withManager(User.builder().withId(entity.getManagerId()).build())
                .withMaster(User.builder().withId(entity.getMasterId()).build())
                .withPrice(entity.getPrice())
                .withRepairStage(RepairStage.builder().withId(entity.getRepairStageId()).build())
                .withRequest(Request.builder().withId(entity.getRequestId()).build())
                .build();
    }
}
