package ru.itis.examjava.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.examjava.controllers.dto.StudentDto;
import ru.itis.examjava.models.Student;
import ru.itis.examjava.models.Teacher;
import ru.itis.examjava.repositories.StudentRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentDetailService implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherDetailService TeacherDetailService;

    public Student student =new Student();
    @Override
    public Student addstudent(StudentDto studentDto) throws JsonProcessingException {
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
//        Set<Teacher> teachers = new HashSet<Teacher>();
//        teachers.add(TeacherDetailService.getTeacher());
//        student.setListTeacher(teachers);
        studentRepository.save(student);
        return student;
    }

    public Student getStudent(){
        return student;
    }
    public void setStudent(Student student){
        this.student = student;
    }
}
