package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {

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
            int studentId = 1;

            session.beginTransaction();
            Student theStudent = session.get(Student.class, studentId);
            theStudent.setFirstName("Sad");
            session.getTransaction().commit();
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student s set email='boss302@gmail.com' where s.lastName='Song' ").executeUpdate();
            session.getTransaction().commit();
            System.out.println("done.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }
}
