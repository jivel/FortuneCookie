package jivel.com.github.fortunecookie.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by jimenezlav on 23/04/16.
 */
public class FortuneCookieContent {

    List<FortuneCookie> fortuneCookies;

    public FortuneCookieContent() {
    }

    public FortuneCookieContent(List<FortuneCookie> fortuneCookies) {
        this.fortuneCookies = fortuneCookies;
    }

    public List<FortuneCookie> getFortuneCookies() {
        return fortuneCookies;
    }

    public void setFortuneCookies(List<FortuneCookie> fortuneCookies) {
        this.fortuneCookies = fortuneCookies;
    }

    @Override
    public String toString() {
        return "FortuneCookieContent{" +
                "fortuneCookies=" + fortuneCookies +
                '}';
    }
}
