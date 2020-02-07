package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.RefusalEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RefusalMapperTest {
    private static final Mapper<RefusalEntity, Refusal> MAPPER = new RefusalMapper();
    private RefusalEntity entity;
    private Refusal item;

    @Before
    public void setUp() {
        entity = RefusalEntity.builder()
                .withId(1)
                .withExplanation("because")
                .withManagerId(2)
                .withRequestId(3)
                .build();
        item = Refusal.builder()
                .withId(1)
                .withExplanation("because")
                .withManager(User.builder().withId(2).build())
                .withRequest(Request.builder().withId(3).build())
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