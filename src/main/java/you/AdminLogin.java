package you;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import jakarta.servlet.http.HttpSession;

import you.EmpConnectionProvider;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        try {
            //Getting all the parameters from the frontend (admin)
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //Retriving our session
            HttpSession hs = request.getSession();
            //Calling Connection method
            Connection con = EmpConnectionProvider.getConnection();
            //Creating Statement
            Statement st = con.createStatement();
            //Querying inside the database
            ResultSet resultset = st.executeQuery("select * from admin where username='" + username + "' AND password='" + password + "'");
            //If all the details are correct
            if (resultset.next()) {
                hs.setAttribute("username", resultset.getString("username"));
                //Redirecting admin to dashboard page
                response.sendRedirect("dashboard.jsp");
            } else {
                //If details are wrong
                String message = "You have entered wrong credentials";
                hs.setAttribute("credential", message);
                //Redirecting admin to admin login page
                response.sendRedirect("adminLogin.jsp");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }		

}
