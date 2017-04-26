package mybklife.main.mybklife.data.database;

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
        values.put(Subject.KEY_ID,);
    }
}
