package com.thaivu.superapp.entity.bionemany;

import com.thaivu.superapp.entity.bionemany.Student;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Major")
public class Major {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(2)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)")
    //KO DUNG @NATIONALIZED, VI PHU THUOC CUNG VAO HIBERNATE
    //PHONG KHI MINH MUON DUNG ECLIPSELINK DO PHAI SUA CODE
    private String name;

    //table Major chi chua dung thong tin Major nhu trong table thuc te

    // bi directional relationship
    // dung ben nay, ngo ben kia, dung ben major, ngo ben students
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    //UY? QUYEN CHO BEN STUDENT LAM KHOA NGOAI
    private List<Student> students = new ArrayList<>();

    // dua mot sv vao danh sach chuyen nganh, sv dang ki chuyen nganh
    public void addStudent(Student student) {
        students.add(student);
        //student PHAI KHAI BAO THEM EM THUOC VE CHUYEN NGANH NAY DESU
        student.setMajor(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        //1 SV RA KHOI LIST CHUYEN NGANH
        //NHUNG BAN THAN INFO CHUYEN NGANH CUA ONG student CUNG PHAI BO? REFERENCE TOI CHUYEN NGANH
        student.setMajor(null);
    }


    //tra ve danh sach sinh vien cua 1 chuyen nganh - ham get() giong get_yob()
    //hau truong chinh la cau join select s.*, m.name FROM STUDENT s,
    //MAJOR m WHERE ... AND m.id = 'SE'

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

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
