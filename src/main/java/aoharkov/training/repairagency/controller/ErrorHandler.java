package aoharkov.training.repairagency.controller;

import aoharkov.training.repairagency.service.exception.validation.ValidateException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandler extends HttpServlet {
    private static final int UNPROCESSABLE_ENTITY = 422;
    private static final int INTERNAL_SERVER_ERROR = 500;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer statusCode = (Integer)
                request.getAttribute("javax.servlet.error.status_code");

        if (request.getAttribute("javax.servlet.error.exception") != null) {
            Throwable throwable = (Throwable)
                    request.getAttribute("javax.servlet.error.exception");
            if (throwable instanceof ValidateException) {
                statusCode = UNPROCESSABLE_ENTITY;
            }
        }

        if (statusCode == null) {
            statusCode = INTERNAL_SERVER_ERROR;
        }

        switch (statusCode) {
            case UNPROCESSABLE_ENTITY:
                forward("/error/422", request, response);
                break;
            case INTERNAL_SERVER_ERROR:
                forward("/error/500", request, response);
                break;
            default:
                forward("/error/404", request, response);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void forward(String requestURI, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String path = String.format("/view%s.jsp", requestURI);
        request.setAttribute("requestURI", requestURI);
        request.getRequestDispatcher(path).forward(request, response);
    }
}
