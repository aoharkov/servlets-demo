package aoharkov.education.repairagency.dao.domain;

import java.util.List;

public interface Pageable<T> {

    List<T> getItems();

    int getPageNumber();

    int getItemsNumberPerPage();

    int getMaxPageNumber();
}
