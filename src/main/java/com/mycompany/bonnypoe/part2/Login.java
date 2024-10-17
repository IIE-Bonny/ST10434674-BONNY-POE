/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonnypoe.part2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author B.O.N.N.Y
 */
public class Login {
    
      //declare variables
         private String name = "";
        private String  username = "";
        private String  password = "";
        private String firstname = "";
        private String lastname = "";
        private boolean UserFound = false;
        private boolean PassFound = false;
    
    
    //check username method
    public boolean checkUserName(String username){
       
        boolean result = false;
        
        if (username.contains("_") && username.length() <= 5){
            System.out.println("Username Captured");
            result = true;
        }
        else{
            System.out.println("Username not captured!");
            result = false;
        }
        
        // check username
        return result;
       
       
    }
    //check password complexity method
    public boolean checkPasswordComplexity(String password){
        
      //password must be at least 8 characters long
      if(password.length() < 8){
          return false;
      }
        //initialized boolean variables
      boolean hasUpperCase = false;
      boolean hasNumber = false;
      boolean hasSpecialChar = false;
      
      //Regex to find special characters
      Pattern specialCharPattern = Pattern.compile("[^a-zA-Z0-9]");
      Matcher matcher = specialCharPattern.matcher(password);
      
      for(int i = 0; i < password.length(); i++){
          char c = password.charAt(i);
          if(Character.isUpperCase(c)){
              //assign isUpperCase to true
              hasUpperCase = true;
          }
          if(Character.isDigit(c)){
              //assign isDigit to true
              hasNumber = true;
          }
          if(matcher.find()){
              //message
              System.out.println("Password Captured");
              //assign hasSpecialChar to true
              hasSpecialChar = true;
          }
      }
      
      return hasUpperCase && hasNumber && hasSpecialChar;
     
    }
    
    
    //Message return method
     public String registerUser(String name, String lastname, String username, String password){
        
        if(!checkUserName(username)){
        return "Username not correctly formatted";
    }
        
        if(!checkPasswordComplexity(password)){
            return "Password not correctly formatted....";
        }
        
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        
        return "Both Username and password successfully captured";
        
    }
    
    public void display(){
        System.out.println(name + "\n" + lastname + "\n" +username + "\n" + password );
        
    }
    public boolean loginUser(String username, String password){
        
        
        return username.equals(this.username) && password.equals(this.password);
        
        
    }
    
    public String returnLoginStatus(boolean login){
      if(login){
          return "Welcome" + name + " " + lastname + "it is great to see you again";
      }  
      return "Username or password incorrect please try again";
    }
    
        
    
    
    
    /*
    public String returnLoginStatus(String firstname, String lastname, String username, String password){
       // Initialized outcome variable
        String outcome ="";
        //check if login is successful
        if(loginUser(username, password)){
        outcome = "A successful Login, Welcome "+firstname+lastname;
        }else{
        outcome  = "A failed Login";
            }      
            return outcome;
}
*/
    
    
}
