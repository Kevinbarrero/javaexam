package ru.itis.examjava.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.examjava.models.Teacher;

import java.util.Collection;

public class TeacherDetailImple implements UserDetails {

    public Teacher teacher;

    public TeacherDetailImple(Teacher teacher) {
        this.teacher = teacher;

        System.out.println(teacher != null ? (teacher.getName()  +  ":" + new BCryptPasswordEncoder().matches("admin", teacher.getPassword())): "user not found");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return teacher.getPassword();
    }

    @Override
    public String getUsername() {
        return teacher.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
