package com.wipro.HiberORM;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.wipro.HiberORM.model.Employee;
import com.wipro.HiberORM.util.HibernateUtil;

public class NativeSQLDemo {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE 
        session.save(new Employee("kiran", 50000));
        session.save(new Employee("jashu", 60000));

        // READ all the employess in the table
        NativeQuery<Employee> query = session.createNativeQuery("SELECT * FROM employee", Employee.class);
        List<Employee> employees = query.getResultList();
        System.out.println("All Employees: " + employees);

        // UPDATE the salary for the employee name jashu to 75000.0
        session.createNativeQuery("UPDATE employee SET salary = :sal WHERE name = :name")
                .setParameter("sal", 75000.0)
                .setParameter("name", "jashu")
                .executeUpdate();

        // DELETE the employee name with kiran
        session.createNativeQuery("DELETE FROM employee WHERE name = :name")
                .setParameter("name", "kiran")
                .executeUpdate();

        tx.commit();
        session.close();
        System.out.println("Session is closed");
    }
}
