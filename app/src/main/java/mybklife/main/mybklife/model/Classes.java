package mybklife.main.mybklife.data.database;

import java.sql.Time;

/**
 * Created by 14102 on 25/04/2017.
 */

public class Classes {
    public static final String TABLE="Class";

    public static final String KEY_NUM="num";
    public static final String KEY_MODULE="module";
    public static final String KEY_ROOM="room";
    public static final String KEY_BUILDING="building";
    public static final String KEY_TEACHER="teacher";
    public static final String KEY_DAYOFWEEK="dayofweek";
    public static final String KEY_TIMEIN="timeIn";
    public static final String KEY_TIMEOUT="timeOut";
    public static final String KEY_ACTIVE="active";
    public static final String KEY_CLASS_SUBJECT_FK="class_subject_fk";

    public int num;
    public String module;
    public String room;
    public String building;
    public String teacher;
    public String dayOfWeek;
    public String timeIn;
    public String timeOut;
    public boolean activeClass;
    public String classSubjectFK;
}
