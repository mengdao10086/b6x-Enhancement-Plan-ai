package com.umeng.commonsdk.internal;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f24055b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f24056a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f24057c;

    private b(Context context) {
        this.f24056a = context;
        this.f24057c = new c(context);
    }

    public static synchronized b a(Context context) {
        if (f24055b == null) {
            f24055b = new b(context.getApplicationContext());
        }
        return f24055b;
    }

    public c a() {
        return this.f24057c;
    }
}
