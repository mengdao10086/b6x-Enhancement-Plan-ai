package hd;

import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g0<R, E extends Exception> implements RunnableFuture<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f30987a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f30988b = new f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f30989c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.p0
    public Exception f30990d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.p0
    public R f30991e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.p0
    public Thread f30992f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f30993g;

    public final void a() {
        this.f30988b.c();
    }

    public final void b() {
        this.f30987a.c();
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        synchronized (this.f30989c) {
            if (!this.f30993g && !this.f30988b.e()) {
                this.f30993g = true;
                c();
                Thread thread = this.f30992f;
                if (thread == null) {
                    this.f30987a.f();
                    this.f30988b.f();
                } else if (z10) {
                    thread.interrupt();
                }
                return true;
            }
            return false;
        }
    }

    @r0
    public abstract R d() throws Exception;

    @r0
    public final R e() throws ExecutionException {
        if (this.f30993g) {
            throw new CancellationException();
        }
        if (this.f30990d == null) {
            return this.f30991e;
        }
        throw new ExecutionException(this.f30990d);
    }

    @Override // java.util.concurrent.Future
    @r0
    public final R get() throws ExecutionException, InterruptedException {
        this.f30988b.a();
        return e();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f30993g;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f30988b.e();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.f30989c) {
            if (this.f30993g) {
                return;
            }
            this.f30992f = Thread.currentThread();
            this.f30987a.f();
            try {
                try {
                    this.f30991e = d();
                    synchronized (this.f30989c) {
                        this.f30988b.f();
                        this.f30992f = null;
                        Thread.interrupted();
                    }
                } catch (Exception e10) {
                    this.f30990d = e10;
                    synchronized (this.f30989c) {
                        this.f30988b.f();
                        this.f30992f = null;
                        Thread.interrupted();
                    }
                }
            } catch (Throwable th2) {
                synchronized (this.f30989c) {
                    this.f30988b.f();
                    this.f30992f = null;
                    Thread.interrupted();
                    throw th2;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @r0
    public final R get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f30988b.b(TimeUnit.MILLISECONDS.convert(j10, timeUnit))) {
            return e();
        }
        throw new TimeoutException();
    }
}
