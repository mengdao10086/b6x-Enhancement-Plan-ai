package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f22808a;

    public static final Context a() {
        Context context = f22808a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context contextA = a();
        if (contextA != null) {
            return contextA.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        f22808a = context;
    }

    public static final File a(String str) {
        return k.h(a(), str);
    }
}
