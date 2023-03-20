package aoharkov.training.repairagency.entity;

import java.util.Objects;

public class NewEntity {
    private final Integer id;
    private final Integer numericValue;
    private final String text;
    private final Integer anotherNumericValue;

    public NewEntity(Integer id, Integer numericValue, String text, Integer anotherNumericValue) {
        this.id = id;
        this.numericValue = numericValue;
        this.text = text;
        this.anotherNumericValue = anotherNumericValue;
    }

    public NewEntity(Integer id, Integer numericValue, String text1, String text2, Integer anotherNumericValue) {
        this.id = id;
        this.numericValue = numericValue;
        this.text = text1 + text2;
        this.anotherNumericValue = anotherNumericValue;
    }

    private NewEntity(Builder builder) {
        this.id = builder.id;
        this.numericValue = builder.numericValue;
        this.text = builder.text;
        this.anotherNumericValue = builder.anotherNumericValue;
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

    public String getText() {
        return text;
    }

    public Integer getAnotherNumericValue() {
        return anotherNumericValue;
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
                Objects.equals(text, that.text) &&
                Objects.equals(anotherNumericValue, that.anotherNumericValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numericValue, text, anotherNumericValue);
    }

    @Override
    public String toString() {
        return "New entity{" +
                "id=" + id +
                ", numericValue=" + numericValue +
                ", text='" + text + '\'' +
                ", anotherNumericValue=" + anotherNumericValue +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Integer numericValue;
        private String text;
        private Integer anotherNumericValue;

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
            this.text = text;
            return this;
        }

        public Builder withAnotherNumericValue(Integer score) {
            this.anotherNumericValue = score;
            return this;
        }

        public NewEntity build() {
            return new NewEntity(this);
        }
    }
}
