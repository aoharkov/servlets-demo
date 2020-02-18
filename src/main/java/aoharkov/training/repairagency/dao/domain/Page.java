package aoharkov.training.repairagency.dao.domain;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final int pageNumber;
    private final int itemsNumberPerPage;
    private final int totalPages;

    private Page(Builder<T> builder) {
        this.content = builder.content;
        this.pageNumber = builder.pageNumber;
        this.itemsNumberPerPage = builder.itemsNumberPerPage;
        this.totalPages = builder.totalPages;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public List<T> getContent() {
        return content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getItemsNumberPerPage() {
        return itemsNumberPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public static class Builder<T> {
        private List<T> content;
        private int pageNumber;
        private int itemsNumberPerPage;
        private int totalPages;

        private Builder() {
        }

        public Page<T> build() {
            return new Page<>(this);
        }

        public Builder<T> withContent(List<T> items) {
            this.content = items;
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

        public Builder<T> withTotalPages(int totalPages) {
            this.totalPages = totalPages;
            return this;
        }
    }
}
