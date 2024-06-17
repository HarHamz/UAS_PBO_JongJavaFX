package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User{

    @Column(name = "teacher_id", nullable = false, unique = true)
    private String teacherId;


    @OneToMany(mappedBy = "supervisor")
    private Set<Student> studentSupervised = new HashSet<>();
    
    public String getTeacherId() {return teacherId;}
    public Set<Student> getStudents() {return studentSupervised;}
    
    public void setTeacherId(String teacherId) {this.teacherId = teacherId;}
    public void setStudents(Set<Student> students) {this.studentSupervised = students;}
    
    public Teacher(String username, String password, String teacherId) {
        super(username, password);
        this.teacherId = teacherId;
    }
}
