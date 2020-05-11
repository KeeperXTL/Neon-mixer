import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/successfulRegistration")
public class SuccessfulRegistration extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean successfulRegistration = true;
		request.setAttribute("successfulRegistration", successfulRegistration);
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}
		

}