package jivel.com.github.fortunecookie.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.List;

import jivel.com.github.fortunecookie.BuildConfig;
import jivel.com.github.fortunecookie.repository.IFortuneCookieRepository;
import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.ui.cookies.FortuneCookieContract;
import jivel.com.github.fortunecookie.ui.cookies.FortuneCookieDetailFragment;

/**
 * Created by jimenezlav on 23/04/16.
 */
public class FortuneCookiePresenter implements FortuneCookieContract.UserActionListener {

    private static final String TAG = FortuneCookiePresenter.class.getSimpleName();

    private FortuneCookieContract.View mView;
    private IFortuneCookieRepository mFortuneCookieRepository;

    public FortuneCookiePresenter(FortuneCookieContract.View view, IFortuneCookieRepository fortuneCookieRepository) {
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
        Fragment fragment = FortuneCookieDetailFragment.newInstance();
        Bundle bundle=new Bundle();
        bundle.putString("fortuneCookie", fortuneCookie.getDescription());
        fragment.setArguments(bundle);
        Log.i(TAG,fortuneCookie.getDescription());

    }
}
