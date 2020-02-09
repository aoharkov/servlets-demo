package aoharkov.training.repairagency.dao.domain;

import java.util.List;

public class Page<T> {
    private final List<T> items;
    private final int pageNumber;
    private final int itemsNumberPerPage;
    private final int lastPageNumber;

    private Page(Builder<T> builder) {
        this.items = builder.items;
        this.pageNumber = builder.pageNumber;
        this.itemsNumberPerPage = builder.itemsNumberPerPage;
        this.lastPageNumber = builder.lastPageNumber;
    }

    public static <T> Builder builder() {
        return new Builder<T>();
    }

    public List<T> getItems() {
        return items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsNumberPerPage() {
        return itemsNumberPerPage;
    }

    public int getLastPageNumber() {
        return lastPageNumber;
    }

    public static class Builder<T> {
        private List<T> items;
        private int pageNumber;
        private int itemsNumberPerPage;
        private int lastPageNumber;

        private Builder() {
        }

        public Page<T> build() {
            return new Page<>(this);
        }

        public Builder<T> withItems(List<T> items) {
            this.items = items;
            return this;
        }

        public Builder<T> withPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder<T> withItemsNumberPerPage(int itemsNumberPerPage) {
            this.itemsNumberPerPage = itemsNumberPerPage;
            return this;
        }

        public Builder<T> withMaxPageNumber(int maxPageNumber) {
            this.lastPageNumber = maxPageNumber;
            return this;
        }
    }
}
