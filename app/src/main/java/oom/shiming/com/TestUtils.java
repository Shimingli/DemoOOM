package oom.shiming.com;

import android.content.Context;

/**
 * @author shiming
 * @time 2017/4/17 19:27
 * @desc
 */

public class TestUtils {
    private static  TestUtils mUtils;
    private Context mContext;
    private TestUtils(Context context){
        mContext=context;
    }
    public static TestUtils getmUtils(Context context){
        if (mUtils!=null){
            mUtils=new TestUtils(context);
        }
        return mUtils;
    }
}
