package jivel.com.github.fortunecookie.presenter;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;

import jivel.com.github.fortunecookie.BuildConfig;
import jivel.com.github.fortunecookie.repository.IFortuneCookieRepository;
import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.ui.cookies.FortuneCookieContract;
import jivel.com.github.fortunecookie.util.Constants;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class FortuneCookiePresenter implements FortuneCookieContract.UserActionListener {

    private static final String TAG = FortuneCookiePresenter.class.getSimpleName();

    private FortuneCookieContract.ViewFortuneCookie mView;
    private IFortuneCookieRepository mFortuneCookieRepository;

    public FortuneCookiePresenter(FortuneCookieContract.ViewFortuneCookie view, IFortuneCookieRepository fortuneCookieRepository) {
        this.mView = view;
        this.mFortuneCookieRepository = fortuneCookieRepository;
    }

    @Override
    public void requestFortuneCookies() {
        this.mView.setProgressVisible(true);
        this.mFortuneCookieRepository.fetchFortuneCookie(new IFortuneCookieRepository.IFetchFortuneCookieCallback() {

            @Override
            public void onSuccess(List<FortuneCookie> fortuneCookies) {
                mView.setProgressVisible(false);
                mView.showFortuneCookie(fortuneCookies);
            }

            @Override
            public void onError(Throwable throwable) {
                if (BuildConfig.DEBUG)
                    throwable.printStackTrace();

                mView.setProgressVisible(false);
                mView.showRequestError();
            }
        });

    }

    @Override
    public void fortuneCookieDetail(FortuneCookie fortuneCookie) {
        String toJson = new Gson().toJson(fortuneCookie);
        Log.i(TAG,toJson);
        Bundle arguments = new Bundle();
        arguments.putString(Constants.KEY_FORTUNE_COOKIE, toJson);
        mView.launchFragment(arguments);
    }
}
