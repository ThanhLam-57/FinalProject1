package Modal;

public class Statistics {
    private int department_id;
    private String department_name;
    private int employee_count;
    private int manager_id;
    private String manager_name;
    private int employee_id_max_salary;
    private String employee_name_max_salary;
    private int salary_max;

    public Statistics() {
    }

    public Statistics(int department_id, String department_name, int employee_count, int manager_id, String manager_name, int employee_id_max_salary, String employee_name_max_salary, int salary_max) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.employee_count = employee_count;
        this.manager_id = manager_id;
        this.manager_name = manager_name;
        this.employee_id_max_salary = employee_id_max_salary;
        this.employee_name_max_salary = employee_name_max_salary;
        this.salary_max = salary_max;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getEmployee_count() {
        return employee_count;
    }

    public void setEmployee_count(int employee_count) {
        this.employee_count = employee_count;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public int getEmployee_id_max_salary() {
        return employee_id_max_salary;
    }

    public void setEmployee_id_max_salary(int employee_id_max_salary) {
        this.employee_id_max_salary = employee_id_max_salary;
    }

    public String getEmployee_name_max_salary() {
        return employee_name_max_salary;
    }

    public void setEmployee_name_max_salary(String employee_name_max_salary) {
        this.employee_name_max_salary = employee_name_max_salary;
    }

    public int getSalary_max() {
        return salary_max;
    }

    public void setSalary_max(int salary_max) {
        this.salary_max = salary_max;
    }
}
