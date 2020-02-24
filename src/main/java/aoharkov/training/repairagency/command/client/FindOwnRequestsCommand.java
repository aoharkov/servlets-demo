package aoharkov.training.repairagency.command.client;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindOwnRequestsCommand implements Command {
    private final ClientService clientService;

    public FindOwnRequestsCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rows = request.getParameter("rows");
        String page = request.getParameter("page");

        int itemsPerPage = Integer.parseInt(rows);
        int pageNum = Integer.parseInt(page);

        User user = (User) request.getSession().getAttribute("user");
        Page<Request> pageOfRequests = clientService.findOwnRequests(pageNum, itemsPerPage, user.getId());

        List<Request> requests = pageOfRequests.getContent();
        request.setAttribute("requests", requests);
        request.setAttribute("maxPage", pageOfRequests.getTotalPages());
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("itemsPerPage", itemsPerPage);

        forward("/client/requests", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
