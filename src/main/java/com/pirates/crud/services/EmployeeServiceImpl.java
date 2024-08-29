package com.pirates.crud.services;

import com.pirates.crud.entity.EmployeeEntity;
import com.pirates.crud.models.Employee;
import com.pirates.crud.repositories.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        return "Saved Successfully";
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeList = employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeList){
            Employee emp = new Employee();
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setPhoneno(employeeEntity.getPhoneno());
            emp.setEmail(employeeEntity.getEmail());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(int id) {
        EmployeeEntity emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(int id, Employee employee) {
        EmployeeEntity existingEmployee = employeeRepository.findById(id).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhoneno(employee.getPhoneno());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return "Updated Successfully";
    }

    @Override
    public Employee getEmployee(int id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity,employee);
        return employee;
    }
}
