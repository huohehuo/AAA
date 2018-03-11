package lins.aaa.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import lins.aaa.R;
import lins.aaa.adapter.AboutMeAdapter;
import lins.aaa.adapter.MainAdapter;
import lins.aaa.databinding.ActivityAboutMeBinding;
import lins.aaa.ui.AddPlanActivity;
import lins.aaa.ui.SettingActivity;
import lins.aaa.utils.ACache;


/**
 * Created by LINS on 2017/2/22.
 */

public class MeFragment extends Fragment {
    public static final String TAG = "three_fragment";
    ActivityAboutMeBinding binding;
    private MainAdapter adapter;
    private View rootView;
    private AppCompatActivity appCompatActivity;
    private ImageView iv_right,iv_left;
    private ACache aCache;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {
            binding = DataBindingUtil.inflate(inflater, R.layout.activity_about_me, container, false);
            rootView = binding.getRoot();
            appCompatActivity = (AppCompatActivity) getActivity();
            iv_right = appCompatActivity.findViewById(R.id.iv_top_right);
            iv_left = appCompatActivity.findViewById(R.id.iv_top_arrow);
            iv_right.setImageResource(R.drawable.add);
            setupViewPager(binding.viewpager);
            binding.tabAboutMe.setupWithViewPager(binding.viewpager);
            getData();
            initEven();
            return binding.getRoot();
        }


        Log.e("plan", "onCreateView");
        return rootView;
    }

    //绑定事件
    private void initEven() {
        iv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(appCompatActivity, AddPlanActivity.class));
            }
        });
        iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(appCompatActivity, SettingActivity.class));
            }
        });
    }

    //获取数据
    protected void getData() {
        aCache = ACache.get(getActivity());
    }

    private void setupViewPager(ViewPager mViewPager) {
        AboutMeAdapter adapter = new AboutMeAdapter(getFragmentManager());
        adapter.addFragment(new AboutMeFragment(), "详细资料");
        adapter.addFragment(new MySayFragment(), "我的计划");
//        adapter.addFragment(DetailFragment.newInstance( "有有有"),"关注");
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.e("plan", "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.e("plan", "onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.e("plan", "onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
//        Log.e("plan", "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
//        Log.e("plan", "onStop");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Log.e("plan", "onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
//        Log.e("plan", "onDetach");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        Log.e("plan", "onDestroyView");

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        Log.e("plan", "onAttach");
    }
}
