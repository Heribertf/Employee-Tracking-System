package you;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ProjectServlet
 */
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    if (request.getParameter("Action").equals("Add Project")) {
		      System.out.println("in");
		      PrintWriter printWriter = response.getWriter();
		      Project project = new Project();
		      ProjectDao dao = new ProjectDao();

		      //project.setProjectId(Integer.parseInt((request.getParameter("projectId"))));
		      project.setProjectCode((request.getParameter("projectCode")));
		      project.setDescription((request.getParameter("description")));
		      project.setDuration((request.getParameter("duration")));
		      project.setStatus((request.getParameter("status")));
		      boolean result = dao.addProject(project);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("addProject.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Project added Successfully!!</h2>");
		    }
		    if (request.getParameter("Action").equals("Edit")) {
		      PrintWriter printWriter = response.getWriter();
		      Project project = new Project();
		      ProjectDao dao = new ProjectDao();
		      project.setProjectCode((request.getParameter("projectCode")));
		      project.setStatus(request.getParameter("status"));
		      boolean result = dao.editProject(project);
		      System.out.println(result);
		      RequestDispatcher dispatcher = request.getRequestDispatcher("editProject.jsp");
		      dispatcher.include(request, response);
		      printWriter.print("<br><h2>Project Updated Successfully!!</h2>");
		    }

	}

}
