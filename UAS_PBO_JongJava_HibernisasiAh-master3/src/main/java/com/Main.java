package com;

import com.model.User;
import com.model.Course;
import com.model.Kelas;
import com.model.Student;
import com.model.Teacher;
import com.model.Score;
import com.model.Meeting;
import com.model.Activity;
import com.model.Assignment;
// import com.model.*;
import com.util.HibernateUtil;

// import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
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

            Teacher teacher = new Teacher("sensei1", "12345", "01020304");
            session.persist(teacher);

            Teacher teacher2 = new Teacher("sensei2", "12345", "01020305");
            session.persist(teacher2);

            Student student = new Student("samurai", "1345", "24");
            student.setSupervisor(teacher);
            session.persist(student);
            
            Student student2 = new Student("ninjitsu", "12345", "25");
            student2.setSupervisor(teacher2);
            session.persist(student2);
            
            Student student3 = new Student("ninjatsu", "12345", "26");
            student3.setSupervisor(teacher2);
            session.persist(student3);
            
            Course course = new Course("Game Development", "1K010101");;
            session.persist(course);

            Course course2 = new Course("Game Development Advanced", "2K010101");;
            session.persist(course2);

            Kelas kelas = new Kelas("kelas01");
            kelas.setTeacher(teacher);
            kelas.setCourse(course);
            kelas.getStudents().add(student);
            kelas.getStudents().add(student2);
            kelas.getStudents().add(student3);
            session.persist(kelas);
            
            Kelas kelas2 = new Kelas("kelas02");
            kelas2.setTeacher(teacher2);
            kelas2.setCourse(course2);
            kelas2.getStudents().add(student2);
            kelas2.getStudents().add(student3);
            session.persist(kelas2);

            Score score1 = new Score(85, kelas, student);
            Score score2 = new Score(90, kelas, student2);
            Score score3 = new Score(75, kelas, student3);

            session.persist(score1);
            session.persist(score2);
            session.persist(score3);

            Score score5 = new Score(90, kelas2, student2);
            Score score6 = new Score(75, kelas2, student3);

            session.persist(score5);
            session.persist(score6);

            student.getScores().add(score1);
            student2.getScores().add(score2);
            student3.getScores().add(score3);
            student2.getScores().add(score5);
            student3.getScores().add(score6);

            session.persist(student);
            session.persist(student2);
            session.persist(student3);

            System.out.println(String.format("Student 1 : %.2f", student.getIPK()));
            System.out.println(String.format("Student 1 : %.2f", student2.getIPK()));
            System.out.println(String.format("Student 1 : %.2f", student3.getIPK()));
            
            student2.getKHS();
        
            Meeting meet1 = new Meeting("meeting ke-1 untuk kelas02", course2, kelas2, teacher2, null);
            Meeting meet2 = new Meeting("meeting ke-2 untuk kelas02", course2, kelas2, teacher2, null);
            Assignment asg1 = new Assignment("assignment ke-1 untuk kelas02", course2, kelas2, teacher2, null);

            session.persist(meet1);
            session.persist(meet2);
            session.persist(asg1);

            kelas2.getActivities().add(meet1);
            kelas2.getActivities().add(meet2);
            kelas2.getActivities().add(asg1);
            session.persist(kelas2);
            
            for (Activity act: kelas2.getActivities()){
                System.out.println("\n\n\n---");
                System.out.println(act.getDescription());
                System.out.println("---\n\n\n");
            }

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