package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class RefusalEntity {
    private final Integer id;
    private final Integer requestId;
    private final String explanation;
    private final Integer managerId;

    private RefusalEntity(Builder builder) {
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
        if (!(o instanceof RefusalEntity)) {
            return false;
        }
        RefusalEntity refusalEntity = (RefusalEntity) o;
        return id.equals(refusalEntity.id) &&
                requestId.equals(refusalEntity.requestId) &&
                explanation.equals(refusalEntity.explanation) &&
                managerId.equals(refusalEntity.managerId);
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

        public RefusalEntity build() {
            return new RefusalEntity(this);
        }
    }
}
