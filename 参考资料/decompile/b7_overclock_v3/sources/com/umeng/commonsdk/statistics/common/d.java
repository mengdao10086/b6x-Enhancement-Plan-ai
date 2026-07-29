package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f24190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f24191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f24192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f24193d = z.b().b(z.f23807m);

    public d(Context context) {
    }

    public static synchronized d a(Context context) {
        f24191b = context.getApplicationContext();
        f24192c = context.getPackageName();
        if (f24190a == null) {
            f24190a = new d(context);
        }
        return f24190a;
    }

    private SharedPreferences f() {
        return f24191b.getSharedPreferences(f24193d + f24192c, 0);
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24191b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f24191b) > 0;
    }

    public String[] d() {
        try {
            SharedPreferences sharedPreferencesF = f();
            String string = sharedPreferencesF.getString("au_p", null);
            String string2 = sharedPreferencesF.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }

    public void a(int i10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24191b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i10).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24191b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f24191b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor editorEdit = f().edit();
        editorEdit.putString("au_p", str);
        editorEdit.putString("au_u", str2);
        editorEdit.commit();
    }
}
