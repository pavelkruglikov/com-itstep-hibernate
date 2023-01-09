package com.itstep.hibernate.service;

import com.itstep.hibernate.dao.models.Doctor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DoctorService {

    public List<Doctor> getAllDoctors() {
        Transaction transaction = null;
        List<Doctor> resultSet = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Doctor> cq = cb.createQuery(Doctor.class);
            Root<Doctor> rootEntry = cq.from(Doctor.class);
            CriteriaQuery<Doctor> all = cq.select(rootEntry);
            TypedQuery<Doctor> allQuery = session.createQuery(all);
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