package com.itstep.hibernate.service;

import com.itstep.hibernate.dao.models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentService {

    public List<Department> getAllDepartments () {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            return session.createQuery("from department", Department.class).list();
        }
    }
}