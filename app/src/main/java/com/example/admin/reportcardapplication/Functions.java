package com.example.admin.reportcardapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Functions extends AppCompatActivity {
    Button btnResgisterStudent;
    Button btnViewAll;
    Button btnUpdate;
    Button btnCreateReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functions);

        btnResgisterStudent = (Button) findViewById(R.id.btnRegisterStudent);
        btnViewAll = (Button) findViewById(R.id.btnViewAll);
        btnUpdate = (Button) findViewById(R.id.btnUpdateStudent);
        btnCreateReport = (Button) findViewById(R.id.btnCreate);
        registerStudent();
        viewAllStudents();
        updateStudent();
        createReport();

    }

    public void registerStudent() {
        btnResgisterStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Functions.this, RegisterStudent.class);
                startActivity(intent);
            }

        });

    }

    public void viewAllStudents() {
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Functions.this, ShowStudentDetailsReport.class);
                startActivity(intent);
            }

        });

    }
public void updateStudent(){
    btnUpdate.setOnClickListener(new View.OnClickListener(){
        public void onClick(View v){

            Intent intent = new Intent(Functions.this,ShowSearchStudent.class);
            startActivity(intent);
        }
    });
}

    public void createReport(){
        btnCreateReport.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Intent intent = new Intent(Functions.this,StudentListForSubjects.class);
                startActivity(intent);
            }
        });
    }
}