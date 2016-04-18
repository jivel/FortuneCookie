package jivel.com.github.fortunecookie.ui;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.ui.home.HomeFragment;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class FortuneCookieActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        home();
    }

    private void home() {
        Fragment fragment = HomeFragment.newInstance();
        openFragment(fragment);
    }
}
