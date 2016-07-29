package com.madhu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class FirstEx {
    
    public static void main(String[] args) throws Exception {
        
        Connection con = getConnection();
        PreparedStatement statement = con.prepareStatement("SELECT count(1) FROM SYS_CONFIG_201502 WHERE (SELECT max(UPDATED_DATE) FROM SYS_CONFIG_201502) > ?");
        statement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        ResultSet rs = statement.executeQuery();
        //System.out.println("rs is >>> "+rs.getInt(1));
        while(rs.next())
        {
        System.out.println(">>>>"+ rs.getInt(1));
        }
    }

    private static Connection getConnection() throws Exception {
        
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.140.30:1521:decedb1", "madhukar", "madhukar");
        return con;
    }
}
