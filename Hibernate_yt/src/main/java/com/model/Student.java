package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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

    public Student(String username, String password, String studentId) {
        super(username, password);
        this.studentId = studentId;
        
    }
    
}
