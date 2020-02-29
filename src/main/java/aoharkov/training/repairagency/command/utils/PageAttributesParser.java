package aoharkov.training.repairagency.command.utils;

public abstract class PageAttributesParser {
    public static final int DEFAULT_ROWS = 4;
    public static final int DEFAULT_PAGE = 1;

    private PageAttributesParser() {
    }

    public static int parseWithDefault(String str, int defaultValue) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
