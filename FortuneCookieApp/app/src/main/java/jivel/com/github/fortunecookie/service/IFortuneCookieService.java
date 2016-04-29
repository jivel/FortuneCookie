package jivel.com.github.fortunecookie.service;

import java.util.List;

import jivel.com.github.fortunecookie.model.FortuneCookie;

/**
 * Created by jimenezlav on 23/04/16.
 */
public interface IFortuneCookieService {
    interface FortuneCookieApiCallback<T> {
        void onLoaded(T type);

        void onError(Throwable throwable);
    }

    void fetchFortuneCookie(FortuneCookieApiCallback<List<FortuneCookie>> listFortuneCookieApiCallback);
}
