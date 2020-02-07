package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.dao.domain.Page;

import java.util.Optional;

public interface CrudPageableDao<E> {

    void save(E entity);

    Optional<E> findById(Integer id);

    Page<E> findAll(int page, int itemsPerPage);

    Page<E> findAll(int pageNumber, int itemsPerPage, String query);

    Page<E> findAllByForeignId(int pageNumber, int itemsPerPage, int foreignId, String query);

    int count();

    void update(E entity);

}
