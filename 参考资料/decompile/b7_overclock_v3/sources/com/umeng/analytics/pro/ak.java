package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: loaded from: classes5.dex */
public class ak implements aa {
    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        String strC = null;
        try {
            if (hu.e.b(context)) {
                strC = hu.e.c(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strC;
    }
}
