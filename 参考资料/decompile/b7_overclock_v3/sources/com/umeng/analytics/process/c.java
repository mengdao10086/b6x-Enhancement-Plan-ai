package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f23858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f23859b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f23860c;

    private c() {
    }

    public static c a(Context context) {
        if (f23858a == null) {
            synchronized (c.class) {
                if (f23858a == null) {
                    f23858a = new c();
                }
            }
        }
        c cVar = f23858a;
        cVar.f23860c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f23859b.get(str) != null) {
            return this.f23859b.get(str);
        }
        a aVarA = a.a(this.f23860c, str);
        this.f23859b.put(str, aVarA);
        return aVarA;
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private AtomicInteger f23861a = new AtomicInteger();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SQLiteOpenHelper f23862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private SQLiteDatabase f23863c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f23862b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.f23861a.decrementAndGet() == 0) {
                    this.f23863c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            if (this.f23861a.incrementAndGet() == 1) {
                this.f23863c = this.f23862b.getWritableDatabase();
            }
            return this.f23863c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
