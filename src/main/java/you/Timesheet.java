package you;

import java.sql.Date;

public class Timesheet {
    private int sno;
    private int empNo;
    private String projectCode;
    private String taskDescription;
    private int totalWorkingHours;
    private Date date;
    private String status;

  
    
    
    public int getSno() {
    	return sno;
    }
    public void setSno(int sno) {
    	this.sno = sno;
    }
    public int getEmpNo() {
    	return empNo;
    }
    public void setEmpNo(int empNo) {
    	this.empNo = empNo;
    }
    public String getProjectCode() {
        return projectCode;
    }
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
    public String getTaskDesription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public int getTotalWorkingHours() {
        return totalWorkingHours;
    }
    public void setTotalWorkingHours(int totalWorkingHours) {
        this.totalWorkingHours = totalWorkingHours;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getStatus() {
    	return status;
    }
    public void setStatus(String status) {
    	this.status = status;
    }

    public Timesheet(int sno, int empNo, String projectCode, String taskDescription, int totalWorkingHours, Date date, String status) {
      super();
      this.sno = sno;
      this.empNo = empNo;
      this.projectCode = projectCode;
      this.taskDescription = taskDescription;
      this.totalWorkingHours = totalWorkingHours;
      this.date = date;
      this.status = status;


    }
    public Timesheet() {
      super();
      
      // TODO Auto-generated constructor stub
    }
}
