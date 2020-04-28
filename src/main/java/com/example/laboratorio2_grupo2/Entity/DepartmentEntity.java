package com.example.laboratorio2_grupo2.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class DepartmentEntity {

    @Id
    @Column(name = "department_id")
    private int departmentid;
    @Column(nullable = false, name = "department_name")
    private String departmentname;
    @Column(name = "manager_id")
    private String managerid;
    @Column(name="department_short_name", nullable = false)
    private String departmentshortname;
    @Column(name = "location_id")
    private String locationid;

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid;
    }

    public String getDepartmentshortname() {
        return departmentshortname;
    }

    public void setDepartmentshortname(String departmentshortname) {
        this.departmentshortname = departmentshortname;
    }

    public int getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(int department_id) {
        this.departmentid = department_id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String department_name) {
        this.departmentname = department_name;
    }

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String manager_id) {
        this.managerid = manager_id;
    }

}
