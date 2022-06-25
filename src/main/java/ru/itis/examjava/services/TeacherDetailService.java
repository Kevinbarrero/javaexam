package ru.itis.examjava.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.examjava.controllers.dto.TeacherDto;
import ru.itis.examjava.models.Teacher;
import ru.itis.examjava.repositories.TeacherRepository;

@Service
public class TeacherDetailService implements TeacherService{
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher teacher = new Teacher();

    @Override
    public Teacher registerNewTeacher(TeacherDto registerUserDto) throws JsonProcessingException {
        teacher.setName(registerUserDto.getName());
        teacher.setEmail(registerUserDto.getEmail());
        teacher.setPassword(registerUserDto.getPassword());
        teacherRepository.save(teacher);

        return teacher;
    }


    public Teacher getTeacher(){
        return teacher;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
}
