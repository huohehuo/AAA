package lins.aaa.ui.login;

import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.Query;
import lins.aaa.App;
import lins.aaa.MainActivity;
import lins.aaa.R;
import lins.aaa.bean.User;
import lins.aaa.bean.User_;
import lins.aaa.databinding.ActivityLoginBinding;
import lins.aaa.ui.BaseActivity;
import lins.aaa.utils.SharedData;


//登录
public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private SharedData data;
    private View layout_login;
    private EditText et_name,et_pwd;
    private Animation animation;
    public Box<User> userBox;
    public Query<User> userQuery;

    private boolean canLogin=false;
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        data = new SharedData(App.getContext());
        layout_login = binding.layoutLogin;
        et_name = layout_login.findViewById(R.id.et_name);
        et_pwd = layout_login.findViewById(R.id.et_pwd);

        BmobUser bmobUser = BmobUser.getCurrentUser();
        if (bmobUser !=null){
            startActivity(MainActivity.class);
            finish();
        }
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
                if (canLogin){
                    showDialog("正在登录");
                    BmobUser.loginByAccount(et_name.getText().toString(),
                            et_pwd.getText().toString(),
                            new LogInListener<User>() {
                                @Override
                                public void done(User user, BmobException e) {
                                    if (e == null) {
                                        startActivity(MainActivity.class);
//                                    App.saveObj(Config.OBJ_USER,user);
////                                    App.setUser(user);
//                                    App.e("Login","登录获的user"+user.toString()+"\n");
//                                    App.setSharedData(Config.HAVE_RONG_TOKEN,"");//清空token，防止登录IM错乱
//                                    App.setSharedData(Config.USER_NAME, binding.etUsername.getText().toString());
//                                    App.setSharedData(Config.USER_PWD, binding.etPassword.getText().toString());
//                                    //将数据存入本地
//                                    SaveService.startSaveLocationUser(App.getContext(),user.getAge(),
//                                            user.getSex(),user.getNote(),user.getIconpic(),user.getRongid());
//                                    //若无token，则从融云服务器获取token
//                                    checkIM(user.getRongid());
//
//                                    //设置为下次自动登录
//                                    App.setSharedData(Config.IS_AUTO_LOGIN, "1");
//                                    startActivity(HomeActivity.class);
                                        finish();
                                    } else {
                                        showToast("登录失败");
                                    }
                                    closeDialog();
                                }
                            });
                }else{
                    canLogin=true;
                    binding.layoutLogin.setVisibility(View.VISIBLE);
                    binding.layoutLogin.startAnimation(animation);
                }

            }
        });


        startActivityWith(RegisterActivity.class, binding.tvRg);
    }

    @Override
    protected void getData() {

        BoxStore boxStore = App.getBoxStore();
        userBox = boxStore.boxFor(User.class);


//        userBox.put(new User("lilei","asdf"));
//        userBox.put(new User("hanmei","asdf"));

        userQuery = userBox.query().order(User_.name).build();

//        List<User> userList =userQuery.find();
//                for (User user:userList) {
//                    textView.setText(textView.getText()+user.getName());
//                }
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
