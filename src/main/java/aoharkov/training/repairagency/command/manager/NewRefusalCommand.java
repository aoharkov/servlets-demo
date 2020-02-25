package aoharkov.training.repairagency.command.manager;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.Refusal;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewRefusalCommand implements Command {
    private final ManagerService managerService;

    public NewRefusalCommand(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("/mgr/new/refusal", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer requestId = Integer.parseInt(request.getParameter("req"));

        Refusal refusal = Refusal.builder()
                .withRequest(Request.builder().withId(requestId).build())
                .withExplanation(request.getParameter("explanation"))
                .withManager(user)
                .build();

        managerService.declineRequest(refusal);
        forward("/mgr/home", request, response);
    }
}
