package aoharkov.training.repairagency.service.impl;

import aoharkov.training.repairagency.dao.FeedbackDao;
import aoharkov.training.repairagency.dao.OrderDao;
import aoharkov.training.repairagency.dao.RefusalDao;
import aoharkov.training.repairagency.dao.RepairStageDao;
import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.UserDao;
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
import aoharkov.training.repairagency.service.validator.UserValidatorImpl;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {
    private static final RequestEntity REQUEST_ENTITY = RequestEntity.builder()
            .withId(1)
            .build();
    private static final Request REQUEST = Request.builder()
            .withId(1)
            .build();
    private static final OrderEntity ORDER_ENTITY = OrderEntity.builder()
            .withId(2)
            .withRequestId(1)
            .build();
    private static final Order ORDER = Order.builder()
            .withId(2)
            .withRequest(REQUEST)
            .build();
    private static final RefusalEntity REFUSAL_ENTITY = RefusalEntity.builder()
            .withId(3)
            .withRequestId(1)
            .build();
    private static final Refusal REFUSAL = Refusal.builder()
            .withId(3)
            .withRequest(REQUEST)
            .build();
    private static final FeedbackEntity FEEDBACK_ENTITY = FeedbackEntity.builder()
            .withId(4)
            .withRequestId(1)
            .build();
    private static final Feedback FEEDBACK = Feedback.builder()
            .withId(4)
            .withRequest(REQUEST)
            .build();
    private static final RepairStageEntity REPAIR_STAGE_ENTITY = RepairStageEntity.builder()
            .withId(5)
            .build();
    private static final RepairStage REPAIR_STAGE = RepairStage.builder()
            .withId(5)
            .build();

    @Mock
    private UserValidatorImpl userValidator;
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
        verifyZeroInteractions(userValidator);
        verifyZeroInteractions(passwordEncoder);
        verifyZeroInteractions(userDao);
        verifyZeroInteractions(userMapper);
        //verifyZeroInteractions(requestDao);
        verifyZeroInteractions(refusalDao);
        verifyZeroInteractions(orderDao);
        verifyZeroInteractions(repairStageDao);
        verifyZeroInteractions(feedbackDao);
        //verifyZeroInteractions(requestMapper);
        verifyZeroInteractions(refusalMapper);
        verifyZeroInteractions(orderMapper);
        verifyZeroInteractions(repairStageMapper);
        verifyZeroInteractions(feedbackMapper);
    }

    @Test
    public void findOwnRequests() {
    }

    @Test
    public void findOrder() {
    }

    @Test
    public void findRefusal() {
    }

    @Test
    public void saveFeedback() {
    }

    @Test
    public void findRepairStage() {
    }
}