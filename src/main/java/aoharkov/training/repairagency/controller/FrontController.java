package aoharkov.training.repairagency.controller;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.injector.DependencyInjector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FrontController extends HttpServlet {
    private final Map<String, Command> uriToCommand;

    public FrontController() {
        uriToCommand = DependencyInjector.getInstance().getCommands();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            uriToCommand.get(req.getRequestURI()).doGet(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            uriToCommand.get(req.getRequestURI()).doPost(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
