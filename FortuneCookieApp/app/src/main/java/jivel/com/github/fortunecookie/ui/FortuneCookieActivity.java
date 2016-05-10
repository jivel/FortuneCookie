package jivel.com.github.fortunecookie.ui;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.ui.cookies.FortuneCookieFragment;
import jivel.com.github.fortunecookie.ui.home.HomeFragment;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class FortuneCookieActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        home();
        welcome();
    }

    private void welcome() {
        Runnable runnableNextView = new Runnable() {
            @Override
            public void run() {
                showCookies();
            }
        };

        Handler handlerNextActivity = new Handler();
        handlerNextActivity.postDelayed(runnableNextView, 5000);
    }

    private void showCookies() {
        Fragment fragment = FortuneCookieFragment.newInstance();
        openFragment(fragment);
        setupToolbar(getString(R.string.app_name), true);
    }

    private void home() {
        Fragment fragment = HomeFragment.newInstance();
        openFragment(fragment);
        setupToolbar(null, false);
    }
}
