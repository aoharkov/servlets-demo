package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;

public class FeedbackMapper implements Mapper<FeedbackEntity, Feedback> {

    @Override
    public FeedbackEntity mapDomainToEntity(Feedback feedback) {
        return FeedbackEntity.builder()
                .withId(feedback.getId())
                .withRequestId(feedback.getRequest().getId())
                .withScore(feedback.getScore())
                .withText(feedback.getText())
                .build();
    }

    @Override
    public Feedback mapEntityToDomain(FeedbackEntity feedbackEntity) {
        return Feedback.builder()
                .withId(feedbackEntity.getId())
                .withRequest(Request.builder().withId(feedbackEntity.getRequestId()).build())
                .withScore(feedbackEntity.getScore())
                .withText(feedbackEntity.getText())
                .build();
    }
}
