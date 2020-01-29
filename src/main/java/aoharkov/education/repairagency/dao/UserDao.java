package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.entity.User;

import java.util.Optional;

public interface UserDao extends CrudPageableDao<User> {

    Optional<User> findByEmail(String email);
}
