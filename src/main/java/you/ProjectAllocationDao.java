package you;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectAllocationDao {
	public boolean addProjectAllocation(ProjectAllocation projectAllocation) {
		
		// Getting Connection Object
		Connection connection = EmpConnectionProvider.getConnection();
		
	    String sql = "insert into project_allocation (sno,empNo,projectCode,location,allocatedFrom,allocatedTo,reportingManagerEmailId,status) values (NULL,?,?,?,?,?,?,?) ";
	    int i = 0;
	    try {
	    	
//	      Employee employee = new Employee();
//	      Project project = new Project();
	      
	      PreparedStatement ps = connection.prepareStatement(sql);
          ps.setInt(1, projectAllocation.getEmpNo());
          ps.setString(2, projectAllocation.getProjectCode());
          ps.setString(3, projectAllocation.getLocation());
          ps.setDate(4, projectAllocation.getAllocatedFrom());
          ps.setDate(5, projectAllocation.getAllocatedTo());
          ps.setString(6, projectAllocation.getReportingManagerEmailId());
          ps.setString(7, projectAllocation.getStatus());
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
	
	public boolean editAllocation(ProjectAllocation projectAllocation) {
		Connection connection = EmpConnectionProvider.getConnection();
	    String sql = "update project_allocation set status=?";
	    sql += " where empNo=? ";
	    int i = 0;
	    try {
	    	
	      //Employee employee = new Employee();
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, projectAllocation.getStatus());
	      ps.setInt(2, projectAllocation.getEmpNo());
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
