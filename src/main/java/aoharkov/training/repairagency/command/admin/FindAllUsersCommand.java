package aoharkov.training.repairagency.command.admin;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.dao.domain.Page;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindAllUsersCommand implements Command {
    private final AdminService adminService;

    public FindAllUsersCommand(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rows = request.getParameter("rows");
        String page = request.getParameter("page");

        int itemsPerPage = Integer.parseInt(rows);
        int pageNum = Integer.parseInt(page);

        Page<User> pageOfUsers = adminService.findAllUsers(pageNum, itemsPerPage);
        List<User> users = pageOfUsers.getContent();
        request.setAttribute("users", users);
        request.setAttribute("maxPage", pageOfUsers.getTotalPages());
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("itemsPerPage", itemsPerPage);

        forward("/admin/users", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
