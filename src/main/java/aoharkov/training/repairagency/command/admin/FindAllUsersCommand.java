package aoharkov.training.repairagency.command.admin;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static aoharkov.training.repairagency.command.utils.PageAttributesParser.DEFAULT_PAGE;
import static aoharkov.training.repairagency.command.utils.PageAttributesParser.DEFAULT_ROWS;
import static aoharkov.training.repairagency.command.utils.PageAttributesParser.parseWithDefault;

public class FindAllUsersCommand implements Command {
    private final AdminService adminService;

    public FindAllUsersCommand(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsPerPage = parseWithDefault(request.getParameter("rows"), DEFAULT_ROWS);
        int pageNum = parseWithDefault(request.getParameter("page"), DEFAULT_PAGE);

        Page<User> pageOfUsers = adminService.findAllUsers(pageNum, itemsPerPage);
        request.setAttribute("users", pageOfUsers.getContent());
        request.setAttribute("maxPage", pageOfUsers.getTotalPages());

        request.setAttribute("pageNum", pageNum);
        request.setAttribute("itemsPerPage", itemsPerPage);

        forward("/admin/users", request, response);
    }

    public void doGet2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemsPerPage = parseWithDefault(request.getParameter("rows"), DEFAULT_ROWS);
        int pageNum = parseWithDefault(request.getParameter("page"), DEFAULT_PAGE);

        Page<User> pageOfUsers = adminService.findAllUsers(pageNum, itemsPerPage);
        request.setAttribute("users", pageOfUsers.getContent());
        request.setAttribute("maxPage", pageOfUsers.getTotalPages());

        request.setAttribute("magicNumber", 10);
        request.setAttribute("itemsPerPage", itemsPerPage);

        forward("/admin/users", request, response);
    }

/*    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }*/

    public void empty() {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
