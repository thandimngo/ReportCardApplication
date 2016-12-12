package com.example.admin.reportcardapplication;

/**
 * Created by admin on 2016/10/18.
 */
public class Subject {
    private int subject_Id;
    private String studentName;
    private String studentSurname;
    private String cellNo;
    private String address;
    private String subject;
    private int test1;
    private int test2;


    public Subject(String subject) {

    }

    public Subject(int subject_Id,String studentName, String studentSurname, String cellNo, String address, String subject, int test1, int test2 ) {
        this.subject_Id = subject_Id;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.cellNo = cellNo;
        this.address = address;
        this.subject = subject;
        this.test1 = test1;
        this.test2 = test2;

    }

    public Subject(String studentName, String studentSurname, String cellNo, String address, String subject, int test1, int test2) {
        this.subject = subject;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.cellNo = cellNo;
        this.address = address;
        this.test1 = test1;
        this.test2 = test2;

    }

    public void setSubject_Id(int subject_Id) {
        this.subject_Id = subject_Id;
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

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }


    public int getSubject_Id() {
        return subject_Id;
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
    public String getSubject() {
        return subject;
    }

    public int getTest1() {
        return test1;
    }

    public int getTest2() {
        return test2;
    }


}

