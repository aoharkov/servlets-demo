package aoharkov.training.repairagency.dao;

import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.entity.RequestEntity;

public interface RequestDao extends CrudPageableDao<RequestEntity> {

    Page<RequestEntity> findAllByClientId(int pageNumber, int itemsPerPage, int clientId);
}
