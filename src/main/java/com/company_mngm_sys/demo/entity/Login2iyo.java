package com.company_mngm_sys.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// ログインユーザーのエンティティを定義
// 実態はemployee
@Entity
@Table(name="employees")
public class Login2iyo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private int employeeId;
    
    @Column(name = "fullName")
    private String fullName;

    @Column(name ="birthday")
    private int birthday;
    
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public Login2iyo(){}

    public Login2iyo(int employeeId, String name, int birthday) {
        this.employeeId = employeeId;
        this.fullName = name;
        this.birthday = birthday;
    }

    public String getfullName() {
        return fullName;
    }

    public void setfullName(String name) {
        this.fullName = name;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }


    
}
