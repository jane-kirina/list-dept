package com.example.dao.interf;

import com.example.entity.Employee;

import java.util.List;

/**
 * Interface for EmployeeDAO
 */
public interface IEmployeeDAO extends IDAO<Employee> {
    /**
     * Finds list with employee
     * @param name of department
     * @return list with employee from department
     */
    List<Employee> findEmployees(String name);
}