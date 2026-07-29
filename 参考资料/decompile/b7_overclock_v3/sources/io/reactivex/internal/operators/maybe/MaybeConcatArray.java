package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeConcatArray<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<? extends T>[] f33832b;

    public static final class ConcatMaybeObserver<T> extends AtomicInteger implements xi.t<T>, bu.e {
        private static final long serialVersionUID = 3520831347801429610L;
        public final bu.d<? super T> downstream;
        public int index;
        public long produced;
        public final xi.w<? extends T>[] sources;
        public final AtomicLong requested = new AtomicLong();
        public final SequentialDisposable disposables = new SequentialDisposable();
        public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);

        public ConcatMaybeObserver(bu.d<? super T> dVar, xi.w<? extends T>[] wVarArr) {
            this.downstream = dVar;
            this.sources = wVarArr;
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
                        int i10 = this.index;
                        xi.w<? extends T>[] wVarArr = this.sources;
                        if (i10 == wVarArr.length) {
                            dVar.onComplete();
                            return;
                        } else {
                            this.index = i10 + 1;
                            wVarArr[i10].a(this);
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

    public MaybeConcatArray(xi.w<? extends T>[] wVarArr) {
        this.f33832b = wVarArr;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        ConcatMaybeObserver concatMaybeObserver = new ConcatMaybeObserver(dVar, this.f33832b);
        dVar.onSubscribe(concatMaybeObserver);
        concatMaybeObserver.a();
    }
}
