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

import static aoharkov.training.repairagency.command.utils.PageAttributesParser.DEFAULT_PAGE;
import static aoharkov.training.repairagency.command.utils.PageAttributesParser.DEFAULT_ROWS;
import static aoharkov.training.repairagency.command.utils.PageAttributesParser.parseWithDefault;

public class FindOwnRequestsCommand implements Command {
    private final ClientService clientService;

    public FindOwnRequestsCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsPerPage = parseWithDefault(request.getParameter("rows"), DEFAULT_ROWS);
        int pageNum = parseWithDefault(request.getParameter("page"), DEFAULT_PAGE);

        User user = (User) request.getSession().getAttribute("user");
        Page<Request> pageOfRequests = clientService.findOwnRequests(pageNum, itemsPerPage, user.getId());
        request.setAttribute("requests", pageOfRequests.getContent());
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
