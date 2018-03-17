package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeWorkOne extends HttpServlet {
	int count;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		count++;						
		res.setContentType("text/plain");
		Timer timer = new Timer();
		Calendar cal = new GregorianCalendar(2018,Calendar.JANUARY,31,0,0,0);
		Date date = new Date();
		TimerTask task = new TimerTask(){
			public void run(){
//				out.println("");
			}
		};
		
//		scheduleAtFixedRate(task, )
		
	}
}
