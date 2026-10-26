/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dmart.dao;

import Dmart.dbutil.DBConnection;
import Dmart.pojo.ProductsPojo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Dmart.pojo.UserProfile;

/**
 *
 * @author INDIA TECHNOLOGY
 */
public class OrderDAO {
      public static String getNextOrderId()throws SQLException
    {
        Connection conn =DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("Select max(order_id) from orders");
        rs.next();
        String ordId=rs.getString(1);
        if(ordId==null)
            return"O_101";
        int ordno=(Integer.parseInt(ordId.substring(2)));
        ordno++;
        return "O_"+ordno;
    }
      public static boolean addOrder(ArrayList<ProductsPojo> al,String ordId)throws SQLException
      {
          Connection conn =DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("Insert into orders (order_id,p_id,quantity,userid) values(?,?,?,?)");
          int count=0;
          for(ProductsPojo p:al)
          {
              ps.setString(1, ordId);
              ps.setString(2, p.getProductId());
              ps.setInt(3, p.getQuantity());
              ps.setString(4,UserProfile.getUserid());
              count=count+ps.executeUpdate();
          }
          return count==al.size();
      }
      public static ArrayList<Object[]>viewBillDitails(String ordId)throws SQLException
      {
          ArrayList<Object[]>al=new ArrayList<>();
           Connection conn =DBConnection.getConnection();
           PreparedStatement ps=conn.prepareStatement("Select o.p_id,p.p_name,p.our_price,o.quantity,(p.our_price*o.quantity)as total,p.p_tax from orders o,products p where o.p_id=p.p_id and o.order_id=?");
           ps.setString(1, ordId);
           ResultSet rs=ps.executeQuery();
           while(rs.next())
           {
               Object[] rows={
                   rs.getString("p_id"),
                   rs.getString("p_name"),
                   rs.getDouble("our_price"),
                   rs.getInt("quantity"),
                   rs.getDouble("total"),
                   rs.getInt("p_tax")
               };
               al.add(rows);
           }
          return al;
      }
        public static ArrayList<Object[]>getAllOrders(String role,String userid)throws SQLException
        {
            Connection conn =DBConnection.getConnection();
            PreparedStatement ps;
            if(role.equalsIgnoreCase("Manager"))
            {
                ps=conn.prepareStatement("select order_id,userid,sum(quantity)as totalqty from orders group by order_id,userid order by order_id desc");
            }
            else
            {
                ps=conn.prepareStatement("select order_id,userid,sum(quantity)as totalqty from orders where userid=? group by order_id,userid order by order_id desc");
            }
            
            if(role.equalsIgnoreCase("Receptionist"))
            {
                ps.setString(1, userid);
            }
            ResultSet rs=ps.executeQuery();
            
            ArrayList<Object[]> al=new ArrayList<>();
            
            while(rs.next())
            {
                Object[] rows=new Object[3];
                rows[0]=rs.getString(1);
                rows[1]=rs.getString(2);
                rows[2]=rs.getInt(3);
                
                al.add(rows);
            }
           return al;
        }
        public static String getOrderReceptionist(String orderId)throws SQLException
        {
            Connection conn =DBConnection.getConnection();
            PreparedStatement ps=conn.prepareStatement("select userid from orders where order_id=? limit 1");
            ps.setString(1, orderId);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                return rs.getString(1);
            }
            return"";
        }
}
