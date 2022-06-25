package ru.itis.examjava.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.examjava.controllers.dto.TeacherDto;
import ru.itis.examjava.models.Student;
import ru.itis.examjava.models.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher registerNewTeacher(TeacherDto registerUserDto)throws JsonProcessingException;
}
