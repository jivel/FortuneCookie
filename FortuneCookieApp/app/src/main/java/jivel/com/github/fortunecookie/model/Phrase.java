package jivel.com.github.fortunecookie.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class Phrase implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;

    public Phrase() {
    }

    public Phrase(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Phrase{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
