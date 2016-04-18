package jivel.com.github.fortunecookie.ui.home;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.ui.BaseFragment;

/**
 * Created by jimenezlav on 17/04/16.
 */
public class HomeFragment extends BaseFragment {

    @Bind(R.id.textViewFortune)
    TextView textViewFortune;
    @Bind(R.id.textViewCookie)
    TextView textViewCookie;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_home;
    }

    public static Fragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AssetManager assetManager = getResources().getAssets();
        Typeface font = Typeface.createFromAsset(assetManager, "my_font.ttf");
        textViewFortune.setTypeface(font);
        textViewCookie.setTypeface(font);
    }

}
