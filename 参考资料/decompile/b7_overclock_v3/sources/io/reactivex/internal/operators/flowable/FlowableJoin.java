package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<? extends TRight> f33311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> f33312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.o<? super TRight, ? extends bu.c<TRightEnd>> f33313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.c<? super TLeft, ? super TRight, ? extends R> f33314f;

    public static final class JoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements bu.e, FlowableGroupJoin.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f33315a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f33316b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Integer f33317c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Integer f33318d = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public volatile boolean cancelled;
        public final bu.d<? super R> downstream;
        public final dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final dj.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final dj.o<? super TRight, ? extends bu.c<TRightEnd>> rightEnd;
        public int rightIndex;
        public final AtomicLong requested = new AtomicLong();
        public final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        public final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(xi.j.Y());
        public final Map<Integer, TLeft> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public JoinSubscription(bu.d<? super R> dVar, dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> oVar, dj.o<? super TRight, ? extends bu.c<TRightEnd>> oVar2, dj.c<? super TLeft, ? super TRight, ? extends R> cVar) {
            this.downstream = dVar;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void a(Throwable th2) {
            if (!ExceptionHelper.a(this.error, th2)) {
                kj.a.Y(th2);
            } else {
                this.active.decrementAndGet();
                i();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void b(Throwable th2) {
            if (ExceptionHelper.a(this.error, th2)) {
                i();
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void c(boolean z10, Object obj) {
            synchronized (this) {
                this.queue.offer(z10 ? f33315a : f33316b, obj);
            }
            i();
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            h();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void d(boolean z10, FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.offer(z10 ? f33317c : f33318d, leftRightEndSubscriber);
            }
            i();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void f(FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber) {
            this.disposables.c(leftRightSubscriber);
            this.active.decrementAndGet();
            i();
        }

        public void h() {
            this.disposables.dispose();
        }

        public void i() {
            if (getAndIncrement() != 0) {
                return;
            }
            io.reactivex.internal.queue.a<Object> aVar = this.queue;
            bu.d<? super R> dVar = this.downstream;
            boolean z10 = true;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    h();
                    k(dVar);
                    return;
                }
                boolean z11 = this.active.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z12 = num == null;
                if (z11 && z12) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    dVar.onComplete();
                    return;
                }
                if (z12) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = aVar.poll();
                    if (num == f33315a) {
                        int i10 = this.leftIndex;
                        this.leftIndex = i10 + 1;
                        this.lefts.put(Integer.valueOf(i10), (TLeft) objPoll);
                        try {
                            bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.leftEnd.apply(objPoll), "The leftEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber = new FlowableGroupJoin.LeftRightEndSubscriber(this, z10, i10);
                            this.disposables.b(leftRightEndSubscriber);
                            cVar.d(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(dVar);
                                return;
                            }
                            long j10 = this.requested.get();
                            Iterator<TRight> it2 = this.rights.values().iterator();
                            long j11 = 0;
                            while (it2.hasNext()) {
                                try {
                                    a0.c cVar2 = (Object) io.reactivex.internal.functions.a.g(this.resultSelector.apply(objPoll, it2.next()), "The resultSelector returned a null value");
                                    if (j11 == j10) {
                                        ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        aVar.clear();
                                        h();
                                        k(dVar);
                                        return;
                                    }
                                    dVar.onNext(cVar2);
                                    j11++;
                                } catch (Throwable th2) {
                                    l(th2, dVar, aVar);
                                    return;
                                }
                            }
                            if (j11 != 0) {
                                io.reactivex.internal.util.b.e(this.requested, j11);
                            }
                        } catch (Throwable th3) {
                            l(th3, dVar, aVar);
                            return;
                        }
                    } else if (num == f33316b) {
                        int i11 = this.rightIndex;
                        this.rightIndex = i11 + 1;
                        this.rights.put(Integer.valueOf(i11), (TRight) objPoll);
                        try {
                            bu.c cVar3 = (bu.c) io.reactivex.internal.functions.a.g(this.rightEnd.apply(objPoll), "The rightEnd returned a null Publisher");
                            FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber2 = new FlowableGroupJoin.LeftRightEndSubscriber(this, false, i11);
                            this.disposables.b(leftRightEndSubscriber2);
                            cVar3.d(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(dVar);
                                return;
                            }
                            long j12 = this.requested.get();
                            Iterator<TLeft> it3 = this.lefts.values().iterator();
                            long j13 = 0;
                            while (it3.hasNext()) {
                                try {
                                    a0.c cVar4 = (Object) io.reactivex.internal.functions.a.g(this.resultSelector.apply(it3.next(), objPoll), "The resultSelector returned a null value");
                                    if (j13 == j12) {
                                        ExceptionHelper.a(this.error, new MissingBackpressureException("Could not emit value due to lack of requests"));
                                        aVar.clear();
                                        h();
                                        k(dVar);
                                        return;
                                    }
                                    dVar.onNext(cVar4);
                                    j13++;
                                } catch (Throwable th4) {
                                    l(th4, dVar, aVar);
                                    return;
                                }
                            }
                            if (j13 != 0) {
                                io.reactivex.internal.util.b.e(this.requested, j13);
                            }
                        } catch (Throwable th5) {
                            l(th5, dVar, aVar);
                            return;
                        }
                    } else if (num == f33317c) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber3 = (FlowableGroupJoin.LeftRightEndSubscriber) objPoll;
                        this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.a(leftRightEndSubscriber3);
                    } else if (num == f33318d) {
                        FlowableGroupJoin.LeftRightEndSubscriber leftRightEndSubscriber4 = (FlowableGroupJoin.LeftRightEndSubscriber) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.a(leftRightEndSubscriber4);
                    }
                    z10 = true;
                }
            }
            aVar.clear();
        }

        public void k(bu.d<?> dVar) {
            Throwable thC = ExceptionHelper.c(this.error);
            this.lefts.clear();
            this.rights.clear();
            dVar.onError(thC);
        }

        public void l(Throwable th2, bu.d<?> dVar, fj.o<?> oVar) {
            io.reactivex.exceptions.a.b(th2);
            ExceptionHelper.a(this.error, th2);
            oVar.clear();
            h();
            k(dVar);
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
            }
        }
    }

    public FlowableJoin(xi.j<TLeft> jVar, bu.c<? extends TRight> cVar, dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> oVar, dj.o<? super TRight, ? extends bu.c<TRightEnd>> oVar2, dj.c<? super TLeft, ? super TRight, ? extends R> cVar2) {
        super(jVar);
        this.f33311c = cVar;
        this.f33312d = oVar;
        this.f33313e = oVar2;
        this.f33314f = cVar2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        JoinSubscription joinSubscription = new JoinSubscription(dVar, this.f33312d, this.f33313e, this.f33314f);
        dVar.onSubscribe(joinSubscription);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, true);
        joinSubscription.disposables.b(leftRightSubscriber);
        FlowableGroupJoin.LeftRightSubscriber leftRightSubscriber2 = new FlowableGroupJoin.LeftRightSubscriber(joinSubscription, false);
        joinSubscription.disposables.b(leftRightSubscriber2);
        this.f33524b.j6(leftRightSubscriber);
        this.f33311c.d(leftRightSubscriber2);
    }
}
