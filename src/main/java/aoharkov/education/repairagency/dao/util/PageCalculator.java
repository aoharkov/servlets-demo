package aoharkov.education.repairagency.dao.util;

public class PageCalculator {

    public static int calculateMaxPageNumber(int itemsPerPage, int rowNum) {
        return (rowNum + itemsPerPage - 1) / itemsPerPage;
    }

    public static int checkPageNumber(int pageNumber, int maxPageNumber) {
        if (pageNumber > maxPageNumber) {
            return maxPageNumber;
        }
        if (pageNumber < 1) {
            return 1;
        }
        return pageNumber;
    }

    public static int calculateOffset(int pageNumber, int itemsPerPage) {
        return (pageNumber - 1) * itemsPerPage;
    }
}
