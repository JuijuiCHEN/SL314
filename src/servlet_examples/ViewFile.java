/*
   測試:   http://localhost:8081/SL314/ViewFile/images/tomcat.gif
   應注意   (※1)注意當有用到【額外路徑資訊】時必須使用【前置路徑對應】的設定
   同時注意(※2)web.xml內的<url-pattern>是<url-pattern>/ViewFile/*</url-pattern>                        
*/

package servlet_examples;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ViewFile extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    
    // Use a ServletOutputStream because we may pass binary information
    ServletOutputStream out = res.getOutputStream();
    
    PrintWriter pr = new PrintWriter(out, true);

    // Get the file to view
    // req.getPathTranslated()拿到真實路徑, 會走I/O
    String file = req.getPathTranslated();
    System.out.println(file);

    // No file, nothing to view
    // 沒有路徑無法顯示
    if (file == null) {
      out.println("No file to view");
      return;
    }

    // Get and set the type of the file
    // (右→左) 拿到file副檔名型態(可動態取得該file副檔名類型), 取得Servlet環境
    String contentType = getServletContext().getMimeType(file);
//    res.setContentType(contentType);
    res.setContentType("application/force-download");
    res.setHeader("Content-Disposition", "attachment; filename=\""+(new File(file).getName())+"\" ");
    System.out.println("contentType :" + contentType);

    pr.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    
    // Return the file
    FileInputStream in = null;
	  try {
		  in = new FileInputStream(file);
		  byte[] buf = new byte[in.available()]; // buffer
		  in.read(buf);
		  out.write(buf);
	  } catch (FileNotFoundException e) {
		  out.println("File not found");
	  } catch (IOException e) {
		  out.println("Problem sending file: " + e.getMessage());
	  } finally {
		  if (in != null)
			  in.close();
	  }
	  
	  pr.println(" ");
	  pr.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	  pr.close();
  }
}