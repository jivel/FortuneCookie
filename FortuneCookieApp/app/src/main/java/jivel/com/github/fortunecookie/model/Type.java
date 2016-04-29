package jivel.com.github.fortunecookie.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by jimenezlav on 18/04/16.
 */
public class Type implements Serializable {

    @SerializedName("id")
    private String id;
    @SerializedName("image_name")
    private String imageName;
    @SerializedName("name")
    private String name;

    public Type() {
    }

    public Type(String id, String imageName, String name) {
        this.id = id;
        this.imageName = imageName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id='" + id + '\'' +
                ", imageName='" + imageName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
