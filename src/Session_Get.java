
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Session_Get extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		//�s�b�s�����O����A�����s����session�N���b�F
		HttpSession session = req.getSession(); //getSession(�w�]��true)
		Object myName2 = session.getAttribute("myName2");
		out.println(myName2);
		
		//��session.getId()�d��session��ID��
		String ID = session.getId();
		out.println("<br>ID :" + ID);
	}
}
