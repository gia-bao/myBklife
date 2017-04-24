package mybklife.main.mybklife.model;

/**
 * Created by 14102 on 24/04/2017.
 */
import java.io.Serializable;
import com.google.gson.annotations.SerializedName;

public class SubjectModel implements Serializable{

    @SerializedName("name") public String name;
    @SerializedName("color") public String color;
    @SerializedName("credit") public String credit;
    @SerializedName("active") public boolean active;
}
