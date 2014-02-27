package com.chengong.implement;

import com.chengong.domainObject.Account;
import com.chengong.service.AccountManager;

/**
 * Created by chengong on 2/26/14.
 */
public class GameAccountManager implements AccountManager {
    Account account;

    @Override
    public void getAccountNumber() {
        System.out.println("getAccountNumber from GameAccountManager " + account.getAccountNumber());
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
