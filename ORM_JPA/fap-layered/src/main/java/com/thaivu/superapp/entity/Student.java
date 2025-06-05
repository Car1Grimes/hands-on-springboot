package com.thaivu.superapp.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                                    // key tu tang

    @Column(name = "name", nullable = false, length = 50)
    @Nationalized                                       //nvarchar
    private String name;

    @Column(name = "yob", nullable = false)
    private int yob;

    @Column(name = "gpa")
    private double gpa;

    //BOILERPLATE
    // bat buoc phai co constructor rong, full tham so (key tu tang thi sao?)
    //getter() setter() tostring()
}
