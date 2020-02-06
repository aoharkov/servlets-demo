package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.RepairStage;
import aoharkov.education.repairagency.entity.RepairStageEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepairStageMapperTest {
    private static final Mapper<RepairStageEntity, RepairStage> MAPPER = new RepairStageMapper();
    private RepairStageEntity entity;
    private RepairStage item;

    @Before
    public void setUp() {
        entity = RepairStageEntity.builder()
                .withId(1)
                .withName("first stage")
                .build();
        item = RepairStage.builder()
                .withId(1)
                .withName("first stage")
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