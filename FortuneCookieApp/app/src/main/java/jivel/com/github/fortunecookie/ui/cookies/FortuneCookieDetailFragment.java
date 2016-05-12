package jivel.com.github.fortunecookie.ui.cookies;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.OnClick;
import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.model.Phrase;
import jivel.com.github.fortunecookie.ui.BaseFragment;
import jivel.com.github.fortunecookie.util.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class FortuneCookieDetailFragment extends BaseFragment implements FortuneCookieContract.ViewFortuneCookieDetail {


    @Bind(R.id.imageViewFortuneCookie)
    ImageView imageViewFortuneCookie;

    @Bind(R.id.textViewPhrase)
    TextView textViewPhrase;

    @OnClick(R.id.buttonReset)
    public void buttonReset() {
        getFragmentManager().popBackStack();
    }

    private  FortuneCookie mFortuneCookie;

    public FortuneCookieDetailFragment() {
    }

    public static FortuneCookieDetailFragment newInstance() {
        return new FortuneCookieDetailFragment();
    }

    public static FortuneCookieDetailFragment newInstance(Bundle arguments) {
        FortuneCookieDetailFragment fortuneCookieDetailFragment = new FortuneCookieDetailFragment();
        if (null != arguments)
            fortuneCookieDetailFragment.setArguments(arguments);
        return fortuneCookieDetailFragment;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        Bundle bundle = getArguments();
        if (null != bundle )
            handleBundle(bundle);
        changeTitleToolBar();
        animateImageViewFortuneCookie();
        getRandomPhrase();
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
    public void launchFragment(Bundle bundle) {

    }

    @Override
    public void showPhrase(String phrase) {
        textViewPhrase.setText(phrase);
    }

    private void handleBundle(Bundle bundle) {
        String json = bundle.getString(Constants.KEY_FORTUNE_COOKIE);
        mFortuneCookie = new Gson().fromJson(json, FortuneCookie.class);
    }

    private void changeTitleToolBar() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(mFortuneCookie.getType().getName());
    }

    private void animateImageViewFortuneCookie() {

    }

    private void getRandomPhrase() {
        List<Phrase> phrases = this.mFortuneCookie.getPhrases();
        int position = randomPosition(phrases.size());
        String phrase = phrases.get(position).getTitle();
        this.showPhrase(phrase);
    }

    private int randomPosition(int size) {
        Random random = new Random();
        int position = random.nextInt(size);
        return position;
    }


}
