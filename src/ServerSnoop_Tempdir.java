
import java.io.*;                                                    
import java.util.*;                                                  
import javax.servlet.*;                                              
                                                                     


public class ServerSnoop_Tempdir extends GenericServlet {

	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain; charset=Big5");
		PrintWriter out = res.getWriter();

		out.println("我的server container 的暫存目錄區");
		ServletContext context = getServletContext();
		out.println(context.getAttribute("javax.servlet.context.tempdir"));
		
		String str = ServletContext.TEMPDIR;
		out.println("ServletContext.TEMPDIR :" + str);
		
		//簡易版
		out.println(getServletContext().getAttribute(context.TEMPDIR));
	}
}