package aoharkov.education.repairagency.domain;

import java.util.Objects;

public class Feedback extends RequestExtension {
    private final Integer id;
    private String text;
    private Integer score;

    private Feedback(FeedbackBuilder builder) {
        super(builder.request);
        this.id = builder.id;
        this.text = builder.text;
        this.score = builder.score;
    }

    public static FeedbackBuilder builder() {
        return new FeedbackBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Integer getScore() {
        return score;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Feedback)) {
            return false;
        }
        Feedback feedback = (Feedback) o;
        return id.equals(feedback.id) &&
                Objects.equals(text, feedback.text) &&
                Objects.equals(score, feedback.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, score);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", score=" + score +
                '}';
    }

    public static final class FeedbackBuilder {
        private Request request;
        private Integer id;
        private String text;
        private Integer score;

        private FeedbackBuilder() {
        }

        public FeedbackBuilder withRequest(Request request) {
            this.request = request;
            return this;
        }

        public FeedbackBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public FeedbackBuilder withText(String text) {
            this.text = text;
            return this;
        }

        public FeedbackBuilder withScore(Integer score) {
            this.score = score;
            return this;
        }

        public Feedback build() {
            return new Feedback(this);
        }
    }
}
