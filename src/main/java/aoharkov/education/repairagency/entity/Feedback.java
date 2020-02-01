package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class Feedback{
    private final Integer id;
    private final Request request;
    private final String text;
    private final Integer score;

    private Feedback(Builder builder) {
        this.id = builder.id;
        this.request = builder.request;
        this.text = builder.text;
        this.score = builder.score;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public Request getRequest() {
        return request;
    }

    public String getText() {
        return text;
    }

    public Integer getScore() {
        return score;
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
                request.equals(feedback.request) &&
                Objects.equals(text, feedback.text) &&
                Objects.equals(score, feedback.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, text, score);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", request=" + request +
                ", text='" + text + '\'' +
                ", score=" + score +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Request request;
        private String text;
        private Integer score;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withRequest(Request request) {
            this.request = request;
            return this;
        }

        public Builder withText(String text) {
            this.text = text;
            return this;
        }

        public Builder withScore(Integer score) {
            this.score = score;
            return this;
        }

        public Feedback build() {
            return new Feedback(this);
        }
    }
}
