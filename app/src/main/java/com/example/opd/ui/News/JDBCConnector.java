package com.example.opd.ui.News;

import android.os.StrictMode;

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
    private String query="SELECT * FROM NewTable;";
    public ResultSet ConncectToDb(){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return rs;
    }
}
