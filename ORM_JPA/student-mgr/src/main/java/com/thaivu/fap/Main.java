package com.thaivu.fap;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        // Co 2 ky thuat ket noi vao csdl
        // ky thuat truyen thong: tu viet SQL

        // ky thuat hien dai: ORM
        // 2 nhanh con: CODE FIRST VS DATABASE FIRST
        // CODE FIRST: Tu code ra table, insert data luon
        // ky thuat hien dai: jdbc chi la cai nen
        // ta can them: jpa, hibernate,...

        // Ky thuat truyen thong: tu lam moi thu voi sql
        // Xai thu vien cua microsoft jdbc la du
        Connection conn = null;
        // We need to specify where the database lives, this information is called "Connection string", written after a standard
        String dbConn = "jdbc:sqlserver://localhost:1433;databaseName=???;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "sa123456";

        // always prone to exception
        try {
            conn = DriverManager.getConnection(dbConn, user, password);
            String sql = "select * from student";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int yob = rs.getInt("yob");
                double gpa = rs.getDouble("gpa");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}