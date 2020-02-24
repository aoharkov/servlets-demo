package aoharkov.training.repairagency.command.user;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RedirectToHomeCommand implements Command {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            forward("/login", request, response);
        } else {
            User user = (User) session.getAttribute("user");
            switch (user.getRole()) {
                case ADMIN:
                    forward("/admin/home", request, response);
                    break;
                case MANAGER:
                    forward("/mgr/home", request, response);
                    break;
                case MASTER:
                    forward("/master/home", request, response);
                    break;
                default:
                    forward("/client/home", request, response);
            }
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
