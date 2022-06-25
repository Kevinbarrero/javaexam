package ru.itis.examjava.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.examjava.controllers.dto.TeacherDto;
import ru.itis.examjava.models.Teacher;

public interface TeacherService {
    Teacher registerNewTeacher(TeacherDto registerUserDto)throws JsonProcessingException;
}
