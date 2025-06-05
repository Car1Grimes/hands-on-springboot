package com.giaolang.superapp.service;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.repository.StudentRepository;

import java.util.List;

public class StudentService {
    //class nay nhan info tu GUI/WEB va day? xuong repo
    //GUI --> SERVICE --> REPO --> UTIL --> TABLE
    //Layer: kien truc 3-layer
    //code du an ngoai doi con them: repo co them interface
    //                               service co them interface

    //service can obj Repo de CRUD table
    private StudentRepository studentRepo = new StudentRepository();

    // cac ham CRUD binh thuong, dung cho GUI
    // ten ham thuong gan gui hon so voi repo
    // vd: saveStudent(), getAllStudent(), searchStudentById(), removeStudent(), updateStudent()
    public void saveStudent(Student student) {
        //co the them tien xu li: trung email, trung ma so...
        //sau do moi goi repo xuong table
        studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.getAll();
    }

    public Student getStudentById(String id) {
        return studentRepo.findById(id);
    }

    public void updateStudent(Student student) {
        studentRepo.update(student);
    }

    public void deleteStudent(String id) {
        studentRepo.remove(id);
    }


}
