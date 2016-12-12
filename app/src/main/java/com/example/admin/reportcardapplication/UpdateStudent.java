package com.example.admin.reportcardapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActionMenuView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class UpdateStudent extends AppCompatActivity {


    private TextView txtStdNo;
    private Button btnUpdate;
    private Button btnDelete;
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText cellNoEditText;
    private EditText addressEditText;


    Student student;

    Intent intent;

    MyDBHandler myDb = new MyDBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        nameEditText = (EditText) findViewById(R.id.updateName);
        surnameEditText = (EditText) findViewById(R.id.updateSurname);
        cellNoEditText = (EditText) findViewById(R.id.updateCellNo_);
        addressEditText = (EditText) findViewById(R.id.updateAddress);
        txtStdNo = (TextView) findViewById(R.id.studentNo);
        btnUpdate = (Button) findViewById(R.id.UpdateBtn);
        btnDelete = (Button) findViewById(R.id.DeleteBtn);

        intent = getIntent();
        intent.getExtras();

        student = (Student) intent.getSerializableExtra("student");

        System.out.println(student.getStudentName()+" "+student.getStudentSurname()+" "+student.getStudent_Id()+" "+student.getAddress()+" "+student.getCellNo());

        txtStdNo.setText(String.valueOf(student.getStudent_Id()));
        nameEditText.setText(student.getStudentName());
        surnameEditText.setText(student.getStudentSurname());
        cellNoEditText.setText(String.valueOf(student.getCellNo()));
        addressEditText.setText(student.getAddress());


        UpdateBtn();
        DeleteBtn();

    }

    public void UpdateBtn() {
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                student = new Student(Integer.parseInt(txtStdNo.getText().toString()), nameEditText.getText().toString(), surnameEditText.getText().toString(), cellNoEditText.getText().toString(), addressEditText.getText().toString());
                boolean isUpdated = myDb.updateStudent(student);
                if (isUpdated == true)
                    Toast.makeText(UpdateStudent.this, "Successfully updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(UpdateStudent.this, "Data not updated", Toast.LENGTH_SHORT).show();

                nameEditText.setText("");
                surnameEditText.setText("");
                cellNoEditText.setText("");
                addressEditText.setText(student.getAddress());

            }
        });

    }
    public void DeleteBtn() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                student = new Student(Integer.parseInt(txtStdNo.getText().toString()), nameEditText.getText().toString(), surnameEditText.getText().toString(), cellNoEditText.getText().toString(), addressEditText.getText().toString());
                boolean isDeleted = myDb.deleteStudent(student);
                if (isDeleted == true)
                    Toast.makeText(UpdateStudent.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(UpdateStudent.this, "Data not deleted", Toast.LENGTH_SHORT).show();

            }
        });

    }


}




