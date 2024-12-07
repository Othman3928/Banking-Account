public class Transactions {
    String accountHolderName ;
    int accountNumber;
    String TransactoinType;
    double TransactoinValue;
    String TransactoinDate;

    public Transactions(int accountNumber,String accountHolderName,String TransactoinType,double TransactoinValue,String TransactoinDate) {
       setAccountHolderName(accountHolderName);
       setAccountNumber(accountNumber);
       setTransactoinType(TransactoinType);
       setTransactoinValue(TransactoinValue);
       setTransactoinDate(TransactoinDate);

    }
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactoinType(String transactoinType) {
        TransactoinType = transactoinType;
    }

    public void setTransactoinValue(double transactoinValue) {
        TransactoinValue = transactoinValue;
    }

    public void setTransactoinDate(String transactoinDate) {
        TransactoinDate = transactoinDate;
    }
    public String toString(){
        return"\nAccount Number:- " + this.accountNumber+"\nAccount Name :- "+this.accountHolderName
                +"\nTransAction Type : "+this.TransactoinType+"\nTransAction Date :-"+this.TransactoinDate+"\nTransaction Value : "+this.TransactoinValue+"\n";
    }

}
