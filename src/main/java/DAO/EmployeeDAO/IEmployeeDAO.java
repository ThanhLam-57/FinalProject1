package DAO.EmployeeDAO;

import Modal.Employees;

import java.util.List;

public interface IEmployeeDAO {
    static List<Employees> getAllEmployees() {
        return null;
    }
    void showEmployeeById();
    void updateEmployee();
    void deleteEmployee();
    void createEmployee();
    void searchEmployee();
    void createEmployeeFormDepartment();
    void deleteEmployeeFormDepartment();
    void transferEmployeeFormDepartment();
    void transferEmployeeToManager();
}
