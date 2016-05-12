package jivel.com.github.fortunecookie.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import jivel.com.github.fortunecookie.R;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class JsonUtil {

    private static final String TAG = JsonUtil.class.getSimpleName();

    public static JSONObject loadJSONObjectFromRawResource(Context context) {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.fortune_cookies);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonContent = new String(buffer, "UTF-8");

            return convertToJSONObject(jsonContent);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static JSONArray loadJSONArrayFromRawResource(Context context) {
        try {
            InputStream is = context.getResources().openRawResource(R.raw.fortune_cookies);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String jsonContent = new String(buffer, "UTF-8");
            return convertToJSONArray(jsonContent);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static JSONArray convertToJSONArray(String jsonContent) {
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(jsonContent);
        } catch (JSONException e) {
            Log.e(TAG, "It couldn't parse to JSONArray");
            e.printStackTrace();
        }
        return jsonArray;
    }

    public static JSONObject convertToJSONObject(String jsonContent) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonContent);
        } catch (JSONException e) {
            Log.e(TAG, "It couldn't parse to JSONObject");
            e.printStackTrace();
        }
        return jsonObject;
    }
}
