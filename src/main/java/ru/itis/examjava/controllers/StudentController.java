package ru.itis.examjava.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.examjava.controllers.dto.StudentDto;
import ru.itis.examjava.controllers.dto.TeacherDto;
import ru.itis.examjava.services.StudentDetailService;

import javax.validation.Valid;

@Controller
public class StudentController {
    @Autowired
    StudentDetailService studentDetailService;

    @GetMapping("/addStudent")
    public String showRegistrationForm(Model model) {
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "addstudent";
    }
    @PostMapping("/addStudent")
    public ModelAndView registerUserAccount(
            @ModelAttribute("student") @Valid StudentDto studentDto) {
        try {
            studentDetailService.addstudent(studentDto);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(("message An account for that username/email already exists."));
            return null;
        }

        return new ModelAndView("ok", "student", studentDto);
    }
    @GetMapping("/liststudents")
    public String usersPage(){
        return "users";
    }
}
