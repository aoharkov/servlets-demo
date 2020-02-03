package aoharkov.education.repairagency.command.manager;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.service.ManagerService;

import javax.servlet.http.HttpServletRequest;

public class ListAllRequestsCommand implements Command {
    private final ManagerService userService;

    public ListAllRequestsCommand(ManagerService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //todo
        return "view/listRequests.jsp";
    }
}
