package com.umeng.umlink;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umeng_general_config", 0);
        }
        return null;
    }
}
