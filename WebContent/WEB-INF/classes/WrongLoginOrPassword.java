import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wrongLoginOrPassword")
public class WrongLoginOrPassword extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean wrongLoginOrPassword = true;
		request.setAttribute("wrongLoginOrPassword", wrongLoginOrPassword);
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}
		

}