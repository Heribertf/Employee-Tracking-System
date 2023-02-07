package you;

import java.sql.Date;

public class ProjectAllocation {
    private int sno;
    private String location;
    private Date allocatedFrom;
    private Date allocatedTo;
    private String reportingManagerEmailId;
    private String status;
    private int empNo;
    private String projectCode;
    
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
    
    public int getSno() {
    	return sno;
    }
    public void setSno(int sno) {
    	this.sno = sno;
    }
    
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public Date getAllocatedFrom() {
        return allocatedFrom;
    }
    public void setAllocatedFrom(Date allocatedFrom) {
        this.allocatedFrom = allocatedFrom;
    }
    public Date getAllocatedTo() {
        return allocatedTo;
    }
    public void setAllocatedTo(Date allocatedTo) {
        this.allocatedTo = allocatedTo;
    }
    public String getReportingManagerEmailId() {
        return reportingManagerEmailId;
    }
    public void setReportingManagerEmailId(String reportingManagerEmailId) {
        this.reportingManagerEmailId = reportingManagerEmailId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public ProjectAllocation(int sno, String location, Date allocatedFrom, Date allocatedTo, String reportingManagerEmailId, String status) {
      super();
      this.sno = sno;
      this.location = location;
      this.allocatedFrom = allocatedFrom;
      this.allocatedTo = allocatedTo;
      this.reportingManagerEmailId = reportingManagerEmailId;
      this.status = status;
    }
    public ProjectAllocation() {
      super();
      // TODO Auto-generated constructor stub
    }
}
