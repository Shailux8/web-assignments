import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/config-demo")
public class ConfigDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String dbUrl;
    private String dbUser;
    private String dbPassword;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dbUrl = config.getInitParameter("dbUrl");
        dbUser = config.getInitParameter("dbUser");
        dbPassword = config.getInitParameter("dbPassword");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head><title>ServletConfig Demo</title></head><body>");
            out.println("<h1>Database Connection Settings</h1>");
            out.println("<p><strong>DB URL:</strong> " + dbUrl + "</p>");
            out.println("<p><strong>DB User:</strong> " + dbUser + "</p>");
            out.println("<p><strong>DB Password:</strong> " + dbPassword + "</p>");
            out.println("</body></html>");
        }
    }
}
