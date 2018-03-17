/*
   ����:   http://localhost:8081/SL314/ViewFile/images/tomcat.gif
   ���`�N   (��1)�`�N���Ψ�i�B�~���|��T�j�ɥ����ϥΡi�e�m���|�����j���]�w
   �P�ɪ`�N(��2)web.xml����<url-pattern>�O<url-pattern>/ViewFile/*</url-pattern>                        
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
    // req.getPathTranslated()����u����|, �|��I/O
    String file = req.getPathTranslated();
    System.out.println(file);

    // No file, nothing to view
    // �S�����|�L�k���
    if (file == null) {
      out.println("No file to view");
      return;
    }

    // Get and set the type of the file
    // (�k����) ����file���ɦW���A(�i�ʺA���o��file���ɦW����), ���oServlet����
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