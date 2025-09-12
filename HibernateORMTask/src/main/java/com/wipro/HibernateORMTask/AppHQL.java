package com.wipro.HibernateORMTask;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.HibernateORMTask.model.Employee;
import com.wipro.HibernateORMTask.util.HibernateUtil;

public class AppHQL {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE the employee of bharath % surya
        session.save(new Employee("bharath", 70000));
        session.save(new Employee("surya", 80000));

        // READ  all the employees
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        System.out.println("All Employees: " + employees);

        // UPDATE the salary of employee bharath to 90000.0
        Query updateQuery = session.createQuery("update Employee set salary = :sal where name = :name");
        updateQuery.setParameter("sal", 90000.0);
        updateQuery.setParameter("name", "bharath");
        updateQuery.executeUpdate();

        // DELETE the name of the employee  surya
        Query deleteQuery = session.createQuery("delete from Employee where name = :name");
        deleteQuery.setParameter("name", "surya");
        deleteQuery.executeUpdate();

        tx.commit();
        session.close();
        System.out.println("session is closed");
    }
}
