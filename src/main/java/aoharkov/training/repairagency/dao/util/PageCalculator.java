package aoharkov.training.repairagency.dao.util;

public class PageCalculator {

    private PageCalculator() {
    }

    public static int calculateTotalPages(int itemsPerPage, int rowNum) {
        return (rowNum + itemsPerPage - 1) / itemsPerPage;
    }

    public static int fitPageNumber(int pageNumber, int totalPages) {
        return pageNumber > totalPages ? totalPages : Math.max(pageNumber, 1);
    }

    public static int calculateOffset(int pageNumber, int itemsPerPage) {
        return (pageNumber - 1) * itemsPerPage;
    }
}
