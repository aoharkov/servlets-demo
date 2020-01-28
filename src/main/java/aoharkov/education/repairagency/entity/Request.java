package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class Request {
    private final Integer id;
    private final User client;
    private final String description;
    private Boolean viewed;
    private Boolean accepted;

    private Request(RequestBuilder builder) {
        this.id = builder.id;
        this.client = builder.client;
        this.description = builder.description;
        this.viewed = builder.viewed;
        this.accepted = builder.accepted;
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public Integer getId() {
        return id;
    }

    public User getClient() {
        return client;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getViewed() {
        return viewed;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setViewed(Boolean viewed) {
        this.viewed = viewed;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request)) return false;
        Request request = (Request) o;
        return id.equals(request.id) &&
                client.equals(request.client) &&
                description.equals(request.description) &&
                Objects.equals(viewed, request.viewed) &&
                Objects.equals(accepted, request.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, description, viewed, accepted);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", client=" + client +
                ", description='" + description + '\'' +
                ", viewed=" + viewed +
                ", accepted=" + accepted +
                '}';
    }

    public static final class RequestBuilder {
        private Integer id;
        private User client;
        private String description;
        private Boolean viewed;
        private Boolean accepted;

        private RequestBuilder() {
        }

        public Request build() {
            return new Request(this);
        }

        public RequestBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public RequestBuilder withClient(User client) {
            this.client = client;
            return this;
        }

        public RequestBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public RequestBuilder withViewed(Boolean viewed) {
            this.viewed = viewed;
            return this;
        }

        public RequestBuilder withAccepted(Boolean accepted) {
            this.accepted = accepted;
            return this;
        }
    }
}
