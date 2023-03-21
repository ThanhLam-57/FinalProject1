import Service.DepartmentService.DepartmentService;
import Service.EmployeeService.EmployeeService;
import Service.LoginService.LogInService;

import java.text.ParseException;
import java.util.Scanner;

import static Service.Validation.Validate.checkNull;

public class Main {
    public static void main(String[] args) throws ParseException {
        LogInService logInService = new LogInService();
        Scanner scanner = new Scanner(System.in);
        if (logInService.checkLogin()) {
            while (true) {
                System.out.println("1. Department management");
                System.out.println("2. Employee management");
                System.out.println("3. Exit");
                System.out.println("Enter your choice: ");
                Integer choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        DepartmentService departmentService = new DepartmentService();
                        while (true) {
                            System.out.println("1. Get all departments");
                            System.out.println("2. Get a department by id");
                            System.out.println("3. Update a department");
                            System.out.println("4. Delete a department");
                            System.out.println("5. Insert a department");
                            System.out.println("6. Exit");
                            System.out.println("Enter your choice: ");
                            Integer choiceDepartment = Integer.parseInt(scanner.nextLine());
                            switch (choiceDepartment) {
                                case 1:
                                    departmentService.getAllDepartments();
                                    break;
                                case 2:
                                    departmentService.showDepartmentById();
                                    break;
                                case 3:
                                    departmentService.updateDepartment();
                                    break;
                                case 4:
                                    departmentService.deleteDepartment();
                                    break;
                                case 5:
                                    departmentService.createDepartment();
                                    break;
                                case 6:
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                            if (choiceDepartment == 6) {
                                break;
                            }
                        }
                        break;
                    case 2:
                        EmployeeService employeeService = new EmployeeService();
                        while (true) {
                            System.out.println("1. Get all employees");
                            System.out.println("2. Get an employee by id");
                            System.out.println("3. Update an employee");
                            System.out.println("4. Delete an employee");
                            System.out.println("5. Create an employee");
                            System.out.println("6. Search an employee");
                            System.out.println("7. Create an employee form department");
                            System.out.println("8.Delete an employee form department");
                            System.out.println("9. Transfer an employee form department");
                            System.out.println("10. Transfer an employee to manager");
                            System.out.println("11. Exit");
                            System.out.println("Enter your choice: ");
                            Integer choiceEmployee = Integer.parseInt(scanner.nextLine());
                            switch (choiceEmployee) {
                                case 1:
                                    employeeService.getAllEmployees();
                                    break;
                                case 2:
                                    employeeService.getEmployeeByID();
                                    break;
                                case 3:
                                    employeeService.updateEmployee();
                                    break;
                                case 4:
                                    employeeService.deleteEmployee();
                                    break;
                                case 5:
                                    employeeService.createEmployee();
                                    break;
                                case 6:
                                    employeeService.searchEmployee();
                                    break;
                                case 7:
                                    employeeService.createEmployeeFormDepartment();
                                    break;
                                case 8:
                                    employeeService.deleteEmployeeFormDepartment();
                                    break;
                                case 9:
                                    employeeService.transferEmployeeFormDepartment();
                                    break;
                                case 10:
                                    employeeService.transferEmployeeToManager();
                                    break;
                                case 11:
                                    break;
                                default:
                                    System.out.println("Invalid choice");
                                    break;
                            }
                            if (choiceEmployee == 11) {
                                break;
                            }
                        }
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            }

        } else {
            System.out.println("Login failed");
        }
    }
}