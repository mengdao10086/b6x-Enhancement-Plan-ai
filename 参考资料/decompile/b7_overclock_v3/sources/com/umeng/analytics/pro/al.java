package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: loaded from: classes5.dex */
class al implements aa {
    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        String strD = null;
        try {
            if (gu.b.c()) {
                strD = gu.b.d(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strD;
    }
}
