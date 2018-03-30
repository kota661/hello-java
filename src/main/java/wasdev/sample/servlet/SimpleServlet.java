package wasdev.sample.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String hostIp;
    private String hostName;

    public SimpleServlet(){
        setHostConfig();
    }

    private void setHostConfig() {
        try {
            InetAddress ia = InetAddress.getLocalHost();
            hostIp = ia.getHostAddress();
            hostName = ia.getHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().println("Hello World!");
        response.getWriter().println("<br>");
        response.getWriter().println(hostName + " " + hostIp);
    }

}
