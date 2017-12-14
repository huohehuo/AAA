package lins.aaa.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import lins.aaa.App;
import lins.aaa.R;
import lins.aaa.bean.PlaceBean;


/**
 * Created by LINS on 2017/5/2.
 */

public class MainAdapter extends RecyclerArrayAdapter<PlaceBean> {
    public MainAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
//        if (getViewType(viewType)==2){
//            Log.e("holder","返回图文布局");
//            return new MainHolder(parent);
//        }else{
//            Log.e("holder","返回--文字--布局");
//            return new MainHolderForTxt(parent);
//        }

        if (viewType==2){
//            Log.e("holder","返回图文布局");
            return new MainHolder(parent);
        }else{
//            Log.e("holder","返回--文字--布局");
            return new MainHolderForTxt(parent);
        }

    }


    @Override
    public int getViewType(int position) {
        return Integer.valueOf(getAllData().get(position).getPlace_type());

//        if ("1".equals(getAllData().get(position).getType())){
//            Log.e("getViewType",getAllData().get(position).getType());
//            return 1;
//        }else{
//            Log.e("getViewType2",getAllData().get(position).getType());
//            return 2;
//        }
    }

    class MainHolder extends BaseViewHolder<PlaceBean> {

        private TextView time;
        private TextView eesay;
        private ImageView favour,img_bg;
        private TextView num;
        public MainHolder(ViewGroup parent) {
            super(parent, R.layout.item_plan);
            time = $(R.id.tv_time);
            eesay = $(R.id.tv_main_essay);
            num = $(R.id.tv_favour);
            favour = $(R.id.iv_favour);
            img_bg = $(R.id.iv_main_bg);
        }

        @Override
        public void setData(PlaceBean data) {
            super.setData(data);
            eesay.setText(data.getPlace_name());
            time.setText(data.getPlace_say());
//            num.setText(data.getFavour().get__op());
            
            favour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(App.getContext(), "喜欢+1", Toast.LENGTH_SHORT).show();
                }
            });

            Glide.with(getContext())
                    .load(data.getPlace_pic())
                    .placeholder(R.drawable.dog)
                    .centerCrop()
                    .into(img_bg);

        }
    }

    //纯文字布局
    class MainHolderForTxt extends BaseViewHolder<PlaceBean> {

        private TextView time;
        private TextView eesay;
        private ImageView favour;
        private TextView num;
        public MainHolderForTxt(ViewGroup parent) {
            super(parent, R.layout.item_plan_for_txt);
            time = $(R.id.tv_time);
            eesay = $(R.id.tv_main_essay);
            num = $(R.id.tv_favour);
            favour = $(R.id.iv_favour);
        }

        @Override
        public void setData(PlaceBean data) {
            super.setData(data);
            eesay.setText(data.getPlace_name());
            time.setText(data.getPlace_say());
//            num.setText(data.getFavour().get__op());

            favour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(App.getContext(), "喜欢+1", Toast.LENGTH_SHORT).show();
                }
            });

//            Glide.with(getContext())
//                    .load(data.getPic())
//                    .placeholder(R.mipmap.ic_launcher)
//                    .centerCrop()
//                    .into(imageView);

        }
    }
}
