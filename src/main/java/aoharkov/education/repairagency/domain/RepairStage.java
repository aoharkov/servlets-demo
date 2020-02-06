package aoharkov.education.repairagency.domain;

import java.util.Objects;

public class RepairStage {
    private final Integer id;
    private final String name;

    public RepairStage(Integer id, String name) {
        this.id = id;
        this.name = name;
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
        if (!(o instanceof RepairStage)) {
            return false;
        }
        RepairStage that = (RepairStage) o;
        return id.equals(that.id) &&
                name.equals(that.name);
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
}
