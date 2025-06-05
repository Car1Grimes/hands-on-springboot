package com.thaivu.fap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thaivu.fap.entity.Employee;
import com.thaivu.fap.entity.Student;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {

        Student s1 = new Student("SE1", "An Nguyen", 2004, 8.6);
        System.out.println(s1);

        Employee e1 = new Employee("E1", "Binh", 2000, 199999999);

        // From object -> json -> frontend
        ObjectMapper mapper = new ObjectMapper();
        String empJson = mapper.writeValueAsString(s1);
        System.out.println("From emp obj to json: " + empJson);

        // From json -> object -> backend
        String s2Json = """
                {"id":"SE2","name":"Cuong Nam","yob":2004,"gpa":7}""";
        // Raw string
        Student s2 = mapper.readValue(s2Json, Student.class);
        System.out.println(s2.toString());
    }
}