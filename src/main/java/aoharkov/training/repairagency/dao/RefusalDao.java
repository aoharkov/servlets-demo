package aoharkov.training.repairagency.dao;

import aoharkov.training.repairagency.entity.RefusalEntity;

import java.util.Optional;

public interface RefusalDao extends CrudPageableDao<RefusalEntity> {

    Optional<RefusalEntity> findByRequestId(Integer requestId);
}
