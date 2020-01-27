package aoharkov.education.servletsproject.domain;

import java.util.Objects;

public class Order extends RequestExtension {
    private Integer id;
    private User manager;
    private Integer price;
    private User master;
    private boolean done;

    private Order(Request request) {
        super(request);
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

    public boolean isDone() {
        return done;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setMaster(User master) {
        this.master = master;
    }

    public void setDone(boolean done) {
        this.done = done;
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
        return done == order.done &&
                id.equals(order.id) &&
                Objects.equals(manager, order.manager) &&
                Objects.equals(price, order.price) &&
                Objects.equals(master, order.master);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, manager, price, master, done);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", manager=" + manager +
                ", price=" + price +
                ", master=" + master +
                ", done=" + done +
                '}';
    }

    public static final class OrderBuilder {
        private Request request;
        private Integer id;
        private User manager;
        private Integer price;
        private User master;
        private boolean done;

        private OrderBuilder() {
        }

        public OrderBuilder withRequest(Request request) {
            this.request = request;
            return this;
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

        public OrderBuilder withDone(boolean done) {
            this.done = done;
            return this;
        }

        public Order build() {
            Order order = new Order(request);
            order.setManager(manager);
            order.setPrice(price);
            order.setMaster(master);
            order.setDone(done);
            order.id = this.id;
            return order;
        }
    }
}
