public class Staff {
    private String name;
    private int gender;
    private String employeeID;
    private String jobTitle;

    public Staff(String name, int gender, String employeeID, String jobTitle){
        this.name=name;
        this.gender=gender;
        this.employeeID=employeeID;
        this.jobTitle=jobTitle;
    }

    public String getName(){
        return this.name;
    }

    public int getGender(){
        return this.gender;
    }

    public String getEmployeeID(){
        return this.employeeID;
    }

    public String getJobTitle(){
        return this.jobTitle;
    }
}
