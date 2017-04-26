package mybklife.main.mybklife.data.database;

/**
 * Created by 14102 on 25/04/2017.
 */

public class Subject {
    public static final String TABLE="subject";

    public static final String KEY_NUM="num";//so thu tu
    public static final String KEY_ID="id";
    public static final String KEY_NAME="name";
    public static final String KEY_CREDIT="credit";
    public static final String KEY_COLOR="color";
    public static final String KEY_ACTIVE="active";

    public int num;
    public String idSubject;
    public String nameSubject;
    public int credit;
    public String color;
    public boolean activeSubject;
}
