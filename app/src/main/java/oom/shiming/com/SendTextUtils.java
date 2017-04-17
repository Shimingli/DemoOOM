package oom.shiming.com;

import android.app.Dialog;
import android.content.Context;

/**
 * @author shiming
 * @time 2017/4/17 16:49
 * @desc
 */

public class SendTextUtils {
    //这里为静态的变量了，会释放不掉我们的这个context对象
    private static Dialog dialog;

    public static void send(Context context) {
        dialog = new Dialog(context);
        dialog.setTitle("shiming");
        dialog.show();
    }
}
