package com.example.admin.reportcardapplication;

import java.io.Serializable;

/**
 * Created by Thandi
 */
public class Student implements Serializable {

    private int student_Id;
    private String studentName;
    private String studentSurname;
    private String cellNo;
    private String address;

    public Student() {
        this(0,"","","","");
    }

    public Student(String student) {
    }

    public Student(int student_Id, String studentName, String studentSurname, String cellNo, String address) {
        this.student_Id = student_Id;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.cellNo = cellNo;
        this.address = address;
    }
    public Student( String studentName, String studentSurname, String cellNo, String address) {

        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.cellNo = cellNo;
        this.address = address;
    }

    public void setStudent_Id(int student_Id) {
        this.student_Id = student_Id;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setCellNo(String cellNo) {
        this.cellNo = cellNo;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStudent_Id() {
        return student_Id;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getCellNo() {
        return cellNo;
    }

    public String getAddress() {
        return address;
    }
}
