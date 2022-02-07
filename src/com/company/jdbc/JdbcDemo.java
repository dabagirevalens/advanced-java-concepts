package com.company.jdbc;

import java.io.IOException;
import java.sql.*;

public class JdbcDemo {

    public static void main(String[] args) throws IOException {
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String u_name = "root";
        String u_pass = "const";
        Connection dbConnect = null;

        Statement statement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            dbConnect = DriverManager.getConnection(url, u_name, u_pass);
            statement = dbConnect.createStatement();

            //insert into cutomers table
//            String query = "insert into customers(name, balance) values('DABAGIRE Valens', 1200000000), ('SHUMBOSHO David', 12000000)";
//
//            int count = statement.executeUpdate(query);
//            System.out.println("number of rows affected by this query= " + count);

            String select_query = "select * from customers";

            ResultSet rs = statement.executeQuery(select_query);

            ResultSetMetaData rsmd = rs.getMetaData();

            int columnsNumber = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print("  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + " : " + columnValue);
                }
                System.out.println("");
            }

            dbConnect.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
