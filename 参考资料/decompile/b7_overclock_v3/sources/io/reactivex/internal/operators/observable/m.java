package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.queue.MpscLinkedQueue;
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
public final class m<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f34588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f34589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f34590d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f34591e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable<U> f34592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f34593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f34594h;

    public static final class a<T, U extends Collection<? super T>> extends gj.k<T, U, U> implements Runnable, io.reactivex.disposables.b {
        public final long C2;
        public final int E7;
        public final boolean F7;
        public final h0.c G7;
        public U H7;
        public io.reactivex.disposables.b I7;
        public io.reactivex.disposables.b J7;
        public final TimeUnit K2;
        public long K7;
        public long L7;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final Callable<U> f34595v2;

        public a(xi.g0<? super U> g0Var, Callable<U> callable, long j10, TimeUnit timeUnit, int i10, boolean z10, h0.c cVar) {
            super(g0Var, new MpscLinkedQueue());
            this.f34595v2 = callable;
            this.C2 = j10;
            this.K2 = timeUnit;
            this.E7 = i10;
            this.F7 = z10;
            this.G7 = cVar;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f29584v1) {
                return;
            }
            this.f29584v1 = true;
            this.J7.dispose();
            this.G7.dispose();
            synchronized (this) {
                this.H7 = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29584v1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // gj.k, io.reactivex.internal.util.j
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(xi.g0<? super U> g0Var, U u6) {
            g0Var.onNext(u6);
        }

        @Override // xi.g0
        public void onComplete() {
            U u6;
            this.G7.dispose();
            synchronized (this) {
                u6 = this.H7;
                this.H7 = null;
            }
            if (u6 != null) {
                this.f29583k1.offer(u6);
                this.C1 = true;
                if (a()) {
                    io.reactivex.internal.util.n.d(this.f29583k1, this.K0, false, this, this);
                }
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            synchronized (this) {
                this.H7 = null;
            }
            this.K0.onError(th2);
            this.G7.dispose();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            synchronized (this) {
                U u6 = this.H7;
                if (u6 == null) {
                    return;
                }
                u6.add(t10);
                if (u6.size() < this.E7) {
                    return;
                }
                this.H7 = null;
                this.K7++;
                if (this.F7) {
                    this.I7.dispose();
                }
                i(u6, false, this);
                try {
                    U u10 = (U) io.reactivex.internal.functions.a.g(this.f34595v2.call(), "The buffer supplied is null");
                    synchronized (this) {
                        this.H7 = u10;
                        this.L7++;
                    }
                    if (this.F7) {
                        h0.c cVar = this.G7;
                        long j10 = this.C2;
                        this.I7 = cVar.d(this, j10, j10, this.K2);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.K0.onError(th2);
                    dispose();
                }
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.J7, bVar)) {
                this.J7 = bVar;
                try {
                    this.H7 = (U) io.reactivex.internal.functions.a.g(this.f34595v2.call(), "The buffer supplied is null");
                    this.K0.onSubscribe(this);
                    h0.c cVar = this.G7;
                    long j10 = this.C2;
                    this.I7 = cVar.d(this, j10, j10, this.K2);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.K0);
                    this.G7.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u6 = (U) io.reactivex.internal.functions.a.g(this.f34595v2.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u10 = this.H7;
                    if (u10 != null && this.K7 == this.L7) {
                        this.H7 = u6;
                        i(u10, false, this);
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.K0.onError(th2);
            }
        }
    }

    public static final class b<T, U extends Collection<? super T>> extends gj.k<T, U, U> implements Runnable, io.reactivex.disposables.b {
        public final long C2;
        public final xi.h0 E7;
        public io.reactivex.disposables.b F7;
        public U G7;
        public final AtomicReference<io.reactivex.disposables.b> H7;
        public final TimeUnit K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final Callable<U> f34596v2;

        public b(xi.g0<? super U> g0Var, Callable<U> callable, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
            super(g0Var, new MpscLinkedQueue());
            this.H7 = new AtomicReference<>();
            this.f34596v2 = callable;
            this.C2 = j10;
            this.K2 = timeUnit;
            this.E7 = h0Var;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this.H7);
            this.F7.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.H7.get() == DisposableHelper.DISPOSED;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // gj.k, io.reactivex.internal.util.j
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(xi.g0<? super U> g0Var, U u6) {
            this.K0.onNext((Object) u6);
        }

        @Override // xi.g0
        public void onComplete() {
            U u6;
            synchronized (this) {
                u6 = this.G7;
                this.G7 = null;
            }
            if (u6 != null) {
                this.f29583k1.offer(u6);
                this.C1 = true;
                if (a()) {
                    io.reactivex.internal.util.n.d(this.f29583k1, this.K0, false, null, this);
                }
            }
            DisposableHelper.dispose(this.H7);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            synchronized (this) {
                this.G7 = null;
            }
            this.K0.onError(th2);
            DisposableHelper.dispose(this.H7);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            synchronized (this) {
                U u6 = this.G7;
                if (u6 == null) {
                    return;
                }
                u6.add(t10);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.F7, bVar)) {
                this.F7 = bVar;
                try {
                    this.G7 = (U) io.reactivex.internal.functions.a.g(this.f34596v2.call(), "The buffer supplied is null");
                    this.K0.onSubscribe(this);
                    if (this.f29584v1) {
                        return;
                    }
                    xi.h0 h0Var = this.E7;
                    long j10 = this.C2;
                    io.reactivex.disposables.b bVarH = h0Var.h(this, j10, j10, this.K2);
                    if (this.H7.compareAndSet(null, bVarH)) {
                        return;
                    }
                    bVarH.dispose();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    dispose();
                    EmptyDisposable.error(th2, this.K0);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u6;
            try {
                U u10 = (U) io.reactivex.internal.functions.a.g(this.f34596v2.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u6 = this.G7;
                    if (u6 != null) {
                        this.G7 = u10;
                    }
                }
                if (u6 == null) {
                    DisposableHelper.dispose(this.H7);
                } else {
                    h(u6, false, this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.K0.onError(th2);
                dispose();
            }
        }
    }

    public static final class c<T, U extends Collection<? super T>> extends gj.k<T, U, U> implements Runnable, io.reactivex.disposables.b {
        public final long C2;
        public final TimeUnit E7;
        public final h0.c F7;
        public final List<U> G7;
        public io.reactivex.disposables.b H7;
        public final long K2;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public final Callable<U> f34597v2;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final U f34598a;

            public a(U u6) {
                this.f34598a = u6;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.G7.remove(this.f34598a);
                }
                c cVar = c.this;
                cVar.i(this.f34598a, false, cVar.F7);
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final U f34600a;

            public b(U u6) {
                this.f34600a = u6;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.G7.remove(this.f34600a);
                }
                c cVar = c.this;
                cVar.i(this.f34600a, false, cVar.F7);
            }
        }

        public c(xi.g0<? super U> g0Var, Callable<U> callable, long j10, long j11, TimeUnit timeUnit, h0.c cVar) {
            super(g0Var, new MpscLinkedQueue());
            this.f34597v2 = callable;
            this.C2 = j10;
            this.K2 = j11;
            this.E7 = timeUnit;
            this.F7 = cVar;
            this.G7 = new LinkedList();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.f29584v1) {
                return;
            }
            this.f29584v1 = true;
            m();
            this.H7.dispose();
            this.F7.dispose();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.f29584v1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // gj.k, io.reactivex.internal.util.j
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(xi.g0<? super U> g0Var, U u6) {
            g0Var.onNext(u6);
        }

        public void m() {
            synchronized (this) {
                this.G7.clear();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.G7);
                this.G7.clear();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                this.f29583k1.offer((U) ((Collection) it2.next()));
            }
            this.C1 = true;
            if (a()) {
                io.reactivex.internal.util.n.d(this.f29583k1, this.K0, false, this.F7, this);
            }
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.C1 = true;
            m();
            this.K0.onError(th2);
            this.F7.dispose();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            synchronized (this) {
                Iterator<U> it2 = this.G7.iterator();
                while (it2.hasNext()) {
                    it2.next().add(t10);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.H7, bVar)) {
                this.H7 = bVar;
                try {
                    Collection collection = (Collection) io.reactivex.internal.functions.a.g(this.f34597v2.call(), "The buffer supplied is null");
                    this.G7.add((U) collection);
                    this.K0.onSubscribe(this);
                    h0.c cVar = this.F7;
                    long j10 = this.K2;
                    cVar.d(this, j10, j10, this.E7);
                    this.F7.c(new b(collection), this.C2, this.E7);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.K0);
                    this.F7.dispose();
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.f29584v1) {
                return;
            }
            try {
                Collection collection = (Collection) io.reactivex.internal.functions.a.g(this.f34597v2.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    if (this.f29584v1) {
                        return;
                    }
                    this.G7.add((U) collection);
                    this.F7.c(new a(collection), this.C2, this.E7);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.K0.onError(th2);
                dispose();
            }
        }
    }

    public m(xi.e0<T> e0Var, long j10, long j11, TimeUnit timeUnit, xi.h0 h0Var, Callable<U> callable, int i10, boolean z10) {
        super(e0Var);
        this.f34588b = j10;
        this.f34589c = j11;
        this.f34590d = timeUnit;
        this.f34591e = h0Var;
        this.f34592f = callable;
        this.f34593g = i10;
        this.f34594h = z10;
    }

    @Override // xi.z
    public void I5(xi.g0<? super U> g0Var) {
        if (this.f34588b == this.f34589c && this.f34593g == Integer.MAX_VALUE) {
            this.f34421a.c(new b(new io.reactivex.observers.l(g0Var), this.f34592f, this.f34588b, this.f34590d, this.f34591e));
            return;
        }
        h0.c cVarD = this.f34591e.d();
        if (this.f34588b == this.f34589c) {
            this.f34421a.c(new a(new io.reactivex.observers.l(g0Var), this.f34592f, this.f34588b, this.f34590d, this.f34593g, this.f34594h, cVarD));
        } else {
            this.f34421a.c(new c(new io.reactivex.observers.l(g0Var), this.f34592f, this.f34588b, this.f34589c, this.f34590d, cVarD));
        }
    }
}
