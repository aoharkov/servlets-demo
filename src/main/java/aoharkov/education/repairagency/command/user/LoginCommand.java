package aoharkov.education.repairagency.command.user;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.entity.User;
import aoharkov.education.repairagency.service.UnregisteredUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private final UnregisteredUserService userService;

    public LoginCommand(UnregisteredUserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        final String email = (String) request.getAttribute("email");
        final String password = (String) request.getAttribute("password");

        final User user = userService.login(email, password);

        final HttpSession session = request.getSession();
        session.setAttribute("user", user);
        return "view/main.jsp";
    }
}
