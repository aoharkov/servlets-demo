package aoharkov.education.repairagency.entity;

public abstract class RequestExtension {
    private final Request request;

    protected RequestExtension(RequestExtensionBuilder builder) {
        this.request = builder.request;
    }

    public Request getRequest() {
        return request;
    }

    public static class RequestExtensionBuilder<T extends RequestExtensionBuilder<T>> {
        private Request request;

        protected RequestExtensionBuilder() {
        }

        public T withRequest(Request request) {
            this.request = request;
            return self();
        }

        @SuppressWarnings("unchecked")
        protected T self() {
            return (T) this;
        }
    }
}
