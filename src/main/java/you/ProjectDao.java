package you;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDao {
	public boolean addProject(Project project) {
		
		// Getting Connection Object
		Connection connection = EmpConnectionProvider.getConnection();
		
	    String sql = "insert into projects (projectCode,description,duration,status) values (?,?,?,?) ";
	    int i = 0;
	    try {
	      PreparedStatement ps = connection.prepareStatement(sql);
          //ps.setInt(1, project.getProjectId());
          ps.setString(1, project.getProjectCode());
          ps.setString(2, project.getDescription());
          ps.setString(3, project.getDuration());
          ps.setString(4, project.getStatus());
	      i = ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    if (i == 0) {
	      return false;
	    } else {
	      return true;
	    }
	  
	}
	
	public boolean editProject(Project project) {
		Connection connection = EmpConnectionProvider.getConnection();
	    String sql = "update projects set status=?";
	    sql += " where projectCode=? ";
	    int i = 0;
	    try {
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, project.getStatus());
	      ps.setString(2, project.getProjectCode());
	      i = ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    if (i == 0) {
	      return false;
	    } else {
	      return true;
	    }
	}
}
