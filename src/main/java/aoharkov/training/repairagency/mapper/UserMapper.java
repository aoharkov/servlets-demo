package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;

public class UserMapper implements Mapper<UserEntity, User> {

    @Override
    public UserEntity mapDomainToEntity(User item) {
        return UserEntity.builder()
                .withId(item.getId())
                .withName(item.getName())
                .withSurname(item.getSurname())
                .withEmail(item.getEmail())
                .withPassword(item.getPassword())
                .withRole(item.getRole())
                .build();
    }

    @Override
    public User mapEntityToDomain(UserEntity entity) {
        return User.builder()
                .withId(entity.getId())
                .withName(entity.getName())
                .withSurname(entity.getSurname())
                .withEmail(entity.getEmail())
                .withPassword(entity.getPassword())
                .withRole(entity.getRole())
                .build();
    }
}
