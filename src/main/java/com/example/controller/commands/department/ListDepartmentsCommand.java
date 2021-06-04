package com.example.controller.commands.department;

import com.example.controller.ICommand;
import com.example.entity.Department;
import com.example.server.impl.DepartmentService;
import com.example.util.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Finds all departments in the database.
 */
public class ListDepartmentsCommand implements ICommand {
    private final DepartmentService departmentService;

    public ListDepartmentsCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * {@link ICommand#execute}
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<Department> departments = departmentService.allData();
        request.setAttribute("departments", departments);
        forward(request, response, Paths.LIST_DEPT);
    }
}