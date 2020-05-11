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

@WebServlet("/singUp")
public class OnSingUp extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String passwordRepeat = request.getParameter("passwordRepeat");
		GetUser getUser = new GetUser();
		CreateUser createUser = new CreateUser();
		ArrayList<Users> user = getUser.getByLogin(login);
		try {
			if(login.length() >= 4) {
				if(password.length() >= 6) {
					if(password.equals(passwordRepeat)) {
						if(user.size() == 0) {
							createUser.create(login, password);
							response.sendRedirect("/successfulRegistration");
						} else {
							response.sendRedirect("/userExist");
						}
					} else {
						response.sendRedirect("/passwordMismatch");
					}
				} else {
					response.sendRedirect("/passwordLength");
				}
			} else {
				response.sendRedirect("/loginLength");
		} 
	} catch(Exception ex) {
		System.out.println(ex);
	} finally {}

}

}
