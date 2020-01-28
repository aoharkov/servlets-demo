package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class Refusal extends RequestExtension {
    private final Integer id;
    private final String explanation;
    private final User manager;

    private Refusal(RefusalBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.explanation = builder.explanation;
        this.manager = builder.manager;
    }

    public static RefusalBuilder builder() {
        return new RefusalBuilder();
    }

    public Integer getId() {
        return id;
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
                explanation.equals(refusal.explanation) &&
                manager.equals(refusal.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, explanation, manager);
    }

    @Override
    public String toString() {
        return "Refusal{" +
                "id=" + id +
                ", request_id=" + super.getRequest().getId() +
                ", explanation='" + explanation + '\'' +
                ", manager=" + manager +
                '}';
    }

    public static final class RefusalBuilder extends RequestExtensionBuilder<RefusalBuilder> {
        private Integer id;
        private String explanation;
        private User manager;

        private RefusalBuilder() {
        }

        public Refusal build() {
            return new Refusal(this);
        }

        public RefusalBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public RefusalBuilder withExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public RefusalBuilder withManager(User manager) {
            this.manager = manager;
            return this;
        }

        @Override
        protected RefusalBuilder self() {
            return this;
        }
    }
}
