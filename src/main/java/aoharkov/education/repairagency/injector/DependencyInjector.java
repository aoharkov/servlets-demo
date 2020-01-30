package aoharkov.education.repairagency.injector;

import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RefusalDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.impl.FeedbackDaoImpl;
import aoharkov.education.repairagency.dao.impl.OrderDaoImpl;
import aoharkov.education.repairagency.dao.impl.RefusalDaoImpl;
import aoharkov.education.repairagency.dao.impl.RepairStageDaoImpl;
import aoharkov.education.repairagency.dao.impl.RequestDaoImpl;
import aoharkov.education.repairagency.dao.impl.UserDaoImpl;
import aoharkov.education.repairagency.dao.util.connector.Connector;
import aoharkov.education.repairagency.dao.util.connector.HikariCPImpl;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ClientService;
import aoharkov.education.repairagency.service.ManagerService;
import aoharkov.education.repairagency.service.MasterService;
import aoharkov.education.repairagency.service.impl.ClientServiceImpl;
import aoharkov.education.repairagency.service.impl.ManagerServiceImpl;
import aoharkov.education.repairagency.service.impl.MasterServiceImpl;
import aoharkov.education.repairagency.service.util.encoder.Encoder;
import aoharkov.education.repairagency.service.util.encoder.EncoderPBKDF2Impl;
import aoharkov.education.repairagency.service.util.validator.UserValidator;
import aoharkov.education.repairagency.service.util.validator.Validator;

public class DependencyInjector {

    private static final DependencyInjector INSTANCE = new DependencyInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidator();

    private static final Encoder PASSWORD_ENCODER = new EncoderPBKDF2Impl();

    private static final Connector CONNECTOR = new HikariCPImpl("database");

    private static final UserDao USER_DAO = new UserDaoImpl(CONNECTOR);

    private static final RequestDao REQUEST_DAO = new RequestDaoImpl(CONNECTOR);

    private static final OrderDao ORDER_DAO = new OrderDaoImpl(CONNECTOR);

    private static final RepairStageDao REPAIR_STAGE_DAO = new RepairStageDaoImpl(CONNECTOR);

    private static final RefusalDao REFUSAL_DAO = new RefusalDaoImpl(CONNECTOR);

    private static final FeedbackDao FEEDBACK_DAO = new FeedbackDaoImpl(CONNECTOR);

    private static final ClientService CLIENT_SERVICE = new ClientServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR);

    private static final ManagerService MANAGER_SERVICE = new ManagerServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR);

    private static final MasterService MASTER_SERVICE = new MasterServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR);

    private DependencyInjector() {

    }

    public static DependencyInjector getInstance() {
        return INSTANCE;
    }

}
