package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private static final String URL = "jdbc:postgresql://localhost:5432/StudentManagementSystem";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Hrishi@0710";
    private static final String DRIVER = "org.postgresql.Driver";

    private static final int POOL_SIZE = 7;

    private static List<Connection> connectionPool = new ArrayList<>();

    static {
        try {
            Class.forName(DRIVER);
            for (int i = 0; i < POOL_SIZE; i++) {
                connectionPool.add(createConnection());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public synchronized static Connection giveConnection() {
        Connection con = null;

        if (!connectionPool.isEmpty()) {
            con = connectionPool.remove(0);
        } else {
            try {
                con = createConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            if (con == null || con.isClosed()) {
                con = createConnection();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;
    }

    public synchronized static void submitConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                if (connectionPool.size() < POOL_SIZE) {
                    connectionPool.add(con);
                } else {
                    con.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
