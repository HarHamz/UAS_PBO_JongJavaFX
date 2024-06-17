package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nilai", nullable = false)
    private int value;

    @ManyToOne(fetch = FetchType.LAZY)
    private Kelas kelas;

    @ManyToOne
    private Student student;

    public Score() {}

    public Score(int value, Kelas kelas, Student student) {
        this.value = value;
        this.kelas = kelas;
        this.student = student;
    }

    public Score(int value, Kelas kelas) {
        this.value = value;
        this.kelas = kelas;
    }

    public int getId() { return id; }
    public int getValue() { return value; }
    public Kelas getKelas() { return kelas; }
    public Student getStudent() { return student; }

    public void setId(int id) { this.id = id; }
    public void setValue(int value) { this.value = value; }
    public void setKelas(Kelas kelas) { this.kelas = kelas; }
    public void setStudent(Student student) { this.student = student; }

}
