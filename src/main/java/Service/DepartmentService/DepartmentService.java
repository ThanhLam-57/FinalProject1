package Service.DepartmentService;

import DAO.DepartmentDAO.DepartmentDAO;
import Modal.Department;

import java.util.List;
import java.util.Scanner;

import static Service.Validation.Validate.validateNotNull;

public class DepartmentService implements IDepartmentService{
    public static  Scanner scanner = new Scanner(System.in);
    public DepartmentDAO departmentDAO;
    public static Department inputValue() {
        System.out.println("Enter department code: ");
        String departmentCode = scanner.nextLine();
        while (validateNotNull(departmentCode) == false){
            System.out.println("Department code is not null, enter again: ");
            departmentCode = scanner.nextLine();
        }
        System.out.println("Enter department name: ");
        String departmentName = scanner.nextLine();
        while (validateNotNull(departmentName) == false){
            System.out.println("Department name is not null, enter again: ");
            departmentName = scanner.nextLine();
        }
        Department department = new Department(departmentCode, departmentName);
        return department;
    }

    //TODO1: Create a method to get all departments
    public void getAllDepartments() {
        List<Department> departments = departmentDAO.getAllDepartment();
        if (departments.size()>0) {
            for (int i = 0; i < departments.size(); i++) {
                System.out.println(departments.get(i).toString());
            }
        } else {
            System.out.println("No department found");
        }
    }
    //TODO2: Create a method to get a department by id
    public void showDepartmentById() {
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            System.out.println("Department not found");
        } else {
            System.out.println(department.toString());
        }
    }
    //TODO3: Create a method to update a department
    public void updateDepartment() {
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            System.out.println("Department not found");
        } else {
            department = inputValue();
            departmentDAO.updateDepartment(department);
            System.out.println("Update department successfully");
        }
    }
    //TODO4: Create a method to delete a department
    public void deleteDepartment() {
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            System.out.println("Department not found");
        } else {
            departmentDAO.deleteDepartment(departmentId);
            System.out.println("Delete department successfully");
        }
    }
    //TODO5: Create a method to create a department
    public void createDepartment() {
        Department department = inputValue();
        departmentDAO.insertDepartment(department);
        System.out.println("Create department successfully");
    }
    public boolean checkDepartmentId(int departmentId){
        Department department = departmentDAO.getDepartmentById(departmentId);
        if(department == null){
            return false;
        } else {
            return true;
        }
    }
}
