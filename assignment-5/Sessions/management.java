import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session-demo")
public class SessionDemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Handling Cookies for username storage
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
        
        if (username == null) {
            username = "Guest";
            Cookie userCookie = new Cookie("username", username);
            userCookie.setMaxAge(60 * 60); // 1 hour
            response.addCookie(userCookie);
        }
        
        // Using HttpSession to store user preferences
        HttpSession session = request.getSession();
        String theme = (String) session.getAttribute("theme");
        if (theme == null) {
            theme = "Light Mode";
            session.setAttribute("theme", theme);
        }
        
        // URL Rewriting Example
        String sessionIdUrl = response.encodeURL("session-demo");
        
        out.println("<html><head><title>Session Management</title></head><body>");
        out.println("<h1>Session Tracking in Servlets</h1>");
        out.println("<p><strong>Username (Cookie):</strong> " + username + "</p>");
        out.println("<p><strong>Theme Preference (HttpSession):</strong> " + theme + "</p>");
        out.println("<p><a href='" + sessionIdUrl + "'>Click here to retain session (URL Rewriting)</a></p>");
        out.println("</body></html>");
    }
}
