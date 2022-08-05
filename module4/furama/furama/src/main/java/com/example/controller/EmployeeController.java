package com.example.controller;

import com.example.model.Division;
import com.example.model.EducationDegree;
import com.example.model.Employee;
import com.example.model.Position;
import com.example.service.IDivisionService;
import com.example.service.IEducationDegreeService;
import com.example.service.IEmployeeService;
import com.example.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @ModelAttribute("divisionList")
    private List<Division> divisionList(){
        return this.divisionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    private List<EducationDegree> educationDegreeList(){
        return this.educationDegreeService.findAll();
    }
    @ModelAttribute("positionList")
    private List<Position> positionList(){
        return this.positionService.findAll();
    }

    @GetMapping("/employee")
    public String showEmployee(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeCreate", new Employee());

        model.addAttribute("employeeEdit", employeeService.findById(1));
        return "employee/list";
    }

    @GetMapping()

    @PostMapping ("/employee/createModal")
    public String createEmployeeModal(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.save(employee);
        redirectAttributes.addAttribute("mess", "Create Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/create")
    public String showEmployeeCreate(Model model) {
        model.addAttribute("employee", new Employee());
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
    public String showEditCustomer(@PathVariable int id, Model model) {
        Optional<Employee> employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "employee/edit";
    }

    @PostMapping("/employee/edit")
    public String editCustomer(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
        employeeService.edit(employee);
        redirectAttributes.addFlashAttribute("mess", "Edit Successfully!");
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/modal/{id}")
    public String showEmployeeModal(@PageableDefault(value = 5) Pageable pageable, Model model,@PathVariable int id) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("employeeCreate", new Employee());
        model.addAttribute("employeeEdit", employeeService.findById(id));
        model.addAttribute("flag", 1);
        return "employee/list";
    }


}
