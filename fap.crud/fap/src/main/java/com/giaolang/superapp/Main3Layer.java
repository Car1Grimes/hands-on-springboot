package com.giaolang.superapp;

import com.giaolang.superapp.entity.Student;
import com.giaolang.superapp.service.StudentService;

import java.util.List;

public class Main3Layer {
    //class nay thu nghiem 3-layer, thay cho GUI
    public static void main(String[] args) {

        StudentService studentService = new StudentService();
//        Student an = new Student("SE1", "An Nguyen", 2004, 8.6);
//        studentService.saveStudent(an);
//        studentService.saveStudent(new Student("SE2", "Binh Le", 2004, 8.7));

        List<Student> result = studentService.getAllStudents();
        System.out.println("The list of students (" + result.size() + ") records:");
        result.forEach(x -> System.out.println(x));

        //tim 1 sinh vien
        Student x = studentService.getStudentById("SE1");
        System.out.println("The student with id " + x.getId() + " is " + x);
        x.setGpa(10);
        studentService.updateStudent(x);

        //in tat ca
        result = studentService.getAllStudents();
        System.out.println("The list of students (" + result.size() + ") records:");
        result.forEach(y -> System.out.println(y));
    }
}
