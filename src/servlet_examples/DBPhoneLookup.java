package servlet_examples;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;

public class DBPhoneLookup extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Connection con = null;
		Statement stmt = null;

		res.setContentType("text/html charset=Big5");
		PrintWriter out = res.getWriter();

		try {
			// // Load (and therefore register) the Oracle Driver
			// Class.forName("oracle.jdbc.driver.OracleDriver");
			//
			// // Get a Connection to the database
			// con = DriverManager.getConnection(
			// "jdbc:oracle:thin:@localhost:1521:XE", "BA107", "BA107");

			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
			con = ds.getConnection();

			// Create a Statement object
			stmt = con.createStatement();

			// 如使用HtmlSQLResult就不打這個, Execute an SQL query, get a ResultSet
			// rs = stmt.executeQuery("SELECT * FROM EMP2");

			// Display the result set as a list
			out.println("<HTML><HEAD><TITLE>Phonebook</TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<UL>");

			// while(rs.next()) {
			// out.println("<LI>" + rs.getString(1) + " " + rs.getString(2));
			// }

			// out.println(new HtmlResultSet(rs));

			out.println(new HtmlSQLResult("SELECT * FROM EMP2", con));

			out.println("</UL>");
			out.println("</BODY></HTML>");
		} catch (Exception e) {
			out.println("Exception caught: " + e.getMessage());
		} finally {
			// Always close the database connection.
			try {
				if (con != null)
					con.close();
			} catch (SQLException ignored) {
			}
		}
	}
}
