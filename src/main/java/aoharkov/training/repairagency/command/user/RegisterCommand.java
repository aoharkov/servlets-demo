package aoharkov.training.repairagency.command.user;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.UserService;
import aoharkov.training.repairagency.service.encoder.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterCommand implements Command {
    private final UserService userService;
    private final Encoder encoder;

    public RegisterCommand(UserService userService, Encoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("/register", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = User.builder()
                .withName(request.getParameter("name"))
                .withSurname(request.getParameter("surname"))
                .withEmail(request.getParameter("email"))
                .withPassword(encoder.encode(request.getParameter("password")))
                .withRole(Role.CLIENT)
                .build();
        userService.register(user);
        forward("/login", request, response);
    }
}
