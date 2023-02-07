package you;

import java.io.Serializable;
/**
 * JavaBean class used in jsp action tags.
 * @author Heribert
 */

public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int empNo;
    private String name;
    private String phone;
    private String emailId;
    private String designation;
    private String baseLocation;
    //private String projectCode;
    private String password;
    
    public int getEmpNo() {
    	return empNo;
    }
    public void setEmpNo(int empNo) {
    	this.empNo = empNo;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public String getBaseLocation() {
        return baseLocation;
    }
    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }
   /* public String getProjectCode() {
    	return projectCode;
    }
    public void setProjectCode(String projectCode) {
    	this.projectCode = projectCode;
    }*/
    
}






