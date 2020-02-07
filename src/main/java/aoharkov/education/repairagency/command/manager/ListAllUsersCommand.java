package aoharkov.education.repairagency.command.manager;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.ManagerService;

import javax.servlet.http.HttpServletRequest;

public class ListAllUsersCommand implements Command {
    private final ManagerService managerService;

    public ListAllUsersCommand(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final User user = (User) request.getSession().getAttribute("user");
        final Role role = user.getRole();
        if (role != Role.MANAGER) {
            return ERROR_PAGE;
        }
        //todo
        return "view/manager/users.jsp";
    }
}
