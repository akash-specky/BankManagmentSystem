import exceptions.InsufficientFundsException;
import exceptions.InvalidAmountExceptions;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();

        Account account1 = bank.createAccount("001","Akash");
        Account account2 = bank.createAccount("002","Ankit");

        account1.deposit(1000.0);
        account2.deposit(500.0);

        try {
            account1.transferAmount(account2, 300.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds for transfer.");
        } catch (InvalidAmountExceptions e) {
            throw new RuntimeException(e);
        }

        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());

    }




}