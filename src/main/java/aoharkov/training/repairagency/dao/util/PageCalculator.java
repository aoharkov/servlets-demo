package aoharkov.training.repairagency.dao.util;

public class PageCalculator {

    private PageCalculator() {
    }

    public static int calculateMaxPageNumber(int itemsPerPage, int rowNum) {
        return (rowNum + itemsPerPage - 1) / itemsPerPage;
    }

    public static int fitPageNumber(int pageNumber, int maxPageNumber) {
        return pageNumber > maxPageNumber ? maxPageNumber : Math.max(pageNumber, 1);
    }

    public static int calculateOffset(int pageNumber, int itemsPerPage) {
        return (pageNumber - 1) * itemsPerPage;
    }
}
