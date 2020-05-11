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

@WebServlet({"/show"})
public class OnShow extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    GetMixes getMixes = new GetMixes();
    GetFlavorInMix getFlavorInMix = new GetFlavorInMix();
    try {
      int curMixId = Integer.parseInt(request.getParameter("curMixId"));
      ArrayList<Mix> arrayList = GetMixes.getByMix(curMixId);
      ArrayList arrayList1 = GetFlavorInMix.getByMix(curMixId);
      request.setAttribute("selectedMixId", Integer.valueOf(((Mix)arrayList.get(0)).getMixId()));
      request.setAttribute("selectedMixName", ((Mix)arrayList.get(0)).getName());
      request.setAttribute("selectedMixPGVG", Integer.valueOf(((Mix)arrayList.get(0)).getPGVG()));
      request.setAttribute("selectedMixVolOfFlud", Integer.valueOf(((Mix)arrayList.get(0)).getVolOfFlud()));
      request.setAttribute("selectedMixWater", Integer.valueOf(((Mix)arrayList.get(0)).getWater()));
      request.setAttribute("selectedMixStrengthOfNicoBase", Integer.valueOf(((Mix)arrayList.get(0)).getStrengthOfNicoBase()));
      request.setAttribute("selectedMixNicoContent", Integer.valueOf(((Mix)arrayList.get(0)).getNicoContent()));
      request.setAttribute("flavorArr", arrayList1);
    } catch (Exception exception) {
      System.out.println(exception);
    } finally {
      getServletContext().getRequestDispatcher("/").forward(request, response);
    } 
  }
}
