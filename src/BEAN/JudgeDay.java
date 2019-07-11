package BEAN;

public class JudgeDay {

    private String employee_no;
    private String performance;
    private String employee_name;
    private String time;


    public JudgeDay(){

    }

    public String getEmployee_no(){
        return this.employee_no;
    }

    public String getPerformance(){
        return  this.performance;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
