package aoharkov.education.repairagency.dao.impl;

import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.dao.connector.HikariCP;
import aoharkov.education.repairagency.dao.domain.Page;
import aoharkov.education.repairagency.entity.Request;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RequestDaoImplTest {
    private static final String DB_TEST = "db_test";

    private static TestDBLoader loader;
    private static Connector connector;
    private static Request request4;

    private RequestDao requestDao;

    @BeforeClass
    public static void setup() {
        loader = new TestDBLoader();
        connector = new HikariCP(DB_TEST);
        request4 = Request.builder()
                .withId(4)
                .withClientId(1)
                .withDescription("some text")
                .withViewed(true)
                .withAccepted(false)
                .build();
    }

    @Before
    public void reload() {
        loader.reloadTestDB(connector);
        requestDao = new RequestDaoImpl(connector);
    }

    @Test
    public void countShouldReturnSizeOf3() {
        assertEquals(3, requestDao.count());
    }

    @Test
    public void saveShouldIncreaseSizeTo4() {
        requestDao.save(request4);
        assertEquals(4, requestDao.count());
    }

    @Test
    public void findByIdShouldFindUser4() {
        requestDao.save(request4);
        assertEquals(Optional.of(request4), requestDao.findById(4));
    }

    @Test
    public void findAllShouldFindPage1WithRequest1AndRequest2() {
        Request[] expected = new Request[]{requestDao.findById(1).get(), requestDao.findById(2).get()};
        Page<Request> page = requestDao.findAll(1, 2);
        assertArrayEquals(expected, page.getItems().toArray());
    }

    @Test
    public void updateShouldUpdateRequest4() {
        requestDao.save(request4);
        Request request4Updated = Request.builder()
                .withId(4)
                .withClientId(1)
                .withDescription("some text")
                .withViewed(true)
                .withAccepted(true)
                .build();
        requestDao.update(request4Updated);
        assertEquals(Optional.of(request4Updated), requestDao.findById(4));
    }
}