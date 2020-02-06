package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class RequestEntity {
    private final Integer id;
    private final Integer clientId;
    private final String description;
    private final Boolean viewed;
    private final Boolean accepted;

    private RequestEntity(Builder builder) {
        this.id = builder.id;
        this.clientId = builder.clientId;
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

    public Integer getClientId() {
        return clientId;
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof RequestEntity)) {
            return false;
        }
        RequestEntity requestEntity = (RequestEntity) o;
        return id.equals(requestEntity.id) &&
                clientId.equals(requestEntity.clientId) &&
                description.equals(requestEntity.description) &&
                Objects.equals(viewed, requestEntity.viewed) &&
                Objects.equals(accepted, requestEntity.accepted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, description, viewed, accepted);
    }

    @Override
    public String toString() {
        return "Request{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", description='" + description + '\'' +
                ", viewed=" + viewed +
                ", accepted=" + accepted +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Integer clientId;
        private String description;
        private Boolean viewed;
        private Boolean accepted;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withClientId(Integer clientId) {
            this.clientId = clientId;
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

        public RequestEntity build() {
            return new RequestEntity(this);
        }
    }
}
