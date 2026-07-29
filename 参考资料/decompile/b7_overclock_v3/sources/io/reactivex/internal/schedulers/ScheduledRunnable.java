package io.reactivex.internal.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class ScheduledRunnable extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, io.reactivex.disposables.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f35127a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f35128b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f35129c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f35130d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f35131e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f35132f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f35133g = 2;
    private static final long serialVersionUID = -6120223772001106981L;
    public final Runnable actual;

    public ScheduledRunnable(Runnable runnable, ej.a aVar) {
        super(3);
        this.actual = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f35130d) {
                return;
            }
            if (obj == f35128b) {
                future.cancel(false);
                return;
            } else if (obj == f35129c) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f35130d || obj5 == (obj3 = f35128b) || obj5 == (obj4 = f35129c)) {
                break;
            }
            boolean z10 = get(2) != Thread.currentThread();
            if (z10) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z10);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f35130d || obj == (obj2 = f35127a) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((ej.a) obj).c(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        Object obj = get(0);
        return obj == f35127a || obj == f35130d;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean zCompareAndSet;
        Object obj4;
        lazySet(2, Thread.currentThread());
        try {
            this.actual.run();
        } finally {
            try {
            } catch (Throwable th2) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        Object obj5 = get(0);
        if (obj5 != f35127a && compareAndSet(0, obj5, f35130d) && obj5 != null) {
            ((ej.a) obj5).c(this);
        }
        do {
            obj4 = get(1);
            if (obj4 == f35128b || obj4 == f35129c) {
                return;
            }
        } while (!compareAndSet(1, obj4, f35130d));
    }
}
