package aoharkov.training.repairagency.command.client;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewFeedbackCommand implements Command {
    private final ClientService clientService;

    public NewFeedbackCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("/client/new/feedback", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer requestId = Integer.parseInt(request.getParameter("req"));
        Request myRequest = clientService.findRequest(requestId);
        Integer score = Integer.parseInt(request.getParameter("score"));
        Feedback feedback = Feedback.builder()
                .withRequest(myRequest)
                .withScore(score)
                .withText(request.getParameter("text"))
                .build();
        clientService.saveFeedback(feedback);
        response.sendRedirect("/client/home");
    }
}
