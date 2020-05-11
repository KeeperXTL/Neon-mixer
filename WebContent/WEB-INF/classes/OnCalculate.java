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
import com.neonmixer.etc.*;

@WebServlet("/calculate")
public class OnCalculate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyMath myMath = new MyMath();
		ArrayList<Flavor> flavors = new ArrayList<Flavor>();
		double PGVG = Double.parseDouble(request.getParameter("pgvg"));
		double PG = PGVG;
		double VG = 100-PG;
		double volOfFlud = Double.parseDouble(request.getParameter("volofliq"));
		double water = Double.parseDouble(request.getParameter("water"));
		double strengthOfNicoBase = Double.parseDouble(request.getParameter("strength"));
		double nicoContent = Double.parseDouble(request.getParameter("nico"));
		String[] flavorName = request.getParameterValues("flavorName");
		String[] flavorContent = request.getParameterValues("flavor");
		
		double waterResNum = myMath.round((volOfFlud / 100) * water);
		double waterResPer = myMath.round((waterResNum / volOfFlud) * 100);
		double VGResNum = myMath.round(((volOfFlud - waterResNum) / 100) * VG);
		double VGResPer = myMath.round((VGResNum / volOfFlud) * 100);
		double nicoContentResNum = myMath.round((volOfFlud * nicoContent) / strengthOfNicoBase);
		double nicoContentResPer = myMath.round((nicoContentResNum / volOfFlud) * 100);
		ArrayList<Double> flavorContentResNum = new ArrayList<Double>();
		for(int i = 0; i < flavorContent.length; i++) {
			flavorContentResNum.add(myMath.round((volOfFlud / 100) * Double.parseDouble(flavorContent[i])));
		}
		ArrayList<Double> flavorContentResPer = new ArrayList<Double>();
		for(int i = 0; i < flavorContentResNum.size(); i++) {
			flavorContentResPer.add(myMath.round((flavorContentResNum.get(i) / volOfFlud) * 100));
		}
		double tempPGResNum = myMath.round((((volOfFlud - waterResNum) / 100) * PG) - nicoContentResNum);
		double PGResNum = myMath.round(tempPGResNum - flavorContentResNum.get(0));
		for(int i = 1; i < flavorContentResNum.size(); i++) {
			PGResNum = myMath.round(PGResNum - flavorContentResNum.get(i));
		}
		double PGResPer = myMath.round((PGResNum / volOfFlud) * 100);
		for(int i = 0; i < flavorContentResNum.size(); i++) {
			Flavor flavor = new Flavor(flavorName[i], flavorContentResNum.get(i), flavorContentResPer.get(i));
			flavors.add(flavor);
		}
		request.setAttribute("PGN", PGResNum);
		request.setAttribute("PGP", PGResPer);
		request.setAttribute("VGN", VGResNum);
		request.setAttribute("VGP", VGResPer);
		request.setAttribute("waterN", waterResNum);
		request.setAttribute("waterP", waterResPer);
		request.setAttribute("nicoContentN", nicoContentResNum);
		request.setAttribute("nicoContentP", nicoContentResPer);
		request.setAttribute("flavorsList", flavors);
		request.setAttribute("total", volOfFlud);
		getServletContext().getRequestDispatcher("/").forward(request, response);
	}
}