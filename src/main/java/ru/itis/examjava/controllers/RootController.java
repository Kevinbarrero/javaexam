package ru.itis.examjava.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.examjava.models.Teacher;
import ru.itis.examjava.services.TeacherDetailService;

@Controller
public class RootController {
    @Autowired
    TeacherDetailService teacherDetailService;

    @GetMapping("/")
    public String getIndex(Model model) {
        Teacher teacher = teacherDetailService.getTeacher();
        model.addAttribute("teacher",teacher);

        return "root";
    }
}
