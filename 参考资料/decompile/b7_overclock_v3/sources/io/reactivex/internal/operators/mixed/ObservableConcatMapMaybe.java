package io.reactivex.internal.operators.mixed;

import dj.o;
import fj.n;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.g0;
import xi.t;
import xi.w;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableConcatMapMaybe<T, R> extends z<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z<T> f34070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o<? super T, ? extends w<? extends R>> f34071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ErrorMode f34072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f34073d;

    public static final class ConcatMapMaybeMainObserver<T, R> extends AtomicInteger implements g0<T>, io.reactivex.disposables.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f34074a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f34075b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f34076c = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public volatile boolean done;
        public final g0<? super R> downstream;
        public final ErrorMode errorMode;
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);
        public R item;
        public final o<? super T, ? extends w<? extends R>> mapper;
        public final n<T> queue;
        public volatile int state;
        public io.reactivex.disposables.b upstream;

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements t<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapMaybeMainObserver<?, R> parent;

            public ConcatMapMaybeObserver(ConcatMapMaybeMainObserver<?, R> concatMapMaybeMainObserver) {
                this.parent = concatMapMaybeMainObserver;
            }

            public void a() {
                DisposableHelper.dispose(this);
            }

            @Override // xi.t
            public void onComplete() {
                this.parent.b();
            }

            @Override // xi.t
            public void onError(Throwable th2) {
                this.parent.c(th2);
            }

            @Override // xi.t
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // xi.t
            public void onSuccess(R r10) {
                this.parent.d(r10);
            }
        }

        public ConcatMapMaybeMainObserver(g0<? super R> g0Var, o<? super T, ? extends w<? extends R>> oVar, int i10, ErrorMode errorMode) {
            this.downstream = g0Var;
            this.mapper = oVar;
            this.errorMode = errorMode;
            this.queue = new io.reactivex.internal.queue.a(i10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        
            r2.clear();
            r10.item = null;
            r0.onError(r3.c());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003b, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                r10 = this;
                int r0 = r10.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                xi.g0<? super R> r0 = r10.downstream
                io.reactivex.internal.util.ErrorMode r1 = r10.errorMode
                fj.n<T> r2 = r10.queue
                io.reactivex.internal.util.AtomicThrowable r3 = r10.errors
                r4 = 1
                r5 = 1
            L11:
                boolean r6 = r10.cancelled
                r7 = 0
                if (r6 == 0) goto L1d
                r2.clear()
                r10.item = r7
                goto L98
            L1d:
                int r6 = r10.state
                java.lang.Object r8 = r3.get()
                if (r8 == 0) goto L3c
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r8) goto L2f
                io.reactivex.internal.util.ErrorMode r8 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r8) goto L3c
                if (r6 != 0) goto L3c
            L2f:
                r2.clear()
                r10.item = r7
                java.lang.Throwable r1 = r3.c()
                r0.onError(r1)
                return
            L3c:
                r8 = 0
                if (r6 != 0) goto L8a
                boolean r6 = r10.done
                java.lang.Object r7 = r2.poll()
                if (r7 != 0) goto L48
                r8 = 1
            L48:
                if (r6 == 0) goto L5a
                if (r8 == 0) goto L5a
                java.lang.Throwable r1 = r3.c()
                if (r1 != 0) goto L56
                r0.onComplete()
                goto L59
            L56:
                r0.onError(r1)
            L59:
                return
            L5a:
                if (r8 == 0) goto L5d
                goto L98
            L5d:
                dj.o<? super T, ? extends xi.w<? extends R>> r6 = r10.mapper     // Catch: java.lang.Throwable -> L73
                java.lang.Object r6 = r6.apply(r7)     // Catch: java.lang.Throwable -> L73
                java.lang.String r7 = "The mapper returned a null MaybeSource"
                java.lang.Object r6 = io.reactivex.internal.functions.a.g(r6, r7)     // Catch: java.lang.Throwable -> L73
                xi.w r6 = (xi.w) r6     // Catch: java.lang.Throwable -> L73
                r10.state = r4
                io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe$ConcatMapMaybeMainObserver$ConcatMapMaybeObserver<R> r7 = r10.inner
                r6.a(r7)
                goto L98
            L73:
                r1 = move-exception
                io.reactivex.exceptions.a.b(r1)
                io.reactivex.disposables.b r4 = r10.upstream
                r4.dispose()
                r2.clear()
                r3.a(r1)
                java.lang.Throwable r1 = r3.c()
                r0.onError(r1)
                return
            L8a:
                r9 = 2
                if (r6 != r9) goto L98
                R r6 = r10.item
                r10.item = r7
                r0.onNext(r6)
                r10.state = r8
                goto L11
            L98:
                int r5 = -r5
                int r5 = r10.addAndGet(r5)
                if (r5 != 0) goto L11
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe.ConcatMapMaybeMainObserver.a():void");
        }

        public void b() {
            this.state = 0;
            a();
        }

        public void c(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.errorMode != ErrorMode.END) {
                this.upstream.dispose();
            }
            this.state = 0;
            a();
        }

        public void d(R r10) {
            this.item = r10;
            this.state = 2;
            a();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            if (!this.errors.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            if (this.errorMode == ErrorMode.IMMEDIATE) {
                this.inner.a();
            }
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableConcatMapMaybe(z<T> zVar, o<? super T, ? extends w<? extends R>> oVar, ErrorMode errorMode, int i10) {
        this.f34070a = zVar;
        this.f34071b = oVar;
        this.f34072c = errorMode;
        this.f34073d = i10;
    }

    @Override // xi.z
    public void I5(g0<? super R> g0Var) {
        if (b.b(this.f34070a, this.f34071b, g0Var)) {
            return;
        }
        this.f34070a.c(new ConcatMapMaybeMainObserver(g0Var, this.f34071b, this.f34073d, this.f34072c));
    }
}
