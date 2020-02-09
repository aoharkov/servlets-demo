package aoharkov.training.repairagency.entity;

import java.util.Objects;

public class OrderEntity {
    private final Integer id;
    private final Integer requestId;
    private final Integer managerId;
    private final Integer price;
    private final Integer masterId;
    private final Integer repairStageId;

    private OrderEntity(Builder builder) {
        this.id = builder.id;
        this.requestId = builder.requestId;
        this.managerId = builder.managerId;
        this.price = builder.price;
        this.masterId = builder.masterId;
        this.repairStageId = builder.repairStageId;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getId() {
        return id;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public Integer getRepairStageId() {
        return repairStageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OrderEntity)) {
            return false;
        }
        OrderEntity that = (OrderEntity) o;
        return id.equals(that.id) &&
                Objects.equals(requestId, that.requestId) &&
                Objects.equals(managerId, that.managerId) &&
                Objects.equals(price, that.price) &&
                Objects.equals(masterId, that.masterId) &&
                Objects.equals(repairStageId, that.repairStageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requestId, managerId, price, masterId, repairStageId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", requestId=" + requestId +
                ", managerId=" + managerId +
                ", price=" + price +
                ", masterId=" + masterId +
                ", repairStageId=" + repairStageId +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private Integer requestId;
        private Integer managerId;
        private Integer price;
        private Integer masterId;
        private Integer repairStageId;

        private Builder() {
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withRequestId(Integer requestId) {
            this.requestId = requestId;
            return this;
        }

        public Builder withManagerId(Integer managerId) {
            this.managerId = managerId;
            return this;
        }

        public Builder withPrice(Integer price) {
            this.price = price;
            return this;
        }

        public Builder withMasterId(Integer masterId) {
            this.masterId = masterId;
            return this;
        }

        public Builder withRepairStageId(Integer repairStageId) {
            this.repairStageId = repairStageId;
            return this;
        }

        public OrderEntity build() {
            return new OrderEntity(this);
        }
    }
}
