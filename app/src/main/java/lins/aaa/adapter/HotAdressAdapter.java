package lins.aaa.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import lins.aaa.R;
import lins.aaa.bean.AdressBean;
import lins.aaa.utils.piccut.CircleImageView;


/**
 * Created by LINS on 2017/5/2.
 */

public class HotAdressAdapter extends RecyclerArrayAdapter<AdressBean> {
    public HotAdressAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
            return new MainHolder(parent);
    }

    class MainHolder extends BaseViewHolder<AdressBean> {
        private CircleImageView imageView;
        public MainHolder(ViewGroup parent) {
            super(parent, R.layout.item_hot_adress);
            imageView = $(R.id.iv_hot);
        }

        @Override
        public void setData(AdressBean data) {
            super.setData(data);
            Glide.with(getContext())
                    .load(data.getAdress_pic())
//                .placeholder(R.drawable.ic_account_circle)
                    .fitCenter()
                    .into(imageView);
        }
    }

}
