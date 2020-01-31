package aoharkov.education.repairagency.entity;

import java.util.Objects;

public class Order extends RequestExtension {
    private final Integer id;
    private final User manager;
    private final Integer price;
    private final User master;
    private RepairStage repairStage;

    private Order(OrderBuilder builder) {
        super(builder);
        this.id = builder.id;
        this.manager = builder.manager;
        this.price = builder.price;
        this.master = builder.master;
        this.repairStage = builder.repairStage;
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public Integer getId() {
        return id;
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

    public void setRepairStage(RepairStage repairStage) {
        this.repairStage = repairStage;
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
                manager.equals(order.manager) &&
                price.equals(order.price) &&
                master.equals(order.master) &&
                repairStage == order.repairStage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager, price, master, repairStage);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", request_id=" + super.getRequest().getId() +
                ", manager=" + manager +
                ", price=" + price +
                ", master=" + master +
                ", repairStages=" + repairStage +
                '}';
    }

    public static final class OrderBuilder extends RequestExtensionBuilder<OrderBuilder> {
        private Integer id;
        private User manager;
        private Integer price;
        private User master;
        private RepairStage repairStage;

        private OrderBuilder() {
        }

        public Order build() {
            return new Order(this);
        }

        public OrderBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public OrderBuilder withManager(User manager) {
            this.manager = manager;
            return this;
        }

        public OrderBuilder withPrice(Integer price) {
            this.price = price;
            return this;
        }

        public OrderBuilder withMaster(User master) {
            this.master = master;
            return this;
        }

        public OrderBuilder withRepairStatus(RepairStage repairStage) {
            this.repairStage = repairStage;
            return this;
        }

        @Override
        protected OrderBuilder self() {
            return this;
        }
    }
}
