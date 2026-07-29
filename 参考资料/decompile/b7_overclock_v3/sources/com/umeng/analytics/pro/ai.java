package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;

/* JADX INFO: loaded from: classes5.dex */
public class ai implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f23193a = false;

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        try {
            if (!this.f23193a) {
                eu.a.a(context);
                this.f23193a = true;
            }
            if (eu.a.b()) {
                return eu.a.d(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
