package com.dao;

import com.model.Student;
import com.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // ---------------- INSERT STUDENT ------------------
    public boolean insertStudent(Student s) {
        String sql = "INSERT INTO student (first_name, last_name, email) VALUES (?, ?, ?)";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionPool.giveConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getEmail());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            ConnectionPool.submitConnection(con);
        }
    }

    // ---------------- GET ALL STUDENTS ------------------
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        String sql = "SELECT student_id, first_name, last_name, email FROM student";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionPool.giveConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setEmail(rs.getString("email"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            ConnectionPool.submitConnection(con);
        }

        return list;
    }

    // ---------------- GET STUDENT BY ID ------------------
    public Student getStudentById(int id) {

        Student s = null;

        String sql = "SELECT student_id, first_name, last_name, email FROM student WHERE student_id = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionPool.giveConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setFirstName(rs.getString("first_name"));
                s.setLastName(rs.getString("last_name"));
                s.setEmail(rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            ConnectionPool.submitConnection(con);
        }

        return s;
    }

    // ---------------- UPDATE STUDENT ------------------
    public boolean updateStudent(Student s) {

        String sql = "UPDATE student SET first_name = ?, last_name = ?, email = ? WHERE student_id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionPool.giveConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, s.getFirstName());
            ps.setString(2, s.getLastName());
            ps.setString(3, s.getEmail());
            ps.setInt(4, s.getStudentId());

            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            ConnectionPool.submitConnection(con);
        }
    }
    
 // ---------------- DELETE STUDENT ------------------
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM student WHERE student_id = ?";

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionPool.giveConnection();
            ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            ps.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            ConnectionPool.submitConnection(con);
        }
    }
 
    
}
