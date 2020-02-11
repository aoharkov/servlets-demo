package aoharkov.training.repairagency.mapper;

import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.entity.UserEntity;

public class UserMapper implements Mapper<UserEntity, User> {

    @Override
    public UserEntity mapDomainToEntity(User user) {
        return UserEntity.builder()
                .withId(user.getId())
                .withName(user.getName())
                .withSurname(user.getSurname())
                .withEmail(user.getEmail())
                .withPassword(user.getPassword())
                .withRole(user.getRole())
                .build();
    }

    @Override
    public User mapEntityToDomain(UserEntity userEntity) {
        return User.builder()
                .withId(userEntity.getId())
                .withName(userEntity.getName())
                .withSurname(userEntity.getSurname())
                .withEmail(userEntity.getEmail())
                .withPassword(userEntity.getPassword())
                .withRole(userEntity.getRole())
                .build();
    }
}
