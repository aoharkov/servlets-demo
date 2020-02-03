package aoharkov.education.repairagency.command.client;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.entity.Role;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.ClientService;

import javax.servlet.http.HttpServletRequest;

public class MakeRequestCommand implements Command {
    private final ClientService userService;

    public MakeRequestCommand(ClientService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final User user = (User) request.getSession().getAttribute("user");
        final Role role = user.getRole();
        if (role != Role.CLIENT) {
            return ERROR_PAGE;
        }
        //todo
        return "view/user/request.jsp";
    }
}
