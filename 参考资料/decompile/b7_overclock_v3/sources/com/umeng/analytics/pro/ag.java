package com.umeng.analytics.pro;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
class ag implements aa {
    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zC = fu.b.c();
        am.a("getOAID", "isSupported", Boolean.valueOf(zC));
        if (zC) {
            return fu.b.d(context);
        }
        return null;
    }
}
