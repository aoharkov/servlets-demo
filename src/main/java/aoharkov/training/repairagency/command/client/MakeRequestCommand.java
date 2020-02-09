package aoharkov.training.repairagency.command.client;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.ClientService;

import javax.servlet.http.HttpServletRequest;

public class MakeRequestCommand implements Command {
    private final ClientService clientService;

    public MakeRequestCommand(ClientService clientService) {
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
        return "view/user/request.jsp";
    }
}
