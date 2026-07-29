package v0;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.RestrictTo;
import g.b0;
import g.i1;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@Deprecated
public class j {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f52527i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f52528j = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0("mLock")
    public HandlerThread f52530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("mLock")
    public Handler f52531c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f52536h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f52529a = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler.Callback f52533e = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b0("mLock")
    public int f52532d = 0;

    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                j.this.c();
                return true;
            }
            if (i10 != 1) {
                return true;
            }
            j.this.d((Runnable) message.obj);
            return true;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f52538a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f52539b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ d f52540c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f52542a;

            public a(Object obj) {
                this.f52542a = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.f52540c.a(this.f52542a);
            }
        }

        public b(Callable callable, Handler handler, d dVar) {
            this.f52538a = callable;
            this.f52539b = handler;
            this.f52540c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object objCall;
            try {
                objCall = this.f52538a.call();
            } catch (Exception unused) {
                objCall = null;
            }
            this.f52539b.post(new a(objCall));
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtomicReference f52544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Callable f52545b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReentrantLock f52546c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AtomicBoolean f52547d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Condition f52548e;

        public c(AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
            this.f52544a = atomicReference;
            this.f52545b = callable;
            this.f52546c = reentrantLock;
            this.f52547d = atomicBoolean;
            this.f52548e = condition;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f52544a.set(this.f52545b.call());
            } catch (Exception unused) {
            }
            this.f52546c.lock();
            try {
                this.f52547d.set(false);
                this.f52548e.signal();
            } finally {
                this.f52546c.unlock();
            }
        }
    }

    public interface d<T> {
        void a(T t10);
    }

    public j(String str, int i10, int i11) {
        this.f52536h = str;
        this.f52535g = i10;
        this.f52534f = i11;
    }

    @i1
    public int a() {
        int i10;
        synchronized (this.f52529a) {
            i10 = this.f52532d;
        }
        return i10;
    }

    @i1
    public boolean b() {
        boolean z10;
        synchronized (this.f52529a) {
            z10 = this.f52530b != null;
        }
        return z10;
    }

    public void c() {
        synchronized (this.f52529a) {
            if (this.f52531c.hasMessages(1)) {
                return;
            }
            this.f52530b.quit();
            this.f52530b = null;
            this.f52531c = null;
        }
    }

    public void d(Runnable runnable) {
        runnable.run();
        synchronized (this.f52529a) {
            this.f52531c.removeMessages(0);
            Handler handler = this.f52531c;
            handler.sendMessageDelayed(handler.obtainMessage(0), this.f52534f);
        }
    }

    public final void e(Runnable runnable) {
        synchronized (this.f52529a) {
            if (this.f52530b == null) {
                HandlerThread handlerThread = new HandlerThread(this.f52536h, this.f52535g);
                this.f52530b = handlerThread;
                handlerThread.start();
                this.f52531c = new Handler(this.f52530b.getLooper(), this.f52533e);
                this.f52532d++;
            }
            this.f52531c.removeMessages(0);
            Handler handler = this.f52531c;
            handler.sendMessage(handler.obtainMessage(1, runnable));
        }
    }

    public <T> void f(Callable<T> callable, d<T> dVar) {
        e(new b(callable, v0.b.a(), dVar));
    }

    public <T> T g(Callable<T> callable, int i10) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionNewCondition = reentrantLock.newCondition();
        AtomicReference atomicReference = new AtomicReference();
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        e(new c(atomicReference, callable, reentrantLock, atomicBoolean, conditionNewCondition));
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i10);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }
}
