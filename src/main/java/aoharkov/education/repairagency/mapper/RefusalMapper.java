package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Refusal;
import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.RefusalEntity;

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
