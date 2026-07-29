package io.reactivex.internal.operators.mixed;

import bu.d;
import bu.e;
import dj.o;
import fj.n;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;
import xi.t;
import xi.w;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatMapMaybe<T, R> extends j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j<T> f34029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o<? super T, ? extends w<? extends R>> f34030c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ErrorMode f34031d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f34032e;

    public static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements xi.o<T>, e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f34033a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f34034b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f34035c = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        public volatile boolean cancelled;
        public int consumed;
        public volatile boolean done;
        public final d<? super R> downstream;
        public long emitted;
        public final ErrorMode errorMode;
        public R item;
        public final o<? super T, ? extends w<? extends R>> mapper;
        public final int prefetch;
        public final n<T> queue;
        public volatile int state;
        public e upstream;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable errors = new AtomicThrowable();
        public final ConcatMapMaybeObserver<R> inner = new ConcatMapMaybeObserver<>(this);

        public static final class ConcatMapMaybeObserver<R> extends AtomicReference<io.reactivex.disposables.b> implements t<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            public final ConcatMapMaybeSubscriber<?, R> parent;

            public ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> concatMapMaybeSubscriber) {
                this.parent = concatMapMaybeSubscriber;
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

        public ConcatMapMaybeSubscriber(d<? super R> dVar, o<? super T, ? extends w<? extends R>> oVar, int i10, ErrorMode errorMode) {
            this.downstream = dVar;
            this.mapper = oVar;
            this.prefetch = i10;
            this.errorMode = errorMode;
            this.queue = new SpscArrayQueue(i10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0036, code lost:
        
            r2.clear();
            r15.item = null;
            r0.onError(r3.c());
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0042, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                r15 = this;
                int r0 = r15.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                bu.d<? super R> r0 = r15.downstream
                io.reactivex.internal.util.ErrorMode r1 = r15.errorMode
                fj.n<T> r2 = r15.queue
                io.reactivex.internal.util.AtomicThrowable r3 = r15.errors
                java.util.concurrent.atomic.AtomicLong r4 = r15.requested
                int r5 = r15.prefetch
                int r6 = r5 >> 1
                int r5 = r5 - r6
                r6 = 1
                r7 = 1
            L18:
                boolean r8 = r15.cancelled
                r9 = 0
                if (r8 == 0) goto L24
                r2.clear()
                r15.item = r9
                goto Lc0
            L24:
                int r8 = r15.state
                java.lang.Object r10 = r3.get()
                if (r10 == 0) goto L43
                io.reactivex.internal.util.ErrorMode r10 = io.reactivex.internal.util.ErrorMode.IMMEDIATE
                if (r1 == r10) goto L36
                io.reactivex.internal.util.ErrorMode r10 = io.reactivex.internal.util.ErrorMode.BOUNDARY
                if (r1 != r10) goto L43
                if (r8 != 0) goto L43
            L36:
                r2.clear()
                r15.item = r9
                java.lang.Throwable r1 = r3.c()
                r0.onError(r1)
                return
            L43:
                r10 = 0
                if (r8 != 0) goto La3
                boolean r8 = r15.done
                java.lang.Object r9 = r2.poll()
                if (r9 != 0) goto L50
                r11 = 1
                goto L51
            L50:
                r11 = 0
            L51:
                if (r8 == 0) goto L63
                if (r11 == 0) goto L63
                java.lang.Throwable r1 = r3.c()
                if (r1 != 0) goto L5f
                r0.onComplete()
                goto L62
            L5f:
                r0.onError(r1)
            L62:
                return
            L63:
                if (r11 == 0) goto L66
                goto Lc0
            L66:
                int r8 = r15.consumed
                int r8 = r8 + r6
                if (r8 != r5) goto L74
                r15.consumed = r10
                bu.e r8 = r15.upstream
                long r10 = (long) r5
                r8.request(r10)
                goto L76
            L74:
                r15.consumed = r8
            L76:
                dj.o<? super T, ? extends xi.w<? extends R>> r8 = r15.mapper     // Catch: java.lang.Throwable -> L8c
                java.lang.Object r8 = r8.apply(r9)     // Catch: java.lang.Throwable -> L8c
                java.lang.String r9 = "The mapper returned a null MaybeSource"
                java.lang.Object r8 = io.reactivex.internal.functions.a.g(r8, r9)     // Catch: java.lang.Throwable -> L8c
                xi.w r8 = (xi.w) r8     // Catch: java.lang.Throwable -> L8c
                r15.state = r6
                io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe$ConcatMapMaybeSubscriber$ConcatMapMaybeObserver<R> r9 = r15.inner
                r8.a(r9)
                goto Lc0
            L8c:
                r1 = move-exception
                io.reactivex.exceptions.a.b(r1)
                bu.e r4 = r15.upstream
                r4.cancel()
                r2.clear()
                r3.a(r1)
                java.lang.Throwable r1 = r3.c()
                r0.onError(r1)
                return
            La3:
                r11 = 2
                if (r8 != r11) goto Lc0
                long r11 = r15.emitted
                long r13 = r4.get()
                int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r8 == 0) goto Lc0
                R r8 = r15.item
                r15.item = r9
                r0.onNext(r8)
                r8 = 1
                long r11 = r11 + r8
                r15.emitted = r11
                r15.state = r10
                goto L18
            Lc0:
                int r7 = -r7
                int r7 = r15.addAndGet(r7)
                if (r7 != 0) goto L18
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe.ConcatMapMaybeSubscriber.a():void");
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
                this.upstream.cancel();
            }
            this.state = 0;
            a();
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        public void d(R r10) {
            this.item = r10;
            this.state = 2;
            a();
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // bu.d
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

        @Override // bu.d
        public void onNext(T t10) {
            if (this.queue.offer(t10)) {
                a();
            } else {
                this.upstream.cancel();
                onError(new MissingBackpressureException("queue full?!"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(this.prefetch);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            io.reactivex.internal.util.b.a(this.requested, j10);
            a();
        }
    }

    public FlowableConcatMapMaybe(j<T> jVar, o<? super T, ? extends w<? extends R>> oVar, ErrorMode errorMode, int i10) {
        this.f34029b = jVar;
        this.f34030c = oVar;
        this.f34031d = errorMode;
        this.f34032e = i10;
    }

    @Override // xi.j
    public void k6(d<? super R> dVar) {
        this.f34029b.j6(new ConcatMapMaybeSubscriber(dVar, this.f34030c, this.f34032e, this.f34031d));
    }
}
