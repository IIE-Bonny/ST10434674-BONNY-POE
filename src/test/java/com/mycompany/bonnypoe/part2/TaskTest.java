/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.bonnypoe.part2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author B.O.N.N.Y
 */
public class TaskTest {
     @Test
    public void testCheckTaskDescription() {
        System.out.println("Task successfully captured");
        Task task_manager = new Task("login Feature",1,"Create Login to autheticate users", "Robyn Harrison",8, "To Do");
        
        assertTrue(task_manager.checkTaskDescription());
        
    }
    
    @Test
    public void testInvalidCheckTaskDescription() {
        System.out.println("Please enter task description of less than 50 characters");
        Task task_manager = new Task("login Feature",1,"Create Login to autheticate users", "Robyn Harrison",8, "To Do");
        
        assertFalse(task_manager.checkTaskDescription(), "Please enter task description of less than 50 characters");
       
    }

    /**
     * Test of createTaskID method, of class Task.
     */
    @Test
    public void testCreateTaskID() {
       
        Task task_manager = new Task("login Feature",2,"Create Login to autheticate users", "Robyn Harrison",9, "To Do");
        assertEquals("AD:2:ITH", task_manager.createTaskID());
        
    }
    
    @Test
    public void testInvalidCreateTaskID() {
        Task task_manager = new Task("login Feature",2,"Create Login to autheticate users", "Mike Smith",10, "Doing");
        assertEquals("AD:2:ITH", task_manager.createTaskID());
        
    }

    /**
     * Test of printTaskDetails method, of class Task.
     */
    @Test
    public void testPrintTaskDetails() {
        Task task_manager = new Task("login Feature",2,"Create Login to autheticate users", "Robyn Harrison",9, "To Do");
        String expDetails = "Task Status:"
                + "TO DO\n" + "Developer Details: Robyn Harrison\n"
                + "Task Number:1\n" +
                "Task Name: Login Feature\n" +
                "Task Description: Create Login to authenticate users\n" +
                "Task ID: LO:1:SON\n" +
                "Task Duration: 8 hours";
        assertEquals(expDetails, task_manager.printTaskDetails());
        
    }
    
    @Test
    public void testInvalidPrintTaskDetails() {
        Task task_manager = new Task("login Feature",2,"Create Login to autheticate users", "Mike Smith",10, "Doing");
        String expDetails = "Task Status:"
                + "DOING\n" + "Developer Details: Mike Smith\n"
                + "Task Number:2\n" +
                "Task Name: Add Task\n" +
                "Task Description: Create add task feature to add task user\n" +
                "Task ID: AD:2:ITH\n" +
                "Task Duration: 10 hours";
        assertEquals(expDetails, task_manager.printTaskDetails());
        
    }


    /**
     * Test of returnTotalHours method, of class Task.
     */
    @Test
    public void testReturnTotalHours() {
        System.out.println("returnTotalHours");
        Task instance = null;
        int expResult = 0;
        int result = instance.returnTotalHours();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    }

    /**
     * Test of checkTaskDescription method, of class Task.
     */
   
