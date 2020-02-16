package aoharkov.training.repairagency.command.user;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginCommand implements Command {
    private final UserService userService;

    public LoginCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("/login", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String email = (String) request.getAttribute("email");
        final String password = (String) request.getAttribute("password");

        final User user = userService.login(email, password);

        final HttpSession session = request.getSession();
        session.setAttribute("user", user);
        switch (user.getRole()) {
            case ADMIN:
                forward("/admin/home", request, response);
                break;
            case MANAGER:
                forward("/manager/home", request, response);
                break;
            case MASTER:
                forward("/master/home", request, response);
                break;
            default:
                forward("/client/home", request, response);
        }
    }
}
