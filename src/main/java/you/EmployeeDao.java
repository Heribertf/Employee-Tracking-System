package you;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EmployeeDao {
	
	public boolean addEmployee(Employee employee) {
		
		// Getting Connection Object
		Connection connection = EmpConnectionProvider.getConnection();
		
	    String sql = "insert into employee_details (empNo,name,phone,emailId,designation,baseLocation,password) values (NULL,?,?,?,?,?,?) ";
	    int i = 0;
	    try {
	      PreparedStatement ps = connection.prepareStatement(sql);
          ps.setString(1, employee.getName());
          ps.setString(2, employee.getPhone());
          ps.setString(3, employee.getEmailId());
          ps.setString(4, employee.getDesignation());
          ps.setString(5, employee.getBaseLocation());
          ps.setString(6, employee.getPassword());
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
		/*try {
			
			PreparedStatement ps = connection.prepareStatement("INSERT INTO employee_details(empNo, name, "
					+ "phone, emailId, designation, baseLocation, password) VALUES (?,?,?,?,?,?,?)");
			
			
            // Create a statement using connection object
            ps.setInt(1, 1);
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getPhone());
            ps.setString(4, employee.getEmailId());
            ps.setString(5, employee.getDesignation());
            ps.setString(6, employee.getBaseLocation());
            ps.setString(7, employee.getPassword());			
			
			
			// It will return 1 if its Inserted successfully..
			if(ps.executeUpdate() > 0) {
				
				return true;
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return false;
	}	*/
	
	public boolean editEmployee(Employee employee) {
		Connection connection = EmpConnectionProvider.getConnection();
	    String sql = "update employee_details set emailId=?, designation=?, baseLocation=?";
	    sql += " where empNo=? ";
	    int i = 0;
	    try {
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setString(1, employee.getEmailId());
	      ps.setString(2, employee.getDesignation());
	      ps.setString(3, employee.getBaseLocation());
	      ps.setInt(4, employee.getEmpNo());
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

	public void deleteEmployee(int empNo) {
		Connection connection = EmpConnectionProvider.getConnection();
	    String sql = "delete from employee_details where empNo=?";
	    try {
	      PreparedStatement ps = connection.prepareStatement(sql);
	      ps.setInt(1, empNo);
	      ps.executeUpdate();
	    } catch (SQLException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  }
}









