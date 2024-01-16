import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;


@WebFilter("/book")
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String method = httpRequest.getMethod();

            if ("GET".equalsIgnoreCase(method)) {
                System.out.println("Обработка запроса /book...");
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
