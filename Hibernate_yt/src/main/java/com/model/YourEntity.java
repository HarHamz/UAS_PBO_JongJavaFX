package com.model;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.Table;

@Entity
public class YourEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters and Setters
    public Long getId() {return id;}
    public String getName() {return name;}

    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}

}
