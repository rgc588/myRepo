package com.chengong.test;

import com.chengong.domainObject.Account;
import com.chengong.util.HibernateUtil;
import org.hibernate.Session;
import org.junit.Test;

import java.util.Date;

/**
 * Created by chengong on 3/9/14.
 */
public class HibernateUtilTest {
    private static String USER_NAME = "testUserName";

    @Test
    public void test() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Account newAccount = new Account();
        newAccount.setUserName(USER_NAME);
        newAccount.setAccountCreationDate(new Date());
        session.save(newAccount);

        session.getTransaction().commit();
        HibernateUtil.getSessionFactory().close();

    }
}
