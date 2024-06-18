package com.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "assignment_id")
public class Assignment extends Activity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Kelas kelas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
    private LocalDateTime dueDate;

    @ManyToMany
    private Set<Student> assignee = new HashSet<>();

    public Assignment(String description, Course course, Kelas kelas, Teacher teacher, LocalDateTime dueDate) {
        this.description = description;
        this.course = course;
        this.kelas = kelas;
        this.teacher = teacher;
        this.dueDate = dueDate;
    }

    @Override public String getDescription() {return this.description;}

    @Override public Course getCourse() {return this.course;}

    @Override public Kelas getKelas() {return this.kelas;}

    @Override public Teacher getTeacher() {return this.teacher;}
    
    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public Set<Student> getAssignee() {
        return assignee;
    }
}
