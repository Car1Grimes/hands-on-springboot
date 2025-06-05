package com.thaivu.superapp.entity.unimany;

import com.thaivu.superapp.entity.unione.Student;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)")
    //KO DUNG @NATIONALIZED, VI PHU THUOC CUNG VAO HIBERNATE
    //PHONG KHI MINH MUON DUNG ECLIPSELINK DO PHAI SUA CODE
    private String name;

    //table Major chi chua dung thong tin Major nhu trong table

    public Major() {}

    public Major(String id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Major{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
