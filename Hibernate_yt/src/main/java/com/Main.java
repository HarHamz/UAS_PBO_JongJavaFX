package com;

import com.model.User;
import com.model.YourEntity;
import com.model.Course;
import com.model.Kelas;
import com.model.Student;
import com.model.Teacher;
// import com.model.*;
import com.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static Object process1x (){
        // Create a new entity object
        YourEntity entity = new YourEntity();
        entity.setName("Sample Name");

        return entity;
    }
    
    public static void main(String[] args) {
        // Obtain a session from the SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = null;
        try {
            // Start a transaction
            tr = session.beginTransaction();

            // Create a new entity object
            User user = new User("ninja", "12345");

            // Save the entity (deprecated)
            // session.save(user);
            session.persist(user);
            
            // Commit the transaction
            // tr.commit();

            Student student = new Student("samurai", "1345", "24");
            session.persist(student);
            
            Student student2 = new Student("ninjitsu", "12345", "25");
            session.persist(student2);
            
            Student student3 = new Student("ninjatsu", "12345", "26");
            session.persist(student3);

            Teacher teacher = new Teacher("shinobi", "12345", "01020304");
            session.persist(teacher);
            
            Course course = new Course("Game Development", "1K010101");;
            session.persist(course);

            Kelas kelas = new Kelas("kelas02");
            kelas.setTeacher(teacher);
            kelas.setCourse(course);
            kelas.getStudents().add(student);
            kelas.getStudents().add(student2);
            kelas.getStudents().add(student3);
            session.persist(kelas);

            tr.commit();

        } catch (Exception e){
            if (tr != null) tr.rollback();
            System.out.println("___");
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
            System.out.println("___");
        } finally {
            session.close();
        }

        // Close the SessionFactory
        HibernateUtil.shutdown();

    }
}