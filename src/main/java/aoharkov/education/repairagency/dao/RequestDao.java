package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.RequestEntity;

public interface RequestDao extends CrudPageableDao<RequestEntity> {

    Page<RequestEntity> findAllByClientId(int pageNumber, int itemsPerPage, int clientId);
}
