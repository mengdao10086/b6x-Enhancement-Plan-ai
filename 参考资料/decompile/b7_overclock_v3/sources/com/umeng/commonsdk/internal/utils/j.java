package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.z;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24107a = z.b().b(z.f23812r);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f24108b = "um_common_strength";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24109c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f24107a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString(f24109c, null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f24107a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString(f24109c, str).commit();
    }
}
