package aoharkov.training.repairagency.command.user;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");

        final User user = userService.login(email, password);
        request.getSession().setAttribute("user", user);

        response.sendRedirect("/home");
    }
}
