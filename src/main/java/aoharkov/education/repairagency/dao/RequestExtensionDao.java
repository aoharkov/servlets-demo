package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.entity.Request;
import aoharkov.education.repairagency.entity.RequestExtension;

public interface RequestExtensionDao<T extends RequestExtension> extends CrudPageableDao<T> {

    Request getRequestById(Integer id);
}
