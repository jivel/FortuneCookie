package jivel.com.github.fortunecookie.ui.cookies;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import butterknife.Bind;
import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.adapter.FortuneCookieAdapter;
import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.presenter.FortuneCookiePresenter;
import jivel.com.github.fortunecookie.repository.impl.FortuneCookieRepositoryImpl;
import jivel.com.github.fortunecookie.service.impl.FortuneCookieServiceImpl;
import jivel.com.github.fortunecookie.ui.BaseFragment;
import jivel.com.github.fortunecookie.ui.OnItemClickListener;
import jivel.com.github.fortunecookie.ui.SpacesItemDecoration;

/**
 * Created by jimenezlav on 17/04/16.
 *
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnItemClickListener}
 * interface.
 */
public class FortuneCookieFragment extends BaseFragment implements FortuneCookieContract.ViewFortuneCookie {

    @Bind(R.id.list_fortune_cookie)
    RecyclerView mListFortuneCookie;

    private FortuneCookieAdapter mFortuneCookieAdapter;

    private FortuneCookieContract.UserActionListener mActionListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FortuneCookieFragment() {
    }

    public static FortuneCookieFragment newInstance() {
        return new FortuneCookieFragment();
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_fortune_cookie_list;
    }

    @Override
    public void initView(View view, Bundle savedInstanceState) {
        super.initView(view, savedInstanceState);
        createAdapter();
        initializeFortuneCookies();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (null == this.mActionListener)
            this.mActionListener = new FortuneCookiePresenter(this, new FortuneCookieRepositoryImpl(new FortuneCookieServiceImpl(getContext())));

        this.mActionListener.requestFortuneCookies();
    }

    @Override
    public void setProgressVisible(boolean visible) {

    }

    @Override
    public void showFortuneCookie(List<FortuneCookie> fortuneCookies) {
            this.mFortuneCookieAdapter.setFortuneCookies(fortuneCookies);
    }

    @Override
    public void showRequestError() {
    }

    @Override
    public void launchFragment(Bundle bundle) {
        FragmentManager fragmentManager = getFragmentManager();
        if (null != fragmentManager) {
            Fragment fragment = FortuneCookieDetailFragment.newInstance(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .setCustomAnimations(R.anim.slide_in_left,
                            R.anim.slide_out_right,
                            R.anim.slide_in_right,
                            R.anim.slide_out_left)
                    .addToBackStack(fragment.toString())
                    .commit();
        }

    }

    private void createAdapter() {
        this.mFortuneCookieAdapter = createFortuneCookieAdapter(new OnItemClickListener<FortuneCookie>() {
            @Override
            public void onItemClicked(int position, FortuneCookie item) {
                mActionListener.fortuneCookieDetail(item);
            }
        });
    }

    private FortuneCookieAdapter createFortuneCookieAdapter(@Nullable OnItemClickListener<FortuneCookie> onItemClickListener) {
        FortuneCookieAdapter fortuneCookieAdapter = new FortuneCookieAdapter();
        if (null != onItemClickListener)
            fortuneCookieAdapter.setItemClickListener(onItemClickListener);
        return  fortuneCookieAdapter;
    }

    private void initializeFortuneCookies() {
        SpacesItemDecoration decoration = new SpacesItemDecoration(24);
        this.mListFortuneCookie.setLayoutManager(new LinearLayoutManager(getContext()));
        this.mListFortuneCookie.setHasFixedSize(true);
        this.mListFortuneCookie.setAdapter(this.mFortuneCookieAdapter);
        this.mListFortuneCookie.addItemDecoration(decoration);
    }

}
