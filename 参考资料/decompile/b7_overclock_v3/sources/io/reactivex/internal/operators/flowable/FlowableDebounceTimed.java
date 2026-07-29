package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDebounceTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f33220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f33221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final xi.h0 f33222e;

    public static final class DebounceEmitter<T> extends AtomicReference<io.reactivex.disposables.b> implements Runnable, io.reactivex.disposables.b {
        private static final long serialVersionUID = 6812032969491025141L;
        public final long idx;
        public final AtomicBoolean once = new AtomicBoolean();
        public final DebounceTimedSubscriber<T> parent;
        public final T value;

        public DebounceEmitter(T t10, long j10, DebounceTimedSubscriber<T> debounceTimedSubscriber) {
            this.value = t10;
            this.idx = j10;
            this.parent = debounceTimedSubscriber;
        }

        public void a() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.a(this.idx, this.value, this);
            }
        }

        public void b(io.reactivex.disposables.b bVar) {
            DisposableHelper.replace(this, bVar);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    public static final class DebounceTimedSubscriber<T> extends AtomicLong implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -9102637559663639004L;
        public boolean done;
        public final bu.d<? super T> downstream;
        public volatile long index;
        public final long timeout;
        public io.reactivex.disposables.b timer;
        public final TimeUnit unit;
        public bu.e upstream;
        public final h0.c worker;

        public DebounceTimedSubscriber(bu.d<? super T> dVar, long j10, TimeUnit timeUnit, h0.c cVar) {
            this.downstream = dVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        public void a(long j10, T t10, DebounceEmitter<T> debounceEmitter) {
            if (j10 == this.index) {
                if (get() == 0) {
                    cancel();
                    this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
                } else {
                    this.downstream.onNext(t10);
                    io.reactivex.internal.util.b.e(this, 1L);
                    debounceEmitter.dispose();
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            this.worker.dispose();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            io.reactivex.disposables.b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = (DebounceEmitter) bVar;
            if (debounceEmitter != null) {
                debounceEmitter.a();
            }
            this.downstream.onComplete();
            this.worker.dispose();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
                return;
            }
            this.done = true;
            io.reactivex.disposables.b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            this.downstream.onError(th2);
            this.worker.dispose();
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            long j10 = this.index + 1;
            this.index = j10;
            io.reactivex.disposables.b bVar = this.timer;
            if (bVar != null) {
                bVar.dispose();
            }
            DebounceEmitter debounceEmitter = new DebounceEmitter(t10, j10, this);
            this.timer = debounceEmitter;
            debounceEmitter.b(this.worker.c(debounceEmitter, this.timeout, this.unit));
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

    public FlowableDebounceTimed(xi.j<T> jVar, long j10, TimeUnit timeUnit, xi.h0 h0Var) {
        super(jVar);
        this.f33220c = j10;
        this.f33221d = timeUnit;
        this.f33222e = h0Var;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        this.f33524b.j6(new DebounceTimedSubscriber(new io.reactivex.subscribers.e(dVar), this.f33220c, this.f33221d, this.f33222e.d()));
    }
}
