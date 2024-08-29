package com.pirates.crud.controller;

import com.pirates.crud.models.Employee;
import com.pirates.crud.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @PutMapping("employees/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        if(employeeService.deleteEmployee(id)){
            return "Deleted Successfully";
        }
        return "Not Found";
    }
}
