package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "user_id")
public class Student extends User{

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @ManyToMany(mappedBy = "students")
    private Set<Kelas>kelases = new HashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<Score> scores = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher supervisor;
    
    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
    }
    
    public Set<Kelas> getKelases() { return kelases; }
    public Set<Score> getScores() { return scores; }
    public Teacher getSupervisor() {return supervisor;}
    
    public void setKelases(Set<Kelas> kelases) { this.kelases = kelases; }
    public void setScores(Set<Score> scores) { this.scores = scores; }
    public void setSupervisor(Teacher supervisor) {this.supervisor = supervisor;}
    
    public float getIPK(){
        int total = 0;
        for (Score score : this.scores){
            total += score.getValue();
        }
        return (float)total / this.scores.size() / 25.00f;
    }

    public void getKHS(){
        System.out.println(String.format("Student %s with GPA of %.2f.",this.getUsername(), this.getIPK()));
        for (Score score : this.scores){

            System.out.print(String.format(
                "|%2s %-10s|%5s %-30s|%2s %03d %2s|%n", 
                "", 
                score.getKelas().getCourse().getCourseId(),
                "", 
                score.getKelas().getCourse().getName(),
                "", 
                score.getValue(),
                ""
            ));
        }
    }
}
