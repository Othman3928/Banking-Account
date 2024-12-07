import java.util.ArrayList;

public class SavingAccount extends BankAccount {
    private double interestRate = 15/100;
    private double minimum;
    private double balance;
    private ArrayList<Transactions> transactions = new ArrayList<>();
    public SavingAccount(int accountNumber,String accountHolderName,double balance, double minimum) {
        super(accountNumber,accountHolderName,balance);
        setMinimum(minimum);

    }
    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }
    public void withdraw(double amount) {
        if(amount>0 && amount<=minimum){
            balance -= amount;
            System.out.println("Succesfull Withdrawn");
        }else if(amount<=0){
            System.out.println("Insufficient Amount to withdraw");
        }else {
            System.out.println("Insufficient Balance In Saving Account");
        }

        Transactions t = new Transactions(this.accountNumber,this.accountHolderName,"Withdraw",amount,formattedDate);
        transactions.add(t);
    }
}
