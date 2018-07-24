package com.troyszc.firstHibernate;

import com.troyszc.firstHibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    public static void main (String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            List<Student> theStudents = session.createQuery("from Student").getResultList();
            displayStudents(theStudents);

            theStudents = session.createQuery("from Student s where s.lastName = 'Chevy'").getResultList();
            displayStudents(theStudents);

            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            factory.close();
        }
    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student s : theStudents) {
            System.out.println(s);
        }
    }
}
