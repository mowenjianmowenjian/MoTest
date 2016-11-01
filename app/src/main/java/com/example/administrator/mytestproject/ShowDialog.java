package com.example.administrator.mytestproject;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2016/9/27.
 */
public class ShowDialog  extends Dialog {


    private final Context context;

    public ShowDialog(Context context) {
        super(context);

        setContentView(R.layout.popwindow_onegu);
        this.context = context;
        Window dialogWindow = getWindow();
        dialogWindow.setWindowAnimations(R.style.AnimationPreview); // 设置窗口弹出动画
        dialogWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE
                | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); //
        p.width = (int) (getScreenWidth(context));
        p.height = (int) (getScreenHeight(context));
        dialogWindow.setAttributes(p);

        dialogWindow.setBackgroundDrawableResource(R.color.colorWhite); //设置对话框背景为透明

    }
    /**
     * 得到屏幕宽度
     *
     * @return 单位:px
     */
    public static int getScreenWidth(Context context) {
        int screenWidth;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        screenWidth = dm.widthPixels;
        return screenWidth;
    }

    /**
     * 得到屏幕高度
     *
     * @return 单位:px
     */
    public static int getScreenHeight(Context context) {
        int screenHeight;
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        screenHeight = dm.heightPixels;
        return screenHeight;
    }
}
