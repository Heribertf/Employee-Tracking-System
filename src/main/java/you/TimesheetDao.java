package you;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TimesheetDao {
	public boolean addTimesheet(Timesheet timesheet) {
		
		// Getting Connection Object
		Connection connection = EmpConnectionProvider.getConnection();
		
	    String sql = "insert into timesheet (sno,empNo,projectCode,taskDescription,totalWorkingHours,date,status) values (NULL,?,?,?,?,?,?) ";
	    int i = 0;
	    try {
	    	
	      //Employee employee = new Employee();
	      //Project project = new Project();
	      
	      PreparedStatement ps = connection.prepareStatement(sql);
          ps.setInt(1, timesheet.getEmpNo());
          ps.setString(2, timesheet.getProjectCode());
          ps.setString(3, timesheet.getTaskDesription());
          ps.setInt(4, timesheet.getTotalWorkingHours());
          ps.setDate(5, timesheet.getDate());
          ps.setString(6, timesheet.getStatus());
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
	
	public boolean editTimesheet(Timesheet timesheet) {
		Connection connection = EmpConnectionProvider.getConnection();
	    String sql = "update timesheet set status=?";
	    sql += " where empNo=? ";
	    int i = 0;
	    try {
	    	
	      //Employee employee = new Employee();
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, timesheet.getStatus());
	      ps.setInt(2, timesheet.getEmpNo());
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
