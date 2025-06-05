package com.thaivu.superapp.entity.bionemany;


import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(8)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob", nullable = false)
    private int yob;

    @Column(name = "Gpa")
    private double gpa;

    @ManyToOne
    @JoinColumn(name = "MajorId")
    //sv phai thuoc ve chuyen nganh nao do, chi 1 thoi, bien don, ko phai list
    private Major major;
    //CO LENH GAN MAJOR CUA SV NAY, CHO SV VAO HOC THEO CHUYEN NGANH

    public void setMajor(Major major) {
        this.major = major; // sv join vao chuyen nganh
        //ve nguoc lai: chuyen nganh phai don nhan sv nay - this
        //list sv cua major Major phai duoc them cai ban nay
        //major.addStudent(this);
    }

    //CO NHU CAU CHO BEN NGOAI BIET MINH HOC CHUYEN NGANH GI
    public Major getMajor() {
        return major;
    }

    //THEO QUAN DIEM CUA TABLE, THI STUDENT CAN CO COT KHOA NGOAI!!!!!!!!!!!!!!!!!!!!!!!!!
    //DE TRO? SANG MAJOR
    //THEO QUAN DIEM OOP, THI LA CLASS NAY CO THAM CHIEU (REFERENCE) CLASS KIA


    public Student() {
    }

    public Student(String id, String name, int yob, double gpa) {
        this.id = id;
        this.name = name;
        this.yob = yob;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yob=" + yob +
                ", gpa=" + gpa +
                '}';
    }
}