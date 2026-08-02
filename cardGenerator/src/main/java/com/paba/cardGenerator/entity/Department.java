package com.paba.cardGenerator.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String departmentName;

    public Department(){

    }

    public long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getDepartmentName(){
        return departmentName;
    }
    public void setDepartmentName(){
        this.departmentName = departmentName;
    }
}
