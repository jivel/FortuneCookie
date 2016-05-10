package jivel.com.github.fortunecookie.ui.cookies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;

import butterknife.Bind;
import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.ui.BaseFragment;
import jivel.com.github.fortunecookie.util.Constants;

/**
 * A simple {@link Fragment} subclass.
 */
public class FortuneCookieDetailFragment extends BaseFragment implements FortuneCookieContract.ViewFortuneCookieDetail {


    @Bind(R.id.imageViewFortuneCookie)
    ImageView imageViewFortuneCookie;

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

    private void handleBundle(Bundle bundle) {
        String json = bundle.getString(Constants.KEY_FORTUNE_COOKIE);
        FortuneCookie fortuneCookie = new Gson().fromJson(json, FortuneCookie.class);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(fortuneCookie.getType().getName());
        imageViewFortuneCookie.setImageResource(getResIdImageView(fortuneCookie.getId()));
    }

    private int getResIdImageView(String id) {
        if ("1".equals(id))
            return R.drawable.fortune_cookie_type_1;
        else if ("2".equals(id))
            return R.drawable.fortune_cookie_type_2;
        else if ("3".equals(id))
            return R.drawable.fortune_cookie_type_3;
        else if ("4".equals(id))
            return R.drawable.fortune_cookie_type_4;
        else if ("5".equals(id))
            return R.drawable.fortune_cookie_type_5;
        else
            return R.drawable.fortune_cookie;
    }

}
