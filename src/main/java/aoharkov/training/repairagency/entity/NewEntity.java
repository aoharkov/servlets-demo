package aoharkov.training.repairagency.entity;

import java.util.Objects;

public class NewEntity {
    private final Integer id;
    private final String stringValue;
    private final Integer numericValue;

    private NewEntity(Builder builder) {
        this.id = builder.id;
        this.stringValue = builder.stringValue;
        this.numericValue = builder.numericValue;
    }

    public void emptyMethod() {

    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumericValue() {
        return numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NewEntity)) {
            return false;
        }
        NewEntity that = (NewEntity) o;
        return id.equals(that.id) &&
                Objects.equals(numericValue, that.numericValue) &&
                Objects.equals(stringValue, that.stringValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numericValue, stringValue);
    }

    @Override
    public String toString() {
        return "New entity{" +
                "id=" + id +
                ", numericValue=" + numericValue +
                ", text='" + stringValue + '\'' +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private String stringValue;
        private Integer numericValue;


        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withNumericValue(Integer requestId) {
            this.numericValue = requestId;
            return this;
        }

        public Builder withText(String text) {
            this.stringValue = text;
            return this;
        }

        public NewEntity build() {
            return new NewEntity(this);
        }
    }
}
