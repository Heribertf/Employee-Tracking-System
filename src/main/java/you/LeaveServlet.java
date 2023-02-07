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
 * Servlet implementation class LeaveServlet
 */
public class LeaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if (request.getParameter("Action").equals("Request Leave")) {
		      System.out.println("in");
		      PrintWriter printWriter = response.getWriter();
		      Leave leave = new Leave();
		      LeaveDao dao = new LeaveDao();
//		      Employee employee = new Employee();

		      leave.setEmpNo(Integer.parseInt((request.getParameter("empNo"))));
		      leave.setLeaveType((request.getParameter("leaveType")));
		      leave.setTakenFrom(convertStringToDate((request.getParameter("takenFrom"))));
		      leave.setTakenTo(convertStringToDate((request.getParameter("takenTo"))));
		      leave.setStatus((request.getParameter("status")));
		      boolean result = dao.addLeave(leave);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("addLeave.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Leave Request Submitted Successfully!!</h2>");
		    }
		    if (request.getParameter("Action").equals("Approve")) {
		      PrintWriter printWriter = response.getWriter();
		      Leave leave = new Leave();
		      LeaveDao dao = new LeaveDao();
//		      Employee employee = new Employee();
		      
		      leave.setEmpNo(Integer.parseInt((request.getParameter("empNo"))));
		      leave.setStatus(request.getParameter("status"));
		      boolean result = dao.editLeave(leave);
		      System.out.println(result);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("updateLeave.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Leave Updated Successfully!!</h2>");
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
