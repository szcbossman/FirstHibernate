package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

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
            //create 3 student objs
            Student theStudent0 = new Student("Challenger", "Dodge", "straightlinepwr@dodge.com");
            Student theStudent1 = new Student("Camaro", "Chevy", "smokestang@gm.com");
            Student theStudent2 = new Student("Mustang", "Ford", "trashzl1@ford.com");
            //start transaction
            session.beginTransaction();
            //save student obj
            session.save(theStudent0);
            session.save(theStudent1);
            session.save(theStudent2);
            //commit transaction
            session.getTransaction().commit();
            System.out.println("work done: 3 students saved to db.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
