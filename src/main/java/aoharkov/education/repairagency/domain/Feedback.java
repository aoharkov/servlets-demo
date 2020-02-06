package aoharkov.education.repairagency.domain;

import java.util.Objects;

public class Feedback {
    private final Integer id;
    private final Integer requestId;
    private final String text;
    private final Integer score;

    private Feedback(Builder builder) {
        this.id = builder.id;
        this.requestId = builder.requestId;
        this.text = builder.text;
        this.score = builder.score;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public Integer getRequestId() {
        return requestId;
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
                requestId.equals(feedback.requestId) &&
                Objects.equals(text, feedback.text) &&
                Objects.equals(score, feedback.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestId, text, score);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", text='" + text + '\'' +
                ", score=" + score +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Integer requestId;
        private String text;
        private Integer score;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withRequestId(Integer requestId) {
            this.requestId = requestId;
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
