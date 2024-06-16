package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "teacher")
@PrimaryKeyJoinColumn(name = "user_id")
public class Teacher extends User{

    @Column(name = "teacher_id", nullable = false, unique = true)
    private String teacherId;

    public Teacher(String username, String password, String teacherId) {
        super(username, password);
        this.teacherId = teacherId;
    }
}
