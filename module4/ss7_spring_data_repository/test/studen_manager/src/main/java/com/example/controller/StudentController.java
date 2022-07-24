package com.example.controller;

import com.example.model.ClassRoom;
import com.example.model.Student;
import com.example.service.IClassRoomService;
import com.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    IStudentService studentService;
    @Autowired
    IClassRoomService classRoomService;

    @GetMapping("/")
    public String showStudent(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Student> studentList = studentService.findAllStudent(pageable);
        model.addAttribute("studentList", studentList);
//        model.addAttribute("classRoomList", classRoomService.findAllClassRoom());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String showCreateStudent(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("classRoomList", classRoomService.findAllClassRoom());
        return "createStudent";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudent(@PathVariable int id, Model model) {
        Optional<Student> student = studentService.findById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/";
    }


}
