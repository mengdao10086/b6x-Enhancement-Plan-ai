package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDebounce<T, U> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends bu.c<U>> f33214c;

    public static final class DebounceSubscriber<T, U> extends AtomicLong implements xi.o<T>, bu.e {
        private static final long serialVersionUID = 6725975399620862591L;
        public final dj.o<? super T, ? extends bu.c<U>> debounceSelector;
        public final AtomicReference<io.reactivex.disposables.b> debouncer = new AtomicReference<>();
        public boolean done;
        public final bu.d<? super T> downstream;
        public volatile long index;
        public bu.e upstream;

        public static final class a<T, U> extends io.reactivex.subscribers.b<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final DebounceSubscriber<T, U> f33215b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f33216c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final T f33217d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f33218e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final AtomicBoolean f33219f = new AtomicBoolean();

            public a(DebounceSubscriber<T, U> debounceSubscriber, long j10, T t10) {
                this.f33215b = debounceSubscriber;
                this.f33216c = j10;
                this.f33217d = t10;
            }

            public void d() {
                if (this.f33219f.compareAndSet(false, true)) {
                    this.f33215b.a(this.f33216c, this.f33217d);
                }
            }

            @Override // bu.d
            public void onComplete() {
                if (this.f33218e) {
                    return;
                }
                this.f33218e = true;
                d();
            }

            @Override // bu.d
            public void onError(Throwable th2) {
                if (this.f33218e) {
                    kj.a.Y(th2);
                } else {
                    this.f33218e = true;
                    this.f33215b.onError(th2);
                }
            }

            @Override // bu.d
            public void onNext(U u6) {
                if (this.f33218e) {
                    return;
                }
                this.f33218e = true;
                a();
                d();
            }
        }

        public DebounceSubscriber(bu.d<? super T> dVar, dj.o<? super T, ? extends bu.c<U>> oVar) {
            this.downstream = dVar;
            this.debounceSelector = oVar;
        }

        public void a(long j10, T t10) {
            if (j10 == this.index) {
                if (get() != 0) {
                    this.downstream.onNext(t10);
                    io.reactivex.internal.util.b.e(this, 1L);
                } else {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            DisposableHelper.dispose(this.debouncer);
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            io.reactivex.disposables.b bVar = this.debouncer.get();
            if (DisposableHelper.isDisposed(bVar)) {
                return;
            }
            a aVar = (a) bVar;
            if (aVar != null) {
                aVar.d();
            }
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onComplete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.debouncer);
            this.downstream.onError(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            long j10 = this.index + 1;
            this.index = j10;
            io.reactivex.disposables.b bVar = this.debouncer.get();
            if (bVar != null) {
                bVar.dispose();
            }
            try {
                bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.debounceSelector.apply(t10), "The publisher supplied is null");
                a aVar = new a(this, j10, t10);
                if (this.debouncer.compareAndSet(bVar, aVar)) {
                    cVar.d(aVar);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                cancel();
                this.downstream.onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                this.downstream.onSubscribe(this);
                eVar.request(Long.MAX_VALUE);
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }
    }

    public FlowableDebounce(xi.j<T> jVar, dj.o<? super T, ? extends bu.c<U>> oVar) {
        super(jVar);
        this.f33214c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new DebounceSubscriber(new io.reactivex.subscribers.e(dVar), this.f33214c));
    }
}
