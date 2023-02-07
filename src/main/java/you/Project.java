package you;

public class Project {
    private String projectCode;
    private String description;
    private String duration;
    private String status;

    
    
    public String getProjectCode() {
        return projectCode;
    }
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Project(String projectCode, String description, String duration, String status) {
      super();
      this.projectCode = projectCode;
      this.description = description;
      this.duration = duration;
      this.status = status;
    }
    public Project() {
      super();
      // TODO Auto-generated constructor stub
    }
}
