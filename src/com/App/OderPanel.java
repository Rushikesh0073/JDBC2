package com.App;

import com.DAO.OrderDao;
import com.DaoImpl.OderDaoImpl;
import com.Entity.Order;

import java.util.Scanner;

public class OderPanel {

        static Scanner sc=new Scanner(System.in);
        public static void main (String[]args)
        {
            OrderDao od=new OderDaoImpl();
            int ch;
            do {
                System.out.println("---------------Order Panel---------------------");
                System.out.println("1. Add Order ");
                System.out.println("2. Delete Order ");
                System.out.println("3. Update Item quantity");
                System.out.println("4.Display all Orders");
                System.out.println("5. Search Order by id ");
                System.out.println("6.Exit ");

                ch = sc.nextInt();
                Order o=new Order();
                switch (ch) {

                    case 1:
                        System.out.println("enter oder id ");
                        o.setOrder_id(sc.nextInt());
                        System.out.println("enter customer id");
                        o.setCid(sc.nextInt());
                        System.out.println("enter item id ");
                        o.setItem_id(sc.nextInt());
                        System.out.println("enter the quantity");
                        o.setQty(sc.nextInt());
                        System.out.println("enter the total cost ");
                        o.settCost(sc.nextInt());
                       // System.out.println("enter order status");
                       // o.setOstatus(sc.next());
                       // System.out.println("ente paymentStatus");
                       // o.setPaystatus(sc.next());
                        od.AddOrder(o);
                        break;


                    case 2:
                        System.out.println("enter the oder id for delete ");
                        int odrid= sc.nextInt();
                        od.DeleteOder(odrid);
                    case 3:
                        System.out.println("enter the oder id for  update ");
                        odrid=sc.nextInt();
                        od.UpdateOder(odrid);
                    case 4:od.DisplayAllOrder();
                          break;
                    case 5:
                        System.out.println("enter the order id for display ");
                        odrid = sc.nextInt();
                        o = od.GetOderByID(odrid);
                        System.out.println("-------------------------------------------------------------------------------------------------------");
                        if (o != null) {
                            System.out.println(o);
                        } else {
                            System.out.println(" no order invalid id ");
                        }
                        System.out.println("------------------------------------------------------------------------------------------------------------");
                        break;
                    case 6:MyApp.main(null);
                    break;
                    default:
                        System.out.println("invalid choice ");
                }
                System.out.println("do you want to continue -----------------------------");
            }while (ch != 6);
            System.out.println("Thank you for using Order Panel-------------------------------- ");
            }

        }


