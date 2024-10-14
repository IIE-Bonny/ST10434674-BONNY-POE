/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bonnypoe.part2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author B.O.N.N.Y
 */
public class BONNYPOEPART2 {

    public static void main(String[] args) {
     
         //Login instance
        Login login_checks = new Login();
           
           // object for a scanner
        Scanner sc = new Scanner(System.in);
       
        
         //declare variables
        String name = "";
        String Lastname = "";
        String username = "";
        String password = "";
        
          //Promting the user for username and password
          System.out.println("Enter your name");
          name = sc.nextLine();
          System.out.println("Enter your lastname");
          Lastname = sc.nextLine();
          
          //use do while
        do{
            //prompt
            System.out.println("Create a username");
            username = sc.nextLine();
        }while( !login_checks.checkUserName(username));
        
        //user do while for password
        do{
            //prompt
            System.out.println("Enter password: ");
            password = sc.nextLine();
        }while(!login_checks.checkPasswordComplexity(password));
        
       
    }
}
