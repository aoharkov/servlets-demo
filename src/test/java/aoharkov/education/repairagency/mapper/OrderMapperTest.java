package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Order;
import aoharkov.education.repairagency.domain.RepairStage;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.OrderEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OrderMapperTest {
    private static final Mapper<OrderEntity, Order> MAPPER = new OrderMapper();
    private OrderEntity entity;
    private Order item;

    @Before
    public void setUp() {
        entity = OrderEntity.builder()
                .withId(1)
                .withManagerId(2)
                .withMasterId(3)
                .withPrice(4000)
                .withRepairStageId(5)
                .withRequestId(6)
                .build();

        item = Order.builder()
                .withId(1)
                .withManager(User.builder().withId(2).build())
                .withMaster(User.builder().withId(3).build())
                .withPrice(4000)
                .withRepairStage(RepairStage.builder().withId(5).build())
                .withRequest(Request.builder().withId(6).build())
                .build();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(entity, MAPPER.mapDomainToEntity(item));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(item, MAPPER.mapEntityToDomain(entity));
    }
}