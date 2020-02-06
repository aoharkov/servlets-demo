package aoharkov.education.repairagency.mapper;

import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.entity.UserEntity;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserMapperTest {
    private static final Mapper<UserEntity, User> MAPPER = new UserMapper();
    private UserEntity entity;
    private User item;

    @Before
    public void setUp() {
        entity = UserEntity.builder()
                .withId(1)
                .withName("John")
                .withSurname("Doe")
                .withEmail("doe@gmail.com")
                .withPassword("pass")
                .withRole(Role.CLIENT)
                .build();
        item = User.builder()
                .withId(1)
                .withName("John")
                .withSurname("Doe")
                .withEmail("doe@gmail.com")
                .withPassword("pass")
                .withRole(Role.CLIENT)
                .build();
    }

    @Test
    public void mapDomainToEntityShouldMapCorrectly() {
        assertEquals(entity, MAPPER.mapDomainToEntity(item));
    }

    @Test
    public void mapEntityToDomainShouldMapCorrectly() {
        assertEquals(item, MAPPER.mapEntityToDomain(entity));
    }
}