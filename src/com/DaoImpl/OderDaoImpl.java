package com.DaoImpl;

import com.DAO.OrderDao;
import com.Entity.Order;
import com.connect.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class OderDaoImpl implements OrderDao {

    Connection con;
    Statement st;
    ResultSet rs;
    PreparedStatement pst;

    static Scanner sc = new Scanner(System.in);
     public OderDaoImpl() {
        con = DBConnection.getConnect();

	System.out.println("connection done..............");
        try {
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


     @Override
     public void AddOrder(Order o) {
         try {
             st = con.createStatement();
             float cost = 0;
             ResultSet rs = st.executeQuery("select * from  item");
             while (rs.next()) {
                 int id = rs.getInt(1);
                 if (o.getItem_id() == id) {
                     cost = rs.getFloat(3);
//					System.out.println(cost);
                 }
             }

             pst = con.prepareStatement("insert into orderdetails values(?,?,?,?,?,?,?)");
             pst.setInt(1, o.getOrder_id());
             pst.setInt(2, o.getCid());
             pst.setInt(3, o.getItem_id());
             pst.setInt(4, o.getQty());


             float TCost = o.getQty() * cost;
//			System.out.println(Cost1);
             pst.setFloat(5, TCost);

             //pst.setString(6, o.getOstatus());
             //pst.setString(7, o.getPayStatus());

             int NoOfRowsAdded = pst.executeUpdate();
             if (NoOfRowsAdded > 0) {
                 System.out.println("order added");
             } else {
                 System.out.println(" invalid error");
             }

         } catch (Exception e) {
             System.out.println(e);
         }


     }

     @Override
     public void UpdateOder(int oid) {
         System.out.println("Enter item id:");
         int Iid = sc.nextInt();
         System.out.println("Enter item name:");
         String name = sc.next();
         System.out.println("Enter item cost:");
         float cost = sc.nextFloat();

         try {
             this.pst = this.con.prepareStatement("insert into item values(?,?,?)");
             this.pst.setInt(1, Iid);
             this.pst.setString(2, name);
             this.pst.setFloat(3, cost);
             int noOfRowsAdded = this.pst.executeUpdate();
             if (noOfRowsAdded > 0) {
                 System.out.println("Item added.............");
             } else {
                 System.out.println("invaid Error......");
             }
         } catch (Exception e) {
             System.out.println(e);
         }



     }

     @Override
     public void DeleteOder(int oid) {
         try {
             pst = con.prepareStatement("delete from orderdetails where order_id=?");
             pst.setInt(1, oid);

             int NoOfRowsDeleted = pst.executeUpdate();
             if (NoOfRowsDeleted > 0) {
                 System.out.println("order deleted");
             } else {
                 System.out.println("invalid id .......");
             }
         } catch (Exception e) {
             System.out.println(e);
         }

     }

     @Override
     public Order GetOderByID(int oid) {
         try {
             pst = con.prepareStatement("select * from Orderdetails where order_id=?");
             pst.setInt(1, oid);

             rs = pst.executeQuery();
             if (rs.next()) {
                 Order o = new Order();
                 o.setOrder_id(rs.getInt(1));
                 o.setCid(rs.getInt(2));
                 o.setItem_id(rs.getInt(3));
                 o.setQty(rs.getInt(4));
                 o.settCost(rs.getFloat(5));
                 //o.setOstatus(rs.getString(6));
                // o.setPayStatus(rs.getString(7));
                 return o;
             }
         } catch (Exception e) {
             System.out.println(e);
         }
         return null;
     }

     @Override
     public void DisplayAllOrder() {
         try {
             rs = st.executeQuery("select*from Orderdetails");
             System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
             while (rs.next()) {
                 System.out.println(rs.getInt(1) + "   " + rs.getInt(2) + "   " + rs.getInt(3) + "   " + rs.getInt(4)
                         + "   " + rs.getFloat(5));
                 //+ "   " + rs.getString(6) + "   " + rs.getString(7));
                 System.out.println("------------------------------------------------------------------------------------");
             }
         } catch (Exception e) {
             System.out.println(e);
         }

     }

     }


