package you;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/ServOne")

public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	/*
    private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
    }*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// Defining Student Service Object
		EmployeeService service = new EmployeeService();
		
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String emailId = request.getParameter("emailId");
        String designation = request.getParameter("designation" );
        String baseLocation = request.getParameter("baseLocation");
        String password = request.getParameter("password");
        
        //Defining Employee Object
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPhone(phone);
        employee.setEmailId(emailId);
        employee.setDesignation(designation);
        employee.setBaseLocation(baseLocation);
        employee.setPassword(password);
		
		if(service.addEmployee(employee)) {
			
			// Dispatching Success Page
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.jsp");
			dispatcher.forward(request, response);
			
		} else {
			
			// Dispatching Error Page
			RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		}		
		
		


        /*try {
            employeeDao.registerEmployee(employee);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("Employeedetails.jsp");
	} */
	
	  /**
	   * @see HttpServlet#HttpServlet()
	   */
	  public EmployeeServlet() {
	    super();
	    // TODO Auto-generated constructor stub
	  }
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    // TODO Auto-generated method stub
	    if (request.getParameter("Action").equals("Add Employee")) {
	      System.out.println("in");
	      PrintWriter printWriter = response.getWriter();
	      Employee employee = new Employee();
	      EmployeeDao dao = new EmployeeDao();
	      employee.setName((request.getParameter("name")));
	      employee.setPhone((request.getParameter("phone")));
	      employee.setEmailId((request.getParameter("emailId")));
	      employee.setDesignation((request.getParameter("designation")));
	      employee.setBaseLocation((request.getParameter("baseLocation")));
	      employee.setPassword((request.getParameter("password")));
	      boolean result = dao.addEmployee(employee);
	      RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
	      dispatcher.include(request, response);
	      printWriter.print("<br><h2>Employee added Successfully!!</h2>");
	    }
	    if (request.getParameter("Action").equals("Edit")) {
	      PrintWriter printWriter = response.getWriter();
	      Employee employee = new Employee();
	      EmployeeDao dao = new EmployeeDao();
	      
	      employee.setEmpNo(Integer.parseInt(request.getParameter("empNo")));
	      employee.setEmailId(request.getParameter("emailId"));
	      employee.setDesignation(request.getParameter("designation"));
	      employee.setBaseLocation(request.getParameter("baseLocation"));
	      boolean result = dao.editEmployee(employee);
	      System.out.println(result);
	      RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
	      dispatcher.include(request, response);
	      printWriter.print("<br><h2>Employee Updated Successfully!!</h2>");
	    }
	    if (request.getParameter("Action").equals("Delete")) {
	      PrintWriter printWriter = response.getWriter();
	      Employee employee = new Employee();
	      EmployeeDao dao = new EmployeeDao();
	      
	      dao.deleteEmployee(Integer.parseInt(request.getParameter("empNo")));
	      RequestDispatcher dispatcher = request.getRequestDispatcher("delete.jsp");
	      dispatcher.include(request, response);
	      printWriter.print("<br><h2>Employee Deleted Successfully!!</h2>");
	    }
	  }

}
