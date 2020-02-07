package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.RequestEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RequestMapperTest {
    private static final Mapper<RequestEntity, Request> MAPPER = new RequestMapper();
    private RequestEntity entity;
    private Request item;

    @Before
    public void setUp() {
        entity = RequestEntity.builder()
                .withId(1)
                .withDescription("just do it")
                .withClientId(2)
                .withViewed(false)
                .withAccepted(false)
                .build();
        item = Request.builder()
                .withId(1)
                .withDescription("just do it")
                .withClient(User.builder().withId(2).build())
                .withViewed(false)
                .withAccepted(false)
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