package com.umeng.analytics.pro;

import com.umeng.analytics.AnalyticsConfig;
import java.lang.Thread;

/* JADX INFO: loaded from: classes5.dex */
public class p implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f23752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private t f23753b;

    public p() {
        if (Thread.getDefaultUncaughtExceptionHandler() == this) {
            return;
        }
        this.f23752a = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void a(t tVar) {
        this.f23753b = tVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        a(th2);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f23752a;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == Thread.getDefaultUncaughtExceptionHandler()) {
            return;
        }
        this.f23752a.uncaughtException(thread, th2);
    }

    private void a(Throwable th2) {
        if (AnalyticsConfig.CATCH_EXCEPTION) {
            this.f23753b.a(th2);
        } else {
            this.f23753b.a(null);
        }
    }
}
