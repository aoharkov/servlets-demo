package aoharkov.education.repairagency.dao.domain;

import java.util.List;

public class PageableImpl<T> implements Pageable {
    private final List<T> items;
    private final int pageNumber;
    private final int itemsNumberPerPage;
    private final int maxPageNumber;

    private PageableImpl(Builder<T> builder) {
        this.items = builder.items;
        this.pageNumber = builder.pageNumber;
        this.itemsNumberPerPage = builder.itemsNumberPerPage;
        this.maxPageNumber = builder.maxPageNumber;
    }

    public static <T> Builder builder() {
        return new Builder<T>();
    }

    @Override
    public List<T> getItems() {
        return items;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getItemsNumberPerPage() {
        return itemsNumberPerPage;
    }

    @Override
    public int getMaxPageNumber() {
        return maxPageNumber;
    }

    public static class Builder<T1> {
        private List<T1> items;
        private int pageNumber;
        private int itemsNumberPerPage;
        private int maxPageNumber;

        private Builder() {
        }

        public PageableImpl<T1> build() {
            return new PageableImpl<>(this);
        }

        public Builder<T1> withItems(List<T1> items) {
            this.items = items;
            return this;
        }

        public Builder<T1> withPageNumber(int pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public Builder<T1> withItemsNumberPerPage(int itemsNumberPerPage) {
            this.itemsNumberPerPage = itemsNumberPerPage;
            return this;
        }

        public Builder<T1> withMaxPageNumber(int maxPageNumber) {
            this.maxPageNumber = maxPageNumber;
            return this;
        }
    }
}
