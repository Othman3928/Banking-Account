import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankAccount implements Reportable {
    protected int accountNumber;
    protected String accountHolderName ;
    private double balance  = 8000;
    private  ArrayList<Transactions> transactions = new ArrayList<>();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = now.format(formatter);

    public BankAccount(int accountNumber, String accountHolderName,double balance) {
        setAccountNumber(accountNumber);
        setAccountHolderName(accountHolderName);
        setBalance(balance);
        System.out.println("Congratulations!");

    }
    protected void setAccountNumber(int accountNumber) {
        if(accountNumber>0){
            this.accountNumber = accountNumber;
        }else {
            System.out.println("Invalid account number");
        }
    }
    protected void setAccountHolderName(String accountHolderName) {
        if(accountHolderName.length()>0){
            this.accountHolderName = accountHolderName;
        }else {
            System.out.println("Invalid account holder name");
        }
    }
    public void withdraw(double amount) {
        if(amount>0 && amount<=balance){
            balance -= amount;
            System.out.println("Successful Withdrawn");
        }else if(amount<=0){
            System.out.println("Insufficient Amount to withdraw");
        }else {
            System.out.println("Insufficient Balance");
        }

        Transactions t = new Transactions(this.accountNumber,this.accountHolderName,"Withdraw",amount,formattedDate);
        transactions.add(t);
    }
    public void deposit(double amount) {
        if(amount>0){
            balance += amount;
            System.out.println("Successful Deposited");
        }else {
            System.out.println("Insufficient Value to deposit");
        }
        Transactions t = new Transactions(this.accountNumber,this.accountHolderName,"Deposit",amount,formattedDate);
    }
    public void TransHistory(){
        System.out.println(transactions);
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder();
        report.append("Account Summary\n");
        report.append("---------------\n");
        report.append("Account Number: ").append(accountNumber).append("\n");
        report.append("Account Holder: ").append(accountHolderName).append("\n");
        report.append("Balance: ").append(balance).append("\n");
        report.append("Transactions:\n");
        for (Transactions transaction : transactions) {
            report.append("- ").append(transaction).append("\n");
        }
        return report.toString();
    }
    public ArrayList<Transactions> transactions(){
        return this.transactions;
    }
}
