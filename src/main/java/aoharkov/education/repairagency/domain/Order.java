package aoharkov.education.repairagency.domain;

import java.util.Objects;

public class Order {
    private final Integer id;
    private final Request request;
    private final User manager;
    private final Integer price;
    private final User master;
    private final RepairStage repairStage;

    private Order(Builder builder) {
        this.id = builder.id;
        this.request = builder.request;
        this.manager = builder.manager;
        this.price = builder.price;
        this.master = builder.master;
        this.repairStage = builder.repairStage;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public Request getRequest() {
        return request;
    }

    public User getManager() {
        return manager;
    }

    public Integer getPrice() {
        return price;
    }

    public User getMaster() {
        return master;
    }

    public RepairStage getRepairStage() {
        return repairStage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return id.equals(order.id) &&
                Objects.equals(request, order.request) &&
                Objects.equals(manager, order.manager) &&
                Objects.equals(price, order.price) &&
                Objects.equals(master, order.master) &&
                Objects.equals(repairStage, order.repairStage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, request, manager, price, master, repairStage);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", request=" + request +
                ", manager=" + manager +
                ", price=" + price +
                ", master=" + master +
                ", repairStage=" + repairStage +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Request request;
        private User manager;
        private Integer price;
        private User master;
        private RepairStage repairStage;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withRequest(Request request) {
            this.request = request;
            return this;
        }

        public Builder withManager(User manager) {
            this.manager = manager;
            return this;
        }

        public Builder withPrice(Integer price) {
            this.price = price;
            return this;
        }

        public Builder withMaster(User master) {
            this.master = master;
            return this;
        }

        public Builder withRepairStage(RepairStage repairStage) {
            this.repairStage = repairStage;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
