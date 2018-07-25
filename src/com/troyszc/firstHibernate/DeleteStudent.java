package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

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
            //session.delete(theStudent);
            session.createQuery("delete from Student where id=studentId").executeUpdate();

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
