package ru.itis.examjava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.examjava.models.Teacher;

import java.util.List;

public interface TeacherRepository extends CrudRepository<Teacher, Long> {

    List<Teacher> findAll();

    Teacher findByName(String username);

}
