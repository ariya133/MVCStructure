package com.example.user.mvcstructure.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.example.user.mvcstructure.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class SceenUtil {

    private static SceenUtil instance;

    public static SceenUtil getInstance() {
        if (instance == null)
            instance = new SceenUtil();
        return instance;
    }

    private Context mContext;

    private SceenUtil() {

        mContext = Contextor.getInstance().getContext();
    }

    public int getScreenWidth(){
        WindowManager wm = (WindowManager)
                mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;

    }
    public int getScreenHeght(){
        WindowManager wm = (WindowManager)
                mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

}
