/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.bonnypoe.part2;

import java.util.*;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author B.O.N.N.Y
 */
public class BONNYPOEPART2 {

    public static void main(String[] args) {

        //Login instance
        Login login_checks = new Login();
        


        //declare variables
        String username;
        String password;
        
        
       

        //Promting the user for username and password
        String name = JOptionPane.showInputDialog("Enter your name");
        String Lastname = JOptionPane.showInputDialog("Enter your lastname");
        
        
       

        //use do while
        do {
            //prompt
            //System.out.println("Create a username");
            username = JOptionPane.showInputDialog("Create a username");
        } while (!login_checks.checkUserName(username));

        //user do while for password
        do {
            //prompt
            password = JOptionPane.showInputDialog("Create a password");
        } while (!login_checks.checkPasswordComplexity(password));
        
        String registerMessage = login_checks.registerUser(name, Lastname, username, password);
        JOptionPane.showMessageDialog(null, registerMessage);
        
        if(registerMessage.equals("Both Username and password successfully captured")){
            String loginUsername = JOptionPane.showInputDialog("Enter your username to log in:");
            String loginPassword = JOptionPane.showInputDialog("Enter your password to log in:");
            
            String loginMessage = login_checks.loginUser(username, password);
            
            JOptionPane.showMessageDialog(null, loginMessage);
            
            
                
        boolean convertedBoolean=true;int choice =0;
              //Main loop to keep the application running until the user quits
       
//                String[] option = {"1.Add Tasks", "2.Show Report(Coming Soon)", "3.Quit"};
//                choice = JOptionPane.showOptionDialog(null, "Choose an option from 1-3", "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null,
//                 new String[] {"1.Add tasks", "2.Show Report", ".3.Quit"}, "Add task");
           String input = JOptionPane.showInputDialog("Choose an option\n" +
                   "1. Add task\n" +
                   "2. Show Report\n" +
                   "3. Quit\n\n" +
                   "Enter the number of your choice");
           if(input == null || input.trim().isEmpty()){
               JOptionPane.showMessageDialog(null, "No option selected, try again");
           }
           //This parses the string input into an integer
            choice = Integer.parseInt(input.trim());
                switch (choice) {
                    case 1:
                        //User selected "Add Task"
                        addTasks();
                        break;
                    case 2:
                        //User selected "Show Report",which is not yet available
                        JOptionPane.showMessageDialog(null, "Coming Soon", "Report", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 3:
                            
                        //User selected "Quit", exit the loop
                       convertedBoolean = false;
                        JOptionPane.showMessageDialog(null, "Exiting EasyKanban\n Goodbye", "Exit", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid Option\n try again\n");

                }
                
            
           
        }
       
        

         
    }

    private static void addTasks(){
        int numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks:"));
        ArrayList<Task> task = new ArrayList<>();
        int totalHours = 0;
        
                        //numTasks = task_manager.taskDuration;
                       

                        //Collect task details and create tasks
                        for (int i = 0; i < numTasks; i++) {
                           
                           String taskName= JOptionPane.showInputDialog("Enter task Name: ");
                           String taskDescription;
                           do{
                           taskDescription = JOptionPane.showInputDialog("Enter Task Description(max 50 characters): ");
                           if(taskDescription.length() >50){
                               taskDescription = JOptionPane.showInputDialog("Description too long.", "Please enter task description of less than 50 characters");
                           }else{
                               JOptionPane.showMessageDialog(null, "Task successfully captured.");
                               break;
                           }
                           }while (taskDescription.length() > 50);
                           

                            //Validate task description length
                            String developerDetails = JOptionPane.showInputDialog("Enter Developer's Name: ");
                            int Duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Task Duration\n(in hours):"));
                           
                            String taskStatus = JOptionPane.showInputDialog("Enter Task Status(TO DO, DONE, DOING): ");
                            
                            developers.add(developerDetails);
                            taskNames.add(taskName);
                            //taskIDs.add(task_manager.createTaskID());
                            taskDurations.add(Duration);
                            taskStatuses.add(taskStatus);
                            
                            Task task_manager = new Task(taskName, i, taskDescription, developerDetails, Duration, taskStatus);
                            task.add(task_manager);
                            //Addittion of taskID to an ArrayList
                            taskIDs.add(task_manager.createTaskID());
                            //updates total hours
                            totalHours +=  Duration;
                            
                            JOptionPane.showMessageDialog(null, task_manager.printTaskDetails());
                        }
                            
                            //Display the task details
                            
                        
                            JOptionPane.showMessageDialog(null, "The total duration is:" + totalHours);
     
                        }
    
private static ArrayList<String> developers = new ArrayList<>();
private static ArrayList<String> taskNames = new ArrayList<>();
private static ArrayList<String> taskIDs = new ArrayList<>();
private static ArrayList<Integer> taskDurations = new ArrayList<>();
private static ArrayList<String> taskStatuses = new ArrayList<>();
/**
 * Display the task report menu and handle user selection
 */
private static void showReport(){
String input = JOptionPane.showInputDialog("Report Menu:\n" +
"1. Display All tasks\n" +
"2. Show Task with Status 'Done'\n" +
"3. Show Task with Longest Duration\n"+
"4. Search for Task by Name\n" +
"5. Search for Tasks by Developer\n" +
"6.Delete a Task by Name\n" +
"Enter the number of your choice:");

if(input == null || input.trim().isEmpty()){
JOptionPane.showMessageDialog(null, "No option selected, returning to main menu.");
return;
}
int choice = Integer.parseInt(input.trim());

switch(choice){
case 1:
displayAllTasks();
case 2:
displayDoneTasks();
case 3:
displayLongestTask();
case 4:
searchTaskByName();
case 5:
searchTasksByDeveloper();
case 6:
deleteTaskByName();
default:
JOptionPane.showMessageDialog(null, "Invalid option, returning to main menu.");
}
}
/**
 * Display all tasks stored in the system.
 */
private static void displayAllTasks(){
StringBuilder  allTasks = new StringBuilder("All Tasks:\n\n");

for(int i = 0; i < taskNames.size(); i++){
allTasks.append("Task ID:").append(taskIDs.get(i)).append("\n"
+ "").append("Task Name:").append(taskNames.get(i)).append("\n"
+ "").append(developers.get(i)).append("\n"
+ "").append(taskDurations.get(i)).append("hours\n").append("Status:").append(taskStatuses.get(i)).append("\n"
+ "").append("------------------------------------------\n");
}
JOptionPane.showMessageDialog(null, allTasks.toString());
}
/**
 * Display tasks with status Done
 */
private static void displayDoneTasks(){
StringBuilder doneTasks = new StringBuilder("Tasks with status 'Done':\n\n");

for(int i = 0; i < taskStatuses.size(); i++){
if(taskStatuses.get(i).equalsIgnoreCase("Done")){
doneTasks.append("Task Name:").append(taskNames.get(i)).append("\n"
+ "").append("Developer:").append(developers.get(i)).append("\n"
+ "").append("Duration:").append(taskDurations.get(i)).append("hours\n").append("--------------------------------\n");
}
}
JOptionPane.showMessageDialog(null, doneTasks.toString());
}
/**
 * Display the task with the longest duration
 */
private static void displayLongestTask(){
int maxIndex = 0;

for(int i = 1; i < taskDurations.size(); i++){
if(taskDurations.get(i) > taskDurations.get(maxIndex)){
maxIndex = i;
}
}
JOptionPane.showMessageDialog(null, "Task with the longest duration:\n"
+ "Task Name:" +
taskNames.get(maxIndex) + "\n" +
"Developer:\n" +
developers.get(maxIndex) + "\n" +
"Duration:" +
taskDurations.get(maxIndex) + 
"hours");
}

/**
 * Search for a task by its name.
 */
private static void searchTaskByName(){
String name = JOptionPane.showInputDialog("Enter the Task Name to search:");

//to check if entered matches a Task Name
boolean found = false;

StringBuilder result = new StringBuilder("Search Results:\n\n");

for(int i = 0; i < taskNames.size(); i++){
found = true;
result.append("Task ID:").append(taskIDs.get(i)).append("\n" +
"").append("Task Name:").append(taskNames.get(i)).append("\n" +
"").append("Developer:").append(developers.get(i)).append("\n" +
"").append("Duration:").append(taskDurations.get(i)).append("hours" +
"\n").append(taskStatuses.get(i)).append("\n").append("-----------------------------------\n");
}

if(found){
JOptionPane.showMessageDialog(null,result.toString());
}else{
JOptionPane.showMessageDialog(null, "No task found with the name" +
name + ".");
}
}

/**
 * Search for all tasks assigned to a specific developer
 */
    private static void searchTasksByDeveloper(){
String developer = JOptionPane.showInputDialog("Enter the Developer's Name to search");

//To track if match is found
boolean found = false;

StringBuilder result = new StringBuilder("Task assigned to" + developer + "\n\n");

List<String> matchingTasks = new ArrayList<>();

for(int i =0; i < developers.size(); i++){
if(developers.get(i).equalsIgnoreCase(developer)){
//case sensetive match
found = true;
result.append("Task ID:").append(taskIDs.get(i)).append("\n" +
"").append("Task Name:").append(taskNames.get(i)).append("\n" +
"").append("Status:").append(taskStatuses.get(i)).append("\n" +
"").append("--------------------------------------------\n");
}
}

if(found){
JOptionPane.showMessageDialog(null, result.toString());
}else{
JOptionPane.showMessageDialog(null, "No task found assigned to" + developer + "");
}
} 

/**
 * Delete a task by its name
 */
  private static void deleteTaskByName(){
String name = JOptionPane.showInputDialog("Enter the Task Name to delete:");

for(int i = 0; i < taskNames.size(); i++){
if(taskNames.get(i).equalsIgnoreCase(name)){
//Case sensitive math
//Remove task details from all parallel arrays

developers.remove(i);
taskNames.remove(i);
taskIDs.remove(i);
taskDurations.remove(i);

JOptionPane.showMessageDialog(null, "Task" + name + "has been successfully deleted");
//Exit after deleting the task
return;
}
}
//if there is no match found
JOptionPane.showMessageDialog(null, "No task found with the name" + name + ".");
}
}











