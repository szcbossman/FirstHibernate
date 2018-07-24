package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main (String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        //use session obj to save java obj
        try {
            //create student obj
            Student theStudent = new Student("Troy", "Song", "troysong33@gmail.com");
            //start transaction
            session.beginTransaction();
            //save student obj
            session.save(theStudent);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("work done: student saved to db.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
