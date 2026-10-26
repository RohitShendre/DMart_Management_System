/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dmart.dao;

import Dmart.dbutil.DBConnection;
import Dmart.pojo.UserPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author INDIA TECHNOLOGY
 */
public class UserDAO {
    public static boolean validateUser(UserPojo user)throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=? ");
        ps.setString(1, user.getUseid());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUsertype());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            return true;
        }
        return false;
    }
    public static boolean isUserPresent(String empid)throws SQLException
    {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select 1 from users where empid=?");
        ps.setString(1,empid);
        ResultSet rs=ps.executeQuery();
        return rs.next();
    }
    
}

    

