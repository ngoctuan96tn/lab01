package com.example.lab01.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    private String name;

    private Boolean gender;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDay;

    private String address;

    private Boolean isActive;

    @ManyToMany(mappedBy = "students")
    Set<Course> courses;

}
