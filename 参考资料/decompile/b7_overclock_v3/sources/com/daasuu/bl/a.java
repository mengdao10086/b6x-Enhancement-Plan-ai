package com.daasuu.bl;

import android.content.Context;
import android.widget.PopupWindow;
import g.n0;
import h0.d;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static PopupWindow a(@n0 Context context, @n0 BubbleLayout bubbleLayout) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setContentView(bubbleLayout);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setWidth(-2);
        popupWindow.setHeight(-2);
        popupWindow.setAnimationStyle(android.R.style.Animation.Dialog);
        popupWindow.setBackgroundDrawable(d.i(context, R.drawable.popup_window_transparent));
        return popupWindow;
    }
}
