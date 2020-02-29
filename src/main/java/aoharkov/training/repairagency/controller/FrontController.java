package aoharkov.training.repairagency.controller;

import aoharkov.training.repairagency.command.Command;
import aoharkov.training.repairagency.injector.DependencyInjector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FrontController extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(FrontController.class);

    private final Map<String, Command> uriToCommand;

    public FrontController() {
        uriToCommand = DependencyInjector.getInstance().getCommands();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Command command = uriToCommand.get(request.getRequestURI());
            if (command != null) {
                command.doGet(request, response);
            } else {
                LOGGER.error("Unknown RequestURI {}", request.getRequestURI());
            }
        } catch (ServletException | IOException e) {
            LOGGER.error("Error in doGet for {}", request.getRequestURI(), e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            Command command = uriToCommand.get(request.getRequestURI());
            if (command != null) {
                command.doPost(request, response);
            } else {
                LOGGER.error("Unknown RequestURI {}", request.getRequestURI());
            }
        } catch (ServletException | IOException e) {
            LOGGER.error("doPost for {}", request.getRequestURI(), e);
        }
    }
}
