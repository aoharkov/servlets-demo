package aoharkov.training.repairagency.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String ERROR_PAGE = "view/problem.jsp";

    String execute(HttpServletRequest request);
}
