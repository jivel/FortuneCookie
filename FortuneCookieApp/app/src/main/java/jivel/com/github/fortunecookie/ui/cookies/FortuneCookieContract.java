package jivel.com.github.fortunecookie.ui.cookies;

import android.content.Intent;

import java.util.List;

import jivel.com.github.fortunecookie.model.FortuneCookie;

/**
 * Created by jimenezlav on 23/04/16.
 */
public class FortuneCookieContract {

    public interface View {
        void setProgressVisible(boolean visible);

        void showFortuneCookie(List<FortuneCookie> fortuneCookies);

        void showRequestError();

        void launchActivity(Intent intent);
    }

    public interface ViewDetail {
        void setProgressVisible(boolean visible);

        void showRequestError();

        void launchActivity(Intent intent);
    }

    public interface UserActionListener {
        void requestFortuneCookies();

        void fortuneCookieDetail(FortuneCookie fortuneCookie);
    }
}
