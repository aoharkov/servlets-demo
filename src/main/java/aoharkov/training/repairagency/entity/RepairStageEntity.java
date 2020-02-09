package aoharkov.training.repairagency.entity;

import java.util.Objects;

public class RepairStageEntity {
    private final Integer id;
    private final String name;

    private RepairStageEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RepairStageEntity)) {
            return false;
        }
        RepairStageEntity that = (RepairStageEntity) o;
        return id.equals(that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RepairStage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public static final class Builder {
        private Integer id;
        private String name;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public RepairStageEntity build() {
            return new RepairStageEntity(this);
        }
    }
}
