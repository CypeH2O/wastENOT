package com.example.opd.ui.News;

import android.os.StrictMode;
import android.util.TimingLogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Statement;
import java.sql.ResultSet;

public class JDBCConnector {
    private String url = "jdbc:mysql://db4free.net:3306/polyecodb";
    private String user = "polyecodb";
    private String password = "polyecodb";
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String query;
    private String select="SELECT * FROM NewTable WHERE id BETWEEN ";
    public ResultSet ConncectToDb(int from,  int count){
        try {
            query = select + Integer.toString(from) + " AND " + Integer.toString(from + count);
            long start = System.nanoTime();
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            con = DriverManager.getConnection(url, user, password);
            long connect = System.nanoTime();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            long finish = System.nanoTime();
            long elapsed = finish - connect;
            long contime = connect - start;
            System.out.println("Прошло времени на соединение, с: " + elapsed/1000000000);
            System.out.println("Прошло времени на запрос, с: " + contime/1000000000);
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return rs;
    }
}
