package jivel.com.github.fortunecookie.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by jimenezlav on 18/04/16.
 */
public class JsonParsingRule implements TestRule {

    private final Gson mGson;
    private Object mValue;

    public JsonParsingRule(Gson gson) {
        mGson = gson;
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue() {
        return (T) mValue;
    }

    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void evaluate() throws Throwable {
                JsonFileResource jsonFileResource = description.getAnnotation(JsonFileResource.class);
                if (jsonFileResource != null) {
                    Class<?> clazz = jsonFileResource.clazz();
                    String resourceName = jsonFileResource.fileName();
                    Class<?> testClass = description.getTestClass();
                    InputStream in = testClass.getResourceAsStream(resourceName);

                    assert in != null : "Failed to load resource: " + resourceName + " from " + testClass;
                    try (Reader reader = new BufferedReader(new InputStreamReader(in))) {
                        mValue = mGson.fromJson(reader, clazz);
                    }
                }
                base.evaluate();
            }
        };
    }

}
