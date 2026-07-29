package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeConcatIterable<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Iterable<? extends xi.w<? extends T>> f33834b;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements xi.t<T>, bu.e {
        private static final long serialVersionUID = 3520831347801429610L;
        public final bu.d<? super T> downstream;
        public long produced;
        public final Iterator<? extends xi.w<? extends T>> sources;
        public final AtomicLong requested = new AtomicLong();
        public final SequentialDisposable disposables = new SequentialDisposable();
        public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        public ConcatMaybeObserver(bu.d<? super T> dVar, Iterator<? extends xi.w<? extends T>> it2) {
            this.downstream = dVar;
            this.sources = it2;
        }

        public void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<Object> atomicReference = this.current;
            bu.d<? super T> dVar = this.downstream;
            SequentialDisposable sequentialDisposable = this.disposables;
            while (!sequentialDisposable.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z10 = true;
                    if (obj != NotificationLite.COMPLETE) {
                        long j10 = this.produced;
                        if (j10 != this.requested.get()) {
                            this.produced = j10 + 1;
                            atomicReference.lazySet(null);
                            dVar.onNext(obj);
                        } else {
                            z10 = false;
                        }
                    } else {
                        atomicReference.lazySet(null);
                    }
                    if (z10 && !sequentialDisposable.isDisposed()) {
                        try {
                            if (this.sources.hasNext()) {
                                try {
                                    ((xi.w) io.reactivex.internal.functions.a.g(this.sources.next(), "The source Iterator returned a null MaybeSource")).a(this);
                                } catch (Throwable th2) {
                                    io.reactivex.exceptions.a.b(th2);
                                    dVar.onError(th2);
                                    return;
                                }
                            } else {
                                dVar.onComplete();
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            dVar.onError(th3);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet(null);
        }

        @Override // bu.e
        public void cancel() {
            this.disposables.dispose();
        }

        @Override // xi.t
        public void onComplete() {
            this.current.lazySet(NotificationLite.COMPLETE);
            a();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.disposables.a(bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.current.lazySet(t10);
            a();
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                a();
            }
        }
    }

    public MaybeConcatIterable(Iterable<? extends xi.w<? extends T>> iterable) {
        this.f33834b = iterable;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        try {
            ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(dVar, (Iterator) io.reactivex.internal.functions.a.g(this.f33834b.iterator(), "The sources Iterable returned a null Iterator"));
            dVar.onSubscribe(concatMaybeObserver);
            concatMaybeObserver.a();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptySubscription.error(th2, dVar);
        }
    }
}
