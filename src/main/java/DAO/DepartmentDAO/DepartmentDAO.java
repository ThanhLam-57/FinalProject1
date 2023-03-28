package DAO.DepartmentDAO;

import Database.Connect;
import Modal.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    //Done
    public static boolean insertDepartment(Department department){
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "INSERT INTO department(department_code, department_name ,isDeleteDep) VALUES (?, ?,1)";
            prst = conn.prepareStatement(sql);
            prst.setString(1, department.getDepartment_code());
            prst.setString(2, department.getDepartment_name());
            prst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Done
    public static List<Department> getAllDepartment(){
        List<Department> departments = new ArrayList<>();
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getInstance().getConnection();
            String sql = "SELECT * FROM department where isDeleteDep = 1";
            prst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = prst.executeQuery();
            while (rs.next()){
                Department department = new Department();
                department.setDepartment_id(rs.getInt("department_id"));
                department.setDepartment_code(rs.getString("department_code"));
                department.setDepartment_name(rs.getString("department_name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            throw  new RuntimeException(e);
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return departments;
    }

    //Done
    public static Department getDepartmentById(int department_id){
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM department s WHERE s.department_id =" + department_id;
            ResultSet rs = stmt.executeQuery(sql);
            Department d = null;
            while(rs.next()) {
                d = new Department();
                d.setDepartment_id(rs.getInt("department_id"));
                d.setDepartment_code(rs.getString("department_code"));
                d.setDepartment_name(rs.getString("department_name"));
                d = new Department(rs.getInt("department_id"), rs.getString("department_code"), rs.getString("department_name"));
            }
            return d;
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

    //Done
    public static boolean updateDepartment(Department department){
        Connection conn= null;
        PreparedStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "UPDATE department SET department_code = ?, department_name = ? WHERE department_id = ?";
            prst = conn.prepareStatement(sql);
            prst.setString(1, department.getDepartment_code());
            prst.setString(2, department.getDepartment_name());
            prst.setInt(3, department.getDepartment_id());
            prst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //Done
//    public static boolean deleteDepartment(int department_id){
//        Connection conn= null;
//        PreparedStatement prst = null;
//        PreparedStatement prst1 = null;
//        try {
//            conn = Connect.getConnection();
//            String sql = "UPDATE employee e SET e.department_id = NULL, e.manager_id = NULL WHERE e.department_id = "+department_id+";";
//            String sql1 = "UPDATE department d SET d.isDeleteDep = 0 WHERE d.department_id = "+department_id+";";
//            prst = conn.prepareStatement(sql);
//            prst.executeUpdate();
//            prst1 = conn.prepareStatement(sql1);
//            prst1.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (prst != null) {
//                    prst.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return false;
//    }

    public static boolean deleteDepartment(int department_id){
        Connection conn= null;
        CallableStatement prst = null;
        try {
            conn = Connect.getConnection();
            String sql = "{call delete_dep(?)}";
            prst = conn.prepareCall(sql);
            prst.setInt(1, department_id);
            prst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (prst != null) {
                    prst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Department getDepartmentByName(String departmentEmp) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM department s WHERE s.department_name ='" + departmentEmp + "'";
            ResultSet rs = stmt.executeQuery(sql);
            Department d = null;
            while(rs.next()) {
                d = new Department();
                d.setDepartment_id(rs.getInt("department_id"));
                d.setDepartment_code(rs.getString("department_code"));
                d.setDepartment_name(rs.getString("department_name"));
                d = new Department(rs.getInt("department_id"), rs.getString("department_code"), rs.getString("department_name"));
            }
            return d;
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

    public static boolean checkDepartmentCode(String departmentCode) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM department s WHERE s.department_code ='" + departmentCode + "'";
            ResultSet rs = stmt.executeQuery(sql);
//            Department d = null;
//            while(rs.next()) {
//                d = new Department();
//                d.setDepartment_id(rs.getInt("department_id"));
//                d.setDepartment_code(rs.getString("department_code"));
//                d.setDepartment_name(rs.getString("department_name"));
//                d = new Department(rs.getInt("department_id"), rs.getString("department_code"), rs.getString("department_name"));
//            }
            if(rs.next()){
                return false;
            }
            return false;
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

    public static boolean checkDepartmentName(String departmentName) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Connect.getInstance().getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM department s WHERE s.department_name ='" + departmentName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return false;
            }
            return false;
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
}
