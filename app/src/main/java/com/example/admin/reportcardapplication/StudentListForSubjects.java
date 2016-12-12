package com.example.admin.reportcardapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class StudentListForSubjects extends AppCompatActivity implements  AdapterView.OnItemClickListener{


    List<Student> studList = new ArrayList<>();
    ArrayList<String> stNameList = new ArrayList<>();
    ArrayAdapter<String> adapter;
    private ListView lstViewStud;
    private android.widget.SearchView inputSearchView;

    MyDBHandler myDB = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list_for_subjects);

        lstViewStud = (ListView) findViewById(R.id.lstViewStudentSelection);

        myDB = new MyDBHandler(getApplicationContext());
        studList = myDB.getAllLearner();
        lstViewStud.setTextFilterEnabled(true);


        for (int i = 0; i < studList.size(); i++) {
            Student temp = studList.get(i);
            stNameList.add(temp.getStudentName());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stNameList);

        lstViewStud.setAdapter(adapter);
        lstViewStud.setOnItemClickListener(this);



    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student objStudent = new Student();

        String studName = adapter.getItem(position);
        System.out.println(studName);
        objStudent = myDB.getStudent(studName);

        Intent intent = new Intent(StudentListForSubjects.this,SubjectAndStudent.class);
        intent.putExtra("student", objStudent);
        startActivity(intent);

    }
}
