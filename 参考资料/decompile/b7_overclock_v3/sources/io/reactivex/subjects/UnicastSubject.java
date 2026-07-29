package io.reactivex.subjects;

import bj.e;
import bj.f;
import fj.o;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class UnicastSubject<T> extends c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final io.reactivex.internal.queue.a<T> f35413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<g0<? super T>> f35414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Runnable> f35415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f35416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f35417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f35418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Throwable f35419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f35420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final BasicIntQueueDisposable<T> f35421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f35422j;

    public final class UnicastQueueDisposable extends BasicIntQueueDisposable<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        public UnicastQueueDisposable() {
        }

        @Override // fj.o
        public void clear() {
            UnicastSubject.this.f35413a.clear();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (UnicastSubject.this.f35417e) {
                return;
            }
            UnicastSubject.this.f35417e = true;
            UnicastSubject.this.s8();
            UnicastSubject.this.f35414b.lazySet(null);
            if (UnicastSubject.this.f35421i.getAndIncrement() == 0) {
                UnicastSubject.this.f35414b.lazySet(null);
                UnicastSubject unicastSubject = UnicastSubject.this;
                if (unicastSubject.f35422j) {
                    return;
                }
                unicastSubject.f35413a.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return UnicastSubject.this.f35417e;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return UnicastSubject.this.f35413a.isEmpty();
        }

        @Override // fj.o
        @f
        public T poll() throws Exception {
            return UnicastSubject.this.f35413a.poll();
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            UnicastSubject.this.f35422j = true;
            return 2;
        }
    }

    public UnicastSubject(int i10, boolean z10) {
        this.f35413a = new io.reactivex.internal.queue.a<>(io.reactivex.internal.functions.a.h(i10, "capacityHint"));
        this.f35415c = new AtomicReference<>();
        this.f35416d = z10;
        this.f35414b = new AtomicReference<>();
        this.f35420h = new AtomicBoolean();
        this.f35421i = new UnicastQueueDisposable();
    }

    @bj.c
    @e
    public static <T> UnicastSubject<T> n8() {
        return new UnicastSubject<>(z.U(), true);
    }

    @bj.c
    @e
    public static <T> UnicastSubject<T> o8(int i10) {
        return new UnicastSubject<>(i10, true);
    }

    @bj.c
    @e
    public static <T> UnicastSubject<T> p8(int i10, Runnable runnable) {
        return new UnicastSubject<>(i10, runnable, true);
    }

    @bj.c
    @e
    public static <T> UnicastSubject<T> q8(int i10, Runnable runnable, boolean z10) {
        return new UnicastSubject<>(i10, runnable, z10);
    }

    @bj.c
    @e
    public static <T> UnicastSubject<T> r8(boolean z10) {
        return new UnicastSubject<>(z.U(), z10);
    }

    @Override // xi.z
    public void I5(g0<? super T> g0Var) {
        if (this.f35420h.get() || !this.f35420h.compareAndSet(false, true)) {
            EmptyDisposable.error(new IllegalStateException("Only a single observer allowed."), g0Var);
            return;
        }
        g0Var.onSubscribe(this.f35421i);
        this.f35414b.lazySet(g0Var);
        if (this.f35417e) {
            this.f35414b.lazySet(null);
        } else {
            t8();
        }
    }

    @Override // io.reactivex.subjects.c
    @f
    public Throwable i8() {
        if (this.f35418f) {
            return this.f35419g;
        }
        return null;
    }

    @Override // io.reactivex.subjects.c
    public boolean j8() {
        return this.f35418f && this.f35419g == null;
    }

    @Override // io.reactivex.subjects.c
    public boolean k8() {
        return this.f35414b.get() != null;
    }

    @Override // io.reactivex.subjects.c
    public boolean l8() {
        return this.f35418f && this.f35419g != null;
    }

    @Override // xi.g0
    public void onComplete() {
        if (this.f35418f || this.f35417e) {
            return;
        }
        this.f35418f = true;
        s8();
        t8();
    }

    @Override // xi.g0
    public void onError(Throwable th2) {
        io.reactivex.internal.functions.a.g(th2, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35418f || this.f35417e) {
            kj.a.Y(th2);
            return;
        }
        this.f35419g = th2;
        this.f35418f = true;
        s8();
        t8();
    }

    @Override // xi.g0
    public void onNext(T t10) {
        io.reactivex.internal.functions.a.g(t10, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        if (this.f35418f || this.f35417e) {
            return;
        }
        this.f35413a.offer(t10);
        t8();
    }

    @Override // xi.g0
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (this.f35418f || this.f35417e) {
            bVar.dispose();
        }
    }

    public void s8() {
        Runnable runnable = this.f35415c.get();
        if (runnable == null || !this.f35415c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    public void t8() {
        if (this.f35421i.getAndIncrement() != 0) {
            return;
        }
        g0<? super T> g0Var = this.f35414b.get();
        int iAddAndGet = 1;
        while (g0Var == null) {
            iAddAndGet = this.f35421i.addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            } else {
                g0Var = this.f35414b.get();
            }
        }
        if (this.f35422j) {
            u8(g0Var);
        } else {
            v8(g0Var);
        }
    }

    public void u8(g0<? super T> g0Var) {
        io.reactivex.internal.queue.a<T> aVar = this.f35413a;
        int iAddAndGet = 1;
        boolean z10 = !this.f35416d;
        while (!this.f35417e) {
            boolean z11 = this.f35418f;
            if (z10 && z11 && x8(aVar, g0Var)) {
                return;
            }
            g0Var.onNext(null);
            if (z11) {
                w8(g0Var);
                return;
            } else {
                iAddAndGet = this.f35421i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
        this.f35414b.lazySet(null);
    }

    public void v8(g0<? super T> g0Var) {
        io.reactivex.internal.queue.a<T> aVar = this.f35413a;
        boolean z10 = !this.f35416d;
        boolean z11 = true;
        int iAddAndGet = 1;
        while (!this.f35417e) {
            boolean z12 = this.f35418f;
            T tPoll = this.f35413a.poll();
            boolean z13 = tPoll == null;
            if (z12) {
                if (z10 && z11) {
                    if (x8(aVar, g0Var)) {
                        return;
                    } else {
                        z11 = false;
                    }
                }
                if (z13) {
                    w8(g0Var);
                    return;
                }
            }
            if (z13) {
                iAddAndGet = this.f35421i.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else {
                g0Var.onNext(tPoll);
            }
        }
        this.f35414b.lazySet(null);
        aVar.clear();
    }

    public void w8(g0<? super T> g0Var) {
        this.f35414b.lazySet(null);
        Throwable th2 = this.f35419g;
        if (th2 != null) {
            g0Var.onError(th2);
        } else {
            g0Var.onComplete();
        }
    }

    public boolean x8(o<T> oVar, g0<? super T> g0Var) {
        Throwable th2 = this.f35419g;
        if (th2 == null) {
            return false;
        }
        this.f35414b.lazySet(null);
        oVar.clear();
        g0Var.onError(th2);
        return true;
    }

    public UnicastSubject(int i10, Runnable runnable) {
        this(i10, runnable, true);
    }

    public UnicastSubject(int i10, Runnable runnable, boolean z10) {
        this.f35413a = new io.reactivex.internal.queue.a<>(io.reactivex.internal.functions.a.h(i10, "capacityHint"));
        this.f35415c = new AtomicReference<>(io.reactivex.internal.functions.a.g(runnable, "onTerminate"));
        this.f35416d = z10;
        this.f35414b = new AtomicReference<>();
        this.f35420h = new AtomicBoolean();
        this.f35421i = new UnicastQueueDisposable();
    }
}
