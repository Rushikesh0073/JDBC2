package com.App;
import com.DAO.CustomerDao;
import com.DaoImpl.CustomerDaoImpl;
import com.Entity.Customer;

import java.util.Scanner;


public class CustomerPanel {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
             CustomerDao cd= new CustomerDaoImpl();//
             int ch;
        do {
            System.out.println(".....................Customer Panel..........................");
            System.out.println("......................enter your choice......................");
            System.out.println("1.Add customer \n2.Delete Customer \n.3.Update Customer mobile number\n4.Display AllCustomer\n5.Searh by Id\n6.Exit");

            int choice= sc.nextInt();
            Customer c= new Customer();

            switch (choice)
            {
                case 1:
                    System.out.println("enter the Customer id ");
                    c.setCid(sc.nextInt());
                    System.out.println("enter the First name ");
                    c.setFname(sc.next());
                    System.out.println("enter the Last name ");
                    c.setLname(sc.next());
                    System.out.println("enter the mobile number ");
                    c.setMobileno(sc.nextLong());
                    System.out.println("enter the email id ");
                    c.setEmail(sc.next());
                    System.out.println("enter the Address");
                    c.setAddress(sc.next());
                    cd.addCust(c);
                    break;

                case 2:
                    System.out.println("enter the customer id for deleted ");
                    int id =sc.nextInt();
                    cd.deleteCust(id);
                    break;

                case 3:
                    System.out.println("enter the customer id for update ");
                    id=sc.nextInt();
                    cd.updateCust(id);
                    break;

                case 4:
                    cd.DisplayAllCust();
                    break;
                case 5:
                    System.out.println("enter customer id to display ");
                    id=sc.nextInt();
                    c=cd.GetCustByID(id);
                    System.out.println("---------------------------------------------------");

                    if(c !=null){
                        System.out.println(c);
                    }else{
                        System.out.println("no customer with this id exits ");
                    }
                    System.out.println("-----------------------------------------------------");
                    break;

                case 6:MyApp.main(null);
                break;

                default:
                    System.out.println("invalid choice ");
            }
            System.out.println(" do you want to continue with this id exits ...........");
            System.out.println();
            ch= sc.nextInt();

            switch (ch)
            {
                case 1:ItemPanel.main(null);

            }
        }while(ch!=6);
        System.out.println("Thank you for using Customer Panel.....................");

    }
}
