package com.itstep.hibernate.view;

import com.itstep.hibernate.dao.models.Department;
import com.itstep.hibernate.service.DepartmentService;

import java.util.List;

public class MainClass {

    static DepartmentService departmentService = new DepartmentService();

    public static void main(String[] args) {
        showTables();
    }

    public static void showTables() {

        List<Department> departments = departmentService.getAllDepartments();

        departments.forEach(department -> System.out.println(department.toString()));

    }
}