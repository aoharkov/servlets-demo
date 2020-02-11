package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RefusalEntity;

public class RefusalMapper implements Mapper<RefusalEntity, Refusal> {

    @Override
    public RefusalEntity mapDomainToEntity(Refusal item) {
        return RefusalEntity.builder()
                .withId(item.getId())
                .withExplanation(item.getExplanation())
                .withManagerId(item.getManager().getId())
                .withRequestId(item.getRequest().getId())
                .build();
    }

    @Override
    public Refusal mapEntityToDomain(RefusalEntity entity) {
        return Refusal.builder()
                .withId(entity.getId())
                .withExplanation(entity.getExplanation())
                .withManager(User.builder().withId(entity.getManagerId()).build())
                .withRequest(Request.builder().withId(entity.getRequestId()).build())
                .build();
    }
}
