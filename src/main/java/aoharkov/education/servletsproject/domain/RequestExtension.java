package aoharkov.education.servletsproject.domain;

public abstract class RequestExtension {
    private Request request;

    protected RequestExtension(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }
}
