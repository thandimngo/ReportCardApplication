package com.example.admin.reportcardapplication;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterStudent extends AppCompatActivity {
    private EditText nameEditText;
    private EditText surnameEditText;
    private EditText cellNoEditText;
    private EditText addressEditText;
    private Button btnAdd;
    private Button btnPreview;


    MyDBHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        nameEditText = (EditText) findViewById(R.id.name);
        surnameEditText = (EditText) findViewById(R.id.Surname);
        cellNoEditText = (EditText) findViewById(R.id.CellNo_);
        addressEditText = (EditText) findViewById(R.id.Address);

        btnAdd = (Button) findViewById(R.id.Submit);
        btnPreview = (Button) findViewById(R.id.Preview);


        myDB = new MyDBHandler(this);
        printDatabaseStudent();
        addButtonStudent();
    }

    public void addButtonStudent() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Student student = new Student(nameEditText.getText().toString(), surnameEditText.getText().toString(), cellNoEditText.getText().toString(), addressEditText.getText().toString());
                                          boolean isAdd = myDB.addStudent(student);
                                          if (isAdd == true)
                                              Toast.makeText(RegisterStudent.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                                          else
                                              Toast.makeText(RegisterStudent.this, "Data not  inserted", Toast.LENGTH_SHORT).show();

                                      }
                                  }
        );


    }

    public void printDatabaseStudent() {

        btnPreview.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              Cursor review = myDB.getStudent();
                                              if (review.getCount() == 0) {
                                                  showMessage("Error", "No Data found");

                                                  return;
                                              }

                                              StringBuffer buffer = new StringBuffer();
                                              while (review.moveToNext()) {
                                                  buffer.append("ID: " + review.getString(0) + "\n");
                                                  buffer.append("Name: " + review.getString(1) + "\n");
                                                  buffer.append("Surname: " + review.getString(2) + "\n");
                                                  buffer.append("CellNo.: " + review.getString(3) + "\n");
                                                  buffer.append("Address: " + review.getString(4) + "\n" + "\n");

                                                  nameEditText.setText(" ");
                                                  surnameEditText.setText(" ");
                                                  cellNoEditText.setText(" ");
                                                  addressEditText.setText(" ");
                                              }
                                              showMessage("Student", buffer.toString());

                                          }
                                      }
        );
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



}
