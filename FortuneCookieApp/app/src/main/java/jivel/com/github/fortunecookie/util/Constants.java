package jivel.com.github.fortunecookie.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class Constants {
    public static final String KEY_FORTUNE_COOKIE = "fortuneCookie";
    public static final Gson GSON;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        GSON = gsonBuilder.create();
    }
}
