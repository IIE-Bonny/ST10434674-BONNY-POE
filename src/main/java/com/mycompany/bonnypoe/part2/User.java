/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bonnypoe.part2;

/**
 *
 * @author B.O.N.N.Y
 */
class User{
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        
//        //Constructor to create a new user
//        public User(String username, String password, String firstName, String lastName){
//            this.username = username;
//            this.password = password;
//            this.firstName = firstName;
//            this.lastName = lastName;
//        }
        
        public void userDetails(String username, String password, String firstName, String lastName){
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
        }
        //Getters to get back the users information
        public String getUsername(){
            return username;
        }
        
        public String getPassword(){
            return password;
        }
        
        public String getFirstName(){
            return firstName;
        }
        
        public String getLastName(){
            return lastName;
        }
    }
    
    
