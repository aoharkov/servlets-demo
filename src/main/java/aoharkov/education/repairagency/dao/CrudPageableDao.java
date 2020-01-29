package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.dao.domain.Pageable;

import java.util.Optional;

public interface CrudPageableDao<E> {

    void save(E entity);

    Optional<E> findById(Integer id);

    Pageable<E> findAll(int page, int itemsPerPage);

    int count();

    void update(E entity);

    void deleteById(Integer id);

}
