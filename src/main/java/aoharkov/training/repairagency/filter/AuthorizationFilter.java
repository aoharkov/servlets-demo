package aoharkov.training.repairagency.filter;

import aoharkov.training.repairagency.domain.Role;
import aoharkov.training.repairagency.domain.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        String requestURI = req.getRequestURI();
        final User user = (User) req.getSession().getAttribute("user");
        if (checkPublicAccess(requestURI) || (user != null && checkRoleAccess(requestURI, user.getRole()))) {
            chain.doFilter(request, response);
        } else {
            req.getRequestDispatcher("/error").forward(request, response);
        }
    }

    private boolean checkPublicAccess(String requestURI) {
        return requestURI.equals("/") ||
                requestURI.equals("/index") ||
                requestURI.equals("/login") ||
                requestURI.equals("/register") ||
                requestURI.equals("/home") ||
                requestURI.equals("/logout") ||
                requestURI.startsWith("/images/");
    }

    private boolean checkRoleAccess(String requestURI, Role role) {
        return requestURI.startsWith("/admin/") && role == Role.ADMIN ||
                requestURI.startsWith("/mgr/") && role == Role.MANAGER ||
                requestURI.startsWith("/master/") && role == Role.MASTER ||
                requestURI.startsWith("/client/") && role == Role.CLIENT;
    }
}
