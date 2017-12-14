package lins.aaa.ui.login;

import android.databinding.DataBindingUtil;
import android.view.View;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import lins.aaa.App;
import lins.aaa.R;
import lins.aaa.bean.User;
import lins.aaa.databinding.ActivityLoginBinding;
import lins.aaa.ui.BaseActivity;
import lins.aaa.utils.SharedData;


//登录
public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;
    private SharedData data;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        data = new SharedData(App.getContext());
    }

    @Override
    protected void initEvent() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("正在登录");
                BmobUser.loginByAccount(binding.etUsername.getText().toString(),
                        binding.etPassword.getText().toString(),
                        new LogInListener<User>() {
                            @Override
                            public void done(User user, BmobException e) {
                                if (e == null) {
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
            }
        });
        startActivityWith(RegisterActivity.class, binding.btnRegis);
    }

    @Override
    protected void getData() {

    }
}
