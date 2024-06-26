package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Description")
    private String description;
    
    public abstract String getDescription(); // mengembalikan deskripsi dari aktivitas, implementasi dilakukan oleh
    
    // kelas yang mengimplementasikan kelas abstract Activity
    public abstract Course getCourse(); // mata kuliah yang diajarkan pada

    public abstract Kelas getKelas(); // mengembalikan kelas yang memiliki activity ini

    public abstract Teacher getTeacher(); // mengembalikan pengajar

    public Activity (String description){
        this.description = description;
    }
}