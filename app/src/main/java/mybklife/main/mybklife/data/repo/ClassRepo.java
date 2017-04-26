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
import mybklife.main.mybklife.data.database.Subject;
import mybklife.main.mybklife.data.database.DBHelper;
public class SubjectRepo {
    private DBHelper dbHelper;

    public SubjectRepo(Context context){
        dbHelper =new DBHelper(context);
    }

    public int insert(Subject subject){
        //open connection to write data
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(Subject.KEY_ID,subject.idSubject);
        values.put(Subject.KEY_NAME,subject.nameSubject);
        values.put(Subject.KEY_CREDIT,subject.credit);
        values.put(Subject.KEY_COLOR,subject.color);
        values.put(Subject.KEY_ACTIVE,"true");
        //insert row
        long num=db.insert(Subject.TABLE,null,values);
        db.close();
        return (int)num;
    }

    public void delete(Subject subject){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        ContentValues values =new ContentValues();

        values.put(Subject.KEY_ACTIVE,"false");
        db.update(Subject.TABLE,values,Subject.KEY_NUM+"=?",new String[]{
                String.valueOf(subject.num)
        });
        db.close();
    }

    public ArrayList<HashMap<String,String>> getSubjectList(){
        //open connection to read only
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        String sellectQuerry="SELECT "
                +Subject.KEY_NUM+","
                +Subject.KEY_ID+","
                +Subject.KEY_COLOR+","
                +Subject.KEY_NAME+","
                +Subject.KEY_CREDIT+","+
                " FROM "
                +Subject.TABLE+
                " WHERE ("
                +Subject.KEY_ACTIVE+" = TRUE);";

        ArrayList<HashMap<String,String>>subjectList=new ArrayList<HashMap<String, String>>();

        Cursor cursor =db.rawQuery(sellectQuerry,null);

        if(cursor.moveToFirst()){
            do{
                HashMap<String,String>subject= new HashMap<String, String>();
                subject.put("num",cursor.getString(cursor.getColumnIndex(Subject.KEY_NUM)));
                subject.put("name",cursor.getString(cursor.getColumnIndex(Subject.KEY_NAME)));
                subjectList.add(subject);
            }while(cursor.moveToNext());
        }
        cursor.close();;
        db.close();
        return subjectList;
    }
    public Subject getSubjectByNum(int num){
        SQLiteDatabase db=dbHelper.getReadableDatabase();

        String selectQuerry="SELECT "
                +Subject.KEY_NUM+","
                +Subject.KEY_ID+","
                +Subject.KEY_NAME+","
                +Subject.KEY_CREDIT+","
                +Subject.KEY_COLOR+","+
                " FROM "
                +Subject.TABLE+
                " WHERE("
                +Subject.KEY_NUM+"=? AND "
                +Subject.KEY_ACTIVE+"=TRUE);";
        int iCount=0;
        Subject subject=new Subject();
        Cursor cursor=db.rawQuery(selectQuerry,new String[]{
                String.valueOf(num)
        });
        if (cursor.moveToFirst()) {
            do {
                subject.num =cursor.getInt(cursor.getColumnIndex(Subject.KEY_NUM));
                subject.nameSubject =cursor.getString(cursor.getColumnIndex(Subject.KEY_NAME));
                subject.idSubject  =cursor.getString(cursor.getColumnIndex(Subject.KEY_ID));
                subject.color  =cursor.getString(cursor.getColumnIndex(Subject.KEY_COLOR));
                subject.credit =cursor.getInt(cursor.getColumnIndex(Subject.KEY_CREDIT));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return subject;
    }
}
