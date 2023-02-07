package you;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaveDao {
	public boolean addLeave(Leave leave) {
		
		// Getting Connection Object
		Connection connection = EmpConnectionProvider.getConnection();
		
	    String sql = "insert into leaves (leaveId,empNo,leaveType,takenFrom,takenTo,status) values (NULL,?,?,?,?,?) ";
	    int i = 0;
	    try {
	    	
//	      Employee employee = new Employee();
	      
	      PreparedStatement ps = connection.prepareStatement(sql);
          ps.setInt(1, leave.getEmpNo());
          ps.setString(2, leave.getLeaveType());
          ps.setDate(3, leave.getTakenFrom());
          ps.setDate(4, leave.getTakenTo());
          ps.setString(5, leave.getStatus());
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
	
	public boolean editLeave(Leave leave) {
		Connection connection = EmpConnectionProvider.getConnection();
	    String sql = "update leaves set status=?";
	    sql += " where empNo=? ";
	    int i = 0;
	    try {
	    	
	      Employee employee = new Employee();
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, leave.getStatus());
	      ps.setInt(2, employee.getEmpNo());
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
