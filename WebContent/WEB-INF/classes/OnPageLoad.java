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

import com.neonmixer.db.*;
import com.neonmixer.dboperations.*;

@WebServlet("")
public class OnPageLoad extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetUserMixInnerMix getUserMixInnerMix = new GetUserMixInnerMix();
		GetUser getUser = new GetUser();
		HttpSession session = request.getSession();
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		ArrayList<Users> user = getUser.getByLogin(sessionLogin);
			try {
				if(user.get(0).getUserId() > 0) {
					request.setAttribute("userMixes", getUserMixInnerMix.getByUser(user.get(0).getUserId()));
				}
			} catch(Exception ex) {
				System.out.println(ex);	
			} finally {
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
	}
		
}