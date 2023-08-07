package com.App;

import com.DAO.ItemDao;
import com.DaoImpl.ItemDaoImpl;
import com.Entity.Item;

import java.util.Scanner;

public class ItemPanel {
     static Scanner sc = new Scanner(System.in);

     public static void main(String[] args) {
          ItemDao id =  new ItemDaoImpl();
          int ch;
          do {

               System.out.println("......................Item-Panel.............................................................................");
               System.out.println(".................Enter your choice...................................................................................................................");

               System.out.println("1. Add Item\n2.Delete Item\n3.Update Item cost\n4.Display All Item\n5.Serach Item By Id\n6..Exit");

               ch = sc.nextInt();
               Item i = new Item();



               switch (ch) {

                    case 1:
                         System.out.println("Enter item id ");
                         i.setItemid(sc.nextInt());
                         System.out.println("enter item name ");
                         i.setIname(sc.next());
                         System.out.println("enter cost of item ");
                         i.setCost(sc.nextFloat());
                         id.AddItem(i);
                         break;

                    case 2:
                         System.out.println("enter the item id for deleted ");
                         int did = sc.nextInt();
                         id.DeleteItem(did);
                         break;

                    case 3:
                         System.out.println("enter item id for update");
                         did = sc.nextInt();
                         id.UpdateItem(did);
                    case 4:
                         id.DisplayAllItem();
                         break;
                    case 5:
                         System.out.println("enter the item id for display");
                         did = sc.nextInt();
                         id.GetItemByID(did);
                         System.out.println("--------------------------------------------------------");
                         break;
                    case 6:
                         MyApp.main(null);
                         break;
                    default:
                         System.out.println("Invalid choice ");
               }
               System.out.println(" do you want to continue with Item panel ..........................");
               System.out.println("if yes then press 1 ");
               System.out.println("for exit press 6");
               ch=sc.nextInt();
               }
               while (ch != 6) ;
          System.out.println(" thank you for using Item panel................");
          }
     }

