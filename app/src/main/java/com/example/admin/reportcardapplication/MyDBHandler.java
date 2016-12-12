package com.example.admin.reportcardapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHandler extends SQLiteOpenHelper {

    public static final String Database_Name = "db_Student";
    public static final String Table_Student = "tbl_Student";
    public static final String Coloumn_StId = "c_StId";
    public static final String Table_Subject = "tbl_Subject";

    //student
    public static final String Coloumn_SId = "c_SId";
    public static final String Coloumn_Name = "c_Name";
    public static final String Coloumn_Surname = "c_Surname";
    public static final String Coloumn_CellNo = "c_CellNo";
    public static final String Coloumn_Address = "c_Address";

    //subject
    public static final String Coloumn_Subject = "c_Subject";
    public static final String Coloumn_Test1 = "c_Test1";
    public static final String Coloumn_Test2 = "c_Test2";
    public static final String Coloumn_SubName = "s_Name";
    public static final String Coloumn_SubSurname = "s_Surname";
    public static final String Coloumn_SubCellNo = "s_CellNo";
    public static final String Coloumn_SubAddress = "s_Address";
    public static final int version = 4;

    public MyDBHandler(Context context) {
        super(context, Database_Name, null, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //  onUpgrade(db,1,version);
        String queryCreateStudent = "CREATE TABLE " + Table_Student + "(" + Coloumn_StId + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Coloumn_Name + " TEXT, " + Coloumn_Surname + " TEXT, " + Coloumn_CellNo + " TEXT, " + Coloumn_Address + " TEXT" + ")";
        db.execSQL(queryCreateStudent);
        String queryCreateSubject = "CREATE TABLE " + Table_Subject + "(" + Coloumn_SId + " INTEGER PRIMARY KEY AUTOINCREMENT, " +  Coloumn_SubName + " TEXT, " + Coloumn_SubSurname + " TEXT, " + Coloumn_SubCellNo + " TEXT, " + Coloumn_SubAddress + " TEXT, " + Coloumn_Subject + " TEXT, " + Coloumn_Test1 + " INTEGER, " + Coloumn_Test2 + " INTEGER "  + ")";
        db.execSQL(queryCreateSubject);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String queryUpgradeStudent = ("DROP TABLE IF EXISTS " + Table_Student);
        String queryUpgradeSubject = ("DROP TABLE IF EXISTS " + Table_Subject);

        db.execSQL(queryUpgradeStudent);
        db.execSQL(queryUpgradeSubject);
        onCreate(db);


    }

    public boolean addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(Coloumn_Name, student.getStudentName());
        values.put(Coloumn_Surname, student.getStudentSurname());
        values.put(Coloumn_CellNo, student.getCellNo());
        values.put(Coloumn_Address, student.getAddress());


        System.out.println(values.get(Coloumn_Surname));
        long inserStudent = db.insert(Table_Student, null, values);


        if (inserStudent == -1)
            return false;
        else
            return true;
    }

    public boolean addSubject(Subject subject) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(Coloumn_SubName, subject.getStudentName());
        contentValues.put(Coloumn_SubSurname, subject.getStudentSurname());
        contentValues.put(Coloumn_SubCellNo, subject.getCellNo());
        contentValues.put(Coloumn_SubAddress, subject.getAddress());
        contentValues.put(Coloumn_Subject, subject.getSubject());
        contentValues.put(Coloumn_Test1, subject.getTest1());
        contentValues.put(Coloumn_Test2, subject.getTest2());



        long insertSubject = db.insert(Table_Subject, null, contentValues);
        db.close();

        if (insertSubject == -1)
            return false;
        else
            return true;
    }

    public Cursor getStudent() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor reviewStudent = db.rawQuery("select * from " + Table_Student, null);

        return reviewStudent;
    }

    public Cursor getSubject() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor reviewSubject = db.rawQuery("select * from " + Table_Subject, null);

        return reviewSubject;
    }

    public List<Student> getAllLearner() {

        List<Student> studList = new ArrayList<Student>();

        //Select all querry

        String selectQry = "SELECT * FROM " + Table_Student;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQry, null);

        //looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                Student student;
                student = new Student(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4));

                studList.add(student);

            } while (cursor.moveToNext());
        }

        //return Learner list
        return studList;

    }


    public boolean updateStudent(Student student) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Coloumn_Name, student.getStudentName());
        values.put(Coloumn_Surname, student.getStudentSurname());
        values.put(Coloumn_CellNo, student.getCellNo());
        values.put(Coloumn_Address, student.getAddress());


        db.update(Table_Student, values, Coloumn_StId + " =  ?", new String[]{String.valueOf(student.getStudent_Id())});


        return true;
    }

    //deleting single contact
    public boolean deleteStudent(Student student) {


        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Table_Student, Coloumn_StId + " = ?", new String[]{String.valueOf(student.getStudent_Id())});
        db.close();

        return true;
    }

    public Student getStudent(String name) {
        Cursor cursor;
        Student stud;
        SQLiteDatabase db = getReadableDatabase();

        cursor = db.query(Table_Student,new String[]{Coloumn_StId,Coloumn_Name,Coloumn_Address,Coloumn_Surname,Coloumn_CellNo},Coloumn_Name+" LIKE? ",new String[]{name},null,null,null,null);

        if (cursor != null) {
            cursor.moveToFirst();
        } else {
            return null;
        }
        stud = new Student(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(3),cursor.getString(4),cursor.getString(2));

        return stud;
    }

}
