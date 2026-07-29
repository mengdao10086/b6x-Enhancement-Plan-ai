package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableConcatArray<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<? extends T>[] f33198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f33199c;

    public static final class ConcatArraySubscriber<T> extends SubscriptionArbiter implements xi.o<T> {
        private static final long serialVersionUID = -8158322871608889516L;
        public final boolean delayError;
        public final bu.d<? super T> downstream;
        public List<Throwable> errors;
        public int index;
        public long produced;
        public final bu.c<? extends T>[] sources;
        public final AtomicInteger wip;

        public ConcatArraySubscriber(bu.c<? extends T>[] cVarArr, boolean z10, bu.d<? super T> dVar) {
            super(false);
            this.downstream = dVar;
            this.sources = cVarArr;
            this.delayError = z10;
            this.wip = new AtomicInteger();
        }

        @Override // bu.d
        public void onComplete() {
            if (this.wip.getAndIncrement() == 0) {
                bu.c<? extends T>[] cVarArr = this.sources;
                int length = cVarArr.length;
                int i10 = this.index;
                while (i10 != length) {
                    bu.c<? extends T> cVar = cVarArr[i10];
                    if (cVar == null) {
                        NullPointerException nullPointerException = new NullPointerException("A Publisher entry is null");
                        if (!this.delayError) {
                            this.downstream.onError(nullPointerException);
                            return;
                        }
                        List arrayList = this.errors;
                        if (arrayList == null) {
                            arrayList = new ArrayList((length - i10) + 1);
                            this.errors = arrayList;
                        }
                        arrayList.add(nullPointerException);
                        i10++;
                    } else {
                        long j10 = this.produced;
                        if (j10 != 0) {
                            this.produced = 0L;
                            i(j10);
                        }
                        cVar.d(this);
                        i10++;
                        this.index = i10;
                        if (this.wip.decrementAndGet() == 0) {
                            return;
                        }
                    }
                }
                List<Throwable> list = this.errors;
                if (list == null) {
                    this.downstream.onComplete();
                } else if (list.size() == 1) {
                    this.downstream.onError(list.get(0));
                } else {
                    this.downstream.onError(new CompositeException(list));
                }
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (!this.delayError) {
                this.downstream.onError(th2);
                return;
            }
            List arrayList = this.errors;
            if (arrayList == null) {
                arrayList = new ArrayList((this.sources.length - this.index) + 1);
                this.errors = arrayList;
            }
            arrayList.add(th2);
            onComplete();
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.produced++;
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            k(eVar);
        }
    }

    public FlowableConcatArray(bu.c<? extends T>[] cVarArr, boolean z10) {
        this.f33198b = cVarArr;
        this.f33199c = z10;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        ConcatArraySubscriber concatArraySubscriber = new ConcatArraySubscriber(this.f33198b, this.f33199c, dVar);
        dVar.onSubscribe(concatArraySubscriber);
        concatArraySubscriber.onComplete();
    }
}
