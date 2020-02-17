package aoharkov.training.repairagency.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocaleFilter implements Filter {
    private static final String LANG = "lang";
    public static final String DEFAULT_LANG = "en";
    private static final String ENCODING = "UTF-8";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String locale = (String) req.getAttribute(LANG);
        if (locale == null) {
            req.setAttribute(LANG, DEFAULT_LANG);
        }
        req.setCharacterEncoding(ENCODING);

        filterChain.doFilter(req, servletResponse);
    }
}
