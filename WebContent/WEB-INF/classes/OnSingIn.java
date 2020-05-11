import com.neonmixer.db.*;
import com.neonmixer.dboperations.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/singIn")
public class OnSingIn extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		GetUser getUser = new GetUser();
		ArrayList<Users> user = getUser.getByLogin(login);
		HttpSession session = request.getSession();
		try {
			if(user.size() > 0) {
				if(user.get(0).getPassword().equals(password)) {
					session.setAttribute("sessionLogin", user.get(0).getLogin());
					response.sendRedirect("/successfulLogin");
				} else {
					System.out.println("password");
					response.sendRedirect("/wrongLoginOrPassword");
				}
			} else {
				System.out.println("login");
				response.sendRedirect("/wrongLoginOrPassword");
			}
		} catch(Exception ex) {
			System.out.println(ex);
		} finally {}

}

}
