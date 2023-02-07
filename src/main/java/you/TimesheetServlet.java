package you;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Servlet implementation class TimesheetServlet
 */
public class TimesheetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesheetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if (request.getParameter("Action").equals("Submit Timesheet")) {
		      System.out.println("in");
		      PrintWriter printWriter = response.getWriter();
		      Timesheet timesheet = new Timesheet();
		      TimesheetDao dao = new TimesheetDao();
		      //Employee employee = new Employee();
		      //Project project = new Project();
		      
		      timesheet.setEmpNo(Integer.parseInt((request.getParameter("empNo"))));
		      timesheet.setProjectCode((request.getParameter("projectCode")));
		      timesheet.setTaskDescription((request.getParameter("taskDescription")));
		      timesheet.setTotalWorkingHours(Integer.parseInt((request.getParameter("totalWorkingHours"))));
		      timesheet.setDate(convertStringToDate((request.getParameter("date"))));
		      timesheet.setStatus((request.getParameter("status")));
		      boolean result = dao.addTimesheet(timesheet);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("addTimesheet.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Timesheet Submitted Successfully!!</h2>");
		    }
		    if (request.getParameter("Action").equals("Update")) {
		      PrintWriter printWriter = response.getWriter();
		      Timesheet timesheet = new Timesheet();
		      TimesheetDao dao = new TimesheetDao();
		      //Employee employee = new Employee();
		      
		      timesheet.setEmpNo(Integer.parseInt((request.getParameter("empNo"))));
		      timesheet.setStatus(request.getParameter("status"));
		      boolean result = dao.editTimesheet(timesheet);
		      System.out.println(result);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("updateTimesheet.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Timesheet Updated Successfully!!</h2>");
		    }		
	}
	
	private Date convertStringToDate(String strDate) {
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		java.util.Date d = null;
		
		try {
			
			d = format.parse(strDate);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return new Date(d.getTime());
	}

}
