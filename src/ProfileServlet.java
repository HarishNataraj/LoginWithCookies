import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProfileServlet extends HttpServlet{
	
	public void init() {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Cookie cookie[] = request.getCookies();
		if(cookie!=null) {
			String name = cookie[0].getValue();
			out.print("<b>Profile</b>");
			out.print("<br>Welcome, "+name);
			request.getRequestDispatcher("logout.html").include(request, response); 
		} else {
		    out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response); 
		}
	}
	
}
