package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aa f23169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f23170b;

    public static synchronized String a(Context context) {
        try {
            if (context == null) {
                throw new RuntimeException("Context is null");
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            b(context);
            aa aaVar = f23169a;
            if (aaVar != null) {
                try {
                    return aaVar.a(context);
                } catch (Exception unused) {
                }
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void b(Context context) {
        if (f23169a != null || f23170b) {
            return;
        }
        synchronized (ab.class) {
            if (f23169a == null && !f23170b) {
                f23169a = ad.a(context);
                f23170b = true;
            }
        }
    }
}
