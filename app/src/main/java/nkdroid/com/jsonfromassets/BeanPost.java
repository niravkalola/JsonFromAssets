package nkdroid.com.jsonfromassets;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nirav kalola on 11/8/2014.
 */
public class BeanPost {

    @SerializedName("post_name")
    private String post_name;
    @SerializedName("auther")
    private String auther;
    @SerializedName("date")
    private String date;
    @SerializedName("description")
    private String description;

    public BeanPost(String post_name, String auther, String date, String description) {
        this.post_name = post_name;
        this.auther = auther;
        this.date = date;
        this.description = description;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
