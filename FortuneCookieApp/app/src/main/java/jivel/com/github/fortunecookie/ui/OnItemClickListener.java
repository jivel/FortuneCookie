package jivel.com.github.fortunecookie.ui;

import jivel.com.github.fortunecookie.model.FortuneCookieContentOld;

/**
 * Created by jimenezlav on 17/04/16.
 */
public interface OnItemClickListener<ItemClass> {
    void onItemClicked(int position, ItemClass item);
}
