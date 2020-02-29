package aoharkov.training.repairagency.command.manager;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.domain.Order;
import aoharkov.training.repairagency.domain.RepairStage;
import aoharkov.training.repairagency.domain.Request;
import aoharkov.training.repairagency.domain.User;
import aoharkov.training.repairagency.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NewOrderCommand implements Command {
    private final ManagerService managerService;

    public NewOrderCommand(ManagerService managerService) {
        this.managerService = managerService;
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        forward("/mgr/new/order", request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Integer requestId = Integer.parseInt(request.getParameter("req"));
        Integer price = Integer.parseInt(request.getParameter("price"));
        Integer masterId = Integer.parseInt(request.getParameter("masterId"));

        Order order = Order.builder()
                .withRequest(Request.builder().withId(requestId).build())
                .withPrice(price)
                .withManager(user)
                .withMaster(User.builder().withId(masterId).build())
                .withRepairStage(RepairStage.builder().withId(1).build())
                .build();

        managerService.acceptRequest(order);
        response.sendRedirect("/mgr/home");
    }
}
