package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeFlatMapIterableFlowable<T, R> extends xi.j<R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<T> f33861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super T, ? extends Iterable<? extends R>> f33862c;

    public static final class FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements xi.t<T> {
        private static final long serialVersionUID = -8938804753851907758L;
        public volatile boolean cancelled;
        public final bu.d<? super R> downstream;

        /* JADX INFO: renamed from: it, reason: collision with root package name */
        public volatile Iterator<? extends R> f33863it;
        public final dj.o<? super T, ? extends Iterable<? extends R>> mapper;
        public boolean outputFused;
        public final AtomicLong requested = new AtomicLong();
        public io.reactivex.disposables.b upstream;

        public FlatMapIterableObserver(bu.d<? super R> dVar, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.downstream = dVar;
            this.mapper = oVar;
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super R> dVar = this.downstream;
            Iterator<? extends R> it2 = this.f33863it;
            if (this.outputFused && it2 != null) {
                dVar.onNext(null);
                dVar.onComplete();
                return;
            }
            int iAddAndGet = 1;
            while (true) {
                if (it2 != null) {
                    long j10 = this.requested.get();
                    if (j10 == Long.MAX_VALUE) {
                        c(dVar, it2);
                        return;
                    }
                    long j11 = 0;
                    while (j11 != j10) {
                        if (this.cancelled) {
                            return;
                        }
                        try {
                            dVar.onNext((Object) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null value"));
                            if (this.cancelled) {
                                return;
                            }
                            j11++;
                            try {
                                if (!it2.hasNext()) {
                                    dVar.onComplete();
                                    return;
                                }
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                dVar.onError(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            dVar.onError(th3);
                            return;
                        }
                    }
                    if (j11 != 0) {
                        io.reactivex.internal.util.b.e(this.requested, j11);
                    }
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (it2 == null) {
                    it2 = this.f33863it;
                }
            }
        }

        public void c(bu.d<? super R> dVar, Iterator<? extends R> it2) {
            while (!this.cancelled) {
                try {
                    dVar.onNext(it2.next());
                    if (this.cancelled) {
                        return;
                    }
                    try {
                        if (!it2.hasNext()) {
                            dVar.onComplete();
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        dVar.onError(th2);
                        return;
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    dVar.onError(th3);
                    return;
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            this.cancelled = true;
            this.upstream.dispose();
            this.upstream = DisposableHelper.DISPOSED;
        }

        @Override // fj.o
        public void clear() {
            this.f33863it = null;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f33863it == null;
        }

        @Override // xi.t
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.upstream = DisposableHelper.DISPOSED;
            this.downstream.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            try {
                Iterator<? extends R> it2 = this.mapper.apply(t10).iterator();
                if (!it2.hasNext()) {
                    this.downstream.onComplete();
                } else {
                    this.f33863it = it2;
                    b();
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.downstream.onError(th2);
            }
        }

        @Override // fj.o
        @bj.f
        public R poll() throws Exception {
            Iterator<? extends R> it2 = this.f33863it;
            if (it2 == null) {
                return null;
            }
            R r10 = (R) io.reactivex.internal.functions.a.g(it2.next(), "The iterator returned a null value");
            if (!it2.hasNext()) {
                this.f33863it = null;
            }
            return r10;
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public MaybeFlatMapIterableFlowable(xi.w<T> wVar, dj.o<? super T, ? extends Iterable<? extends R>> oVar) {
        this.f33861b = wVar;
        this.f33862c = oVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        this.f33861b.a(new FlatMapIterableObserver(dVar, this.f33862c));
    }
}
