package aoharkov.training.repairagency.injector;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.command.admin.FindAllUsersCommand;
import aoharkov.training.repairagency.command.client.FindOwnRequestsCommand;
import aoharkov.training.repairagency.command.client.NewFeedbackCommand;
import aoharkov.training.repairagency.command.client.NewRequestCommand;
import aoharkov.training.repairagency.command.manager.FindAllFeedbackCommand;
import aoharkov.training.repairagency.command.manager.FindAllOrdersCommand;
import aoharkov.training.repairagency.command.manager.FindAllRefusalsCommand;
import aoharkov.training.repairagency.command.manager.FindAllRequestsCommand;
import aoharkov.training.repairagency.command.manager.NewOrderCommand;
import aoharkov.training.repairagency.command.manager.NewRefusalCommand;
import aoharkov.training.repairagency.command.master.FindAllRepairStagesCommand;
import aoharkov.training.repairagency.command.master.ProcessOrdersCommand;
import aoharkov.training.repairagency.command.user.InitialRedirectCommand;
import aoharkov.training.repairagency.command.user.LoginCommand;
import aoharkov.training.repairagency.command.user.LogoutCommand;
import aoharkov.training.repairagency.command.user.RedirectToHomeCommand;
import aoharkov.training.repairagency.command.user.RegisterCommand;
import aoharkov.training.repairagency.dao.FeedbackDao;
import aoharkov.training.repairagency.dao.OrderDao;
import aoharkov.training.repairagency.dao.RefusalDao;
import aoharkov.training.repairagency.dao.RepairStageDao;
import aoharkov.training.repairagency.dao.RequestDao;
import aoharkov.training.repairagency.dao.UserDao;
import aoharkov.training.repairagency.dao.connector.Connector;
import aoharkov.training.repairagency.dao.connector.HikariCP;
import aoharkov.training.repairagency.dao.impl.FeedbackDaoImpl;
import aoharkov.training.repairagency.dao.impl.OrderDaoImpl;
import aoharkov.training.repairagency.dao.impl.RefusalDaoImpl;
import aoharkov.training.repairagency.dao.impl.RepairStageDaoImpl;
import aoharkov.training.repairagency.dao.impl.RequestDaoImpl;
import aoharkov.training.repairagency.dao.impl.UserDaoImpl;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.mapper.FeedbackMapper;
import aoharkov.training.repairagency.mapper.OrderMapper;
import aoharkov.training.repairagency.mapper.RefusalMapper;
import aoharkov.training.repairagency.mapper.RepairStageMapper;
import aoharkov.training.repairagency.mapper.RequestMapper;
import aoharkov.training.repairagency.mapper.UserMapper;
import aoharkov.training.repairagency.service.AdminService;
import aoharkov.training.repairagency.service.ClientService;
import aoharkov.training.repairagency.service.ManagerService;
import aoharkov.training.repairagency.service.MasterService;
import aoharkov.training.repairagency.service.UserService;
import aoharkov.training.repairagency.service.encoder.BCryptEncoder;
import aoharkov.training.repairagency.service.encoder.Encoder;
import aoharkov.training.repairagency.service.impl.AdminServiceImpl;
import aoharkov.training.repairagency.service.impl.ClientServiceImpl;
import aoharkov.training.repairagency.service.impl.ManagerServiceImpl;
import aoharkov.training.repairagency.service.impl.MasterServiceImpl;
import aoharkov.training.repairagency.service.impl.UserServiceImpl;
import aoharkov.training.repairagency.service.validator.UserValidatorImpl;
import aoharkov.training.repairagency.service.validator.Validator;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {

    private static final DependencyInjector INSTANCE = new DependencyInjector();

    private static final Validator<User> USER_VALIDATOR = new UserValidatorImpl();

    private static final Encoder PASSWORD_ENCODER = new BCryptEncoder();

    private static final Connector CONNECTOR = new HikariCP("db");

    private static final UserDao USER_DAO = new UserDaoImpl(CONNECTOR);

    private static final RequestDao REQUEST_DAO = new RequestDaoImpl(CONNECTOR);

    private static final OrderDao ORDER_DAO = new OrderDaoImpl(CONNECTOR);

    private static final RepairStageDao REPAIR_STAGE_DAO = new RepairStageDaoImpl(CONNECTOR);

    private static final RefusalDao REFUSAL_DAO = new RefusalDaoImpl(CONNECTOR);

    private static final FeedbackDao FEEDBACK_DAO = new FeedbackDaoImpl(CONNECTOR);

    private static final UserMapper USER_MAPPER = new UserMapper();

    private static final RequestMapper REQUEST_MAPPER = new RequestMapper();

    private static final RefusalMapper REFUSAL_MAPPER = new RefusalMapper();

    private static final RepairStageMapper REPAIR_STAGE_MAPPER = new RepairStageMapper();

    private static final OrderMapper ORDER_MAPPER = new OrderMapper();

    private static final FeedbackMapper FEEDBACK_MAPPER = new FeedbackMapper();

    private static final UserService USER_SERVICE =
            new UserServiceImpl(PASSWORD_ENCODER, USER_VALIDATOR, USER_DAO, USER_MAPPER);

    private static final ClientService CLIENT_SERVICE =
            new ClientServiceImpl(PASSWORD_ENCODER, USER_VALIDATOR,
                    USER_DAO, REQUEST_DAO, REFUSAL_DAO,
                    ORDER_DAO, REPAIR_STAGE_DAO, FEEDBACK_DAO,
                    USER_MAPPER, REQUEST_MAPPER, REFUSAL_MAPPER,
                    ORDER_MAPPER, REPAIR_STAGE_MAPPER, FEEDBACK_MAPPER);

    private static final ManagerService MANAGER_SERVICE =
            new ManagerServiceImpl(PASSWORD_ENCODER, USER_VALIDATOR,
                    USER_DAO, REQUEST_DAO, REFUSAL_DAO,
                    ORDER_DAO, FEEDBACK_DAO,
                    USER_MAPPER, REQUEST_MAPPER, REFUSAL_MAPPER,
                    ORDER_MAPPER, FEEDBACK_MAPPER);

    private static final MasterService MASTER_SERVICE =
            new MasterServiceImpl(PASSWORD_ENCODER, USER_VALIDATOR,
                    USER_DAO, REQUEST_DAO,
                    ORDER_DAO, REPAIR_STAGE_DAO,
                    USER_MAPPER, REQUEST_MAPPER,
                    ORDER_MAPPER, REPAIR_STAGE_MAPPER);

    private static final AdminService ADMIN_SERVICE =
            new AdminServiceImpl(PASSWORD_ENCODER, USER_VALIDATOR, USER_DAO, USER_MAPPER);

    private static final Command INITIAL_REDIRECT_COMMAND = new InitialRedirectCommand();

    private static final Command LOGIN_COMMAND = new LoginCommand(USER_SERVICE);

    private static final Command REGISTER_COMMAND = new RegisterCommand(USER_SERVICE, PASSWORD_ENCODER);

    private static final Command REDIRECT_TO_HOME_COMMAND = new RedirectToHomeCommand();

    private static final Command FIND_ALL_USERS = new FindAllUsersCommand(ADMIN_SERVICE);

    private static final Command FIND_OWN_REQUESTS_COMMAND = new FindOwnRequestsCommand(CLIENT_SERVICE);

    private static final Command NEW_FEEDBACK_COMMAND = new NewFeedbackCommand(CLIENT_SERVICE);

    private static final Command NEW_REQUEST_COMMAND = new NewRequestCommand(CLIENT_SERVICE);

    private static final Command FIND_ALL_REQUESTS_COMMAND = new FindAllRequestsCommand(MANAGER_SERVICE);

    private static final Command NEW_ORDER_COMMAND = new NewOrderCommand(MANAGER_SERVICE);

    private static final Command NEW_REFUSAL_COMMAND = new NewRefusalCommand(MANAGER_SERVICE);

    private static final Command FIND_ALL_ORDERS_COMMAND = new FindAllOrdersCommand(MANAGER_SERVICE);

    private static final Command FIND_ALL_REFUSALS_COMMAND = new FindAllRefusalsCommand(MANAGER_SERVICE);

    private static final Command FIND_ALL_FEEDBACK_COMMAND = new FindAllFeedbackCommand(MANAGER_SERVICE);

    private static final Command PROCESS_ORDERS_COMMAND = new ProcessOrdersCommand(MASTER_SERVICE);

    private static final Command FIND_ALL_REPAIR_STAGES_COMMAND = new FindAllRepairStagesCommand(MASTER_SERVICE);

    private static final Command LOGOUT_COMMAND = new LogoutCommand();

    private static final Map<String, Command> COMMANDS = initCommands();

    private DependencyInjector() {

    }

    private static Map<String, Command> initCommands() {
        Map<String, Command> userCommandNameToCommand = new HashMap<>();
        userCommandNameToCommand.put("/", INITIAL_REDIRECT_COMMAND);
        userCommandNameToCommand.put("/login", LOGIN_COMMAND);
        userCommandNameToCommand.put("/register", REGISTER_COMMAND);
        userCommandNameToCommand.put("/home", REDIRECT_TO_HOME_COMMAND);
        userCommandNameToCommand.put("/admin/home", REDIRECT_TO_HOME_COMMAND);
        userCommandNameToCommand.put("/client/home", REDIRECT_TO_HOME_COMMAND);
        userCommandNameToCommand.put("/mgr/home", REDIRECT_TO_HOME_COMMAND);
        userCommandNameToCommand.put("/master/home", REDIRECT_TO_HOME_COMMAND);
        userCommandNameToCommand.put("/admin/users", FIND_ALL_USERS);
        userCommandNameToCommand.put("/client/requests", FIND_OWN_REQUESTS_COMMAND);
        userCommandNameToCommand.put("/client/new/feedback", NEW_FEEDBACK_COMMAND);
        userCommandNameToCommand.put("/client/new/request", NEW_REQUEST_COMMAND);
        userCommandNameToCommand.put("/mgr/requests", FIND_ALL_REQUESTS_COMMAND);
        userCommandNameToCommand.put("/mgr/new/order", NEW_ORDER_COMMAND);
        userCommandNameToCommand.put("/mgr/new/refusal", NEW_REFUSAL_COMMAND);
        userCommandNameToCommand.put("/mgr/orders", FIND_ALL_ORDERS_COMMAND);
        userCommandNameToCommand.put("/mgr/refusals", FIND_ALL_REFUSALS_COMMAND);
        userCommandNameToCommand.put("/mgr/feedback", FIND_ALL_FEEDBACK_COMMAND);
        userCommandNameToCommand.put("/master/orders", PROCESS_ORDERS_COMMAND);
        userCommandNameToCommand.put("/master/stages", FIND_ALL_REPAIR_STAGES_COMMAND);
        userCommandNameToCommand.put("/logout", LOGOUT_COMMAND);
        return Collections.unmodifiableMap(userCommandNameToCommand);
    }

    public static DependencyInjector getInstance() {
        return INSTANCE;
    }

    public Map<String, Command> getCommands() {
        return COMMANDS;
    }
}
