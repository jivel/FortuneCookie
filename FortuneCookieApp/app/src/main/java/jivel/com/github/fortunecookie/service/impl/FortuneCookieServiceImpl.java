package jivel.com.github.fortunecookie.service.impl;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.service.IFortuneCookieService;
import jivel.com.github.fortunecookie.util.Constants;
import jivel.com.github.fortunecookie.util.JsonUtil;

/**
 * Created by jimenezlav on 23/04/16.
 */
public class FortuneCookieServiceImpl implements IFortuneCookieService {

    private static final String TAG = FortuneCookieServiceImpl.class.getSimpleName();
    private Context mContext;

    public FortuneCookieServiceImpl() {
    }

    public FortuneCookieServiceImpl(Context context) {
        this.mContext = context;
    }

    @Override
    public void fetchFortuneCookie(FortuneCookieApiCallback<List<FortuneCookie>> listFortuneCookieApiCallback) {
        JSONArray jsonArray = JsonUtil.loadJSONArrayFromRawResource(this.mContext);
        Gson gson = Constants.GSON;
        FortuneCookie [] fortuneCookiesArray  = gson.fromJson(jsonArray.toString(), FortuneCookie[].class);

        List<FortuneCookie> fortuneCookieList = getListOfThreeCookies(fortuneCookiesArray);

        listFortuneCookieApiCallback.onLoaded(fortuneCookieList);
    }

    private List<FortuneCookie> getListOfThreeCookies(FortuneCookie[] fortuneCookiesArray) {
        List<FortuneCookie> fortuneCookiesAll = Arrays.asList(fortuneCookiesArray);
        List<FortuneCookie> fortuneCookiesThree = new ArrayList<>();
        int size = fortuneCookiesAll.size();
        Log.i(TAG,"Total de galletas: " + size);
        for (int i = 0; i < 3; i ++) {
            int randomPosition = randomPosition(size);
            fortuneCookiesThree.add(fortuneCookiesAll.get(randomPosition));
        }
        return fortuneCookiesThree;
    }

    private int randomPosition(int size) {
        Random random = new Random();
        int position = random.nextInt(size);
        Log.i(TAG,"Posición: " + position);
        return position;
    }
}
