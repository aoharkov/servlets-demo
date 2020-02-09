package aoharkov.training.repairagency.dao;

import aoharkov.training.repairagency.entity.UserEntity;

import java.util.Optional;

public interface UserDao extends CrudPageableDao<UserEntity> {

    Optional<UserEntity> findByEmail(String email);
}
