package aoharkov.education.repairagency.injector;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.command.manager.ListAllRequestsCommand;
import aoharkov.education.repairagency.command.manager.ListUncheckedRequestsCommand;
import aoharkov.education.repairagency.command.user.LoginCommand;
import aoharkov.education.repairagency.command.user.RegisterCommand;
import aoharkov.education.repairagency.dao.FeedbackDao;
import aoharkov.education.repairagency.dao.OrderDao;
import aoharkov.education.repairagency.dao.RefusalDao;
import aoharkov.education.repairagency.dao.RepairStageDao;
import aoharkov.education.repairagency.dao.RequestDao;
import aoharkov.education.repairagency.dao.UserDao;
import aoharkov.education.repairagency.dao.connector.Connector;
import aoharkov.education.repairagency.dao.connector.HikariCP;
import aoharkov.education.repairagency.dao.impl.FeedbackDaoImpl;
import aoharkov.education.repairagency.dao.impl.OrderDaoImpl;
import aoharkov.education.repairagency.dao.impl.RefusalDaoImpl;
import aoharkov.education.repairagency.dao.impl.RepairStageDaoImpl;
import aoharkov.education.repairagency.dao.impl.RequestDaoImpl;
import aoharkov.education.repairagency.dao.impl.UserDaoImpl;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.AdminService;
import aoharkov.education.repairagency.service.ClientService;
import aoharkov.education.repairagency.service.ManagerService;
import aoharkov.education.repairagency.service.MasterService;
import aoharkov.education.repairagency.service.UserService;
import aoharkov.education.repairagency.service.encoder.Encoder;
import aoharkov.education.repairagency.service.encoder.EncoderPBKDF2;
import aoharkov.education.repairagency.service.impl.AdminServiceImpl;
import aoharkov.education.repairagency.service.impl.ClientServiceImpl;
import aoharkov.education.repairagency.service.impl.ManagerServiceImpl;
import aoharkov.education.repairagency.service.impl.MasterServiceImpl;
import aoharkov.education.repairagency.service.impl.UserServiceImpl;
import aoharkov.education.repairagency.service.validator.UserValidatorImpl;
import aoharkov.education.repairagency.service.validator.Validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {

    private static final DependencyInjector INSTANCE = new DependencyInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidatorImpl();

    private static final Encoder PASSWORD_ENCODER = new EncoderPBKDF2();

    private static final Connector CONNECTOR = new HikariCP("db");

    private static final UserDao USER_DAO = new UserDaoImpl(CONNECTOR);

    private static final RequestDao REQUEST_DAO = new RequestDaoImpl(CONNECTOR);

    private static final OrderDao ORDER_DAO = new OrderDaoImpl(CONNECTOR);

    private static final RepairStageDao REPAIR_STAGE_DAO = new RepairStageDaoImpl(CONNECTOR);

    private static final RefusalDao REFUSAL_DAO = new RefusalDaoImpl(CONNECTOR);

    private static final FeedbackDao FEEDBACK_DAO = new FeedbackDaoImpl(CONNECTOR);

    private static final UserService USER_SERVICE =
            new UserServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR, REQUEST_DAO, ORDER_DAO, REPAIR_STAGE_DAO);

    private static final ClientService CLIENT_SERVICE =
            new ClientServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR, REQUEST_DAO, ORDER_DAO, REPAIR_STAGE_DAO, REFUSAL_DAO, FEEDBACK_DAO);

    private static final ManagerService MANAGER_SERVICE =
            new ManagerServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR, REQUEST_DAO, ORDER_DAO, REPAIR_STAGE_DAO, REFUSAL_DAO, FEEDBACK_DAO);

    private static final MasterService MASTER_SERVICE =
            new MasterServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR, REQUEST_DAO, ORDER_DAO, REPAIR_STAGE_DAO);

    private static final AdminService ADMIN_SERVICE =
            new AdminServiceImpl(USER_DAO, PASSWORD_ENCODER, USER_VALIDATOR, REQUEST_DAO, ORDER_DAO, REPAIR_STAGE_DAO, REFUSAL_DAO, FEEDBACK_DAO);

    private static final Command LOGIN_COMMAND = new LoginCommand(USER_SERVICE);

    private static final Command REGISTER_COMMAND = new RegisterCommand(USER_SERVICE);

    private static final Command LIST_ALL_REQUEST_COMMAND = new ListAllRequestsCommand(MANAGER_SERVICE);

    private static final Command LIST_UNCHECKED_REQUESTS_COMMAND = new ListUncheckedRequestsCommand(MANAGER_SERVICE);

    private static final Map<String, Command> COMMANDS = initCommands();

    private DependencyInjector() {

    }

    private static Map<String, Command> initCommands() {
        Map<String, Command> userCommandNameToCommand = new HashMap<>();
        userCommandNameToCommand.put("login", LOGIN_COMMAND);
        userCommandNameToCommand.put("register", REGISTER_COMMAND);
        userCommandNameToCommand.put("listAllRequests", LIST_ALL_REQUEST_COMMAND);
        userCommandNameToCommand.put("listUncheckedRequests", LIST_UNCHECKED_REQUESTS_COMMAND);
        return Collections.unmodifiableMap(userCommandNameToCommand);
    }

    public static DependencyInjector getInstance() {
        return INSTANCE;
    }

    public UserService getUserService() {
        return USER_SERVICE;
    }

    public ClientService getClientService() {
        return CLIENT_SERVICE;
    }

    public ManagerService getManagerService() {
        return MANAGER_SERVICE;
    }

    public MasterService getMasterService() {
        return MASTER_SERVICE;
    }

    public AdminService getAdminService() {
        return ADMIN_SERVICE;
    }

    public Map<String, Command> getCommands() {
        return COMMANDS;
    }
}
