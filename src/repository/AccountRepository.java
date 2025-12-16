package repository;

import model.Account;

import java.util.HashMap;

public class AccountRepository {

    private HashMap<String, Account> myTinyDatabase;

    public AccountRepository() {
        this.myTinyDatabase = new HashMap<>(10);
        startDatabase();
    }

    public void startDatabase() {
        for (int i = 0; i < 10; i++) {
            String userName = "User-" + (int) (Math.random() * 100);
            Account randomAccount = new Account(String.valueOf(i), userName, (long) (Math.random() * 10000));
            myTinyDatabase.put(randomAccount.getId(), randomAccount);
        }
    }

    public Account getAccount(String id) {
        return myTinyDatabase.get(id);
    }

}
