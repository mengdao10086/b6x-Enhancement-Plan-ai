package com.umeng.analytics.pro;

import android.content.Context;

/* JADX INFO: loaded from: classes5.dex */
public class af implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f23188a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ju.b f23189b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23190c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23191d = false;

    @Override // com.umeng.analytics.pro.aa
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f23190c) {
            ju.b bVar = new ju.b();
            this.f23189b = bVar;
            this.f23191d = bVar.a(context, null) == 1;
            this.f23190c = true;
        }
        am.a("getOAID", "isSupported", Boolean.valueOf(this.f23191d));
        if (this.f23191d && this.f23189b.j()) {
            return this.f23189b.c();
        }
        return null;
    }
}
