
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletContext_Get extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		//永遠存在記憶體
		ServletContext context = getServletContext();
		Object myName1 = context.getAttribute("myName1");
		out.println(myName1);
	}
}
