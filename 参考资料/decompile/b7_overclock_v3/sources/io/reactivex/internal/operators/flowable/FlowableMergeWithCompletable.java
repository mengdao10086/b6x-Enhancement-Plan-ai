package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableMergeWithCompletable<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xi.g f33323c;

    public static final class MergeWithSubscriber<T> extends AtomicInteger implements xi.o<T>, bu.e {
        private static final long serialVersionUID = -4592979584110982903L;
        public final bu.d<? super T> downstream;
        public volatile boolean mainDone;
        public volatile boolean otherDone;
        public final AtomicReference<bu.e> mainSubscription = new AtomicReference<>();
        public final OtherObserver otherObserver = new OtherObserver(this);
        public final AtomicThrowable error = new AtomicThrowable();
        public final AtomicLong requested = new AtomicLong();

        public static final class OtherObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.d {
            private static final long serialVersionUID = -2935427570954647017L;
            public final MergeWithSubscriber<?> parent;

            public OtherObserver(MergeWithSubscriber<?> mergeWithSubscriber) {
                this.parent = mergeWithSubscriber;
            }

            @Override // xi.d, xi.t
            public void onComplete() {
                this.parent.a();
            }

            @Override // xi.d
            public void onError(Throwable th2) {
                this.parent.b(th2);
            }

            @Override // xi.d
            public void onSubscribe(io.reactivex.disposables.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        public MergeWithSubscriber(bu.d<? super T> dVar) {
            this.downstream = dVar;
        }

        public void a() {
            this.otherDone = true;
            if (this.mainDone) {
                io.reactivex.internal.util.g.a(this.downstream, this, this.error);
            }
        }

        public void b(Throwable th2) {
            SubscriptionHelper.cancel(this.mainSubscription);
            io.reactivex.internal.util.g.c(this.downstream, th2, this, this.error);
        }

        @Override // bu.e
        public void cancel() {
            SubscriptionHelper.cancel(this.mainSubscription);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // bu.d
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                io.reactivex.internal.util.g.a(this.downstream, this, this.error);
            }
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.otherObserver);
            io.reactivex.internal.util.g.c(this.downstream, th2, this, this.error);
        }

        @Override // bu.d
        public void onNext(T t10) {
            io.reactivex.internal.util.g.e(this.downstream, t10, this, this.error);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.deferredSetOnce(this.mainSubscription, this.requested, eVar);
        }

        @Override // bu.e
        public void request(long j10) {
            SubscriptionHelper.deferredRequest(this.mainSubscription, this.requested, j10);
        }
    }

    public FlowableMergeWithCompletable(xi.j<T> jVar, xi.g gVar) {
        super(jVar);
        this.f33323c = gVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        MergeWithSubscriber mergeWithSubscriber = new MergeWithSubscriber(dVar);
        dVar.onSubscribe(mergeWithSubscriber);
        this.f33524b.j6(mergeWithSubscriber);
        this.f33323c.a(mergeWithSubscriber.otherObserver);
    }
}
