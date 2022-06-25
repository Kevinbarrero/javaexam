package ru.itis.examjava.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.examjava.models.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
}
