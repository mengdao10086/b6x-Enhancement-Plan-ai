package fi;

import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f28519a;

    public c(String str) {
        this.f28519a = str;
        b.p(null);
    }

    public void a(String str, Object... objArr) {
        if (b.i()) {
            b.e(str, objArr);
        }
    }

    public void b(String str, Object... objArr) {
        if (b.j()) {
            b.e(str, objArr);
        }
    }

    public void c(Throwable th2, String str, Object... objArr) {
        if (b.j()) {
            b.e(str, objArr);
        }
    }

    public void d(String str, Object... objArr) {
        if (b.k()) {
            b.e(str, objArr);
        }
    }

    public void e(String str, Object... objArr) {
        if (b.l()) {
            b.e(str, objArr);
        }
    }

    public void f(String str, Object... objArr) {
        if (b.m()) {
            b.e(str, objArr);
        }
    }

    public void g(Throwable th2, String str, Object... objArr) {
        if (b.m()) {
            b.e(str, objArr);
        }
    }

    public void h(String str, Object... objArr) {
        if (b.j()) {
            Log.wtf(this.f28519a, b.e(str, objArr));
        }
    }

    public void i(Throwable th2, String str, Object... objArr) {
        if (b.j()) {
            Log.wtf(this.f28519a, b.e(str, objArr), th2);
        }
    }
}
