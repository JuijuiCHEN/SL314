
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Session_Set extends HttpServlet {


	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("text/html; charset=Big5");
		PrintWriter out = res.getWriter();

		//�s�b�s�����O����A�����s����session�N���b�F
		HttpSession session = req.getSession(); //getSession(�w�]��true)
        session.setAttribute("myName2","�d�ç�2");
        
        //��session.getId()�d��session��ID��
        String ID = session.getId();
		out.println("<br>ID :" + ID);
	
	}
}
