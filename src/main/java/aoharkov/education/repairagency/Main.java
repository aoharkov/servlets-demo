package aoharkov.education.repairagency;

import aoharkov.education.repairagency.entity.Feedback;
import aoharkov.education.repairagency.entity.Request;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");
        Request request = Request.builder().withId(12).withDescription("test").build();
        Feedback feedback = Feedback.builder()
                .withId(2)
                .withRequest(request)
                .withScore(10)
                .build();
        System.out.println(feedback);
    }
}
