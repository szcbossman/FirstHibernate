package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    public static void main (String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //use a new session to retrieve data from db
            session.beginTransaction();
            Student student = session.get(Student.class, 1);
            System.out.println("\nthe retrieved the student is: " + student);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
