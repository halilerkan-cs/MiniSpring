package controller;

import annotation.Autowired;
import model.Account;
import service.AccountService;

public class AccountController {

    @Autowired
    private AccountService accountService;

    public Account getAccount(String id) {
        return accountService.getAccount(id);
    }
}
