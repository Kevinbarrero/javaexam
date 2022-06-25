package ru.itis.examjava.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.examjava.controllers.dto.TeacherDto;
import ru.itis.examjava.services.TeacherDetailService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class TeacherController {
    @Autowired
    TeacherDetailService teacherDetailService;


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        TeacherDto teacherDto = new TeacherDto();
        model.addAttribute("teacher", teacherDto);
        return "register";
    }
    @PostMapping("/register")
    public ModelAndView registerUserAccount(
            @ModelAttribute("teacher") @Valid TeacherDto teacherDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(teacherDto.getPassword());
        teacherDto.setPassword(encodedPassword);
        try {
            teacherDetailService.registerNewTeacher(teacherDto);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(("message An account for that username/email already exists."));
            return null;
        }

        return new ModelAndView("loginform", "teacher", teacherDto);
    }

    @GetMapping("/login")
    public String loginPage() {

        return "loginform";

    }
    @PostMapping("/")
    public String loginForm(HttpServletRequest request, TeacherDto teacherDto) {
        System.out.println(teacherDto.getName() + "--------------");
        try {
            request.login(teacherDto.getName(), teacherDto.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return "/";
    }
    @GetMapping("/students")
    public String usersPage(){
        return "students";
    }
}
