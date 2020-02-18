package aoharkov.training.repairagency.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

    void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    default void forward(String requestURI, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String path = String.format("/view%s.jsp", requestURI);
        request.setAttribute("requestURI", requestURI);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
