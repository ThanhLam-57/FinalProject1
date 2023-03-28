package DAO.EmployeeDAO;

import Database.Connect;
import Modal.Employees;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    //Create method to get all employees
    //Done
    public static List<Employees> getAllEmployees() {
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE isDelete != 0;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public static List<Employees> getAllEmployeesNotDep(){
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE department_id IS NULL AND isDelete = 1;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public static List<Employees> getAllEmployeesDelete(){
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE isDelete = 0;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public static List<Employees> getEmployeeByDepartment(int id, int isDelete) {
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE department_id = " + id + " AND isDelete = " + isDelete + ";" ;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    //Create method to get employee by id
    //Done
    public static Employees showEmployeeById(int id){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM employee e WHERE e.employee_id = " + id;
            ResultSet rs = stmt.executeQuery(sql);
            Employees employee = new Employees();
            while(rs.next()) {
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
            }
            return employee;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //Create method to add new employee
    //Done
    public static boolean insertEmployee(Employees employee){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "INSERT INTO employee(employee_code,employee_name,date_of_birth,gender,address,phone,email,salary,department_id,isDelete)\n" +
                    "VALUES(?,?,?,?,?,?,?,?,?,?);";
            prst=conn.prepareStatement(sql);
            prst.setString(1,employee.getEmployee_code());
            prst.setString(2,employee.getEmployee_name());

            java.sql.Date sqlDate = new java.sql.Date(employee.getDate_of_birth().getTime());
            prst.setDate(3, sqlDate);
            prst.setString(4,employee.getGender());
            prst.setString(5,employee.getAddress());
            prst.setString(6,employee.getPhone());
            prst.setString(7,employee.getEmail());
            if (employee.getSalary() == 0){
                prst.setNull(8, Types.INTEGER);
            } else {
                prst.setInt(8,employee.getSalary());
            }
            if (employee.getDepartment_id() == 0){
                prst.setNull(9, Types.INTEGER);
            } else {
                prst.setInt(9,employee.getDepartment_id());
            }
            prst.setInt(10,1);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    //Create method to update employee
    public static boolean updateEmployee(int id, Employees employees){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employee SET employee_code = ?, employee_name = ?, date_of_birth = ?, gender = ?, address = ?, phone = ?, email = ?, salary = ?, department_id = ? WHERE employee_id = ?";
            prst = conn.prepareStatement(sql);
            prst.setString(1, employees.getEmployee_code());
            prst.setString(2, employees.getEmployee_name());
            java.sql.Date sqlDate = new java.sql.Date(employees.getDate_of_birth().getTime());
            prst.setDate(3, sqlDate);
            prst.setString(4, employees.getGender());
            prst.setString(5, employees.getAddress());
            prst.setString(6, employees.getPhone());
            prst.setString(7, employees.getEmail());
            if (employees.getSalary() == 0){
                prst.setNull(8, Types.INTEGER);
            } else {
                prst.setInt(8, employees.getSalary());
            }
//            prst.setInt(8, employees.getSalary());
            if (employees.getDepartment_id() == 0){
                prst.setNull(9, Types.INTEGER);
            } else {
                prst.setInt(9, employees.getDepartment_id());
            }
//            prst.setInt(9, employees.getDepartment_id());
            prst.setInt(10, id);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    //Create method to delete employee
    //done
    public static boolean deleteEmployee(int id) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employee e SET e.isDelete = 0, e.manager_id = NULL, e.department_id = NULL WHERE e.employee_id = ?;";
            prst = conn.prepareStatement(sql);
            prst.setInt(1, id);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    //Create method to search employee by name, code, phone, email
    public static List<Employees> searchEmployee(String keyword){
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM (SELECT * FROM employee e WHERE e.isDelete = 1) AS isDel WHERE employee_code LIKE '%"+keyword+"%' OR employee_name LIKE '%"+keyword+"%' OR phone LIKE '%"+keyword+"%' OR email LIKE '%"+keyword+"%' AND isDelete = 1;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    public static int checkEmployeeInDepartment(int employeeId){
    Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT e.department_id FROM employee e WHERE e.employee_id = "+employeeId+";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("department_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public static boolean insertEmployeeToDepartment(int employeeID, int departmentID){
        Connection conn = null;
        PreparedStatement prst = null;
        String strSQL;
        String strdepartmentID;
        try {
            conn = Connect.getInstance().getConnection();
            if (departmentID == 0){
                 strSQL = ", manager_id = NULL";
                    strdepartmentID = "NULL";
            } else {
                 strSQL = "";
                    strdepartmentID = String.valueOf(departmentID);
            }

            String sql = "UPDATE employee SET department_id ="+strdepartmentID + strSQL +" WHERE employee_id = "+employeeID+";";
            prst=conn.prepareStatement(sql);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static List<Employees> showEmployeeByDepartmentId(int departmentId){
        List<Employees> employees = new ArrayList<>();
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee where  WHERE e.department_id ="+departmentId+" ;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Employees employee = new Employees();
                employee.setEmployee_id(rs.getInt("employee_id"));
                employee.setEmployee_code(rs.getString("employee_code"));
                employee.setEmployee_name(rs.getString("employee_name"));
                employee.setDate_of_birth(rs.getDate("date_of_birth"));
                employee.setGender(rs.getString("gender"));
                employee.setAddress(rs.getString("address"));
                employee.setPhone(rs.getString("phone"));
                employee.setEmail(rs.getString("email"));
                employee.setSalary(rs.getInt("salary"));
                employee.setDepartment_id(rs.getInt("department_id"));
                employee.setNamager_id(rs.getInt("manager_id"));
                employees.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    //Làm lại
    public static boolean transferEmployeeToManager(int employeeID){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employee SET manager_id = NULL WHERE employee_id = "+employeeID+";";
            prst=conn.prepareStatement(sql);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static boolean checkEmployeeCode(String employeeCode){
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE employee_code = '"+employeeCode+"';";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void transferEmployee(int id, int newDepartmentId){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employee e SET e.department_id = "+newDepartmentId+",e.isDelete = 1, e.manager_id = NULL WHERE e.employee_id = "+id+";";
            prst=conn.prepareStatement(sql);
            prst.executeUpdate();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static  boolean updateEmployeePromotion(int id, int DepartmentId){
        Connection conn = null;
        CallableStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "{call update_emp_Promo(?,?)}";
            prst = conn.prepareCall(sql);
            prst.setInt(1, DepartmentId);
            prst.setInt(2,id);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    //Xoá nhân viên khỏi phòng ban
    public static boolean updateEmployeeDelete(int id){
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employee e SET e.department_id = NULL, e.manager_id = NULL WHERE e.employee_id = "+id+";";
            prst=conn.prepareStatement(sql);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static boolean goBackToWork(int id) {
        Connection conn = null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "UPDATE employee e SET e.isDelete = 1 WHERE e.employee_id = "+id+";";
            prst=conn.prepareStatement(sql);
            prst.executeUpdate();
            return true;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if(prst != null) {
                try {
                    prst.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }

    public static boolean getEmployeesIdDelete(int employeeId) {
        Connection conn = null;
        try {
            conn = Connect.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee WHERE employee_id = "+employeeId+" AND isDelete = 0;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
