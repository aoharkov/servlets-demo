package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;

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
