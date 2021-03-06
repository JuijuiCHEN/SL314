package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SiteSelector extends HttpServlet {

  Vector<String> sites = new Vector<String>();
  Random random = new Random();

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    int siteIndex = Math.abs(random.nextInt()) % sites.size(); //取得0.1.2.3 
    String site = sites.get(siteIndex); //隨機拿到0.1.2.3其中一個

    
    res.sendRedirect(site); //等同於下面兩個註解
    
//    res.setStatus(HttpServletResponse.SC_FOUND);
//    res.setHeader("Location", site);
  }
  public void init() throws ServletException {
    sites.add("http://www.oracle.com/technetwork/java/index.html");
    sites.add("http://www.apache.org/");
    sites.add("http://struts.apache.org/");
    sites.add("https://tw.yahoo.com");
  }
}
