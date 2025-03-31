import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context-demo")
public class ContextDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    public void init() throws ServletException {
        ServletContext context = getServletContext();
        context.setAttribute("appName", "My Web Application");
        context.setAttribute("visitorCount", 0);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        String appName = (String) context.getAttribute("appName");
        int visitorCount = (int) context.getAttribute("visitorCount");
        visitorCount++;
        context.setAttribute("visitorCount", visitorCount);
        
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>ServletContext Demo</title></head><body>");
            out.println("<h1>Application-Wide Data</h1>");
            out.println("<p><strong>Application Name:</strong> " + appName + "</p>");
            out.println("<p><strong>Visitor Count:</strong> " + visitorCount + "</p>");
            out.println("</body></html>");
        }
    }
}

// Deploy the servlet and access:
// http://localhost:8080/your-app/context-demo

// Reloading the page increases the visitor count.