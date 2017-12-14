package lins.aaa;

import android.content.Context;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import java.util.HashMap;

import cn.bmob.v3.Bmob;
import io.objectbox.BoxStore;
import lins.aaa.bean.MyObjectBox;
import lins.aaa.utils.SharedData;


/**
 * Created by Administrator on 2017/12/3.
 */
public class App extends MultiDexApplication {
    // 用来保存整个应用程序数据
    private static HashMap<String, Object> allData = new HashMap<String, Object>();
    private static Context mContext;
    //    private static Tencent mTencent;
    public static String userName = "";
    public static String bmobObjectId = "";

    //扫描
    private static int mainThreadId;
    private static Handler handler;

    private static BoxStore boxStore;
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

        mainThreadId = android.os.Process.myTid();// 获取当前主线程id
        handler = new Handler();

        boxStore = MyObjectBox.builder().androidContext(App.this).build();
//        if (BuildConfig.DEBUG) {
//            new AndroidObjectBrowser(boxStore).start(this);
//        }
        Bmob.initialize(this,"6900346c5d815b7112fda7ee8170cf07");
//        cn.bmob.v3.statistics.AppStat.i(appKey, channel);
//        JPushInterface.init(this);
//        RongIM.init(this);

        // Tencent类是SDK的主要实现类，开发者可通过Tencent类访问腾讯开放的OpenAPI。
        // 其中APP_ID是分配给第三方应用的appid，类型为String。
//        mTencent = Tencent.createInstance(Config.QQ_ID, this);

    }

    public static Context getContext() {
        return mContext;
    }

    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Handler getHandler() {
        return handler;
    }

    public static BoxStore getBoxStore() {
        return boxStore;
    }
    //    public static void setUser(User user){
//        new SharedData(mContext).saveUser(user);
//    }
    public static String getSharedData(String key) {
        return new SharedData(mContext).getString(key, "0");
    }

    public static void setSharedData(String key, String autoLogin) {
        new SharedData(mContext).putString(key, autoLogin);
    }

    public static void saveObj(String key, Object obj) {
        new SharedData(mContext).setObject(key, obj);
    }

    public static <T> T getObj(String key) {
        return new SharedData(mContext).getObject(key);
    }

    public static void clearShareData() {
        new SharedData(mContext).clearShareData();
    }

    //    public static String getIsVip(){
//        return new KeyValueStorage(getContext()).getString(Config.IS_VIP,"");
//    }
//    public static void setIsVip(){
//        new KeyValueStorage(getContext()).putString(Config.IS_VIP,"");
//    }

    //-------------------------HashMap数据操作
    // 存数据*/
    public static void setHashData(String key, Object value) {
        allData.put(key, value);
    }

    // 取数据
    public static Object getHashData(String key) {
        if (allData.containsKey(key)) {
            return allData.get(key);
        }
        return null;
    }

    // 删除一条数据
    public static void delHashDataBykey(String key) {
        if (allData.containsKey(key)) {
            allData.remove(key);
        }
    }

    // 删除所有数据
    public static void delAllHashData() {
        allData.clear();
    }

    //---------------------------END
//    public static Tencent getTencent(){
//        return mTencent;
//    }
//
//    public static String getObjectId(){
//        return BmobUser.getCurrentUser().getObjectId();
//    }


    //获取uuid，给当前用户设定一个唯一值，用于融云userid
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }




    public static void e(String tag, String str) {
        if (str == null || "".equals(str)) {
            Log.e(tag, "---------|\n" + "！！！！ 传值为空 / NULL" + "\n---------");
        } else {
            Log.e(tag, "---------|\n" + str + "\n---------");
        }
    }

    public static void e(String str) {
        if (str == null || "".equals(str)) {
            Log.e("qz测试Log", "---------|\n" + "！！！！ 传值为空 / NULL" + "\n---------");
        } else {
            Log.e("qz测试Log", "---------|\n" + str + "\n---------");
        }
    }
}