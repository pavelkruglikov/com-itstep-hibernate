package com.itstep.hibernate.dao.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    long id;
    String name;
    int building;
    int floor;
    Double financing;

    public Department() {
    }

    public Department(long id, String name, int building, int floor, Double financing) {
        this.id = id;
        this.name = name;
        this.building = building;
        this.floor = floor;
        this.financing = financing;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Double getFinancing() {
        return financing;
    }

    public void setFinancing(Double financing) {
        this.financing = financing;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", building=" + building +
                ", floor=" + floor +
                ", financing=" + financing +
                '}';
    }
}

