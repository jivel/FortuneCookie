package jivel.com.github.fortunecookie.repository.impl;

import android.content.Context;

import java.util.List;

import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.service.IFortuneCookieService;
import jivel.com.github.fortunecookie.repository.IFortuneCookieRepository;
import jivel.com.github.fortunecookie.service.impl.FortuneCookieServiceImpl;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class FortuneCookieRepositoryImpl implements IFortuneCookieRepository {

    private IFortuneCookieService mFortuneCookieService;

    public FortuneCookieRepositoryImpl() {
    }

    public FortuneCookieRepositoryImpl(IFortuneCookieService fortuneCookieService) {
        this.mFortuneCookieService = fortuneCookieService;
    }

    @Override
    public void fetchFortuneCookie(final IFetchFortuneCookieCallback fortuneCookieCallback) {
        this.mFortuneCookieService.fetchFortuneCookie(new IFortuneCookieService.FortuneCookieApiCallback<List<FortuneCookie>>() {

            @Override
            public void onLoaded(List<FortuneCookie> type) {
                fortuneCookieCallback.onSuccess(type);
            }

            @Override
            public void onError(Throwable throwable) {
                fortuneCookieCallback.onError(throwable);
            }
        });
    }
}
