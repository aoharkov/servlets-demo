package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.entity.RefusalEntity;

import java.util.Optional;

public interface RefusalDao extends CrudPageableDao<RefusalEntity> {

    Optional<RefusalEntity> findByRequestId(Integer requestId);
}
