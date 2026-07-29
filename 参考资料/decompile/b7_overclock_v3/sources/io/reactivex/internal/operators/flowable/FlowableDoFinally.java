package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableDoFinally<T> extends a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.a f33225c;

    public static final class DoFinallyConditionalSubscriber<T> extends BasicIntQueueSubscription<T> implements fj.a<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final fj.a<? super T> downstream;
        public final dj.a onFinally;

        /* JADX INFO: renamed from: qs, reason: collision with root package name */
        public fj.l<T> f33226qs;
        public boolean syncFused;
        public bu.e upstream;

        public DoFinallyConditionalSubscriber(fj.a<? super T> aVar, dj.a aVar2) {
            this.downstream = aVar;
            this.onFinally = aVar2;
        }

        public void c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            c();
        }

        @Override // fj.o
        public void clear() {
            this.f33226qs.clear();
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f33226qs.isEmpty();
        }

        @Override // fj.a
        public boolean m(T t10) {
            return this.downstream.m(t10);
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
            c();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            c();
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof fj.l) {
                    this.f33226qs = (fj.l) eVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.f33226qs.poll();
            if (tPoll == null && this.syncFused) {
                c();
            }
            return tPoll;
        }

        @Override // bu.e
        public void request(long j10) {
            this.upstream.request(j10);
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            fj.l<T> lVar = this.f33226qs;
            if (lVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = lVar.requestFusion(i10);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }
    }

    public static final class DoFinallySubscriber<T> extends BasicIntQueueSubscription<T> implements xi.o<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        public final bu.d<? super T> downstream;
        public final dj.a onFinally;

        /* JADX INFO: renamed from: qs, reason: collision with root package name */
        public fj.l<T> f33227qs;
        public boolean syncFused;
        public bu.e upstream;

        public DoFinallySubscriber(bu.d<? super T> dVar, dj.a aVar) {
            this.downstream = dVar;
            this.onFinally = aVar;
        }

        public void c() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    kj.a.Y(th2);
                }
            }
        }

        @Override // bu.e
        public void cancel() {
            this.upstream.cancel();
            c();
        }

        @Override // fj.o
        public void clear() {
            this.f33227qs.clear();
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.f33227qs.isEmpty();
        }

        @Override // bu.d
        public void onComplete() {
            this.downstream.onComplete();
            c();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            c();
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            if (SubscriptionHelper.validate(this.upstream, eVar)) {
                this.upstream = eVar;
                if (eVar instanceof fj.l) {
                    this.f33227qs = (fj.l) eVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T tPoll = this.f33227qs.poll();
            if (tPoll == null && this.syncFused) {
                c();
            }
            return tPoll;
        }

        @Override // bu.e
        public void request(long j10) {
            this.upstream.request(j10);
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            fj.l<T> lVar = this.f33227qs;
            if (lVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int iRequestFusion = lVar.requestFusion(i10);
            if (iRequestFusion != 0) {
                this.syncFused = iRequestFusion == 1;
            }
            return iRequestFusion;
        }
    }

    public FlowableDoFinally(xi.j<T> jVar, dj.a aVar) {
        super(jVar);
        this.f33225c = aVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        if (dVar instanceof fj.a) {
            this.f33524b.j6(new DoFinallyConditionalSubscriber((fj.a) dVar, this.f33225c));
        } else {
            this.f33524b.j6(new DoFinallySubscriber(dVar, this.f33225c));
        }
    }
}
