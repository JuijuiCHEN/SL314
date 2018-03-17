package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Hello extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
        
	    req.setCharacterEncoding("Big5"); // Get�MPost�ѨM����r���D
        res.setContentType("text/html; charset=Big5");
        PrintWriter out = res.getWriter();
        
        String name = req.getParameter("name");
        
        System.out.println(name == null); 
        System.out.println(name.trim().length() == 0);
        System.out.println(name.trim().isEmpty());
        System.out.println(name.trim().equals(""));
        
        String name2 = new String(name.getBytes("ISO-8859-1"), "Big5"); // Get�ѨM����r���D
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello, " + name2 + "</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("Hello, �A�n: " + name2);
        out.println("</BODY></HTML>");
  }
  
  public String getServletInfo() {
    return "A servlet that knows the name of the person to whom it's" + 
           "saying hello";
  }
}
