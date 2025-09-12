package com.wipro.web;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import com.wipro.model.User;



@Repository
public class UserDao {

private SessionFactory factory;

public UserDao() {
    factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();
}

public void saveUser(User user) {
    Session session = factory.getCurrentSession();
    try {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    } finally {
        session.close();
    }
}


}