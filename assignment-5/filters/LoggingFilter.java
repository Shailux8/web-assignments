package filters;

import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class RequestLoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        String userIP = req.getRemoteAddr();
        String urlAccessed = httpReq.getRequestURL().toString();

        System.out.println("Request received at: " + LocalDateTime.now());
        System.out.println("Client IP: " + userIP + " | Accessed: " + urlAccessed);
        
        chain.doFilter(req, res);
    }
}

