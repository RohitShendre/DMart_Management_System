/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dmart.dbutil;

import java.sql.*;
import javax.swing.JOptionPane;




public class DBConnection {
    private static Connection conn;
    static
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/dmart_db","root",System.getenv("DMART_DB_PASSWORD"));
            JOptionPane.showMessageDialog(null,"connection opened successfully!","success",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in loading the driver","Driver Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in opening connection","DB Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
        
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        try
        {
            conn.close();
            JOptionPane.showMessageDialog(null,"connection closed successfully!","success",JOptionPane.INFORMATION_MESSAGE);
        }
         catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in closing connection","DB Error!",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
