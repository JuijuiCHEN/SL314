/*
 * http://localhost:8888/SL314/ParameterSnoop?name1=peter1&name2=peter2&name3=peter3
 */

package servlet_examples;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ParameterSnoop extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/plain; charset=Big5");
		PrintWriter out = res.getWriter();

		out.println("Query String:");
		out.println(req.getQueryString());
		out.println();
		
		// 設定瀏覽器語言, 如沒設定會顯示null
		req.setCharacterEncoding("UTF-8");
		// 印出瀏覽器語言
		out.println("Request Character Encoding:");
		out.println(req.getCharacterEncoding());
		out.println();
		
		out.println("Request Parameters:");
		// 拿到client端請求參數名稱
		Enumeration en = req.getParameterNames();
		// 有內容元素時跑迴圈
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			String values[] = req.getParameterValues(name);
			if (values != null) {
				for (int i = 0; i < values.length; i++) {
					out.println(name + " [" + i + "]: " + values[i]);
					System.out.println(name + " [" + i + "]: " + values[i]);
				}
			}
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
