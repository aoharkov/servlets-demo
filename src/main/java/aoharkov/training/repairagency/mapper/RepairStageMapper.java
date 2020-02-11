package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.entity.RepairStageEntity;

public class RepairStageMapper implements Mapper<RepairStageEntity, RepairStage> {

    @Override
    public RepairStageEntity mapDomainToEntity(RepairStage repairStage) {
        return RepairStageEntity.builder()
                .withId(repairStage.getId())
                .withName(repairStage.getName())
                .build();
    }

    @Override
    public RepairStage mapEntityToDomain(RepairStageEntity repairStageEntity) {
        return RepairStage.builder()
                .withId(repairStageEntity.getId())
                .withName(repairStageEntity.getName())
                .build();
    }
}
