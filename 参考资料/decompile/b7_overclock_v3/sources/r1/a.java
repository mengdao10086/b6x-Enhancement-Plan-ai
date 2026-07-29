package r1;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.RestrictTo;
import androidx.core.os.OperationCanceledException;
import androidx.core.util.g0;
import androidx.loader.content.ModernAsyncTask;
import g.n0;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<D> extends c<D> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f47689p = "AsyncTaskLoader";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final boolean f47690q = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Executor f47691j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile a<D>.RunnableC0549a f47692k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile a<D>.RunnableC0549a f47693l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f47694m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f47695n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Handler f47696o;

    /* JADX INFO: renamed from: r1.a$a, reason: collision with other inner class name */
    public final class RunnableC0549a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final CountDownLatch f47697q = new CountDownLatch(1);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f47698r;

        public RunnableC0549a() {
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void m(D d10) {
            try {
                a.this.E(this, d10);
            } finally {
                this.f47697q.countDown();
            }
        }

        @Override // androidx.loader.content.ModernAsyncTask
        public void n(D d10) {
            try {
                a.this.F(this, d10);
            } finally {
                this.f47697q.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47698r = false;
            a.this.G();
        }

        @Override // androidx.loader.content.ModernAsyncTask
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public D b(Void... voidArr) {
            try {
                return (D) a.this.K();
            } catch (OperationCanceledException e10) {
                if (k()) {
                    return null;
                }
                throw e10;
            }
        }

        public void v() {
            try {
                this.f47697q.await();
            } catch (InterruptedException unused) {
            }
        }
    }

    public a(@n0 Context context) {
        this(context, ModernAsyncTask.f6293l);
    }

    public void D() {
    }

    public void E(a<D>.RunnableC0549a runnableC0549a, D d10) {
        J(d10);
        if (this.f47693l == runnableC0549a) {
            x();
            this.f47695n = SystemClock.uptimeMillis();
            this.f47693l = null;
            e();
            G();
        }
    }

    public void F(a<D>.RunnableC0549a runnableC0549a, D d10) {
        if (this.f47692k != runnableC0549a) {
            E(runnableC0549a, d10);
            return;
        }
        if (k()) {
            J(d10);
            return;
        }
        c();
        this.f47695n = SystemClock.uptimeMillis();
        this.f47692k = null;
        f(d10);
    }

    public void G() {
        if (this.f47693l != null || this.f47692k == null) {
            return;
        }
        if (this.f47692k.f47698r) {
            this.f47692k.f47698r = false;
            this.f47696o.removeCallbacks(this.f47692k);
        }
        if (this.f47694m <= 0 || SystemClock.uptimeMillis() >= this.f47695n + this.f47694m) {
            this.f47692k.e(this.f47691j, null);
        } else {
            this.f47692k.f47698r = true;
            this.f47696o.postAtTime(this.f47692k, this.f47695n + this.f47694m);
        }
    }

    public boolean H() {
        return this.f47693l != null;
    }

    @p0
    public abstract D I();

    public void J(@p0 D d10) {
    }

    @p0
    public D K() {
        return I();
    }

    public void L(long j10) {
        this.f47694m = j10;
        if (j10 != 0) {
            this.f47696o = new Handler();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void M() {
        a<D>.RunnableC0549a runnableC0549a = this.f47692k;
        if (runnableC0549a != null) {
            runnableC0549a.v();
        }
    }

    @Override // r1.c
    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.g(str, fileDescriptor, printWriter, strArr);
        if (this.f47692k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f47692k);
            printWriter.print(" waiting=");
            printWriter.println(this.f47692k.f47698r);
        }
        if (this.f47693l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f47693l);
            printWriter.print(" waiting=");
            printWriter.println(this.f47693l.f47698r);
        }
        if (this.f47694m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            g0.c(this.f47694m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            g0.b(this.f47695n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    @Override // r1.c
    public boolean o() {
        if (this.f47692k == null) {
            return false;
        }
        if (!this.f47712e) {
            this.f47715h = true;
        }
        if (this.f47693l != null) {
            if (this.f47692k.f47698r) {
                this.f47692k.f47698r = false;
                this.f47696o.removeCallbacks(this.f47692k);
            }
            this.f47692k = null;
            return false;
        }
        if (this.f47692k.f47698r) {
            this.f47692k.f47698r = false;
            this.f47696o.removeCallbacks(this.f47692k);
            this.f47692k = null;
            return false;
        }
        boolean zA = this.f47692k.a(false);
        if (zA) {
            this.f47693l = this.f47692k;
            D();
        }
        this.f47692k = null;
        return zA;
    }

    @Override // r1.c
    public void q() {
        super.q();
        b();
        this.f47692k = new RunnableC0549a();
        G();
    }

    public a(@n0 Context context, @n0 Executor executor) {
        super(context);
        this.f47695n = -10000L;
        this.f47691j = executor;
    }
}
