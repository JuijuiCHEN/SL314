
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Session_Set extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		//存在瀏覽器記憶體，關掉瀏覽器session就不在了
		HttpSession session = req.getSession(); //getSession(預設為true)
        session.setAttribute("myName2","吳永志2");
        
        //用session.getId()查看session的ID值
        String ID = session.getId();
		out.println("<br>ID :" + ID);
	
	}
}
