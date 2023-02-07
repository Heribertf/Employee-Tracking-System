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
 * Servlet implementation class projectAllocationServlet
 */

@WebServlet("/ProjectAllocationServlet")
public class ProjectAllocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectAllocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if (request.getParameter("Action").equals("Assign Project")) {
		      System.out.println("in");
		      PrintWriter printWriter = response.getWriter();
		      
		      ProjectAllocation projectAllocation = new ProjectAllocation();
		      ProjectAllocationDao dao = new ProjectAllocationDao();
//		      Employee employee = new Employee();
//		      Project project = new Project();
		     
		      projectAllocation.setEmpNo(Integer.parseInt((request.getParameter("empNo"))));
		      projectAllocation.setProjectCode((request.getParameter("projectCode")));
		      projectAllocation.setLocation((request.getParameter("location")));
		      projectAllocation.setAllocatedFrom(convertStringToDate((request.getParameter("allocatedFrom"))));
		      projectAllocation.setAllocatedTo(convertStringToDate((request.getParameter("allocatedTo"))));
		      projectAllocation.setReportingManagerEmailId((request.getParameter("reportingManagerEmailId")));
		      projectAllocation.setStatus((request.getParameter("status")));
		      boolean result = dao.addProjectAllocation(projectAllocation);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("assignProject.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Project Assigned Successfully!!</h2>");
		    }
	    if (request.getParameter("Action").equals("Update")) {
		      PrintWriter printWriter = response.getWriter();
		      ProjectAllocation projectAllocation = new ProjectAllocation();
		      ProjectAllocationDao dao = new ProjectAllocationDao();
		      //Employee employee = new Employee();
		      
		      projectAllocation.setEmpNo(Integer.parseInt((request.getParameter("empNo"))));
		      projectAllocation.setStatus(request.getParameter("status"));
		      boolean result = dao.editAllocation(projectAllocation);
		      System.out.println(result);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("updateAllocation.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Project Allocation Updated Successfully!!</h2>");
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
