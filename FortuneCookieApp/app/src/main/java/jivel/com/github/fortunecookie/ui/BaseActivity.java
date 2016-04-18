package jivel.com.github.fortunecookie.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import jivel.com.github.fortunecookie.R;


/**
 * Created by jimenezlav on 17/04/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune_cookie);
        this.mFragmentManager = getSupportFragmentManager();

    }

    /**
     * Displays the next fragment
     *
     * @param nextFragment
     */
    protected void openFragment(Fragment nextFragment) {

        Fragment fragmentActual = this.mFragmentManager.findFragmentById(R.id.fragment_container);


        if (fragmentActual == null){
            this.mFragmentManager.beginTransaction()
                    .add(R.id.fragment_container, nextFragment)
                    .commit();
        }else {
            this.mFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, nextFragment)
                    .setCustomAnimations(R.anim.slide_in_left,
                            R.anim.slide_out_right,
                            R.anim.slide_in_right,
                            R.anim.slide_out_left)
                    .addToBackStack(nextFragment.toString())
                    .commit();
        }

    }

}
