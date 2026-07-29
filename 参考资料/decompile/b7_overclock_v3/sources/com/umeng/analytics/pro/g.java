package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SQLiteOpenHelper f23593b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f23594d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f23595a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SQLiteDatabase f23596c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f23597a = new g();

        private a() {
        }
    }

    public static g a(Context context) {
        if (f23594d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f23594d = applicationContext;
            f23593b = f.a(applicationContext);
        }
        return a.f23597a;
    }

    public synchronized void b() {
        try {
            if (this.f23595a.decrementAndGet() == 0) {
                this.f23596c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.f23595a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f23595a.incrementAndGet() == 1) {
            this.f23596c = f23593b.getWritableDatabase();
        }
        return this.f23596c;
    }
}
