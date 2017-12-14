package lins.aaa.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.view.KeyEvent;

import lins.aaa.R;
import lins.aaa.databinding.ActivityWebBinding;


public class WebActivity extends BaseActivity {

    ActivityWebBinding binding;
    Intent intent;
    String url="www.baidu.com";
    String title = "网页浏览";
    @Override
    protected void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_web);
        binding.toolbar.ivTopArrow.setImageResource(R.drawable.back);
        binding.toolbar.tvTopTitle.setText(title);
        intent = getIntent();
        if (intent!=null){
            binding.toolbar.tvTopTitle.setText(intent.getStringExtra("title")==null?"网页浏览":intent.getStringExtra("title"));
            url = intent.getStringExtra("geturl");
        }

    }

    @Override
    protected void initEvent() {
        binding.wbAction.loadUrl(url);
        closeActivity(binding.toolbar.ivTopArrow);


    }

    @Override
    protected void getData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.wbAction.canGoBack()) {
            binding.wbAction.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * @param context
     */
    public static void start(Context context,String url) {
        Intent starter = new Intent(context, WebActivity.class);
        starter.putExtra("geturl", url);
        context.startActivity(starter);
    }
    public static void start(Context context, String title,String url) {
        Intent starter = new Intent(context, WebActivity.class);
        starter.putExtra("title", title);
        starter.putExtra("geturl", url);
        context.startActivity(starter);
    }
}
