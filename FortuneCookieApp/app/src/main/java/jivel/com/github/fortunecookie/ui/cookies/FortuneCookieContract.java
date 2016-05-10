package jivel.com.github.fortunecookie.ui.cookies;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

import jivel.com.github.fortunecookie.model.FortuneCookie;

/**
 * Created by jimenezlav on 23/04/16.
 */
public class FortuneCookieContract {

    public interface View {
        void setProgressVisible(boolean visible);
        void showRequestError();
        void launchFragment(Bundle bundle);
    }

    public interface ViewFortuneCookie extends View {
        void showFortuneCookie(List<FortuneCookie> fortuneCookies);
    }

    public interface ViewFortuneCookieDetail extends View {
    }

    public interface UserActionListener {
        void requestFortuneCookies();

        void fortuneCookieDetail(FortuneCookie fortuneCookie);
    }
}
