package com.App;

import com.Entity.Customer;

import java.util.Scanner;

public class MyApp {
    static  Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int ch;
        do {
            System.out.println("-------------Welcome to ORDER MANAGEMENT SYSTEM----------------");
            System.out.println("Enter your choice.................");
            System.out.println("1.Item Panel\n2.Customer Panel\n.3.Order Panel\n4.Exit");

            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    ItemPanel.main(null);
                    break;
                case 2:
                    CustomerPanel.main(null);
                    break;
                case 3:
                    OderPanel.main(null);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice :");
            }
        }while (ch !=4);
        System.out.println("Enter your Choice Again ");
    }

}
