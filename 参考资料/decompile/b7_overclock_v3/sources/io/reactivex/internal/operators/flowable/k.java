package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class k<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.flowable.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f33644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TimeUnit f33645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final xi.h0 f33646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Callable<U> f33647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f33648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f33649i;

    public static final class a<T, U extends Collection<? super T>> extends hj.h<T, U, U> implements bu.e, Runnable, io.reactivex.disposables.b {
        public final Callable<U> R7;
        public final long S7;
        public final TimeUnit T7;
        public final int U7;
        public final boolean V7;
        public final h0.c W7;
        public U X7;
        public io.reactivex.disposables.b Y7;
        public bu.e Z7;

        /* JADX INFO: renamed from: a8, reason: collision with root package name */
        public long f33650a8;

        /* JADX INFO: renamed from: b8, reason: collision with root package name */
        public long f33651b8;

        public a(bu.d<? super U> dVar, Callable<U> callable, long j10, TimeUnit timeUnit, int i10, boolean z10, h0.c cVar) {
            super(dVar, new MpscLinkedQueue());
            this.R7 = callable;
            this.S7 = j10;
            this.T7 = timeUnit;
            this.U7 = i10;
            this.V7 = z10;
            this.W7 = cVar;
        }

        @Override // bu.e
        public void cancel() {
            if (this.O7) {
                return;
            }
            this.O7 = true;
            dispose();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            synchronized (this) {
                this.X7 = null;
            }
            this.Z7.cancel();
            this.W7.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.W7.isDisposed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // hj.h, io.reactivex.internal.util.m
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean h(bu.d<? super U> dVar, U u6) {
            dVar.onNext(u6);
            return true;
        }

        @Override // bu.d
        public void onComplete() {
            U u6;
            synchronized (this) {
                u6 = this.X7;
                this.X7 = null;
            }
            if (u6 != null) {
                this.N7.offer(u6);
                this.P7 = true;
                if (a()) {
                    io.reactivex.internal.util.n.e(this.N7, this.M7, false, this, this);
                }
                this.W7.dispose();
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            synchronized (this) {
                this.X7 = null;
            }
            this.M7.onError(th2);
            this.W7.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            synchronized (this) {
                U u6 = this.X7;
                if (u6 == null) {
                    return;
                }
                u6.add(t10);
                if (u6.size() < this.U7) {
                    return;
                }
                this.X7 = null;
                this.f33650a8++;
                if (this.V7) {
                    this.Y7.dispose();
                }
                k(u6, false, this);
                try {
                    U u10 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.X7 = u10;
                        this.f33651b8++;
                    }
                    if (this.V7) {
                        h0.c cVar = this.W7;
                        long j10 = this.S7;
                        this.Y7 = cVar.d(this, j10, j10, this.T7);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    this.M7.onError(th2);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.Z7, eVar)) {
                this.Z7 = eVar;
                try {
                    this.X7 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                    this.M7.onSubscribe(this);
                    h0.c cVar = this.W7;
                    long j10 = this.S7;
                    this.Y7 = cVar.d(this, j10, j10, this.T7);
                    eVar.request(Long.MAX_VALUE);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.W7.dispose();
                    eVar.cancel();
                    EmptySubscription.error(th2, this.M7);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u10 = this.X7;
                    if (u10 != null && this.f33650a8 == this.f33651b8) {
                        this.X7 = u6;
                        k(u10, false, this);
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                this.M7.onError(th2);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>> extends hj.h<T, U, U> implements bu.e, Runnable, io.reactivex.disposables.b {
        public final Callable<U> R7;
        public final long S7;
        public final TimeUnit T7;
        public final xi.h0 U7;
        public bu.e V7;
        public U W7;
        public final AtomicReference<io.reactivex.disposables.b> X7;

        public b(bu.d<? super U> dVar, Callable<U> callable, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            super(dVar, new MpscLinkedQueue());
            this.X7 = new AtomicReference<>();
            this.R7 = callable;
            this.S7 = j10;
            this.T7 = timeUnit;
            this.U7 = h0Var;
        }

        @Override // bu.e
        public void cancel() {
            this.O7 = true;
            this.V7.cancel();
            DisposableHelper.dispose(this.X7);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            cancel();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.X7.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // hj.h, io.reactivex.internal.util.m
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean h(bu.d<? super U> dVar, U u6) {
            this.M7.onNext((Object) u6);
            return true;
        }

        @Override // bu.d
        public void onComplete() {
            DisposableHelper.dispose(this.X7);
            synchronized (this) {
                U u6 = this.W7;
                if (u6 == null) {
                    return;
                }
                this.W7 = null;
                this.N7.offer(u6);
                this.P7 = true;
                if (a()) {
                    io.reactivex.internal.util.n.e(this.N7, this.M7, false, null, this);
                }
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.X7);
            synchronized (this) {
                this.W7 = null;
            }
            this.M7.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            synchronized (this) {
                U u6 = this.W7;
                if (u6 != null) {
                    u6.add(t10);
                }
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.V7, eVar)) {
                this.V7 = eVar;
                try {
                    this.W7 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                    this.M7.onSubscribe(this);
                    if (this.O7) {
                        return;
                    }
                    eVar.request(Long.MAX_VALUE);
                    xi.h0 h0Var = this.U7;
                    long j10 = this.S7;
                    io.reactivex.disposables.b bVarH = h0Var.h(this, j10, j10, this.T7);
                    if (this.X7.compareAndSet(null, bVarH)) {
                        return;
                    }
                    bVarH.dispose();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    EmptySubscription.error(th2, this.M7);
                }
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u10 = this.W7;
                    if (u10 == null) {
                        return;
                    }
                    this.W7 = u6;
                    j(u10, false, this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                this.M7.onError(th2);
            }
        }
    }

    public static final class c<T, U extends Collection<? super T>> extends hj.h<T, U, U> implements bu.e, Runnable {
        public final Callable<U> R7;
        public final long S7;
        public final long T7;
        public final TimeUnit U7;
        public final h0.c V7;
        public final List<U> W7;
        public bu.e X7;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final U f33652a;

            public a(U u6) {
                this.f33652a = u6;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.W7.remove(this.f33652a);
                }
                c cVar = c.this;
                cVar.k(this.f33652a, false, cVar.V7);
            }
        }

        public c(bu.d<? super U> dVar, Callable<U> callable, long j10, long j11, TimeUnit timeUnit, h0.c cVar) {
            super(dVar, new MpscLinkedQueue());
            this.R7 = callable;
            this.S7 = j10;
            this.T7 = j11;
            this.U7 = timeUnit;
            this.V7 = cVar;
            this.W7 = new LinkedList();
        }

        @Override // bu.e
        public void cancel() {
            this.O7 = true;
            this.X7.cancel();
            this.V7.dispose();
            p();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // hj.h, io.reactivex.internal.util.m
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public boolean h(bu.d<? super U> dVar, U u6) {
            dVar.onNext(u6);
            return true;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // bu.d
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.W7);
                this.W7.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.N7.offer((U) ((Collection) it2.next()));
            }
            this.P7 = true;
            if (a()) {
                io.reactivex.internal.util.n.e(this.N7, this.M7, false, this.V7, this);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.P7 = true;
            this.V7.dispose();
            p();
            this.M7.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            synchronized (this) {
                Iterator<U> it2 = this.W7.iterator();
                while (it2.hasNext()) {
                    it2.next().add(t10);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.X7, eVar)) {
                this.X7 = eVar;
                try {
                    Collection collection = (Collection) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                    this.W7.add((U) collection);
                    this.M7.onSubscribe(this);
                    eVar.request(Long.MAX_VALUE);
                    h0.c cVar = this.V7;
                    long j10 = this.T7;
                    cVar.d(this, j10, j10, this.U7);
                    this.V7.c(new a(collection), this.S7, this.U7);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.V7.dispose();
                    eVar.cancel();
                    EmptySubscription.error(th2, this.M7);
                }
            }
        }

        public void p() {
            synchronized (this) {
                this.W7.clear();
            }
        }

        @Override // bu.e
        public void request(long j10) {
            l(j10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.O7) {
                return;
            }
            try {
                Collection collection = (Collection) io.reactivex.internal.functions.a.g(this.R7.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.O7) {
                        return;
                    }
                    this.W7.add((U) collection);
                    this.V7.c(new a(collection), this.S7, this.U7);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                this.M7.onError(th2);
            }
        }
    }

    public k(xi.j<T> jVar, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, Callable<U> callable, int i10, boolean z10) {
        super(jVar);
        this.f33643c = j10;
        this.f33644d = j11;
        this.f33645e = timeUnit;
        this.f33646f = h0Var;
        this.f33647g = callable;
        this.f33648h = i10;
        this.f33649i = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super U> dVar) {
        if (this.f33643c == this.f33644d && this.f33648h == Integer.MAX_VALUE) {
            this.f33524b.j6(new b(new io.reactivex.subscribers.e(dVar), this.f33647g, this.f33643c, this.f33645e, this.f33646f));
            return;
        }
        h0.c cVarD = this.f33646f.d();
        if (this.f33643c == this.f33644d) {
            this.f33524b.j6(new a(new io.reactivex.subscribers.e(dVar), this.f33647g, this.f33643c, this.f33645e, this.f33648h, this.f33649i, cVarD));
        } else {
            this.f33524b.j6(new c(new io.reactivex.subscribers.e(dVar), this.f33647g, this.f33643c, this.f33644d, this.f33645e, cVarD));
        }
    }
}
