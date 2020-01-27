package aoharkov.education.repairagency.domain;

public abstract class RequestExtension {
    private final Request request;

    protected RequestExtension(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }
}
