package aoharkov.training.repairagency.filter;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocaleFilterTest {
    private static final String ENG = "en";
    private static final String UKR = "uk";
    private static final String DEFAULT_LANG = ENG;
    private static final String LANG_PARAMETER_NAME = "lang";

    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private FilterChain chain;
    @Mock
    private HttpSession session;

    @InjectMocks
    private LocaleFilter filter;

    @After
    public void resetMocks() {
        Mockito.reset(request, response, chain, session);
    }

    @Test
    public void doFilterShouldUpdateSessionAttributeFromRequestParameter() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(LANG_PARAMETER_NAME)).thenReturn(UKR);
        when(session.getAttribute(LANG_PARAMETER_NAME)).thenReturn(UKR);

        filter.doFilter(request, response, chain);

        verify(request).getSession();
        verify(request).getParameter(LANG_PARAMETER_NAME);
        verify(session).setAttribute(LANG_PARAMETER_NAME, UKR);
        verify(session).getAttribute(LANG_PARAMETER_NAME);
        verify(request).setAttribute(LANG_PARAMETER_NAME, UKR);
    }

    @Test
    public void doFilterShouldSetSessionAttributeWithDefaultValue() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(LANG_PARAMETER_NAME)).thenReturn(null);
        when(session.getAttribute(LANG_PARAMETER_NAME)).thenReturn(null);

        filter.doFilter(request, response, chain);

        verify(request).getSession();
        verify(request).getParameter(LANG_PARAMETER_NAME);
        verify(session).getAttribute(LANG_PARAMETER_NAME);
        verify(session).setAttribute(LANG_PARAMETER_NAME, DEFAULT_LANG);
        verify(request).setAttribute(LANG_PARAMETER_NAME, DEFAULT_LANG);
    }

    @Test
    public void doFilterShouldChangeNothing() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(LANG_PARAMETER_NAME)).thenReturn(null);
        when(session.getAttribute(LANG_PARAMETER_NAME)).thenReturn(UKR);

        filter.doFilter(request, response, chain);

        verify(request).getSession();
        verify(request).getParameter(LANG_PARAMETER_NAME);
        verify(session).getAttribute(LANG_PARAMETER_NAME);
        verify(request).setAttribute(LANG_PARAMETER_NAME, UKR);
    }

    @Test
    public void doFilterShouldIgnoreUnknownLang() throws IOException, ServletException {
        when(request.getSession()).thenReturn(session);
        when(request.getParameter(LANG_PARAMETER_NAME)).thenReturn("RUS");
        when(session.getAttribute(LANG_PARAMETER_NAME)).thenReturn(UKR);

        filter.doFilter(request, response, chain);

        verify(request).getSession();
        verify(request).getParameter(LANG_PARAMETER_NAME);
        verify(session).getAttribute(LANG_PARAMETER_NAME);
        verify(request).setAttribute(LANG_PARAMETER_NAME, UKR);
    }
}