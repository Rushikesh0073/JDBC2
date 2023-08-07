package com.DaoImpl;

import com.DAO.CustomerDao;
import com.Entity.Customer;
import com.connect.DBConnection;

import java.sql.*;
import java.util.Scanner;

public class CustomerDaoImpl implements CustomerDao{
     Connection con;
     Statement st;
     ResultSet rs;
     PreparedStatement pst;
     static Scanner sc= new Scanner(System.in);

     public CustomerDaoImpl()
     {
         con = DBConnection.getConnect();
         System.out.println("Connection done.............");
          try {
               st = con.createStatement();
          } catch (SQLException e) {
               System.out.println(e);
          }

     }

     @Override
     public void addCust(Customer c) {
          try {
               pst = con.prepareStatement("insert into customer values(?,?,?,?,?,?)");
               pst.setInt(1, c.getCid());
               pst.setString(2, c.getFname());
               pst.setString(3, c.getLname());
               pst.setLong(4, c.getMobileno());
               pst.setString(5, c.getEmail());
               pst.setString(6, c.getAddress());

               int NoOfRowsAdded = pst.executeUpdate();
               if (NoOfRowsAdded > 0) {
                    System.out.println("customer added");
               } else {
                    System.out.println("error....................");
               }

          } catch (Exception e) {
               System.out.println(e);
          }

     }

     @Override
     public void deleteCust(int cid) {
          try {
               pst = con.prepareStatement("delete from  customer where cid=?");
               pst.setInt(1, cid);
               int NoOfRowsDeleted = pst.executeUpdate();
               if (NoOfRowsDeleted > 0) {
                    System.out.println("customer is deleted");
               } else {
                    System.out.println("error");
               }
          } catch (Exception e) {
               System.out.println(e);
          }

     }

     @Override
     public void updateCust(int cid) {
          try {
               Customer c = new Customer();
               c = GetCustByID(cid);
               if (c != null) {
                    System.out.println("old details of customer");
                    System.out.println(c);
                    System.out.println("............................................................................................");
                    System.out.println(" enter new mobile number");
                    long mno =sc.nextLong();
                    pst = con.prepareStatement("update customer set mobileno=? where cid=?");
                    pst.setLong(1, mno);
                    pst.setInt(2, cid);

                    int NoOfRowsUpdated = pst.executeUpdate();
                    if (NoOfRowsUpdated > 0) {
                         System.out.println("mobile number updates");
                    } else {
                         System.out.println("error...........................");
                    }

               } else {
                    System.out.println("customer id doestnt exist...................");
               }

          } catch (Exception e) {
               System.out.println(e);
          }

     }

     @Override
     public Customer GetCustByID(int cid) {
          try {
               pst = con.prepareStatement("select * from Customer where cid=?");
               pst.setInt(1, cid);

               rs = pst.executeQuery();
               if (rs.next()) {
                    Customer c = new Customer();
                    c.setCid(rs.getInt(1));
                    c.setFname(rs.getString(2));
                    c.setLname(rs.getString(3));
                    c.setMobileno(rs.getLong(4));
                    c.setEmail(rs.getString(5));
                    c.setAddress(rs.getString(6));
                    return c;

               }

          } catch (Exception e) {
               System.out.println(e);
          }
          return null;

     }

     @Override
     public void DisplayAllCust() {
          try {
               rs = st.executeQuery("select * from Customer");
               System.out.println("-----------------------------------------------------------------------------");
               while (rs.next()) {
                    System.out.println(rs.getInt(1) + "   " + rs.getString(2) + "   " + rs.getString(3) + "   "
                            + rs.getLong(4) + "   " + rs.getString(5) + "   " + rs.getString(6));
                    System.out.println("-------------------------------------------------------------------------------------------------------");
               }
          } catch (Exception e) {
               System.out.println(e);
          }

     }

     @Override
     public void addCustomer(Customer c) {

          try {
               pst = con.prepareStatement("insert into Customer values(?,?,?,?,?,?)");
               pst.setInt(1, c.getCid());
               pst.setString(2, c.getFname());
               pst.setString(3, c.getLname());
               pst.setLong(4, c.getMobileno());
               pst.setString(5, c.getEmail());
               pst.setString(6, c.getAddress());

               int NoOfRowsAdded = pst.executeUpdate();
               if (NoOfRowsAdded > 0) {
                    System.out.println("Customer added");
               } else {
                    System.out.println("Invalid error...........");
               }

          } catch (Exception e) {
               System.out.println(e);
          }


     }
}
