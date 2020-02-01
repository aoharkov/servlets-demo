package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class Refusal{
    private final Integer id;
    private final Request request;
    private final String explanation;
    private final User manager;

    private Refusal(Builder builder) {
        this.id = builder.id;
        this.request = builder.request;
        this.explanation = builder.explanation;
        this.manager = builder.manager;
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

    public String getExplanation() {
        return explanation;
    }

    public User getManager() {
        return manager;
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
                request.equals(refusal.request) &&
                explanation.equals(refusal.explanation) &&
                manager.equals(refusal.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, explanation, manager);
    }

    @Override
    public String toString() {
        return "Refusal{" +
                "id=" + id +
                ", request=" + request +
                ", explanation='" + explanation + '\'' +
                ", manager=" + manager +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Request request;
        private String explanation;
        private User manager;

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

        public Builder withExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public Builder withManager(User manager) {
            this.manager = manager;
            return this;
        }

        public Refusal build() {
            return new Refusal(this);
        }
    }
}
