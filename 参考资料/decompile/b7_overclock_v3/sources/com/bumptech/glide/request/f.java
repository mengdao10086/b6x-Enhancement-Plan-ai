package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import g.b0;
import g.i1;
import g.n0;
import g.p0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import s4.o;
import s4.p;

/* JADX INFO: loaded from: classes2.dex */
public class f<R> implements d<R>, g<R> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f12745k = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f12749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    @b0("this")
    public R f12750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    @b0("this")
    public e f12751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @b0("this")
    public boolean f12752g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b0("this")
    public boolean f12753h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @b0("this")
    public boolean f12754i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    @b0("this")
    public GlideException f12755j;

    @i1
    public static class a {
        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j10) throws InterruptedException {
            obj.wait(j10);
        }
    }

    public f(int i10, int i11) {
        this(i10, i11, true, f12745k);
    }

    @Override // p4.m
    public void a() {
    }

    @Override // p4.m
    public void b() {
    }

    @Override // p4.m
    public void c() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        synchronized (this) {
            if (isDone()) {
                return false;
            }
            this.f12752g = true;
            this.f12749d.a(this);
            e eVar = null;
            if (z10) {
                e eVar2 = this.f12751f;
                this.f12751f = null;
                eVar = eVar2;
            }
            if (eVar != null) {
                eVar.clear();
            }
            return true;
        }
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean d(@p0 GlideException glideException, Object obj, p<R> pVar, boolean z10) {
        this.f12754i = true;
        this.f12755j = glideException;
        this.f12749d.a(this);
        return false;
    }

    @Override // com.bumptech.glide.request.g
    public synchronized boolean e(R r10, Object obj, p<R> pVar, DataSource dataSource, boolean z10) {
        this.f12753h = true;
        this.f12750e = r10;
        this.f12749d.a(this);
        return false;
    }

    @Override // s4.p
    public void f(@n0 o oVar) {
    }

    @Override // s4.p
    public synchronized void g(@n0 R r10, @p0 t4.f<? super R> fVar) {
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return h(null);
        } catch (TimeoutException e10) {
            throw new AssertionError(e10);
        }
    }

    public final synchronized R h(Long l10) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f12748c && !isDone()) {
            v4.o.a();
        }
        if (this.f12752g) {
            throw new CancellationException();
        }
        if (this.f12754i) {
            throw new ExecutionException(this.f12755j);
        }
        if (this.f12753h) {
            return this.f12750e;
        }
        if (l10 == null) {
            this.f12749d.b(this, 0L);
        } else if (l10.longValue() > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jLongValue = l10.longValue() + jCurrentTimeMillis;
            while (!isDone() && jCurrentTimeMillis < jLongValue) {
                this.f12749d.b(this, jLongValue - jCurrentTimeMillis);
                jCurrentTimeMillis = System.currentTimeMillis();
            }
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.f12754i) {
            throw new ExecutionException(this.f12755j);
        }
        if (this.f12752g) {
            throw new CancellationException();
        }
        if (!this.f12753h) {
            throw new TimeoutException();
        }
        return this.f12750e;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f12752g;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0010  */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean isDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f12752g     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.f12753h     // Catch: java.lang.Throwable -> L13
            if (r0 != 0) goto L10
            boolean r0 = r1.f12754i     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            monitor-exit(r1)
            return r0
        L13:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.f.isDone():boolean");
    }

    @Override // s4.p
    public synchronized void l(@p0 e eVar) {
        this.f12751f = eVar;
    }

    @Override // s4.p
    public void m(@n0 o oVar) {
        oVar.e(this.f12746a, this.f12747b);
    }

    @Override // s4.p
    public synchronized void n(@p0 Drawable drawable) {
    }

    @Override // s4.p
    public void q(@p0 Drawable drawable) {
    }

    @Override // s4.p
    @p0
    public synchronized e r() {
        return this.f12751f;
    }

    @Override // s4.p
    public void s(@p0 Drawable drawable) {
    }

    public String toString() {
        e eVar;
        String str;
        String str2 = super.toString() + "[status=";
        synchronized (this) {
            eVar = null;
            if (this.f12752g) {
                str = "CANCELLED";
            } else if (this.f12754i) {
                str = "FAILURE";
            } else if (this.f12753h) {
                str = "SUCCESS";
            } else {
                str = "PENDING";
                eVar = this.f12751f;
            }
        }
        if (eVar == null) {
            return str2 + str + "]";
        }
        return str2 + str + ", request=[" + eVar + "]]";
    }

    public f(int i10, int i11, boolean z10, a aVar) {
        this.f12746a = i10;
        this.f12747b = i11;
        this.f12748c = z10;
        this.f12749d = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j10, @n0 TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return h(Long.valueOf(timeUnit.toMillis(j10)));
    }
}
