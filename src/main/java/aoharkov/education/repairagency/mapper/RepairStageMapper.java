package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.RepairStage;
import aoharkov.education.repairagency.entity.RepairStageEntity;

public class RepairStageMapper implements Mapper<RepairStageEntity, RepairStage> {
    @Override
    public RepairStageEntity mapDomainToEntity(RepairStage item) {
        return RepairStageEntity.builder()
                .withId(item.getId())
                .withName(item.getName())
                .build();
    }

    @Override
    public RepairStage mapEntityToDomain(RepairStageEntity entity) {
        return RepairStage.builder()
                .withId(entity.getId())
                .withName(entity.getName())
                .build();
    }
}
