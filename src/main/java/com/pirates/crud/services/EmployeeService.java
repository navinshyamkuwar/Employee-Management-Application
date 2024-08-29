package com.pirates.crud.services;

import com.pirates.crud.models.Employee;

import java.util.List;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> getAllEmployees();
    boolean deleteEmployee(int id);
    String updateEmployee(int id, Employee employee);
    Employee getEmployee(int id);
}
