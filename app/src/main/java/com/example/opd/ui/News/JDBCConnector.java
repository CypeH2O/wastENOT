package com.example.opd.ui.News;

import android.os.StrictMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    public ResultSet GetNewsfromdb(int from, int count){
        try {
            if(con==null) {
                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();
            }
            query = select + Integer.toString(from) + " AND " + Integer.toString(from + count);
            //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(policy);
            rs = stmt.executeQuery(query);
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return rs;
    }
    public ResultSet GetMarkNewsfromDB(int NewsID){
        String str ="SELECT * FROM ExtendedNews WHERE id = " ;
        try {
            if(con==null) {
                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();
            }
            query = str + Integer.toString(NewsID);
            //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(policy);
            rs = stmt.executeQuery(query);
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return rs;
    }
    public ResultSet GetBLOBNewsfromDB(int NewsID){
        String str ="SELECT * FROM DataStorage WHERE id = " ;
        try {
            if(con==null) {
                con = DriverManager.getConnection(url, user, password);
            }
            stmt = con.createStatement();
            query = str + Integer.toString(NewsID);
            //StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            //StrictMode.setThreadPolicy(policy);
            rs = stmt.executeQuery(query);
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return rs;
    }
}
