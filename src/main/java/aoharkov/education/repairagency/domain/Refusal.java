package aoharkov.education.repairagency.domain;

import java.util.Objects;

public class Refusal {
    private final Integer id;
    private final Integer requestId;
    private final String explanation;
    private final Integer managerId;

    private Refusal(Builder builder) {
        this.id = builder.id;
        this.requestId = builder.requestId;
        this.explanation = builder.explanation;
        this.managerId = builder.managerId;
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

    public String getExplanation() {
        return explanation;
    }

    public Integer getManagerId() {
        return managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Refusal)) {
            return false;
        }
        Refusal refusal = (Refusal) o;
        return id.equals(refusal.id) &&
                requestId.equals(refusal.requestId) &&
                explanation.equals(refusal.explanation) &&
                managerId.equals(refusal.managerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestId, explanation, managerId);
    }

    @Override
    public String toString() {
        return "Refusal{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", explanation='" + explanation + '\'' +
                ", managerId=" + managerId +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Integer requestId;
        private String explanation;
        private Integer managerId;

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

        public Builder withExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public Builder withManagerId(Integer managerId) {
            this.managerId = managerId;
            return this;
        }

        public Refusal build() {
            return new Refusal(this);
        }
    }
}
