package lins.aaa.ui.login;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import lins.aaa.App;
import lins.aaa.R;
import lins.aaa.databinding.ActivityLoginBinding;
import lins.aaa.ui.BaseActivity;
import lins.aaa.utils.SharedData;


//登录
public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private SharedData data;
    private Animation animation;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        data = new SharedData(App.getContext());
    }

    @Override
    protected void initEvent() {
        //设置动画效果
        animation = AnimationUtils.loadAnimation(this, R.anim.logo_and_text);
        //为动画设置监听事件
        animation.setAnimationListener(animationListener);
        //给logo图片设置渐变动画效果
        binding.ivLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.layoutLogin.setVisibility(View.VISIBLE);
                binding.layoutLogin.startAnimation(animation);
            }
        });

//        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showDialog("正在登录");
//                BmobUser.loginByAccount(binding.etUsername.getText().toString(),
//                        binding.etPassword.getText().toString(),
//                        new LogInListener<User>() {
//                            @Override
//                            public void done(User user, BmobException e) {
//                                if (e == null) {
////                                    App.saveObj(Config.OBJ_USER,user);
//////                                    App.setUser(user);
////                                    App.e("Login","登录获的user"+user.toString()+"\n");
////                                    App.setSharedData(Config.HAVE_RONG_TOKEN,"");//清空token，防止登录IM错乱
////                                    App.setSharedData(Config.USER_NAME, binding.etUsername.getText().toString());
////                                    App.setSharedData(Config.USER_PWD, binding.etPassword.getText().toString());
////                                    //将数据存入本地
////                                    SaveService.startSaveLocationUser(App.getContext(),user.getAge(),
////                                            user.getSex(),user.getNote(),user.getIconpic(),user.getRongid());
////                                    //若无token，则从融云服务器获取token
////                                    checkIM(user.getRongid());
////
////                                    //设置为下次自动登录
////                                    App.setSharedData(Config.IS_AUTO_LOGIN, "1");
////                                    startActivity(HomeActivity.class);
//                                    finish();
//                                } else {
//                                    showToast("登录失败");
//                                }
//                                closeDialog();
//                            }
//                        });
//            }
//        });
//        startActivityWith(RegisterActivity.class, binding.btnRegis);
    }

    @Override
    protected void getData() {

    }

    //设置动画监听器AnimationListener,需要重写三个方法
    private Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
            //当动画开始的时候执行
            binding.llTitle.setVisibility(View.GONE);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //当动画结束的时候执行
            binding.layoutLogin.setVisibility(View.VISIBLE);
//            handler.postDelayed(runnable,100);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            //当动画重复的时候执行
        }
    };
}
