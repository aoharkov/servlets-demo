package aoharkov.education.servletsproject.domain;

public class Refusal extends RequestExtension {
    private Integer id;
    private String explanation;
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

    public String getExplanation() {
        return explanation;
    }

    public User getManager() {
        return manager;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Refusal{" +
                "id=" + id +
                ", explanation='" + explanation + '\'' +
                ", manager=" + manager +
                '}';
    }

    public static final class RefusalBuilder {
        private Request request;
        private Integer id;
        private String explanation;
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

        public RefusalBuilder withExplanation(String explanation) {
            this.explanation = explanation;
            return this;
        }

        public RefusalBuilder withManager(User manager) {
            this.manager = manager;
            return this;
        }

        public Refusal build() {
            Refusal refusal = new Refusal(request);
            refusal.setExplanation(explanation);
            refusal.setManager(manager);
            refusal.id = this.id;
            return refusal;
        }
    }
}
