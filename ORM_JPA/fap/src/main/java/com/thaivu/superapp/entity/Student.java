package com.thaivu.superapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Nationalized;

// ta se dung annotation @ de yeu cau javac, jvm , jpa, hibernate, jdbc bien doi class -> table

@Entity // day la mot table trong tuong lai
@Table(name = "Student") // ko can @ nay thi se lay ten class lam ten table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    // mot table bat buoc phai co pk
    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    // string mac dinh convert thanh varchar (255)
    // string bien thanh char(?) thi ta can them cau hinh
    private String id; // mac dinh lay ten bien lam ten cot

    @Column(name = "Name", length = 50, nullable = false)// mac dinh cot chuoi la varchar, ko luu tieng viet co dau
    @Nationalized // bien doi tu varchar -> nvarchar
    private String name;// mac dinh chuoi la varchar

    @Column(name = "Yob")
    private int yob;

    @Column(name = "Gpa")
    private double gpa;


}
