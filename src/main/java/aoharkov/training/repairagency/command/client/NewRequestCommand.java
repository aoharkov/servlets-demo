package aoharkov.training.repairagency.command.client;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewRequestCommand implements Command {
    private final ClientService clientService;

    public NewRequestCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("/client/new/request", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        Request myRequest = Request.builder()
                .withClient(user)
                .withDescription(request.getParameter("description"))
                .withViewed(Boolean.FALSE)
                .withAccepted(Boolean.FALSE)
                .build();
        clientService.saveRequest(myRequest);
        forward("/client/home", request, response);
    }
}
