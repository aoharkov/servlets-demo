package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Feedback;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.entity.FeedbackEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FeedbackMapperTest {
    private static final Mapper<FeedbackEntity, Feedback> MAPPER = new FeedbackMapper();
    private FeedbackEntity entity;
    private Feedback item;

    @Before
    public void setUp() {
        entity = FeedbackEntity.builder()
                .withId(1)
                .withRequestId(2)
                .withScore(3)
                .withText("UFO has published here")
                .build();
        item = Feedback.builder()
                .withId(1)
                .withRequest(Request.builder().withId(2).build())
                .withScore(3)
                .withText("UFO has published here")
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