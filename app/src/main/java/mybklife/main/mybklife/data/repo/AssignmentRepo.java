package mybklife.main.mybklife.data.repo;

/**
 * Created by 14102 on 25/04/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import mybklife.main.mybklife.data.database.DBHelper;
import mybklife.main.mybklife.data.database.Classes;

public class ClassRepo {
    private DBHelper dbHelper;

    public ClassRepo(Context context){
        dbHelper =new DBHelper(context);
    }

    public int insert(Classes classes){
        //open connection to write data
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(Classes.KEY_MODULE,classes.module);
        values.put(Classes.KEY_ROOM,classes.room);
        values.put(Classes.KEY_BUILDING,classes.building);
        values.put(Classes.KEY_TEACHER,classes.teacher);
        values.put(Classes.KEY_TIMEIN,classes.timeIn);
        values.put(Classes.KEY_TIMEOUT,classes.timeOut);
        values.put(Classes.KEY_DAYOFWEEK,classes.dayOfWeek);
        values.put(Classes.KEY_CLASS_SUBJECT_FK,classes.classSubjectFK);
        values.put(Classes.KEY_ACTIVE,"true");
        //insert row
        long num=db.insert(Classes.TABLE,null,values);
        db.close();
        return (int)num;
    }

    public void delete(Classes classes){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(Classes.KEY_ACTIVE,"false");
        db.update(Classes.TABLE,values,Classes.KEY_NUM+"=?",new String[]{
                String.valueOf(classes.num)
        });
        db.close();
    }

    public ArrayList<HashMap<String,String>> getClassList(){
        //open connection to read only
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String sellectQuerry="SELECT "
                +Classes.KEY_NUM+","
                +Classes.KEY_MODULE+","
                +Classes.KEY_ROOM+","
                +Classes.KEY_BUILDING+","
                +Classes.KEY_TEACHER+","
                +Classes.KEY_DAYOFWEEK+","
                +Classes.KEY_TIMEIN+","
                +Classes.KEY_TIMEOUT+","
                +Classes.KEY_CLASS_SUBJECT_FK+","+
                " FROM "
                +Classes.TABLE+
                " WHERE ("
                +Classes.KEY_ACTIVE+" = TRUE);";

        ArrayList<HashMap<String,String>>classList=new ArrayList<HashMap<String, String>>();

        Cursor cursor =db.rawQuery(sellectQuerry,null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String,String>classes= new HashMap<String, String>();
                classes.put("num",cursor.getString(cursor.getColumnIndex(Classes.KEY_NUM)));
                classes.put("name",cursor.getString(cursor.getColumnIndex(Classes.KEY_MODULE)));
                classList.add(classes);
            }while(cursor.moveToNext());
        }
        cursor.close();;
        db.close();
        return classList;
    }
    public Classes getClassByNum(int num){
        SQLiteDatabase db=dbHelper.getReadableDatabase();

        String selectQuerry="SELECT "
                +Classes.KEY_NUM+","
                +Classes.KEY_MODULE+","
                +Classes.KEY_ROOM+","
                +Classes.KEY_BUILDING+","
                +Classes.KEY_TEACHER+","
                +Classes.KEY_TIMEIN+","
                +Classes.KEY_TIMEOUT+","
                +Classes.KEY_DAYOFWEEK+","
                +Classes.KEY_CLASS_SUBJECT_FK+","+
                " FROM "
                +Classes.TABLE+
                " WHERE("
                +Classes.KEY_NUM+"=? AND "
                +Classes.KEY_ACTIVE+"=TRUE);";
        int iCount=0;
        Classes classes=new Classes();
        Cursor cursor=db.rawQuery(selectQuerry,new String[]{
                String.valueOf(num)
        });
        if (cursor.moveToFirst()) {
            do {
                classes.num =cursor.getInt(cursor.getColumnIndex(Classes.KEY_NUM));
                classes.module =cursor.getString(cursor.getColumnIndex(Classes.KEY_MODULE));
                classes.room  =cursor.getString(cursor.getColumnIndex(Classes.KEY_ROOM));
                classes.building  =cursor.getString(cursor.getColumnIndex(Classes.KEY_BUILDING));
                classes.teacher =cursor.getString(cursor.getColumnIndex(Classes.KEY_TEACHER));
                classes.timeIn =cursor.getString(cursor.getColumnIndex(Classes.KEY_TIMEIN));
                classes.timeOut =cursor.getString(cursor.getColumnIndex(Classes.KEY_TIMEOUT));
                classes.dayOfWeek =cursor.getString(cursor.getColumnIndex(Classes.KEY_DAYOFWEEK));
                classes.classSubjectFK =cursor.getString(cursor.getColumnIndex(Classes.KEY_CLASS_SUBJECT_FK));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return classes;
    }
}
