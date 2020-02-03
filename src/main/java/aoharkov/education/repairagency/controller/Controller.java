package aoharkov.education.repairagency.controller;

import aoharkov.education.repairagency.command.Command;
import aoharkov.education.repairagency.injector.DependencyInjector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Controller extends HttpServlet {
    private final Map<String, Command> commandNameToCommand;
    private final Command defaultCommand = request -> Command.ERROR_PAGE;

    public Controller() {
        DependencyInjector injector = DependencyInjector.getInstance();
        commandNameToCommand = injector.getIndexCommands();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String commandName = req.getParameter("command");

        final String page = commandNameToCommand.getOrDefault(commandName, defaultCommand).execute(req);

        req.getRequestDispatcher(page).forward(req, resp);
    }
}
