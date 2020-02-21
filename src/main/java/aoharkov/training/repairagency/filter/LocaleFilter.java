package aoharkov.training.repairagency.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LocaleFilter implements Filter {
    private static final String ENG = "en";
    private static final String RUS = "ru";
    private static final String UKR = "uk";
    private static final Set<String> LANGUAGES = new HashSet<>(Arrays.asList(ENG, RUS, UKR));
    private static final String DEFAULT_LANG = ENG;
    private static final String LANG_PARAMETER_NAME = "lang";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String langParameter = request.getParameter(LANG_PARAMETER_NAME);
        if (langParameter != null && LANGUAGES.contains(langParameter)) {
            session.setAttribute(LANG_PARAMETER_NAME, langParameter);
        }

        String lang = (String) session.getAttribute(LANG_PARAMETER_NAME);
        if (lang == null) {
            session.setAttribute(LANG_PARAMETER_NAME, DEFAULT_LANG);
            lang = DEFAULT_LANG;
        }
        request.setAttribute(LANG_PARAMETER_NAME, lang);

        filterChain.doFilter(request, servletResponse);
    }
}
