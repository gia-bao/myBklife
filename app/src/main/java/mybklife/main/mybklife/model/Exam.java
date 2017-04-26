package mybklife.main.mybklife.data.database;

import java.sql.Time;

/**
 * Created by 14102 on 25/04/2017.
 */

public class Exam {
    public static final String TABLE="Exam";

    public static final String KEY_NUM="num";
    public static final String KEY_MODULE="module";
    public static final String KEY_TIMEIN="timeIn";
    public static final String KEY_DURATION="duration";
    public static final String KEY_ROOM="room";
    public static final String KEY_BUILDING="building";
    public static final String KEY_SEAT="seat";
    public static final String KEY_ACTIVE="active";
    public static final String KEY_EXAM_SUBJECT_FK="exam_subject_fk";

    public int num;
    public String module;
    public String timeIn;
    public int duration;
    public String room;
    public String building;
    public String seat;
    public boolean activeExam;
    public String examSubjectFK;
}
