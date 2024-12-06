package beans;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class CsrfFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
            HttpSession session = httpRequest.getSession();
            String userToken = (String) session.getAttribute("csrfToken");
            String formToken = httpRequest.getParameter("csrfToken");

            if (userToken == null || formToken == null || !userToken.equals(formToken)) {
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                httpResponse.sendRedirect("errorPage.jsp");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    // Other methods of the Filter interface
}

