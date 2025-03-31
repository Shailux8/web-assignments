import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request-info")
public class RequestInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String ageParam = request.getParameter("age");
            int age = -1;
            
            if (ageParam != null && !ageParam.isEmpty()) {
                try {
                    age = Integer.parseInt(ageParam);
                } catch (NumberFormatException e) {
                    age = -1;
                }
            }
            
            String clientIP = request.getRemoteAddr();
            String userAgent = request.getHeader("User-Agent");
            
            out.println("<html><head><title>Request Details</title></head><body>");
            out.println("<h1>Client Request Information</h1>");
            out.println("<p><strong>Name:</strong> " + (name != null ? name : "Not provided") + "</p>");
            out.println("<p><strong>Age:</strong> " + (age >= 0 ? age : "Invalid or not provided") + "</p>");
            out.println("<p><strong>Client IP:</strong> " + clientIP + "</p>");
            out.println("<p><strong>User-Agent:</strong> " + userAgent + "</p>");
            out.println("</body></html>");
        }
    }
}
