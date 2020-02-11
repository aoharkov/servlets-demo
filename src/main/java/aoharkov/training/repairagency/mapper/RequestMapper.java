package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.RequestEntity;

public class RequestMapper implements Mapper<RequestEntity, Request> {

    @Override
    public RequestEntity mapDomainToEntity(Request request) {
        return RequestEntity.builder()
                .withId(request.getId())
                .withDescription(request.getDescription())
                .withClientId(request.getClient().getId())
                .withViewed(request.getViewed())
                .withAccepted(request.getAccepted())
                .build();
    }

    @Override
    public Request mapEntityToDomain(RequestEntity requestEntity) {
        return Request.builder()
                .withId(requestEntity.getId())
                .withDescription(requestEntity.getDescription())
                .withClient(User.builder().withId(requestEntity.getClientId()).build())
                .withViewed(requestEntity.getViewed())
                .withAccepted(requestEntity.getAccepted())
                .build();
    }
}
