package aoharkov.education.servletsproject.domain;

public class Refusal extends RequestExtension {
    private Integer id;
    private String reasoning;
    private User manager;

    private Refusal(Request request) {
        super(request);
    }

    public static RefusalBuilder builder() {
        return new RefusalBuilder();
    }

    public Integer getId() {
        return id;
    }

    public String getReasoning() {
        return reasoning;
    }

    public User getManager() {
        return manager;
    }

    public void setReasoning(String reasoning) {
        this.reasoning = reasoning;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Refusal{" +
                "id=" + id +
                ", reasoning='" + reasoning + '\'' +
                ", manager=" + manager +
                '}';
    }

    public static final class RefusalBuilder {
        private Request request;
        private Integer id;
        private String reasoning;
        private User manager;

        private RefusalBuilder() {
        }

        public RefusalBuilder withRequest(Request request) {
            this.request = request;
            return this;
        }

        public RefusalBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public RefusalBuilder withReasoning(String reasoning) {
            this.reasoning = reasoning;
            return this;
        }

        public RefusalBuilder withManager(User manager) {
            this.manager = manager;
            return this;
        }

        public Refusal build() {
            Refusal refusal = new Refusal(request);
            refusal.setReasoning(reasoning);
            refusal.setManager(manager);
            refusal.id = this.id;
            return refusal;
        }
    }
}
