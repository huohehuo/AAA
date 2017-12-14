package lins.aaa.ui.login;

import android.databinding.DataBindingUtil;
import android.view.View;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import lins.aaa.R;
import lins.aaa.bean.User;
import lins.aaa.databinding.ActivityRegisterBinding;
import lins.aaa.ui.BaseActivity;
import lins.aaa.utils.EmailUtil;


public class RegisterActivity extends BaseActivity {
    ActivityRegisterBinding binding;

    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register);
    }

    @Override
    protected void initEvent() {
        binding.btnRegisterReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkIsOkInput()){
                    return;
                }
                if (!EmailUtil.isEmail(binding.etUsernameReg.getText().toString())){
                    showToast("请输入正确的邮箱");
                    return;
                }
                showDialog("正在注册");
                User user = new User();
                user.setUsername(binding.etUsernameReg.getText().toString());
                user.setPassword(binding.etPasswordReg.getText().toString());

                user.signUp(new SaveListener<User>() {
                    @Override
                    public void done(User user, BmobException e) {
                        if (e == null){
                            showToast("注册成功");
//                            User user2 = new User();
//                            user2.setRongid(App.getUUID());
//                            user2.update(bmobUser.getObjectId(), new UpdateListener() {
//                                @Override
//                                public void done(BmobException e) {
//                                    if (e==null){
//                                        Log.e("rong","生成融云IM账户id----成功");
//                                    }else{
//                                        Log.e("rong","生成融云IM账户id----失败");
//                                    }
//                                }
//                            });
                            finish();
                        }else{
                            showToast("注册失败");
                        }
                        closeDialog();
                    }
                });
            }
        });
    }
    private boolean checkIsOkInput(){
        if ("".equals(binding.etUsernameReg.getText().toString())){
            showToast("邮箱不能为空");
            return false;
        }
        if ("".equals(binding.etPasswordReg.getText().toString())){
            showToast("密码不能为空");
            return false;
        }
        if ("".equals(binding.etConfirmReg.getText().toString())){
            showToast("再次输入的密码不能为空");
            return false;
        }
        if (binding.etPasswordReg.getText().toString().equals(binding.etConfirmReg.getText().toString())){
            showToast("两次输入的密码不一致，请重新检查");
            return false;
        }
        return true;
    }

    @Override
    protected void getData() {

    }
}
