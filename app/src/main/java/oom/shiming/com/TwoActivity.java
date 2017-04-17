package oom.shiming.com;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * @author shiming
 * @time 2017/4/17 15:24
 * @desc
 */

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        SystemClock.sleep(2000);
        System.out.println(MainActivity.mMainActivity+"shiming");
    }
}
