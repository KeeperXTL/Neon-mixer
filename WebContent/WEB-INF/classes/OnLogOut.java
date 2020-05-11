import java.io.IOException; 
import java.io.PrintWriter;

import java.sql.*;

import java.util.ArrayList;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logOut")
public class OnLogOut extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			session.invalidate();
			response.sendRedirect("/");
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}
		
	}
}