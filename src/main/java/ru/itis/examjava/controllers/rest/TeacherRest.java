package ru.itis.examjava.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.examjava.models.Student;
import ru.itis.examjava.repositories.StudentRepository;
import ru.itis.examjava.services.TeacherService;

import java.util.List;

@RestController
public class TeacherRest {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value="/getstudents")
    public List<Student> getStudents(){

        return studentRepository.findAll();
    }
}
