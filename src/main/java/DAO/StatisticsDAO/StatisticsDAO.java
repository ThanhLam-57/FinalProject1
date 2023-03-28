package DAO.StatisticsDAO;

import Database.Connect;
import Modal.Statistics;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class StatisticsDAO {
    public static List<Statistics> getStatistics(){
        List<Statistics> statisticsList = new ArrayList<>();
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = Connect.getConnection();
            String sql = "{ call bang_tong_hop() }";
            cstmt = conn.prepareCall(sql);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                int department_id = rs.getInt(1);
                String department_name = rs.getString(2);
                int employee_count = rs.getInt(3);
                int manager_id = rs.getInt(4);
                String manager_name = rs.getString(5);
                int employee_id_max_salary = rs.getInt(6);
                String employee_name_max_salary = rs.getString(7);
                int salary_max = rs.getInt(8);
                Statistics statistics = new Statistics(department_id, department_name, employee_count, manager_id, manager_name, employee_id_max_salary, employee_name_max_salary, salary_max);
                statisticsList.add(statistics);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (cstmt != null) {
                    cstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return statisticsList;
    }
}
