package mybklife.main.mybklife.model;

/**
 * Created by 14102 on 24/04/2017.
 */

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ClassModel implements Serializable{

    @SerializedName("subject") public SubjectModel subject;
    @SerializedName("module") public String module;
    @SerializedName("teacher") public String teacher;
    @SerializedName("room") public String room;
    @SerializedName("building") public String building;

    @SerializedName("active") public boolean active;

}
