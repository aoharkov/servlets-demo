package aoharkov.training.repairagency.dao.impl;

import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.connector.Connector;
import aoharkov.training.repairagency.dao.connector.HikariCP;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.entity.RequestEntity;
import org.junit.Assert;
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
    private static RequestEntity requestEntity4;

    private RequestDao requestDao;

    @BeforeClass
    public static void setup() {
        loader = new TestDBLoader();
        connector = new HikariCP(DB_TEST);
        requestEntity4 = RequestEntity.builder()
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
        requestDao.save(requestEntity4);
        assertEquals(4, requestDao.count());
    }

    @Test
    public void findByIdShouldFindUser4() {
        requestDao.save(requestEntity4);
        assertEquals(Optional.of(requestEntity4), requestDao.findById(4));
    }

    @Test
    public void findAllShouldFindPage1WithRequest1AndRequest2() {
        RequestEntity[] expected = new RequestEntity[]{requestDao.findById(1).get(), requestDao.findById(2).get()};
        Page<RequestEntity> page = requestDao.findAll(1, 2);
        assertArrayEquals(expected, page.getItems().toArray());
    }

    @Test
    public void updateShouldUpdateRequest4() {
        requestDao.save(requestEntity4);
        RequestEntity requestEntity4Updated = RequestEntity.builder()
                .withId(4)
                .withClientId(1)
                .withDescription("some text")
                .withViewed(true)
                .withAccepted(true)
                .build();
        requestDao.update(requestEntity4Updated);
        assertEquals(Optional.of(requestEntity4Updated), requestDao.findById(4));
    }

    @Test
    public void findAllByClientIdShouldReturnListOfSize3() {
        Assert.assertEquals(3, requestDao.findAllByClientId(1, 4, 1).getItems().size());
    }
}