package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.employeeService.IDivisionService;
import com.example.service.employeeService.IEducationDegreeService;
import com.example.service.employeeService.IEmployeeService;
import com.example.service.employeeService.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IDivisionService divisionService;
    @Autowired
    private IEducationDegreeService educationDegreeService;
    @Autowired
    private IPositionService positionService;

    @GetMapping("/employee")
    public String showEmployee(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }

    @GetMapping("/employee/create")
    public String showEmployeeCreate(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisionList", divisionService.findAll());
        model.addAttribute("educationDegreeList", educationDegreeService.findAll());
        model.addAttribute("positionList", positionService.findAll());
        return "employee/create";
    }

    @PostMapping("/employee/create")
    public String createEmployee(RedirectAttributes redirectAttributes, @ModelAttribute Employee employee) {
        employeeService.save(employee);
        redirectAttributes.addAttribute("mess", "Create Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id, RedirectAttributes redirectAttributes) {
        employeeService.remove(id);
        redirectAttributes.addAttribute("mess", "delete Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/{id}")
    public String ShowEditCustomer(@PathVariable int id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        List<Division> divisionList = divisionService.findAll();
        model.addAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);
        List<Position> positionList = positionService.findAll();
        model.addAttribute("positionList", positionList);
        return "employee/edit";
    }

    @PostMapping("/employee/edit")
    public String editCustomer(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.edit(employee);
        redirectAttributes.addFlashAttribute("mess", "Edit Successfully!");
        return "redirect:/employee";
    }


}
