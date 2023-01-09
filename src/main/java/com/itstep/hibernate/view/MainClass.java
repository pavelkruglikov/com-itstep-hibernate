package com.itstep.hibernate.view;


import com.itstep.hibernate.dao.models.Department;
import com.itstep.hibernate.dao.models.Diseases;
import com.itstep.hibernate.dao.models.Doctor;
import com.itstep.hibernate.service.DepartmentService;
import com.itstep.hibernate.service.DiseaseService;
import com.itstep.hibernate.service.DoctorService;

import java.util.List;

public class MainClass {

    DepartmentService departmentService;
    DoctorService doctorService;
    DiseaseService diseaseService;

    public MainClass() {
        this.departmentService = new DepartmentService();
        this.doctorService = new DoctorService();
        this.diseaseService = new DiseaseService();
    }

    public static void main(String[] args) {
        MainClass m = new MainClass();
        m.showTables();
        m.addDiseases();
        m.showTables();
    }

    public void addDiseases(){
        Diseases diseases = new Diseases();
        diseases.setName("Грипп");
        diseases.setSeverity(1);
        diseaseService.saveDisease(diseases);

    }

    public void showTables() {

        List<Department> departments = departmentService.getAllDepartments();

        departments.forEach(department -> System.out.println(department.toString()));

        List<Diseases> diseases = diseaseService.getAllDiseases();

        diseases.forEach(disease -> System.out.println(disease.toString()));
        List<Doctor> doctors = doctorService.getAllDoctors();

        doctors.forEach(doctor -> System.out.println(doctor.toString()));




    }
}