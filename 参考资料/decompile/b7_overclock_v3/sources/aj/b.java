package aj;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.disposables.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f718d;

    public static final class a extends h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f721c;

        public a(Handler handler, boolean z10) {
            this.f719a = handler;
            this.f720b = z10;
        }

        @Override // xi.h0.c
        @SuppressLint({"NewApi"})
        public io.reactivex.disposables.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f721c) {
                return c.a();
            }
            RunnableC0014b runnableC0014b = new RunnableC0014b(this.f719a, kj.a.b0(runnable));
            Message messageObtain = Message.obtain(this.f719a, runnableC0014b);
            messageObtain.obj = this;
            if (this.f720b) {
                messageObtain.setAsynchronous(true);
            }
            this.f719a.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
            if (!this.f721c) {
                return runnableC0014b;
            }
            this.f719a.removeCallbacks(runnableC0014b);
            return c.a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f721c = true;
            this.f719a.removeCallbacksAndMessages(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f721c;
        }
    }

    /* JADX INFO: renamed from: aj.b$b, reason: collision with other inner class name */
    public static final class RunnableC0014b implements Runnable, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Runnable f723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f724c;

        public RunnableC0014b(Handler handler, Runnable runnable) {
            this.f722a = handler;
            this.f723b = runnable;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.f722a.removeCallbacks(this);
            this.f724c = true;
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f724c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f723b.run();
            } catch (Throwable th2) {
                kj.a.Y(th2);
            }
        }
    }

    public b(Handler handler, boolean z10) {
        this.f717c = handler;
        this.f718d = z10;
    }

    @Override // xi.h0
    public h0.c d() {
        return new a(this.f717c, this.f718d);
    }

    @Override // xi.h0
    @SuppressLint({"NewApi"})
    public io.reactivex.disposables.b g(Runnable runnable, long j10, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        RunnableC0014b runnableC0014b = new RunnableC0014b(this.f717c, kj.a.b0(runnable));
        Message messageObtain = Message.obtain(this.f717c, runnableC0014b);
        if (this.f718d) {
            messageObtain.setAsynchronous(true);
        }
        this.f717c.sendMessageDelayed(messageObtain, timeUnit.toMillis(j10));
        return runnableC0014b;
    }
}
