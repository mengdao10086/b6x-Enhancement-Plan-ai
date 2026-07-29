package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableSequenceEqual;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableSequenceEqualSingle<T> extends xi.i0<Boolean> implements fj.b<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends T> f33437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bu.c<? extends T> f33438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.d<? super T, ? super T> f33439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33440d;

    public static final class EqualCoordinator<T> extends AtomicInteger implements io.reactivex.disposables.b, FlowableSequenceEqual.a {
        private static final long serialVersionUID = -6178010334400373240L;
        public final dj.d<? super T, ? super T> comparer;
        public final xi.l0<? super Boolean> downstream;
        public final AtomicThrowable error = new AtomicThrowable();
        public final FlowableSequenceEqual.EqualSubscriber<T> first;
        public final FlowableSequenceEqual.EqualSubscriber<T> second;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public T f33441v1;

        /* JADX INFO: renamed from: v2, reason: collision with root package name */
        public T f33442v2;

        public EqualCoordinator(xi.l0<? super Boolean> l0Var, int i10, dj.d<? super T, ? super T> dVar) {
            this.downstream = l0Var;
            this.comparer = dVar;
            this.first = new FlowableSequenceEqual.EqualSubscriber<>(this, i10);
            this.second = new FlowableSequenceEqual.EqualSubscriber<>(this, i10);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void a(Throwable th2) {
            if (this.error.a(th2)) {
                b();
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual.a
        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            int iAddAndGet = 1;
            do {
                fj.o<T> oVar = this.first.queue;
                fj.o<T> oVar2 = this.second.queue;
                if (oVar != null && oVar2 != null) {
                    while (!isDisposed()) {
                        if (this.error.get() != null) {
                            c();
                            this.downstream.onError(this.error.c());
                            return;
                        }
                        boolean z10 = this.first.done;
                        T tPoll = this.f33441v1;
                        if (tPoll == null) {
                            try {
                                tPoll = oVar.poll();
                                this.f33441v1 = tPoll;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                c();
                                this.error.a(th2);
                                this.downstream.onError(this.error.c());
                                return;
                            }
                        }
                        boolean z11 = tPoll == null;
                        boolean z12 = this.second.done;
                        T tPoll2 = this.f33442v2;
                        if (tPoll2 == null) {
                            try {
                                tPoll2 = oVar2.poll();
                                this.f33442v2 = tPoll2;
                            } catch (Throwable th3) {
                                io.reactivex.exceptions.a.b(th3);
                                c();
                                this.error.a(th3);
                                this.downstream.onError(this.error.c());
                                return;
                            }
                        }
                        boolean z13 = tPoll2 == null;
                        if (z10 && z12 && z11 && z13) {
                            this.downstream.onSuccess(Boolean.TRUE);
                            return;
                        }
                        if (z10 && z12 && z11 != z13) {
                            c();
                            this.downstream.onSuccess(Boolean.FALSE);
                            return;
                        }
                        if (!z11 && !z13) {
                            try {
                                if (!this.comparer.a(tPoll, tPoll2)) {
                                    c();
                                    this.downstream.onSuccess(Boolean.FALSE);
                                    return;
                                } else {
                                    this.f33441v1 = null;
                                    this.f33442v2 = null;
                                    this.first.b();
                                    this.second.b();
                                }
                            } catch (Throwable th4) {
                                io.reactivex.exceptions.a.b(th4);
                                c();
                                this.error.a(th4);
                                this.downstream.onError(this.error.c());
                                return;
                            }
                        }
                    }
                    this.first.clear();
                    this.second.clear();
                    return;
                }
                if (isDisposed()) {
                    this.first.clear();
                    this.second.clear();
                    return;
                } else if (this.error.get() != null) {
                    c();
                    this.downstream.onError(this.error.c());
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        public void c() {
            this.first.a();
            this.first.clear();
            this.second.a();
            this.second.clear();
        }

        public void d(bu.c<? extends T> cVar, bu.c<? extends T> cVar2) {
            cVar.d(this.first);
            cVar2.d(this.second);
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            this.first.a();
            this.second.a();
            if (getAndIncrement() == 0) {
                this.first.clear();
                this.second.clear();
            }
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.first.get() == SubscriptionHelper.CANCELLED;
        }
    }

    public FlowableSequenceEqualSingle(bu.c<? extends T> cVar, bu.c<? extends T> cVar2, dj.d<? super T, ? super T> dVar, int i10) {
        this.f33437a = cVar;
        this.f33438b = cVar2;
        this.f33439c = dVar;
        this.f33440d = i10;
    }

    @Override // xi.i0
    public void b1(xi.l0<? super Boolean> l0Var) {
        EqualCoordinator equalCoordinator = new EqualCoordinator(l0Var, this.f33440d, this.f33439c);
        l0Var.onSubscribe(equalCoordinator);
        equalCoordinator.d(this.f33437a, this.f33438b);
    }

    @Override // fj.b
    public xi.j<Boolean> d() {
        return kj.a.S(new FlowableSequenceEqual(this.f33437a, this.f33438b, this.f33439c, this.f33440d));
    }
}
