package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ExportRestriction extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    // Get the client's hostname
    // 取得client端的主機名稱,如取不到會取IP位置
    String remoteHost = req.getRemoteHost();
    out.println("client's hostname or IP="+remoteHost);

    // See if the client is allowed
    if (! isHostAllowed(remoteHost)) {
      out.println("<br><font color='red'>  Access denied ..... </font>");
    }
    else {
      out.println("<br><font color='blue'> Access granted .....</font>");
      // Display download links, etc...
    }
  }
  // Disallow hosts ending with .cu, .ir, .iq, .kp, .ly, .sy, and .sd.
  private boolean isHostAllowed(String host) {
    return (!host.endsWith(".1") &&
            !host.endsWith(".ir") &&
            !host.endsWith(".iq") &&
            !host.endsWith(".kp") &&
            !host.endsWith(".ly") &&
            !host.endsWith(".sy") &&
            !host.endsWith(".sd"));
  }
}
