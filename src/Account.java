import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountExceptions;

public class Account {
    private String accountNumber;
    private double balance;
    private String name;

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
    public Account(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.name = name;
    }

    public void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited: " + amount+ "Current Balance is "+getBalance());
    }
    public void withdraw(double amount)throws InsufficientFundsException,InvalidAmountExceptions {
        if (getBalance()<amount){
            throw new InsufficientFundsException();
        }
        if (amount <= 0) {
            throw new InvalidAmountExceptions();
        }
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
        System.out.println(amount+"Amount has been debited. \n Available balance is "+getBalance());
    }

    public void transferAmount(Account des,double amount) throws InsufficientFundsException, InvalidAmountExceptions {
        withdraw(amount);
        des.deposit(amount);
        System.out.println("Transferred: " + amount + " to Account: " + des.accountNumber);
    }
}
