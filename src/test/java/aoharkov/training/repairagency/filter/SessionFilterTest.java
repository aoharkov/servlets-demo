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
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SessionFilterTest {
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private FilterChain chain;
    @Mock
    private HttpSession session;

    @InjectMocks
    private SessionFilter filter;

    @After
    public void resetMocks() {
        Mockito.reset(request, response, chain, session);
    }

    @Test
    public void doFilterShouldSetNewSession() throws IOException, ServletException {
        when(request.getSession(false)).thenReturn(null);
        when(request.getSession(true)).thenReturn(session);

        filter.doFilter(request, response, chain);

        verify(request).getSession(false);
        verify(request).getSession(true);
    }

    @Test
    public void doFilterShouldDoNothing() throws IOException, ServletException {
        when(request.getSession(false)).thenReturn(session);

        filter.doFilter(request, response, chain);

        verify(request).getSession(false);
        verifyZeroInteractions(request);
    }
}