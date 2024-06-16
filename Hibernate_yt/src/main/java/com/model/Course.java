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
    @Column(name = "course_id", nullable = false)
    private String courseId;

    public Course(String name, String courseId) {
        this.name = name;
        this.courseId = courseId;
    }

    public String getName() {return name;}
    public String getCourseId() {return courseId;}

    public void setName(String name) {this.name = name;}
    public void setCourseId(String courseId) {this.courseId = courseId;}
}
