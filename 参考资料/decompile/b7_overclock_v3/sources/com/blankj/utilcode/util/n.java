package com.blankj.utilcode.util;

import android.app.ActivityManager;
import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public n() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    @g.v0(api = 19)
    public static void a() {
        ((ActivityManager) j1.a().getSystemService(androidx.appcompat.widget.c.f2369r)).clearApplicationUserData();
    }

    public static boolean b(String str) {
        return l1.u(l1.P(str));
    }

    public static boolean c() {
        return "mounted".equals(Environment.getExternalStorageState()) && l1.u(j1.a().getExternalCacheDir());
    }

    public static boolean d() {
        return l1.u(j1.a().getCacheDir());
    }

    public static boolean e(String str) {
        return j1.a().deleteDatabase(str);
    }

    public static boolean f() {
        return l1.u(new File(j1.a().getFilesDir().getParent(), "databases"));
    }

    public static boolean g() {
        return l1.u(j1.a().getFilesDir());
    }

    public static boolean h() {
        return l1.u(new File(j1.a().getFilesDir().getParent(), "shared_prefs"));
    }
}
