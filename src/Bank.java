import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accountList;

    public Bank(){
        accountList = new ArrayList<>();
    }

    public Account createAccount(String accountNumber, String name){
        Account account = new Account(accountNumber,name);
        accountList.add(account);
        return account;
    }
    public Account findAccount(String acNumber)throws AccountNotFoundException {
        for (int i=0;i<accountList.size();i++){
            if (accountList.get(i).getAccountNumber().equalsIgnoreCase(acNumber)){
                return accountList.get(i);
            }
        }
        throw new AccountNotFoundException("Account Not found");
    }


}
