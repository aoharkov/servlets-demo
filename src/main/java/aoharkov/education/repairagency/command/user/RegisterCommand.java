package aoharkov.education.repairagency.command.user;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.service.UserService;

import javax.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    private final UserService userService;

    public RegisterCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        //todo
        return "view/index.jsp";
    }
}
