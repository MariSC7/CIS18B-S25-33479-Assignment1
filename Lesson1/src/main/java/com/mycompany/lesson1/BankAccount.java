package com.mycompany.lesson1;
 
public class BankAccount {
    // Holds account name, number and balance. 
    private String accountHolderName;
    private int accountNumber; 
    private double balance; 
        
    //Constructor to create bank account.
    public BankAccount(String name, int accountNumber,double money) {
        this.accountHolderName = name;
        this.accountNumber = accountNumber;
        this.balance = money;
    }    

    //Adds money to account
    public void deposit (double amount){
        this.balance += amount;
        System.out.println("Balance: $" + this.balance); 
    }

    //Subtracts money from account
    public void withdraw (double amount){
        this.balance -= amount;
        System.out.println("Balance: $" + this.balance); 
    }
    
    //Displays balance
    public void getBalance (){
        System.out.println("Balance: $" + this.balance); 
    }
    
    //Retrieves balance.
    public double Balance (){
        return this.balance;
    }
}       