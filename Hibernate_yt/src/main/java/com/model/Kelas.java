package com.model;

import java.util.HashSet;
import java.util.Set;

import com.sun.istack.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "kelas")
public class Kelas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "kelas_id", nullable = false, unique = true)
    private String classId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @ManyToMany
    @JoinTable(
        name = "student_class",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students = new HashSet<>();
    
    public Set<Student> getStudents() {return students;}
    public int getId() {return id;}
    public String getClassId() {return classId;}
    public Teacher getTeacher() {return teacher;}
    public Course getCourse() {return course;}
    
    public void setId(int id) {this.id = id;}
    public void setClassId(String classId) {this.classId = classId;}
    public void setTeacher(Teacher teacher) {this.teacher = teacher;}
    public void setCourse(Course course) {this.course = course;}
    public void setStudents(Set<Student> students) {this.students = students;}

    public Kelas (String classId){
        this.classId = classId;
    }
}