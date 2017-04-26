package mybklife.main.mybklife.data.database;

/**
 * Created by 14102 on 25/04/2017.
 */

public class Assignment {
    public static final String TABLE="Assignment";

    public static final String KEY_NUM="num";
    public static final String KEY_NAME="name";
    public static final String KEY_PROCESS="process";
    public static final String KEY_DEADLINE="deadline";
    public static final String KEY_ACTIVE="active";
    public static final String KEY_NOTE="note";
    public static final String KEY_ASSIGNMENT_SUBJECT_FK="assignment_subject_fk";

    public int num;
    public String name;
    public String process;
    public String deadline;
    public boolean activeAssignment;
    public String note;
    public String assignmentSubjectFK;
}
