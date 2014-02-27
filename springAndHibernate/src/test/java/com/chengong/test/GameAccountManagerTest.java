package com.chengong.test;

import com.chengong.service.AccountManager;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chengong on 2/26/14.
 */
public class GameAccountManagerTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountManager accountManager = (AccountManager) context.getBean("GameAccountManager");
        accountManager.getAccountNumber();
    }
}
