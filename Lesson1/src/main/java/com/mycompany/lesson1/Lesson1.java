
package com.mycompany.lesson1;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Lesson1 { 

    // String Input Error - Warns of strings instead of numbers being used. 
    static void StrInputErr () {
        System.out.println("Error: Please enter an number.");
        System.out.print("Amount of Money:");
    }
    // Number Input Error - Warns of negative numbers.
    static void NumInputErr (){
        System.out.println("Error: Enter a positive number.");
        System.out.print("Amount of Money: ");
    }

    // Null Account Error - Warns of no account created.
    static void NullAccErr (){
        System.out.println("You do not have an existing account");
    }

    public static void main(String[] args) {
        
        //Take user input for using the menu and entering needed information
        Scanner userInput = new Scanner(System.in);        
        
        // Keeps program running and displaying the menu. 
        boolean run = true; 
        

        //Makes known that no account exists until the first account is created by the user. 
        BankAccount Account = null;

        while (run) {
            //Displayes choices user can pick from
            System.out.println("\nWelcome to the Banking System:");             
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit \n");  
            
            System.out.print("Enter a choice: ");

            int choice = 0; 
            
            while (choice < 1 || choice > 5)
            { 
            try {
                    choice = userInput.nextInt(); 
                //Checks for values below 1 or above 5 and prompts for a valid menu choice.
                if ( choice < 1 || choice > 5 ) { 
                    System.out.println("Error: Enter a valid number between 1-5.");
                    System.out.print("Enter a choice: ");
                }
            }
            // Checks for a string value and prompts for a number. 
            catch ( InputMismatchException StringInput){
                userInput.nextLine();
                System.out.println("Error: Please enter an number."); 
                System.out.print("Enter a choice: ");
            }
            }
            
            switch (choice) {
                case 1:
                    System.out.println("\n1. Create Account");
                   
                    System.out.print("Account Name: ");
                    String name = userInput.next();
                    
                    double money = -1; 

                    System.out.print("Amount of Money: ");

                    while (money < 0) {
                        try {
                            money = userInput.nextDouble();  
                            
                            // Checks for negative values and prompts for a positve input. 
                            if (money < 0) {
                                NumInputErr();
                            }
                        // Checks for a string value and prompts for a number.                 
                        } catch (InputMismatchException e) {
                            userInput.nextLine();  
                            StrInputErr();
                        }
                    } 
                
                    int accountNumber = 0; 
                    Account = new BankAccount(name, accountNumber, money);
                    System.out.println("Account created!"); 

                    break;
                case 2: 
                    System.out.println("\n2. Deposit Money");
                    
                    // Amount deposited
                    double amountD = -1;
                    System.out.print("Amount of Money: ");

                    while (amountD < 0 ) {
                        try {
                             amountD = userInput.nextDouble();

                            // Checks for negative values and prompts for a positve input. 
                            while (amountD < 0)
                            {
                                NumInputErr();
                                amountD = userInput.nextDouble();
                            }
                            Account.deposit(amountD);
                        }
                        // Checks for a string value and prompts for a number. 
                        catch ( InputMismatchException StringInput){
                            userInput.nextLine();
                            StrInputErr();
                        }
                        // Checks if no account exists and sends user back to the menu. 
                        catch (NullPointerException NoAccount){
                            NullAccErr();
                        }
                    }
                    break;
                case 3:

                    System.out.println("\n 3. Withdraw Money");
                    
                    //Amount withdrawn
                    double amountW = -1 ;
                    System.out.print("Amount of Money: ");
                    
                    while (amountW < 0)
                        try {
                             amountW = userInput.nextDouble();

                            // Checks for negative values and prompts for a positve input. 
                            if (amountW < 0)
                            {
                                NumInputErr();    
                            }
                            // Prevents user from withdrawing more than whats currently in their account
                            // and sends them back to the menu.
                            else if (amountW > Account.Balance())
                            {
                                System.out.println("Error: You do not have enough money to withdraw that amount.");
                            }
                            else Account.withdraw(amountW);
                        }
                        // Checks for a string value and prompts for a number. 
                        catch ( InputMismatchException StringInput){
                            userInput.nextLine();
                            StrInputErr();                            
                        }
                        // Checks if no account exists and sends user back to the menu. 
                        catch (NullPointerException NoAccount){
                            NullAccErr();
                        }
                    break;
                case 4:
                    System.out.println("\n4. Check Balance.");
                    try {
                        Account.getBalance();
                    } 
                    // Checks if no account exists and sends user back to the menu.   
                    catch (NullPointerException NoAccount){
                        NullAccErr();
                    }

                    break;
                case 5:      
                    System.out.println("\n 5. Exit Program");
                    System.out.println("You've now exited the program");
                    run = false; 
                    break;
            }
        } 
    
    }

}
