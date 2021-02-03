import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet{
	
	public void init() {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        Cookie cookie[] = request.getCookies();
        cookie[0].setMaxAge(0);
        response.addCookie(cookie[0]);
        
//        request.getRequestDispatcher("login.html").include(request, response);
        response.sendRedirect("login.html");
        out.print("Logout successfull");
          
	}
	
}
