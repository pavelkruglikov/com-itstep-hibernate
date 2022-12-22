package com.itstep.hibernate.service;

import com.itstep.hibernate.dao.models.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DepartmentService {

    public List<Department> getAllDepartments() {
        Transaction transaction = null;
        List<Department> resultSet = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Department> cq = cb.createQuery(Department.class);
            Root<Department> rootEntry = cq.from(Department.class);
            CriteriaQuery<Department> all = cq.select(rootEntry);
            TypedQuery<Department> allQuery = session.createQuery(all);
            resultSet = allQuery.getResultList();
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return resultSet;
    }
}