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

            Teacher teacher = new Teacher("Jos Timanta Tarigan", "123", "001");
            session.persist(teacher);

            Teacher teacher2 = new Teacher("Mohammad Andri Budiman", "234", "002");
            session.persist(teacher2);

            Teacher teacher3 = new Teacher("Amer Sharif", "345", "003");
            session.persist(teacher3);

            Teacher teacher4 = new Teacher("Maya Silvi Lydia", "456", "004");
            session.persist(teacher4);

            Student student = new Student("Kevin Maverick", "1", "001");
            student.setSupervisor(teacher);
            session.persist(student);
            
            Student student2 = new Student("Harry Hamara", "2", "002");
            student2.setSupervisor(teacher2);
            session.persist(student2);

            Student student3 = new Student("Gavriel Ernesto", "3", "003");
            student3.setSupervisor(teacher3);
            session.persist(student3);

            Student student4 = new Student("Jason Sendytio", "4", "004");
            student4.setSupervisor(teacher4);
            session.persist(student4);
            
            Student student5 = new Student("Ucok", "5", "005");
            student5.setSupervisor(teacher);
            session.persist(student5);
            
            Student student6 = new Student("Butet", "6", "006");
            student6.setSupervisor(teacher2);
            session.persist(student6);

            Student student7 = new Student("John", "7", "007");
            student7.setSupervisor(teacher3);
            session.persist(student7);

            Student student8 = new Student("Jane", "8", "008");
            student8.setSupervisor(teacher4);
            session.persist(student8);

            Student student9 = new Student("Harry Potter", "9", "009");
            student9.setSupervisor(teacher);
            session.persist(student9);
            
            Student student10 = new Student("Hermione Granger", "10", "010");
            student10.setSupervisor(teacher2);
            session.persist(student10);

            Student student11 = new Student("Ron Weasley", "11", "011");
            student11.setSupervisor(teacher3);
            session.persist(student11);

            Student student12 = new Student("Captain America", "12", "012");
            student12.setSupervisor(teacher4);
            session.persist(student12);

            Student student13 = new Student("Iron Man", "13", "013");
            student13.setSupervisor(teacher);
            session.persist(student13);
            
            Student student14 = new Student("Ant Man", "14", "014");
            student14.setSupervisor(teacher2);
            session.persist(student14);

            Student student15 = new Student("Dr Strange", "15", "015");
            student15.setSupervisor(teacher3);
            session.persist(student15);

            Student student16 = new Student("Hulk", "16", "016");
            student16.setSupervisor(teacher4);
            session.persist(student16);

            Student student17 = new Student("Steve", "17", "017");
            student.setSupervisor(teacher);
            session.persist(student17);
            
            Student student18 = new Student("Alex", "18", "018");
            student18.setSupervisor(teacher2);
            session.persist(student18);

            Student student19 = new Student("Saitama", "19", "019");
            student19.setSupervisor(teacher3);
            session.persist(student3);

            Student student20 = new Student("Ririn", "20", "020");
            student20.setSupervisor(teacher4);
            session.persist(student20);
            
            
            Course course = new Course("Game Development", "ILK001");
            session.persist(course);

            Course course2 = new Course("Game Development Advanced", "ILK002");
            session.persist(course2);

            Course course3 = new Course("Object Oriented Programming", "ILK003");
            session.persist(course3);

            Course course4 = new Course("Data Structures", "ILK004");
            session.persist(course4);

            Kelas kelas = new Kelas("D101");
            kelas.setTeacher(teacher);
            kelas.setCourse(course);
            kelas.getStudents().add(student);
            kelas.getStudents().add(student2);
            kelas.getStudents().add(student3);
            kelas.getStudents().add(student4);
            kelas.getStudents().add(student5);
            kelas.getStudents().add(student6);
            kelas.getStudents().add(student7);
            kelas.getStudents().add(student8);
            
            session.persist(kelas);

            Kelas kelas2 = new Kelas("D102");
            kelas2.setTeacher(teacher2);
            kelas2.setCourse(course2);
            kelas2.getStudents().add(student5);
            kelas2.getStudents().add(student6);
            kelas2.getStudents().add(student7);
            kelas2.getStudents().add(student8);
            kelas2.getStudents().add(student9);
            kelas2.getStudents().add(student10);
            kelas2.getStudents().add(student11);
            kelas2.getStudents().add(student12);
            session.persist(kelas2);
            
            Kelas kelas3 = new Kelas("D103");
            kelas3.setTeacher(teacher3);
            kelas3.setCourse(course3);
            kelas3.getStudents().add(student9);
            kelas3.getStudents().add(student10);
            kelas3.getStudents().add(student11);
            kelas3.getStudents().add(student12);
            kelas3.getStudents().add(student13);
            kelas3.getStudents().add(student14);
            kelas3.getStudents().add(student15);
            kelas3.getStudents().add(student16);
            session.persist(kelas3);
            
            Kelas kelas4 = new Kelas("D104");
            kelas4.setTeacher(teacher4);
            kelas4.setCourse(course4);
            kelas4.getStudents().add(student13);
            kelas4.getStudents().add(student14);
            kelas4.getStudents().add(student15);
            kelas4.getStudents().add(student16);
            kelas4.getStudents().add(student17);
            kelas4.getStudents().add(student18);
            kelas4.getStudents().add(student19);
            kelas4.getStudents().add(student20);
            session.persist(kelas4);
            
            

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