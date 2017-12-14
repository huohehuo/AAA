package lins.aaa.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import lins.aaa.R;
import lins.aaa.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends BaseActivity {

    ActivityWelcomeBinding binding;
    private Animation animation;
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_welcome);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void getData() {
        animation = AnimationUtils.loadAnimation(this, R.anim.logo_and_text);
        //为动画设置监听事件
        animation.setAnimationListener(animationListener);
        //给logo图片设置渐变动画效果
        binding.ll.startAnimation(animation);
    }
    //执行登录操作
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            autoLogin();
        }
    };
    private void autoLogin(){

    }
    //设置动画监听器AnimationListener,需要重写三个方法
    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            //当动画开始的时候执行
            binding.ll.setVisibility(View.VISIBLE);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //当动画结束的时候执行
            handler.postDelayed(runnable,100);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            //当动画重复的时候执行
        }
    };
}
