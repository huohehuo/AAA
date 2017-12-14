package lins.aaa.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.View;
import android.view.ViewGroup;

import lins.aaa.R;
import lins.aaa.databinding.ActivitySettingBinding;
import lins.aaa.ui.login.LoginActivity;
import lins.aaa.utils.AppManager;
import lins.aaa.widget.CustomPopWindow;


public class SettingActivity extends BaseActivity{
    ActivitySettingBinding binding;
    private View contentView;
    private CustomPopWindow popWindow;
//    private Version versionBean=null;


    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setting);
        setToolbarBack(binding.toolbar.ivTopArrow);
        binding.toolbar.tvTopLeft.setText("设置");

//        UpdataUtil.getGitHubJson(SettingActivity.this, Config.UPDATER_URL, null, new JsonHttpResponseHandler() {
//            @Override
//            public void onFailure(Throwable error) {
//                Log.e("check---no", error.toString());
//            }
//
//            @Override
//            public void onSuccess(final JSONObject response) {
//                Log.e("check", response.toString());
////                showToast(response.toString());
//
//            }
//        });
    }

    @Override
    protected void initEvent() {
        binding.tvUpdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (versionBean!=null){
//                    if (!CheckUtil.getVersionName(SettingActivity.this).equals(versionBean.getVersion())){
//                        initPopView(versionBean.getVsDetails(),
//                                versionBean.getVersion(),
//                                versionBean.getAppSize());
//                        showPopUpdata();
//                    }
//                }else{
//                    showToast("获取更新信息错误，请稍后再试");
//                    getData();
//                }
            }
        });

        binding.tvShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                shareApp();
            }
        });
//        startActivityWith(EditUserInfoActivity.class,binding.tvAccount);
//        startActivityWith(EncodeQrActivity.class, binding.tvCode);
        binding.tvAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebActivity.start(SettingActivity.this,"关于","http://www.linspace.club/pages/phone/about.html");
            }
        });
        binding.tvFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebActivity.start(SettingActivity.this,"反馈","http://www.linspace.club/pages/phone/feedback.html");
            }
        });
        binding.tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                RongIM.getInstance().logout();//退出融云IM
//                App.clearShareData();//无效？
//                App.setSharedData(Config.IS_AUTO_LOGIN, "");
                Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                AppManager.getAppManager().finishAllActivity();
            }
        });


    }

    @Override
    protected void getData() {
//        BmobQuery<Version> query = new BmobQuery<Version>();
//        query.findObjects(new FindListener<Version>() {
//            @Override
//            public void done(List<Version> list, BmobException e) {
//                App.e("updata",list.toString());
//                if (e==null){
//                    versionBean = list.get(0);
//                }else{
//
//                }
//
//            }
//        });
    }

//    private void shareApp() {
//        final Bundle params = new Bundle();
//        params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
//        params.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
//        params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "要分享的摘要");
//        params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.qq.com/news/1.html");
//        params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://imgcache.qq.com/qzone/space_item/pre/0/66768.gif");
//        params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "测试应用222222");
//        mTencent.shareToQQ(SettingActivity.this, params, new QShareListener(qShareIO));
//    }

    //初始化最近联系人List的PopWindow
//    private void initPopView(String dt, String vs, String sz){
//        contentView = LayoutInflater.from(this).inflate(R.layout.pop_updata_version,null);
//        //处理popWindow 显示内容
//        TextView detail = (TextView) contentView.findViewById(R.id.tv_detail);
//        TextView version = (TextView) contentView.findViewById(R.id.tv_version);
//        TextView size = (TextView) contentView.findViewById(R.id.tv_vs_size);
//        TextView yes = (TextView) contentView.findViewById(R.id.tv_yes);
//        TextView no = (TextView) contentView.findViewById(R.id.tv_no);
//        detail.setText(getString(R.string.txt_detail,dt));
//        version.setText(getString(R.string.txt_version,vs));
//        size.setText(getString(R.string.txt_size,sz));
//        yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showToast("更新中。。。");
//                UpdataUtil.get().download(Config.UPDATA_APK_URL, new UpdataUtil.OnDownloadListener() {
//                    @Override
//                    public void onDownloadSuccess() {
//                        App.e("down","OK");
//                    }
//                    @Override
//                    public void onDownloading(int progress) {
////                        progressBar.setProgress(progress);
//                        App.e("pg",progress+"");
//                    }
//                    @Override
//                    public void onDownloadFailed() {
//                        App.e("down","NO--OK");
//                    }
//                });
//                popWindow.dissmiss();
//            }
//        });
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showToast("取消更新");
//                popWindow.dissmiss();
//            }
//        });
//
//    }
    /**
     * 显示最近联系人PopWindow
     */
    private void showPopUpdata(){
        //创建并显示popWindow
        popWindow= new CustomPopWindow.PopupWindowBuilder(this)
                .setView(contentView)
                .enableBackgroundDark(true)
                .setBgDarkAlpha(0.6f)
//                .enableOutsideTouchableDissmiss(false)
                .setAnimationStyle(R.style.PopCommentStyle)
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()
//                .showAtLocation(binding.nvs, Gravity.BOTTOM,0,-250);
                .showAsDropDown(binding.toolbar.tvTopLeft,0,0);
    }
}
