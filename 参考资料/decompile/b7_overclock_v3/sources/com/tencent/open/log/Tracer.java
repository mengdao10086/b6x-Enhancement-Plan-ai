package com.tencent.open.log;

import com.tencent.open.log.d;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Tracer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f22736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f22737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f22738c;

    public Tracer() {
        this(c.f22762a, true, g.f22783a);
    }

    public void a(int i10, Thread thread, long j10, String str, String str2, Throwable th2) {
        if (d() && d.a.a(this.f22736a, i10)) {
            doTrace(i10, thread, j10, str, str2, th2);
        }
    }

    public boolean d() {
        return this.f22737b;
    }

    public abstract void doTrace(int i10, Thread thread, long j10, String str, String str2, Throwable th2);

    public g e() {
        return this.f22738c;
    }

    public Tracer(int i10, boolean z10, g gVar) {
        this.f22736a = c.f22762a;
        this.f22737b = true;
        this.f22738c = g.f22783a;
        a(i10);
        a(z10);
        a(gVar);
    }

    public void a(int i10) {
        this.f22736a = i10;
    }

    public void a(boolean z10) {
        this.f22737b = z10;
    }

    public void a(g gVar) {
        this.f22738c = gVar;
    }
}
