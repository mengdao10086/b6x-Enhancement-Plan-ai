package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicInteger;
import xi.g0;

/* JADX INFO: loaded from: classes5.dex */
public final class g {
    public g() {
        throw new IllegalStateException("No instances!");
    }

    public static void a(bu.d<?> dVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thC = atomicThrowable.c();
            if (thC != null) {
                dVar.onError(thC);
            } else {
                dVar.onComplete();
            }
        }
    }

    public static void b(g0<?> g0Var, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable thC = atomicThrowable.c();
            if (thC != null) {
                g0Var.onError(thC);
            } else {
                g0Var.onComplete();
            }
        }
    }

    public static void c(bu.d<?> dVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th2)) {
            kj.a.Y(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            dVar.onError(atomicThrowable.c());
        }
    }

    public static void d(g0<?> g0Var, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (!atomicThrowable.a(th2)) {
            kj.a.Y(th2);
        } else if (atomicInteger.getAndIncrement() == 0) {
            g0Var.onError(atomicThrowable.c());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(bu.d<? super T> dVar, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            dVar.onNext(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thC = atomicThrowable.c();
                if (thC != null) {
                    dVar.onError(thC);
                } else {
                    dVar.onComplete();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(g0<? super T> g0Var, T t10, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            g0Var.onNext(t10);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable thC = atomicThrowable.c();
                if (thC != null) {
                    g0Var.onError(thC);
                } else {
                    g0Var.onComplete();
                }
            }
        }
    }
}
