package com.thaivu.fap.entity;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private String id;
    private String name;
    private int yob;
    private double salary;

}