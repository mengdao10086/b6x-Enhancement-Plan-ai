package com.example.waspwingtempctrl.ui;

/**
 * 选区背景清除的对外入口：Activity 在 {@code dispatchTouchEvent} 的 ACTION_DOWN 上调用。
 * 实现在 {@link TextCopy}（包内），这里只把那一件事暴露给 app 包的 Activity。
 */
public final class SelectionDismiss {

    private SelectionDismiss() {
    }

    /** 触点（屏幕坐标）不在任何有选区的文本上时，清掉选区并结束浮条。 */
    public static void onDown(float rawX, float rawY) {
        TextCopy.dismissSelectionsOutside(rawX, rawY);
    }
}
