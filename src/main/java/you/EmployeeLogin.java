package you;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import jakarta.servlet.http.HttpSession;

import you.EmpConnectionProvider;


/**
 * Servlet implementation class EmployeeLogin
 */
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        //Getting all data from user/customer
        String emailId = request.getParameter("emailId");
        String password = request.getParameter("password");
        //Creating Session
        HttpSession hs = request.getSession();
        try {
            //Creating Resultset
            ResultSet resultset = null;
            //Query to check Login Details
            resultset = EmpConnectionProvider.getResultFromSqlQuery("select * from employee_details where emailId='" + emailId + "' and password='" + password + "'");
            //Checking whether the details of user are null or not
            if (emailId != null && password != null) {
                if (resultset.next()) {
                    //Storing the login details in session
                    hs.setAttribute("empNo", resultset.getInt("empNo"));
                    hs.setAttribute("name", resultset.getString("name"));
                    //Redirecting response to the index.jsp
                    response.sendRedirect("employeeScreen.jsp");
                } else {
                    //If wrong credentials are entered in java online shopping system
                    String message = "You have entered wrong credentials";
                    hs.setAttribute("credential", message);
                    //Redirecting response to the customer-login.jsp
                    response.sendRedirect("employeeLogin.jsp");
                }
            } else {
                //If username or password is empty or null
                String message = "User name or Password is null";
                hs.setAttribute("credential", message);
                //Redirecting response to the customer-login.jsp
                response.sendRedirect("employeeLogin.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
