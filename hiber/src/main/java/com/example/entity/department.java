package com.example.entity;
import javax.persistence.*;
@Entity
@Table(name="dept")
public class department {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int deptId;
 private String deptName;
 public department() {}
 public department(String deptName) {
 this.deptName = deptName;
 }
 public int getDeptId() { return deptId; }
 public String getDeptName() { return deptName; }
 public void setDeptName(String deptName) { this.deptName = deptName; }
}