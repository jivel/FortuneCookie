package jivel.com.github.fortunecookie;

import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.model.FortuneCookieContent;
import jivel.com.github.fortunecookie.util.Constants;
import jivel.com.github.fortunecookie.util.JsonFileResource;
import jivel.com.github.fortunecookie.util.JsonParsingRule;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by jimenezlav on 18/04/16.
 */
public class FortuneCookieTest {

    @Rule public JsonParsingRule jsonParsingRule = new JsonParsingRule(Constants.GSON);

    @Test
    @JsonFileResource(fileName = "fortune_cookies.json", clazz = FortuneCookie[].class)
    public void testGetFortuneCookies() throws Exception {
        FortuneCookie[] fortuneCookies = jsonParsingRule.getValue();
        assertThat(fortuneCookies).hasSize(5);
    }

    @Test
    public void testSomethingElse() {
        assertThat(jsonParsingRule.getValue()).isNull();
    }

}
