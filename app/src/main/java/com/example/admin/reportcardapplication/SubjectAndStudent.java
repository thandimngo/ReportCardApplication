package com.example.admin.reportcardapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SubjectAndStudent extends AppCompatActivity {

    private TextView txtStdNo;

    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText cellNoEditText;
    private EditText addressEditText;
    private EditText subjectNameEditText;
    private EditText test1EditText;
    private EditText test2EditText;

    Student students;


    Intent intents;

    MyDBHandler myDb = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_and_student);

        nameEditText = (EditText) findViewById(R.id.sName);
        surnameEditText = (EditText) findViewById(R.id.sSurname);
        cellNoEditText = (EditText) findViewById(R.id.sCellNo_);
        addressEditText = (EditText) findViewById(R.id.sAddress);
        subjectNameEditText = (EditText) findViewById(R.id.Subject);
        test1EditText = (EditText) findViewById(R.id.Test1Subject);
        test2EditText = (EditText) findViewById(R.id.Test2Subject);


        txtStdNo = (TextView) findViewById(R.id.studentNo);



        intents = getIntent();
        intents.getExtras();

        students = (Student) intents.getSerializableExtra("student");


        System.out.println(students.getStudentName()+" "+students.getStudentSurname()+" "+students.getStudent_Id()+" "+students.getAddress()+" "+students.getCellNo());

        txtStdNo.setText(String.valueOf(students.getStudent_Id()));
        nameEditText.setText(students.getStudentName());
        surnameEditText.setText(students.getStudentSurname());
        cellNoEditText.setText(String.valueOf(students.getCellNo()));
        addressEditText.setText(students.getAddress());

    }
    public void addButtonStudent(View v) {

                                         Subject subject = new Subject(nameEditText.getText().toString(), surnameEditText.getText().toString(), cellNoEditText.getText().toString(), addressEditText.getText().toString(),subjectNameEditText.getText().toString(),Integer.parseInt(test1EditText.getText().toString()),Integer.parseInt(test2EditText.getText().toString()));
                                          boolean isAdd = myDb.addSubject(subject);
                                          if (isAdd == true)
                                              Toast.makeText(SubjectAndStudent.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                                          else
                                              Toast.makeText(SubjectAndStudent.this, "Data not  inserted", Toast.LENGTH_SHORT).show();

                                      }


}
