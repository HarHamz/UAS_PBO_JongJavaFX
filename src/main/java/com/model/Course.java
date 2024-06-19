package com.model;

import com.sun.istack.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @NotNull
    @Column(name = "course_code", nullable = false)
    private String courseCode;

    public Course(String name, String courseId) {
        this.name = name;
        this.courseCode = courseId;
    }

    public String getName() {return name;}
    public String getCourseId() {return courseCode;}

    public void setName(String name) {this.name = name;}
    public void setCourseId(String courseCode) {this.courseCode = courseCode;}
}
