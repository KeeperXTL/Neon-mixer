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

@WebServlet("/deletePreset")
public class OnDeletePreset extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int mixId = Integer.parseInt(request.getParameter("mixId"));
		DeleteMix deleteMix = new DeleteMix();
		deleteMix.delete(mixId);
		response.sendRedirect("/successfulDeletedPreset");
	} catch(Exception ex) {
		response.sendRedirect("/nothingToDelete");
	} finally {
		
	}
}
}