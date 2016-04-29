package jivel.com.github.fortunecookie.ui.cookies;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class FortuneCookieDetailFragment extends BaseFragment implements FortuneCookieContract.ViewDetail {


    public FortuneCookieDetailFragment() {
    }

    public static FortuneCookieDetailFragment newInstance() {
        return new FortuneCookieDetailFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_fortune_cookie_detail;
    }

    @Override
    public void setProgressVisible(boolean visible) {

    }

    @Override
    public void showRequestError() {

    }

    @Override
    public void launchActivity(Intent intent) {

    }
}
