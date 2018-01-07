package lins.aaa.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import lins.aaa.App;
import lins.aaa.R;
import lins.aaa.adapter.GlideImageLoader;
import lins.aaa.adapter.HotAdressAdapter;
import lins.aaa.adapter.MainAdapter;
import lins.aaa.bean.AdressBean;
import lins.aaa.bean.PlaceBean;
import lins.aaa.databinding.FgHomeBinding;
import lins.aaa.ui.SysNotifyActivity;


/**
 * Created by LINS on 2017/2/22.
 */

public class HomeFragment extends Fragment {
    public static final String TAG = "three_fragment";
    FgHomeBinding binding;
    private MainAdapter adapter;
    private HotAdressAdapter hotAdapter;
    private View rootView;
    private List<String> imagesList;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null){
            binding = DataBindingUtil.inflate(inflater, R.layout.fg_home,container,false);
            rootView = binding.getRoot();

            binding.rySquare.setAdapter(adapter = new MainAdapter(getActivity()));
            binding.rySquare.setLayoutManager(new LinearLayoutManager(getActivity()));

            binding.ryHot.setAdapter(hotAdapter = new HotAdressAdapter(getActivity()));
            binding.ryHot.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));


            binding.banner.setBannerStyle(BannerConfig.NUM_INDICATOR);
            binding.banner.setImageLoader(new GlideImageLoader());
            imagesList = new ArrayList<>();
            imagesList.add("http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg");
            imagesList.add("http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg");
            imagesList.add("http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg");
            binding.banner.setImages(imagesList);
            //设置banner动画效果
            binding.banner.setBannerAnimation(Transformer.Default);
            //设置标题集合（当banner样式有显示title时）
//            binding.banner.setBannerTitles(titles);
            //设置自动轮播，默认为true
            binding.banner.isAutoPlay(true);
            //设置轮播时间
            binding.banner.setDelayTime(2800);
            //设置指示器位置（当banner模式中有指示器时）
            binding.banner.setIndicatorGravity(BannerConfig.CENTER);
            //banner设置方法全部调用完毕时最后调用
            binding.banner.start();



            getData();
            initEven();
            return binding.getRoot();
        }


        Log.e("plan","onCreateView");
        return rootView;
    }

    //绑定事件
    private void initEven(){
        binding.banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                App.e(position+"");
            }
        });
        binding.rySquare.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getData();
            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                ShowPlanActivity.start(
//                        getActivity(),
//                        adapter.getAllData().get(position).getObjectId(),
//                        adapter.getAllData().get(position).getEssay(),
//                        adapter.getAllData().get(position).getCreatedAt());
            }
        });

        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SysNotifyActivity.class));
            }
        });
    }
    //获取数据
    protected void getData() {
        List<PlaceBean> list=new ArrayList<>();
        list.add(new PlaceBean("钦州","海豚之乡","aaaa","1"));
        list.add(new PlaceBean("钦州","海豚之乡","aaaa","1"));
        list.add(new PlaceBean("钦州","海豚之乡","aaaa","1"));
        adapter.addAll(list);

        List<AdressBean> list1 = new ArrayList<>();
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        list1.add(new AdressBean("qinhou","http://bmob-cdn-14674.b0.upaiyun.com/2017/10/25/65600ac740e4bdea8018c806b2dc8b4a.jpg","haoahaoao"));
        hotAdapter.addAll(list1);
//        binding.rySquare.setRefreshing(true);
//        User user = BmobUser.getCurrentUser(User.class);
//        BmobQuery<PlanBean> query = new BmobQuery<>();
//        query.addWhereEqualTo("author",user);// 查询当前用户的所有帖子
//        query.order("-updatedAt");
//        query.include("author");// 希望在查询帖子信息的同时也把发布人的信息查询出来
//        query.findObjects(new FindListener<PlanBean>() {
//            @Override
//            public void done(List<PlanBean> list, BmobException e) {
//                if (e==null){
//                    adapter.clear();
//                    adapter.addAll(list);
//                }else{
//                    Toast.makeText(getActivity(), "获取信息失败", Toast.LENGTH_SHORT).show();
//                }
//                binding.rySquare.setRefreshing(false);
//            }
//        });
        //删除帖子
//        PlanBean p = new PlanBean();
//        p.remove("author");
//        p.update("ESIt3334", new UpdateListener() {
//
//            @Override
//            public void done(BmobException e) {
//                if(e==null){
//                    Log.i("bmob","成功");
//                }else{
//                    Log.i("bmob","失败："+e.getMessage());
//                }
//            }
//        });
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.e("plan","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        binding.banner.startAutoPlay();
//        Log.e("plan","onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.e("plan","onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
//        Log.e("plan","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();binding.banner.stopAutoPlay();
//        Log.e("plan","onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Log.e("plan","onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
//        Log.e("plan","onDetach");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        Log.e("plan","onDestroyView");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        Log.e("plan","onAttach");
    }
}
