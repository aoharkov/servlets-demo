package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.dao.connector.HikariCP;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;
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
    private static User user4;

    private UserDao userDao;

    @BeforeClass
    public static void setup() {
        loader = new TestDBLoader();
        connector = new HikariCP(DB_TEST);
        user4 = User.builder()
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
        userDao.save(user4);
        assertEquals(4, userDao.count());
    }

    @Test
    public void findByIdShouldFindUser4() {
        userDao.save(user4);
        assertEquals(Optional.of(user4), userDao.findById(4));
    }

    @Test
    public void findByEmailShouldFindUser4() {
        userDao.save(user4);
        assertEquals(Optional.of(user4), userDao.findByEmail("john.doe@email.com"));
    }

    @Test
    public void findAllShouldFindPage1WithUser1AndUser2() {
        User[] expected = new User[]{userDao.findById(1).get(),userDao.findById(2).get()};
        Page<User> page = userDao.findAll(1, 2);
        assertArrayEquals(expected, page.getItems().toArray());
    }

    @Test
    public void updateShouldUpdateUser4() {
        userDao.save(user4);
        User user4Updated = User.builder()
                .withId(4)
                .withName("Jane")
                .withSurname("Doe")
                .withEmail("jane.doe@email.com")
                .withPassword("12345678")
                .withRole(Role.CLIENT)
                .build();
        userDao.update(user4Updated);
        assertEquals(Optional.of(user4Updated), userDao.findByEmail("jane.doe@email.com"));
    }
}