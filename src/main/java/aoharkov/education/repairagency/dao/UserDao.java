package aoharkov.education.repairagency.dao;

import aoharkov.education.repairagency.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends CrudPageableDao<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
