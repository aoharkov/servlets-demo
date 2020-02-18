package aoharkov.training.repairagency.dao.impl;

import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.connector.Connector;
import aoharkov.training.repairagency.dao.connector.HikariCP;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.entity.UserEntity;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {
    private static final String DB_TEST = "db_test";

    private static TestDBLoader loader;
    private static Connector connector;
    private static UserEntity userEntity4;

    private UserDao userDao;

    @BeforeClass
    public static void setup() {
        loader = new TestDBLoader();
        connector = new HikariCP(DB_TEST);
        userEntity4 = UserEntity.builder()
                .withId(4)
                .withName("John")
                .withSurname("Doe")
                .withEmail("john.doe@email.com")
                .withPassword("12345678")
                .withRole(Role.CLIENT)
                .build();
    }

    @Before
    public void reload() {
        loader.reloadTestDB(connector);
        userDao = new UserDaoImpl(connector);
    }

    @Test
    public void countShouldReturnSizeOf3() {
        assertEquals(3, userDao.count());
    }

    @Test
    public void saveShouldIncreaseSizeTo4() {
        userDao.save(userEntity4);
        assertEquals(4, userDao.count());
    }

    @Test
    public void findByIdShouldFindUser4() {
        userDao.save(userEntity4);
        assertEquals(Optional.of(userEntity4), userDao.findById(4));
    }

    @Test
    public void findByEmailShouldFindUser4() {
        userDao.save(userEntity4);
        assertEquals(Optional.of(userEntity4), userDao.findByEmail("john.doe@email.com"));
    }

    @Test
    public void findAllShouldFindPage1WithUser1AndUser2() {
        UserEntity[] expected = new UserEntity[]{userDao.findById(1).get(), userDao.findById(2).get()};
        Page<UserEntity> page = userDao.findAll(1, 2);
        assertArrayEquals(expected, page.getContent().toArray());
    }

    @Test
    public void updateShouldUpdateUser4() {
        userDao.save(userEntity4);
        UserEntity userEntity4Updated = UserEntity.builder()
                .withId(4)
                .withName("Jane")
                .withSurname("Doe")
                .withEmail("jane.doe@email.com")
                .withPassword("12345678")
                .withRole(Role.CLIENT)
                .build();
        userDao.update(userEntity4Updated);
        assertEquals(Optional.of(userEntity4Updated), userDao.findByEmail("jane.doe@email.com"));
    }
}