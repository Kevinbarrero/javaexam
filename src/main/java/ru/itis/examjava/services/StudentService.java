package ru.itis.examjava.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.examjava.controllers.dto.StudentDto;
import ru.itis.examjava.controllers.dto.TeacherDto;
import ru.itis.examjava.models.Student;
import ru.itis.examjava.models.Teacher;

public interface StudentService {
    Student addstudent(StudentDto StudentDto)throws JsonProcessingException;
}
