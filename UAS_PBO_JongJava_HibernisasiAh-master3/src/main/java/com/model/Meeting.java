package com.model;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Meeting extends Activity {
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
    private LocalDateTime meetingStartTime;
    
    @OneToMany
    private Set<Student> attendees;

    @Override public String getDescription() {return this.description;}

    @Override public Course getCourse() {return this.course;}

    @Override public Kelas getKelas() {return this.kelas;}

    @Override public Teacher getTeacher() {return this.teacher;}

    public LocalDateTime getMeetingStartTime (){
        return this.meetingStartTime;
    }

    public Set<Student> getAttendee(){
        return this.attendees;
    }
    
    public Meeting(String description, Course course, Kelas kelas, Teacher teacher, LocalDateTime meetingStartTime) {
        this.description = description;
        this.course = course;
        this.kelas = kelas;
        this.teacher = teacher;
        this.meetingStartTime = meetingStartTime;
    }
}
