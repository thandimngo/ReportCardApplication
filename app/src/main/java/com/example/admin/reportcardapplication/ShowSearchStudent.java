package com.example.admin.reportcardapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowSearchStudent extends AppCompatActivity implements android.widget.SearchView.OnQueryTextListener, AdapterView.OnItemClickListener {
    List<Student> stdList = new ArrayList<>();

    ArrayList<String> nameList = new ArrayList<>();


    ArrayAdapter<String> adapter;
    private ListView lstStud;
    private android.widget.SearchView inputSearchView;

    MyDBHandler myDB = new MyDBHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_search_student);




        lstStud = (ListView) findViewById(R.id.lstViewStudent);

        inputSearchView = (android.widget.SearchView) findViewById(R.id.search_view);
        myDB = new MyDBHandler(getApplicationContext());
        stdList = myDB.getAllLearner();
        lstStud.setTextFilterEnabled(true);
        setupSearchView();

        for (int i = 0; i < stdList.size(); i++) {
            Student temp = stdList.get(i);
            nameList.add(temp.getStudentName());
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nameList);

        lstStud.setAdapter(adapter);
        lstStud.setOnItemClickListener(this);

    }



    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student objStudent = new Student();

        String studName = adapter.getItem(position);
        System.out.println(studName);
        objStudent = myDB.getStudent(studName);

        Intent intent = new Intent(ShowSearchStudent.this, UpdateStudent.class);
        intent.putExtra("student", objStudent);
        startActivity(intent);

    }

    private void setupSearchView() {
        inputSearchView.setIconifiedByDefault(false);
        inputSearchView.setOnQueryTextListener(this);
        inputSearchView.setSubmitButtonEnabled(true);
        inputSearchView.setQueryHint("Search Here");
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            lstStud.clearTextFilter();
        } else {
            lstStud.setFilterText(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }




}





