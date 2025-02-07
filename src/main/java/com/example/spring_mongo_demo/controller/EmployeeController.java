package com.example.spring_mongo_demo.controller;


import com.example.spring_mongo_demo.entity.Employee;
import com.example.spring_mongo_demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/index")
    public String showForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "index";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/displayAll";
    }
    @GetMapping("/displayAll")
    public String getAllEmployees(Model model)
    {
        List<Employee> employees=employeeService.getAllEmployees();
        model.addAttribute("employees",employees);
        return "employee-list";
    }
    @GetMapping("/display/{id}")
    public String getEmployee(@PathVariable String id,Model model)
    {
        Optional<Employee> employee=employeeService.getEmployeeById(id);
        if(employee.isPresent()){
            model.addAttribute("employee",employee.get());
            return "employee-detail";

        }
else {
    return "redirect:/displayAll";
        }
    }
    }

