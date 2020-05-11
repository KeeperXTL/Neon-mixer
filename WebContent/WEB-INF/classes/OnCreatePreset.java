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

@WebServlet("/createPreset")
public class OnCreatePreset extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String presetName = request.getParameter("presetName");
		if(presetName != "") {
		HttpSession session = request.getSession();
		int PGVG = Integer.parseInt(request.getParameter("pgvg"));
		int volOfFlud = Integer.parseInt(request.getParameter("volofliq"));
		int water = Integer.parseInt(request.getParameter("water"));
		int strengthOfNicoBase = Integer.parseInt(request.getParameter("strength"));
		int nicoContent = Integer.parseInt(request.getParameter("nico"));
		String[] flavorName = request.getParameterValues("flavorName");
		String[] flavorContent = request.getParameterValues("flavor");
		GetUser getUser = new GetUser();
		CreateMix createMix = new CreateMix();
		CreateFlavorInMix createFlavorInMix = new CreateFlavorInMix();
		CreateUserMix createUserMix = new CreateUserMix();
		String sessionLogin = (String) session.getAttribute("sessionLogin");
		ArrayList<Users> user = getUser.getByLogin(sessionLogin);
		int userId = user.get(0).getUserId();
		ArrayList<Mix> mixes = createMix.create(presetName, PGVG, volOfFlud, water, strengthOfNicoBase, nicoContent);
		int mixId = mixes.get(0).getMixId();
		createUserMix.create(userId, mixId);
		for(int i = 0; i < flavorName.length; i++) {
			createFlavorInMix.create(mixId, flavorName[i], Integer.parseInt(flavorContent[i]));
		}
		response.sendRedirect("/successfulCreatedPreset");
		} else {
			response.sendRedirect("/emptyPresetName");
		}
		
	}
}