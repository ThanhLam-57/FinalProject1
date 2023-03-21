package Service.EmployeeService;

import DAO.DepartmentDAO.DepartmentDAO;
import DAO.EmployeeDAO.EmployeeDAO;
import Modal.Employees;
import Service.DepartmentService.DepartmentService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static Service.Validation.Validate.*;

public class EmployeeService implements IEmployeeService {
    public static Scanner scanner = new Scanner(System.in);
    static DepartmentService departmentService = new DepartmentService();
    public static DepartmentDAO departmentDAO;
    public static Employees inputValue() throws ParseException {
        System.out.println("Enter employee code: ");
        String employeeCode = scanner.nextLine();
        while (validateNotNull(employeeCode) == false){
            System.out.println("Mã nhân viên không được để trống, nhập lại: ");
            employeeCode = scanner.nextLine();
        }
        System.out.println("Enter employee name: ");
        String employeeName = scanner.nextLine();
        while (validateNotNull(employeeName) == false){
            System.out.println("Tên nhân viên không được để trống, nhập lại: ");
            employeeName = scanner.nextLine();
        }
        System.out.println("Enter employee date of birth(yyyy-MM-dd): ");
        String employeeDateOfBirth = scanner.nextLine();
        while (validateDate(employeeDateOfBirth) == false){
            System.out.println("Ngày sinh chưa hợp lệ, nhập lại: ");
            employeeDateOfBirth = scanner.nextLine();
        }
        System.out.println("Enter employee gender(nam/ nữ/ khác): ");
        String employeeGender = scanner.nextLine();
        while (validateGender(employeeGender) == false){
            System.out.println("Giới tính chưa hợp lệ, nhập lại: ");
            employeeGender = scanner.nextLine();
        }
        System.out.println("Enter employee address: ");
        String employeeAddress = scanner.nextLine();
        System.out.println("Enter employee phone (10 số): ");
        String employeePhone = scanner.nextLine();
        while (validatePhone(employeePhone) == false){
            System.out.println("Số điện thoai chưa hợp lệ, nhập lại: ");
            employeePhone = scanner.nextLine();
        }
        System.out.println("Enter employee email: ");
        String employeeEmail = scanner.nextLine();
        while (validateEmail(employeeEmail) == false){
            System.out.println("Email chưa hợp lệ, nhập lại: ");
            employeeEmail = scanner.nextLine();
        }
        System.out.println("Enter employee salary: ");
        String employeeSalary = scanner.nextLine();
        while (isNumeric(employeeSalary) == false){
            System.out.println("Lương chưa hợp lệ, nhập lại: ");
            employeeSalary = scanner.nextLine();
        }
        Integer employeeSalary1 = Integer.parseInt(employeeSalary);

        System.out.println("Enter employee department id: ");
        departmentService.getAllDepartments();
        Integer employeeDepartmentId = Integer.parseInt(scanner.nextLine());
        while (departmentService.checkDepartmentId(employeeDepartmentId) == false){
            System.out.println("Mã phòng ban không tồn tại, nhập lại: ");
            employeeDepartmentId = Integer.parseInt(scanner.nextLine());
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(employeeDateOfBirth);
        Employees employees1 = new Employees(employeeCode,employeeName,date,employeeGender,employeeAddress,employeePhone,employeeEmail,employeeSalary1,employeeDepartmentId);
        return employees1;
    }
    public EmployeeDAO employeeDAO;
    //TODO: Create a method to get all employees
    @Override
    public void getAllEmployees() {
        List<Employees>  employees= employeeDAO.getAllEmployees();
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }
    //TODO: Create a method to get an employee by id
    @Override
    public void getEmployeeByID(){
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        Employees employees = employeeDAO.showEmployeeById(employeeId);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            System.out.println(employees.toString());
        }
    }
    //TODO: Create a method to update an employee
    @Override
    public void updateEmployee() throws ParseException {
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        Employees employees = employeeDAO.showEmployeeById(employeeId);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            Employees employees1 = inputValue();
            employeeDAO.updateEmployee(employeeId,employees1);
        }
    }
    //TODO: Create a method to delete an employee
    @Override
    public void deleteEmployee(){
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        Employees employees = employeeDAO.showEmployeeById(employeeId);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            employeeDAO.deleteEmployee(employeeId);
            System.out.println("Delete employee successfully");
        }
    }
    //TODO: Create a method create an employee
    @Override
    public void createEmployee() throws ParseException {
        Employees employees = inputValue();
        employeeDAO.insertEmployee(employees);
        System.out.println("Create employee successfully");
    }
    @Override
    public void searchEmployee(){
        System.out.println("Enter employee code/name/phone/email: ");
        String keyword = scanner.nextLine();
        List<Employees> employees = employeeDAO.searchEmployee(keyword);
        if (employees == null) {
            System.out.println("Employee not found");
        }else {
            for (int i = 0; i < employees.size(); i++) {
                System.out.println(employees.get(i).toString());
            }
        }
    }

    @Override
    public void createEmployeeFormDepartment() {
        getAllEmployees();
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        String sc = scanner.nextLine();
        departmentService.getAllDepartments();
        sc = scanner.nextLine();
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        sc = scanner.nextLine();
        if (employeeDAO.checkEmployeeInDepartment(employeeId) == departmentId) {
            System.out.println("Employee already in department");
        } else {
            employeeDAO.insertEmployeeToDepartment(employeeId, departmentId);
            System.out.println("Create employee successfully");
        }
    }

    @Override
    public void deleteEmployeeFormDepartment() {
        getAllEmployees();
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        departmentService.getAllDepartments();
        employeeDAO.insertEmployeeToDepartment(employeeId,0);
        System.out.println("Delete employee successfully");
    }

    @Override
    public void transferEmployeeFormDepartment(){
        getAllEmployees();
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        departmentService.getAllDepartments();
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        if (employeeDAO.checkEmployeeInDepartment(employeeId) == departmentId) {
            System.out.println("Employee already in department");
        } else {
            employeeDAO.insertEmployeeToDepartment(employeeId, departmentId);
            System.out.println("Transfer employee successfully");
        }
    }

    @Override
    public void transferEmployeeToManager(){
        departmentService.getAllDepartments();
        System.out.println("Get employee in department");
        System.out.println("Enter department id: ");
        Integer departmentId = Integer.parseInt(scanner.nextLine());
        List<Employees> employees = employeeDAO.showEmployeeByDepartmentId(departmentId);
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
        System.out.println("Enter employee id: ");
        Integer employeeId = Integer.parseInt(scanner.nextLine());
        employeeDAO.transferEmployeeToManager(employeeId);
        System.out.println(" Transfer employee to manager successfully");
    }
}
