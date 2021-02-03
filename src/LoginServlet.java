import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	
	public void init() {
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if(name.equals("admin") && password.equals("admin123")) {
			Cookie cookie = new Cookie("name", name);
			response.addCookie(cookie);
//			request.getRequestDispatcher("ProfileServlet").include(request, response);
			response.sendRedirect("ProfileServlet");
		} else {
//			response.sendRedirect("login.html");
			out.print("<h3>Invalid credentials</h3>");
			request.getRequestDispatcher("login.html").include(request, response);
		}
	}
	
}
