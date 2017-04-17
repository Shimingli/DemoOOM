package oom.shiming.com;

import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * @author shiming
 * @time 2017/4/17 15:24
 * @desc
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGoToActivity;
    //static
    //泄漏 activity 最简单的方法就是在 activity 类中定义一个 static 变量，并且将其指向一个运行中的 activity 实例。
    // 如果在 activity 的生命周期结束之前，没有清除这个引用，那它就会泄漏了。这是因为 activity
    // （例如 MainActivity） 的类对象是静态的，一旦加载，就会在 APP 运行时一直常驻内存，
    // 因此如果类对象不卸载，其静态成员就不会被垃圾回收。
    public static MainActivity mMainActivity;
    //view 持有静态的变量
//    view 被加入到界面中，它就会持有 context 的强引用，也就是我们的 activity。
// 由于我们通过一个静态成员引用了这个 view，
//    所以我们也就引用了 activity，因此 activity 就发生了泄漏。
//    所以一定不要把加载的 view 赋值给静态变量，如果你真的需要，那一定要确保在 activity 销毁之前将其从 view 层级中移除。
    private static View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        mGoToActivity = (Button) findViewById(R.id.btn_goto_two_activity);
        mGoToActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_goto_two_activity:
                setStatic();
                Intent intent = new Intent(this, TwoActivity.class);
                startActivity(intent);
//                SystemClock.sleep(600);
                finish();
                break;
        }
    }

    private void setStatic() {
//        mMainActivity = this;
        mView = findViewById(R.id.btn_goto_two_activity);
    }

    /**
     * 虽然走了这个ondestroy的方法，但是我们这个类其实没有被销毁掉
     * 所以会内存泄漏
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ondestroy");
    }
    private class InnerClass{

        InnerClass() {

        }
    }

}
