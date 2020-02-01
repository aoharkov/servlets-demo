package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class Request {
    private final Integer id;
    private final User client;
    private final String description;
    private final Boolean viewed;
    private final Boolean accepted;

    private Request(Builder builder) {
        this.id = builder.id;
        this.client = builder.client;
        this.description = builder.description;
        this.viewed = builder.viewed;
        this.accepted = builder.accepted;
    }

    public static Builder builder() {
        return new Builder();
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

    public static final class Builder {
        private Integer id;
        private User client;
        private String description;
        private Boolean viewed;
        private Boolean accepted;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withClient(User client) {
            this.client = client;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withViewed(Boolean viewed) {
            this.viewed = viewed;
            return this;
        }

        public Builder withAccepted(Boolean accepted) {
            this.accepted = accepted;
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }
}
