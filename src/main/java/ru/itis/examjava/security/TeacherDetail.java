package ru.itis.examjava.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.itis.examjava.models.Teacher;
import ru.itis.examjava.repositories.TeacherRepository;
import ru.itis.examjava.services.TeacherDetailService;

@Service(value = "myTeacherDetailService")
public class TeacherDetail implements UserDetailsService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    TeacherDetailService teacherDetailService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Teacher teacher = teacherRepository.findByName(username);

        if (teacher != null) {
            teacherDetailService.setTeacher(teacher);
            //List<UserRole> roles = roleRepository.findByUser(user.getId());
            //user.setRoles(roles);
            return new TeacherDetailImple(teacher);
        } throw new UsernameNotFoundException("User not found!");
    }
}
