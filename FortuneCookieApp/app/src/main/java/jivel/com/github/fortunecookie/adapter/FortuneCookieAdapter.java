package jivel.com.github.fortunecookie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import jivel.com.github.fortunecookie.R;
import jivel.com.github.fortunecookie.model.FortuneCookie;
import jivel.com.github.fortunecookie.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jimenezlav on 17/04/16.
 *
 * {@link RecyclerView.Adapter} that can display a {@link FortuneCookie} and makes a call to the
 * specified {@link OnItemClickListener}.
 */
public class FortuneCookieAdapter extends RecyclerView.Adapter<FortuneCookieAdapter.FortuneCookieHolder> {

    private List<FortuneCookie> mFortuneCookies;
    private OnItemClickListener<FortuneCookie> mItemClickListener;
    private Context mContext;

    public FortuneCookieAdapter() {
        if (null == mFortuneCookies)
            this.mFortuneCookies = new ArrayList<>();
    }

    public FortuneCookieAdapter(List<FortuneCookie> fortuneCookies) {
        this.mFortuneCookies = fortuneCookies;
    }

    /**
     * Aquí definiremos el archivo de layout que utilizaremos para representar las filas de un RecyclerView.
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public FortuneCookieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null)
            mContext = parent.getContext();

        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_fortune_cookie_list, parent, false);

        View root = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_fortune_cookie, parent, false);
        return new FortuneCookieHolder(root);
    }

    /**
     * Aquí haremos el binding entre la vista representada por el FortuneCookieHolder y el modelo de datos.
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final FortuneCookieHolder holder, int position) {
        FortuneCookie fortuneCookie = this.mFortuneCookies.get(position);
        holder.bindFortuneCookie(fortuneCookie);
    }

    /**
     * Aquí le decimos al adaptador cuántos elementos necesitamos pintar
     * @return
     */
    @Override
    public int getItemCount() {
        return this.mFortuneCookies.size();
    }

    public void setItemClickListener(OnItemClickListener<FortuneCookie> mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setFortuneCookies(List<FortuneCookie> mFortuneCookies) {
        this.mFortuneCookies = mFortuneCookies;
        notifyDataSetChanged();
    }

    public class FortuneCookieHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.image_fortune_cookie)
        ImageView imageViewFortuneCookie;
        @Bind(R.id.label_type)
        TextView textViewType;
        @Bind(R.id.label_description)
        TextView textViewDescription;

        private FortuneCookie mFortuneCookie;

        public FortuneCookieHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
        }

        public void bindFortuneCookie(FortuneCookie fortuneCookie) {
            this.mFortuneCookie = fortuneCookie;
            String description = new StringBuilder().append(this.mFortuneCookie.getPhrases().size()).append(" ").append(mContext.getString(R.string.app_fortune_cookie_phrases)).toString();
            this.textViewType.setText(this.mFortuneCookie.getType().getName());
            this.textViewDescription.setText(description);
            int resIdImageView = getResIdImageView();
            this.imageViewFortuneCookie.setImageResource(resIdImageView);
        }

        private int getResIdImageView() {
            String id = this.mFortuneCookie.getId().trim();
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

        @Override
        public String toString() {
            return super.toString() + " '" + textViewType.getText() + "'";
        }

        @Override
        public void onClick(View v) {
            if (null != mItemClickListener)
                mItemClickListener.onItemClicked(getAdapterPosition(), this.mFortuneCookie);
        }
    }
}
