import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    public static void print_Transacton(ArrayList<Transactions> arr) {
        try(FileWriter writer = new FileWriter("TransActions.txt")) {
            File file = new File("TransActions.txt");
            for(Transactions t : arr) {
                writer.write(t.toString()+System.lineSeparator());
                System.out.println("The File In "+ file.getAbsolutePath());
            }
        }catch (IOException e) {
            System.out.println("Error in writing file "+ e.getMessage());
        }


    }
    public static void main(String[] args) {
        System.out.println("Welcome Yo will Make a New Account Bank");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of your account: \n");
        int number = input.nextInt();
        input.nextLine();
        System.out.print("Enter the name of your account: \n");
        String name = input.nextLine();
        System.out.print("Enter the balance: \n");
        int balance = input.nextInt();
        input.nextLine();
        BankAccount bankAccount = new BankAccount(number,name,balance);
        SavingAccount savingAccount = null ;
        boolean s = true;
        boolean t = true;
        while (t&&s){
            System.out.print("Select An Operation: \n");
            System.out.println("1. Make a Saving account");
            System.out.println("2. Withdraw account");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.println("5. Report");
            System.out.println("6. Write a Transaction in File");
            char option = input.next().charAt(0);
            switch(option){
                case '1':
                    if(balance<1900){
                        System.out.println("Your balance is less than minimum of Saving Account");
                    }else {
                         savingAccount = new SavingAccount(number,name,balance,1900);
                        s=false;
                    }
                    break;
                case '2':
                    System.out.println("Enter the amount to withdraw: ");
                    int amount = input.nextInt();
                    input.nextLine();
                    bankAccount.withdraw(amount);
                    break;
                case '3':
                    System.out.println("Enter the amount to deposit: ");
                    int amount_ = input.nextInt();
                    input.nextLine();
                    bankAccount.deposit(amount_);
                    break;
                case '4':
                    System.out.println("Thank you for using Banking Account");
                    System.exit(1);
                    break;
                case '5':
                    System.out.println("Thank you for using Saving Account");
                    System.out.println(bankAccount.report());
                    break;
                case '6':
                    System.out.println("Thank you for using Saving Account");
                    print_Transacton(bankAccount.transactions());
                    break;
            }
        }
        while (t){
            System.out.print("Select An Operation: \n");
            System.out.println("1. use a Saving account");
            System.out.println("2. Withdraw account");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.println("5. Report");
            System.out.println("6. Write a Transaction in File");
            char option = input.next().charAt(0);
            switch(option){
                        case '1':
                               s=true;
                               t = false;
                               break;
                        case '2':
                               System.out.println("Enter the amount to withdraw: ");
                               int amount = input.nextInt();
                               input.nextLine();
                               bankAccount.withdraw(amount);
                               break;
                        case '3':
                              System.out.println("Enter the amount to deposit: ");
                              int amount_ = input.nextInt();
                              input.nextLine();
                              bankAccount.deposit(amount_);
                              break;
                        case '4':
                            System.out.println("Thank you for using Banking Account");
                            System.exit(1);
                            break;
                        case '5':
                            System.out.println("Thank you for using Saving Account");
                            System.out.println(bankAccount.report());
                            break;
                        case '6':
                            System.out.println("Thank you for using Saving Account");
                            print_Transacton(bankAccount.transactions());
                            break;
            }

        }
        while (s){
            System.out.print("Select An Operation: \n");
            System.out.println("1. use a Banking account");
            System.out.println("2. Withdraw account");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.println("5. Report");
            System.out.println("6. Write a Transaction in File");
            char option = input.next().charAt(0);
            switch(option){
                case '1':
                    s=true;
                    break;
                case '2':
                    System.out.println("Enter the amount to withdraw: ");
                    int amount = input.nextInt();
                    input.nextLine();
                    savingAccount.withdraw(amount);
                    break;
                case '3':
                    System.out.println("Enter the amount to deposit: ");
                    int amount_ = input.nextInt();
                    input.nextLine();
                    savingAccount.deposit(amount_);
                    break;
                case '4':
                    System.out.println("Thank you for using Saving Account");
                    System.exit(1);
                    break;
                case '5':
                    System.out.println("Thank you for using Saving Account");
                    System.out.println(savingAccount.report());
                    break;
                case '6':
                    System.out.println("Thank you for using Saving Account");
                    print_Transacton(savingAccount.transactions());
                    break;

            }

    }

    }
}