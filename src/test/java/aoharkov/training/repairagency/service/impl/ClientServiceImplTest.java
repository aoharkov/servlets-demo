package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.FeedbackDao;
import aoharkov.training.repairagency.dao.OrderDao;
import aoharkov.training.repairagency.dao.RefusalDao;
import aoharkov.training.repairagency.dao.RepairStageDao;
import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.entity.FeedbackEntity;
import aoharkov.training.repairagency.entity.OrderEntity;
import aoharkov.training.repairagency.entity.RefusalEntity;
import aoharkov.training.repairagency.entity.RepairStageEntity;
import aoharkov.training.repairagency.entity.RequestEntity;
import aoharkov.training.repairagency.mapper.FeedbackMapper;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RefusalMapper;
import aoharkov.training.repairagency.mapper.RepairStageMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.exception.EntityNotFoundException;
import aoharkov.training.repairagency.service.validator.Validator;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    private static final RequestEntity REQUEST_ENTITY = initRequestEntity();
    private static final Request REQUEST = initRequest();
    private static final Page<RequestEntity> REQUEST_ENTITY_PAGE = initRequestEntityPage();
    private static final RepairStageEntity REPAIR_STAGE_ENTITY = initRepairStageEntity();
    private static final RepairStage REPAIR_STAGE = initRepairStage();
    private static final OrderEntity ORDER_ENTITY = initOrderEntity();
    private static final Order ORDER = initOrder();
    private static final RefusalEntity REFUSAL_ENTITY = initRefusalEntity();
    private static final Refusal REFUSAL = initRefusal();
    private static final FeedbackEntity FEEDBACK_ENTITY = initFeedbackEntity();
    private static final Feedback FEEDBACK = initFeedback();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Mock
    private Validator userValidator;
    @Mock
    private Encoder passwordEncoder;
    @Mock
    private UserDao userDao;
    @Mock
    private UserMapper userMapper;
    @Mock
    private RequestDao requestDao;
    @Mock
    private RefusalDao refusalDao;
    @Mock
    private OrderDao orderDao;
    @Mock
    private RepairStageDao repairStageDao;
    @Mock
    private FeedbackDao feedbackDao;
    @Mock
    private RequestMapper requestMapper;
    @Mock
    private RefusalMapper refusalMapper;
    @Mock
    private OrderMapper orderMapper;
    @Mock
    private RepairStageMapper repairStageMapper;
    @Mock
    private FeedbackMapper feedbackMapper;

    @InjectMocks
    private ClientServiceImpl clientService;

    private static RequestEntity initRequestEntity() {
        return RequestEntity.builder()
                .withId(1)
                .build();
    }

    private static Request initRequest() {
        return Request.builder()
                .withId(1)
                .build();
    }

    private static Page<RequestEntity> initRequestEntityPage() {
        return Page.<RequestEntity>builder()
                .withContent(Arrays.asList(REQUEST_ENTITY, REQUEST_ENTITY))
                .build();
    }

    private static OrderEntity initOrderEntity() {
        return OrderEntity.builder()
                .withId(2)
                .withRequestId(1)
                .withRepairStageId(5)
                .build();
    }

    private static Order initOrder() {
        return Order.builder()
                .withId(2)
                .withRequest(REQUEST)
                .withRepairStage(REPAIR_STAGE)
                .build();
    }

    private static RefusalEntity initRefusalEntity() {
        return RefusalEntity.builder()
                .withId(3)
                .withRequestId(1)
                .build();
    }

    private static Refusal initRefusal() {
        return Refusal.builder()
                .withId(3)
                .withRequest(REQUEST)
                .build();
    }

    private static FeedbackEntity initFeedbackEntity() {
        return FeedbackEntity.builder()
                .withId(4)
                .withRequestId(1)
                .build();
    }

    private static Feedback initFeedback() {
        return Feedback.builder()
                .withId(4)
                .withRequest(REQUEST)
                .build();
    }

    private static RepairStageEntity initRepairStageEntity() {
        return RepairStageEntity.builder()
                .withId(5)
                .build();
    }

    private static RepairStage initRepairStage() {
        return RepairStage.builder()
                .withId(5)
                .build();
    }

    @After
    public void resetMocks() {
        Mockito.reset(userValidator, passwordEncoder, userDao, userMapper,
                requestDao, refusalDao, orderDao, repairStageDao, feedbackDao,
                requestMapper, refusalMapper, orderMapper, repairStageMapper, feedbackMapper);
    }

    @Test
    public void saveRequestShouldSaveSuccessfully() {
        when(requestMapper.mapDomainToEntity(eq(REQUEST))).thenReturn(REQUEST_ENTITY);
        doNothing().when(requestDao).save(REQUEST_ENTITY);

        clientService.saveRequest(REQUEST);

        verify(requestMapper).mapDomainToEntity(eq(REQUEST));
        verify(requestDao).save(eq(REQUEST_ENTITY));
    }

    @Test
    public void findOwnRequestsShouldFindSuccessfully() {
        when(requestDao.findAllByClientId(anyInt(), anyInt(), anyInt())).thenReturn(REQUEST_ENTITY_PAGE);
        when(requestMapper.mapEntityToDomain(eq(REQUEST_ENTITY))).thenReturn(REQUEST);

        assertThat(clientService.findOwnRequests(1, 5, 1).getContent(),
                equalTo(Arrays.asList(REQUEST, REQUEST)));

        verify(requestDao).findAllByClientId(anyInt(), anyInt(), anyInt());
        verify(requestMapper, times(2)).mapEntityToDomain(eq(REQUEST_ENTITY));
    }

    @Test
    public void findRequestShouldFindSuccessfully() {
        when(requestDao.findById(eq(1))).thenReturn(Optional.of(REQUEST_ENTITY));
        when(requestMapper.mapEntityToDomain(eq(REQUEST_ENTITY))).thenReturn(REQUEST);

        assertEquals(REQUEST, clientService.findRequest(1));

        verify(requestDao).findById(eq(1));
        verify(requestMapper).mapEntityToDomain(eq(REQUEST_ENTITY));
    }

    @Test
    public void findRequestShouldThrowEntityNotFoundException() {
        when(requestDao.findById(eq(99))).thenReturn(Optional.empty());

        exception.expect(EntityNotFoundException.class);
        clientService.findRequest(99);

        verify(requestDao).findById(eq(99));
        verifyZeroInteractions(requestMapper);
    }

    @Test
    public void findOrderShouldFindSuccessfully() {
        when(orderDao.findByRequestId(eq(1))).thenReturn(Optional.of(ORDER_ENTITY));
        when(orderMapper.mapEntityToDomain(eq(ORDER_ENTITY))).thenReturn(ORDER);

        assertEquals(ORDER, clientService.findOrder(1));

        verify(orderDao).findByRequestId(eq(1));
        verify(orderMapper).mapEntityToDomain(eq(ORDER_ENTITY));
    }

    @Test
    public void findOrderShouldThrowEntityNotFoundException() {
        when(orderDao.findByRequestId(eq(99))).thenReturn(Optional.empty());

        exception.expect(EntityNotFoundException.class);
        clientService.findOrder(99);

        verify(orderDao).findByRequestId(eq(99));
        verifyZeroInteractions(requestMapper);
    }

    @Test
    public void findRefusalShouldFindSuccessfully() {
        when(refusalDao.findByRequestId(eq(1))).thenReturn(Optional.of(REFUSAL_ENTITY));
        when(refusalMapper.mapEntityToDomain(eq(REFUSAL_ENTITY))).thenReturn(REFUSAL);

        assertEquals(REFUSAL, clientService.findRefusal(1));

        verify(refusalDao).findByRequestId(eq(1));
        verify(refusalMapper).mapEntityToDomain(eq(REFUSAL_ENTITY));
    }

    @Test
    public void findRefusalShouldThrowEntityNotFoundException() {
        when(refusalDao.findByRequestId(eq(99))).thenReturn(Optional.empty());

        exception.expect(EntityNotFoundException.class);
        clientService.findRefusal(99);

        verify(refusalDao).findByRequestId(eq(99));
        verifyZeroInteractions(refusalMapper);
    }

    @Test
    public void saveFeedbackShouldSaveSuccessfully() {
        when(feedbackMapper.mapDomainToEntity(eq(FEEDBACK))).thenReturn(FEEDBACK_ENTITY);
        doNothing().when(feedbackDao).save(FEEDBACK_ENTITY);

        clientService.saveFeedback(FEEDBACK);

        verify(feedbackMapper).mapDomainToEntity(eq(FEEDBACK));
        verify(feedbackDao).save(eq(FEEDBACK_ENTITY));
    }

    @Test
    public void findRepairStageShouldFindSuccessfully() {
        when(orderDao.findByRequestId(eq(1))).thenReturn(Optional.of(ORDER_ENTITY));
        when(orderMapper.mapEntityToDomain(eq(ORDER_ENTITY))).thenReturn(ORDER);
        when(repairStageDao.findById(eq(5))).thenReturn(Optional.of(REPAIR_STAGE_ENTITY));
        when(repairStageMapper.mapEntityToDomain(eq(REPAIR_STAGE_ENTITY))).thenReturn(REPAIR_STAGE);

        assertEquals(REPAIR_STAGE, clientService.findRepairStage(1));

        verify(orderDao).findByRequestId(eq(1));
        verify(orderMapper).mapEntityToDomain(eq(ORDER_ENTITY));
        verify(repairStageDao).findById(eq(5));
        verify(repairStageMapper).mapEntityToDomain(eq(REPAIR_STAGE_ENTITY));
    }

    @Test
    public void findRepairStageShouldThrowEntityNotFoundException() {
        when(orderDao.findByRequestId(eq(99))).thenReturn(Optional.empty());

        exception.expect(EntityNotFoundException.class);
        clientService.findRepairStage(99);

        verify(orderDao).findByRequestId(eq(99));
        verifyZeroInteractions(orderMapper);
        verifyZeroInteractions(repairStageDao);
        verifyZeroInteractions(repairStageMapper);
    }
}