package oom.shiming.com;

import android.app.Application;
import android.content.Context;

/**
 * @author shiming
 * @time 2017/4/17 16:54
 * @desc
 */

public class DemoApp extends Application{

    public static DemoApp mDemoApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoApp = this;
    }
    public static Application getDemoApp(){
        return mDemoApp;
    }
    //不要对一个 Activity Context 保持长生命周期的引用。尽量在一切可以使用应用 ApplicationContext 代替 Context 的地方进行替换。
    public static Context getContext(){
        return mDemoApp.getApplicationContext();
    }
}
