/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.travelagency;

import java.sql.*;

public class ConnectionToDb {
    private static final String URL = "jdbc:mysql://localhost:3306/travelagency";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    //Connection con = null;

    public static Connection connectMySqlDB() {
        try {

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}