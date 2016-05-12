package jivel.com.github.fortunecookie.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class FortuneCookie implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("description")
    private String description;
    @SerializedName("phrase")
    private List<Phrase> phrases;
    @SerializedName("type")
    private Type type;

    public FortuneCookie() {
    }

    public FortuneCookie(String id, String description, List<Phrase> phrases, Type type) {
        this.id = id;
        this.description = description;
        this.phrases = phrases;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases) {
        this.phrases = phrases;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FortuneCookie{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", phrases=" + phrases +
                ", type=" + type +
                '}';
    }
}
