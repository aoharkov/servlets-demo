package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RefusalEntity;

public class RefusalMapper implements Mapper<RefusalEntity, Refusal> {

    @Override
    public RefusalEntity mapDomainToEntity(Refusal refusal) {
        return RefusalEntity.builder()
                .withId(refusal.getId())
                .withExplanation(refusal.getExplanation())
                .withManagerId(refusal.getManager().getId())
                .withRequestId(refusal.getRequest().getId())
                .build();
    }

    @Override
    public Refusal mapEntityToDomain(RefusalEntity refusalEntity) {
        return Refusal.builder()
                .withId(refusalEntity.getId())
                .withExplanation(refusalEntity.getExplanation())
                .withManager(User.builder().withId(refusalEntity.getManagerId()).build())
                .withRequest(Request.builder().withId(refusalEntity.getRequestId()).build())
                .build();
    }
}
