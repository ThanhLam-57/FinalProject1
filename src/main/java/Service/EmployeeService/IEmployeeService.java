package Service.EmployeeService;

import java.text.ParseException;

public interface IEmployeeService {
    void getAllEmployees();
    void getEmployeeByID();
    void updateEmployee() throws ParseException;
    void deleteEmployee();
    void createEmployee() throws ParseException;
    void searchEmployee();
    void createEmployeeFormDepartment();
    void deleteEmployeeFormDepartment();
    void transferEmployeeFormDepartment();
    void transferEmployeeToManager();
}
