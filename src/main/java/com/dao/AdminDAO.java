package com.dao;

import com.util.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

    public boolean validate(String username, String password) {

        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionPool.giveConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            rs = ps.executeQuery();

            return rs.next(); 

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception ignored) {}
            try { if (ps != null) ps.close(); } catch (Exception ignored) {}
            ConnectionPool.submitConnection(con);
        }
    }
}
