package jivel.com.github.fortunecookie.repository;

import java.util.List;

import jivel.com.github.fortunecookie.model.FortuneCookie;

/**
 * Created by jimenezlav on 17/04/16.
 */
public interface IFortuneCookieRepository {

    interface IFetchFortuneCookieCallback {
        void onSuccess(List<FortuneCookie> fortuneCookies);

        void onError(Throwable throwable);
    }

    void fetchFortuneCookie(IFetchFortuneCookieCallback fortuneCookieCallback);
}
