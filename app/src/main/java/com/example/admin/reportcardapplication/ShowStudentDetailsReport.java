package com.example.admin.reportcardapplication;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowStudentDetailsReport extends AppCompatActivity {

    private TextView reviewText;

    private Button btnReview;

    MyDBHandler myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_details_report);


        reviewText = (TextView)findViewById(R.id.textViewAllLearners);


        btnReview = (Button) findViewById(R.id.btnReviewStudent);


        myDB = new MyDBHandler(this);
        printDatabaseStudent();

    }
    public void printDatabaseStudent() {

        btnReview.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {

                                              Cursor review = myDB.getStudent();
                                              if (review.getCount() == 0) {
                                                 // Toast.makeText(ShowStudentDetailsReport.this, getResources().getString(R.string.view_me), Toast.LENGTH_LONG).show();

                                                  return;
                                              }

                                              StringBuffer buffer = new StringBuffer();
                                              while (review.moveToNext()) {
                                                  buffer.append(getResources().getString(R.string.id) + review.getString(0) + "\n");
                                                  buffer.append(getResources().getString(R.string.name) + review.getString(1) + "\n");
                                                  buffer.append(getResources().getString(R.string.surname) + review.getString(2) + "\n");
                                                  buffer.append(getResources().getString(R.string.cell) + review.getString(3) + "\n");
                                                  buffer.append(getResources().getString(R.string.address) + review.getString(4) + "\n" + "\n");


                                              }
reviewText.setText(buffer);

                                          }
                                      }

        );
    }


}
