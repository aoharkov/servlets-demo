package aoharkov.education.repairagency.command.client;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.domain.Role;
import aoharkov.education.repairagency.domain.User;
import aoharkov.education.repairagency.service.ClientService;

import javax.servlet.http.HttpServletRequest;

public class ListOwnRequestsCommand implements Command {
    private final ClientService clientService;

    public ListOwnRequestsCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final User user = (User) request.getSession().getAttribute("user");
        final Role role = user.getRole();
        if (role != Role.CLIENT) {
            return ERROR_PAGE;
        }
        //todo
        return "view/user/requests.jsp";
    }
}
