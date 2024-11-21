/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.bonnypoe.part2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author B.O.N.N.Y
 */
public class BONNYPOEPART2Test {
    
   
    @BeforeEach
    public void setUp() {
        //Clear and populate the task arrays before each test
        BONNYPOEPART2.developers.clear();
        
        BONNYPOEPART2.taskNames.clear();
        
        BONNYPOEPART2.taskIDs.clear();
        
        BONNYPOEPART2.taskDurations.clear();
        
        BONNYPOEPART2.taskStatuses.clear();
        
        //TASK 1
        BONNYPOEPART2.developers.add("Mike Smith");
        
        BONNYPOEPART2.taskNames.add("Create Login");
        
        BONNYPOEPART2.taskIDs.add("CL:0:MS");
        
        BONNYPOEPART2.taskDurations.add(5);
        
        BONNYPOEPART2.taskStatuses.add("To Do");
        
        //TASK 2
        BONNYPOEPART2.developers.add("Edward Harrison");
        
        BONNYPOEPART2.taskNames.add("Create Add Features");
        
        BONNYPOEPART2.taskIDs.add("CAF:1:EH");
        
        BONNYPOEPART2.taskDurations.add(8);
        
        BONNYPOEPART2.taskStatuses.add("Doing");
        
        //TASK 3
        BONNYPOEPART2.developers.add("Samantha Paulson");
        
        BONNYPOEPART2.taskNames.add("Create Reports");
        
        BONNYPOEPART2.taskIDs.add("CR:2:SP");
        
        BONNYPOEPART2.taskDurations.add(2);
        
        BONNYPOEPART2.taskStatuses.add("Done");
        
        //TASK 4
        BONNYPOEPART2.developers.add("Glenda Oberholzer");
        
        BONNYPOEPART2.taskNames.add("Add Arrays");
        
        BONNYPOEPART2.taskIDs.add("AA:3:GO");
        
        BONNYPOEPART2.taskDurations.add(11);
        
        BONNYPOEPART2.taskStatuses.add("To Do");
    }
    
   

    /**
     * Test of displayAllTasks method, of class BONNYPOEPART2.
     */
    @Test
    public void testDisplayAllTasks() {
       //Capture the results of displayAllTasks
       ArrayList<String> allTasks = new ArrayList<>();
       for(int i = 0; i < BONNYPOEPART2.taskNames.size(); i++){
           allTasks.add("Task Name: " +BONNYPOEPART2.taskNames.get(i));
       }
       //VERIFY THE SIZE AND CONTENT
       assertEquals(4,allTasks.size());
       
       assertTrue(allTasks.contains("Task Name: Create Login"));
       
       assertTrue(allTasks.contains("Task Name: Create Add Features"));
    }

    /**
     * Test of displayDoneTasks method, of class BONNYPOEPART2.
     */
    @Test
    public void testDisplayDoneTasks() {
       //FILTER TASKS WITH THE STATUS "DONE"
       ArrayList<String> doneTasks = new ArrayList<>();
       for(int i = 0; i < BONNYPOEPART2.taskStatuses.size(); i++){
           if(BONNYPOEPART2.taskStatuses.get(i).equalsIgnoreCase("Done")){
               doneTasks.add(BONNYPOEPART2.taskNames.get(i));
           }
       }
       //VERIFY THE SIZE AND CONTENT
       assertEquals(1, doneTasks.size());
       
       assertTrue(doneTasks.contains("Create Reports"));
    }

    /**
     * Test of displayLongestTask method, of class BONNYPOEPART2.
     */
    @Test
    public void testDisplayLongestTask() {
       int maxNum = 0;
       for(int i = 1; i <BONNYPOEPART2.taskDurations.size(); i++){
           if(BONNYPOEPART2.taskDurations.get(i) > BONNYPOEPART2.taskDurations.get(maxNum)){
               maxNum = i;
           }
       }
       //VERIFY THE LONGEST TASK
       assertEquals("Add Arrays", BONNYPOEPART2.taskNames.get(maxNum));
       
       assertEquals(11, BONNYPOEPART2.taskDurations.get(maxNum));
    }

    /**
     * Test of searchTaskByName method, of class BONNYPOEPART2.
     */
    @Test
    public void testSearchTaskByName() {
        String taskToSearch = "Create Login";
        
        boolean found = false;
        for(String taskName : BONNYPOEPART2.taskNames){
            if(taskName.equalsIgnoreCase(taskToSearch)){
                found = true;
                break;
            }
        }
        //VERIFY THE SEARCH RESULT
        assertTrue(found);
    }

    /**
     * Test of searchTasksByDeveloper method, of class BONNYPOEPART2.
     */
    @Test
    public void testSearchTasksByDeveloper() {
       String developerToSearch = "Mike Smith";
       
       ArrayList<String> tasksByDeveloper = new ArrayList<>();
       for(int i = 0; i < BONNYPOEPART2.developers.size(); i++){
           if(BONNYPOEPART2.developers.get(i).equalsIgnoreCase(developerToSearch)){
               tasksByDeveloper.add(BONNYPOEPART2.taskNames.get(i));
           }
       }
       assertEquals(1, tasksByDeveloper.size());
       
       assertTrue(tasksByDeveloper.contains("Create Login"));
    }

    /**
     * Test of deleteTaskByName method, of class BONNYPOEPART2.
     */
    @Test
    public void testDeleteTaskByName() {
        String taskToDelete = "Create Login";
        
        for(int i = 0; i < BONNYPOEPART2.taskNames.size(); i++){
            if(BONNYPOEPART2.taskNames.get(i).equalsIgnoreCase(taskToDelete)){
                BONNYPOEPART2.taskNames.remove(i);
                
                BONNYPOEPART2.developers.remove(i);
                
                BONNYPOEPART2.taskIDs.remove(i);
                
                BONNYPOEPART2.taskDurations.remove(i);
                
                BONNYPOEPART2.taskStatuses.remove(i);
                break;
            }
        }
        //VERIFY TASK DELETION
        assertFalse(BONNYPOEPART2.taskNames.contains(taskToDelete));
    }
    
}
