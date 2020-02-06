package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Request;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.RequestEntity;

public class RequestMapper implements Mapper<RequestEntity, Request> {

    @Override
    public RequestEntity mapDomainToEntity(Request item) {
        return RequestEntity.builder()
                .withId(item.getId())
                .withDescription(item.getDescription())
                .withClientId(item.getClient().getId())
                .withViewed(item.getViewed())
                .withAccepted(item.getAccepted())
                .build();
    }

    @Override
    public Request mapEntityToDomain(RequestEntity entity) {
        return Request.builder()
                .withId(entity.getId())
                .withDescription(entity.getDescription())
                .withClient(User.builder().withId(entity.getClientId()).build())
                .withViewed(entity.getViewed())
                .withAccepted(entity.getAccepted())
                .build();
    }
}
