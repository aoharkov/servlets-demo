package aoharkov.training.repairagency.command.manager;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.Feedback;
import aoharkov.training.repairagency.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllFeedbackCommand implements Command {
    private final ManagerService managerService;

    public FindAllFeedbackCommand(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rows = request.getParameter("rows");
        String page = request.getParameter("page");

        int itemsPerPage = Integer.parseInt(rows);
        int pageNum = Integer.parseInt(page);

        Page<Feedback> pageOfFeedback = managerService.findAllFeedback(pageNum, itemsPerPage);

        List<Feedback> feedback = pageOfFeedback.getContent();
        request.setAttribute("feedback", feedback);
        request.setAttribute("maxPage", pageOfFeedback.getTotalPages());
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("itemsPerPage", itemsPerPage);

        forward("/mgr/feedback", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
