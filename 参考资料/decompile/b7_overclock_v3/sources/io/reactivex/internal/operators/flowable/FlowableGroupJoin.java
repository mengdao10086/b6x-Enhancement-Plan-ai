package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.flowable.a<TLeft, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bu.c<? extends TRight> f33267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> f33268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.o<? super TRight, ? extends bu.c<TRightEnd>> f33269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final dj.c<? super TLeft, ? super xi.j<TRight>, ? extends R> f33270f;

    public static final class GroupJoinSubscription<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements bu.e, a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f33271a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f33272b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Integer f33273c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Integer f33274d = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public volatile boolean cancelled;
        public final bu.d<? super R> downstream;
        public final dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final dj.c<? super TLeft, ? super xi.j<TRight>, ? extends R> resultSelector;
        public final dj.o<? super TRight, ? extends bu.c<TRightEnd>> rightEnd;
        public int rightIndex;
        public final AtomicLong requested = new AtomicLong();
        public final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        public final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(xi.j.Y());
        public final Map<Integer, UnicastProcessor<TRight>> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public GroupJoinSubscription(bu.d<? super R> dVar, dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> oVar, dj.o<? super TRight, ? extends bu.c<TRightEnd>> oVar2, dj.c<? super TLeft, ? super xi.j<TRight>, ? extends R> cVar) {
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
                this.queue.offer(z10 ? f33271a : f33272b, obj);
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
        public void d(boolean z10, LeftRightEndSubscriber leftRightEndSubscriber) {
            synchronized (this) {
                this.queue.offer(z10 ? f33273c : f33274d, leftRightEndSubscriber);
            }
            i();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableGroupJoin.a
        public void f(LeftRightSubscriber leftRightSubscriber) {
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
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    h();
                    k(dVar);
                    return;
                }
                boolean z10 = this.active.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z11 = num == null;
                if (z10 && z11) {
                    Iterator<UnicastProcessor<TRight>> it2 = this.lefts.values().iterator();
                    while (it2.hasNext()) {
                        it2.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    dVar.onComplete();
                    return;
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = aVar.poll();
                    if (num == f33271a) {
                        UnicastProcessor unicastProcessorS8 = UnicastProcessor.S8();
                        int i10 = this.leftIndex;
                        this.leftIndex = i10 + 1;
                        this.lefts.put(Integer.valueOf(i10), (UnicastProcessor<TRight>) unicastProcessorS8);
                        try {
                            bu.c cVar = (bu.c) io.reactivex.internal.functions.a.g(this.leftEnd.apply(objPoll), "The leftEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber = new LeftRightEndSubscriber(this, true, i10);
                            this.disposables.b(leftRightEndSubscriber);
                            cVar.d(leftRightEndSubscriber);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(dVar);
                                return;
                            }
                            try {
                                a0.c cVar2 = (Object) io.reactivex.internal.functions.a.g(this.resultSelector.apply(objPoll, unicastProcessorS8), "The resultSelector returned a null value");
                                if (this.requested.get() == 0) {
                                    l(new MissingBackpressureException("Could not emit value due to lack of requests"), dVar, aVar);
                                    return;
                                }
                                dVar.onNext(cVar2);
                                io.reactivex.internal.util.b.e(this.requested, 1L);
                                Iterator<TRight> it3 = this.rights.values().iterator();
                                while (it3.hasNext()) {
                                    unicastProcessorS8.onNext(it3.next());
                                }
                            } catch (Throwable th2) {
                                l(th2, dVar, aVar);
                                return;
                            }
                        } catch (Throwable th3) {
                            l(th3, dVar, aVar);
                            return;
                        }
                    } else if (num == f33272b) {
                        int i11 = this.rightIndex;
                        this.rightIndex = i11 + 1;
                        this.rights.put(Integer.valueOf(i11), (TRight) objPoll);
                        try {
                            bu.c cVar3 = (bu.c) io.reactivex.internal.functions.a.g(this.rightEnd.apply(objPoll), "The rightEnd returned a null Publisher");
                            LeftRightEndSubscriber leftRightEndSubscriber2 = new LeftRightEndSubscriber(this, false, i11);
                            this.disposables.b(leftRightEndSubscriber2);
                            cVar3.d(leftRightEndSubscriber2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(dVar);
                                return;
                            } else {
                                Iterator<UnicastProcessor<TRight>> it4 = this.lefts.values().iterator();
                                while (it4.hasNext()) {
                                    it4.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th4) {
                            l(th4, dVar, aVar);
                            return;
                        }
                    } else if (num == f33273c) {
                        LeftRightEndSubscriber leftRightEndSubscriber3 = (LeftRightEndSubscriber) objPoll;
                        UnicastProcessor<TRight> unicastProcessorRemove = this.lefts.remove(Integer.valueOf(leftRightEndSubscriber3.index));
                        this.disposables.a(leftRightEndSubscriber3);
                        if (unicastProcessorRemove != null) {
                            unicastProcessorRemove.onComplete();
                        }
                    } else if (num == f33274d) {
                        LeftRightEndSubscriber leftRightEndSubscriber4 = (LeftRightEndSubscriber) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndSubscriber4.index));
                        this.disposables.a(leftRightEndSubscriber4);
                    }
                }
            }
            aVar.clear();
        }

        public void k(bu.d<?> dVar) {
            Throwable thC = ExceptionHelper.c(this.error);
            Iterator<UnicastProcessor<TRight>> it2 = this.lefts.values().iterator();
            while (it2.hasNext()) {
                it2.next().onError(thC);
            }
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

    public static final class LeftRightEndSubscriber extends AtomicReference<bu.e> implements xi.o<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1883890389173668373L;
        public final int index;
        public final boolean isLeft;
        public final a parent;

        public LeftRightEndSubscriber(a aVar, boolean z10, int i10) {
            this.parent = aVar;
            this.isLeft = z10;
            this.index = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.parent.d(this.isLeft, this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.b(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            if (SubscriptionHelper.cancel(this)) {
                this.parent.d(this.isLeft, this);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public static final class LeftRightSubscriber extends AtomicReference<bu.e> implements xi.o<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1883890389173668373L;
        public final boolean isLeft;
        public final a parent;

        public LeftRightSubscriber(a aVar, boolean z10) {
            this.parent = aVar;
            this.isLeft = z10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // bu.d
        public void onComplete() {
            this.parent.f(this);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.a(th2);
        }

        @Override // bu.d
        public void onNext(Object obj) {
            this.parent.c(this.isLeft, obj);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public interface a {
        void a(Throwable th2);

        void b(Throwable th2);

        void c(boolean z10, Object obj);

        void d(boolean z10, LeftRightEndSubscriber leftRightEndSubscriber);

        void f(LeftRightSubscriber leftRightSubscriber);
    }

    public FlowableGroupJoin(xi.j<TLeft> jVar, bu.c<? extends TRight> cVar, dj.o<? super TLeft, ? extends bu.c<TLeftEnd>> oVar, dj.o<? super TRight, ? extends bu.c<TRightEnd>> oVar2, dj.c<? super TLeft, ? super xi.j<TRight>, ? extends R> cVar2) {
        super(jVar);
        this.f33267c = cVar;
        this.f33268d = oVar;
        this.f33269e = oVar2;
        this.f33270f = cVar2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // xi.j
    public void k6(bu.d<? super R> dVar) {
        GroupJoinSubscription groupJoinSubscription = new GroupJoinSubscription(dVar, this.f33268d, this.f33269e, this.f33270f);
        dVar.onSubscribe(groupJoinSubscription);
        LeftRightSubscriber leftRightSubscriber = new LeftRightSubscriber(groupJoinSubscription, true);
        groupJoinSubscription.disposables.b(leftRightSubscriber);
        LeftRightSubscriber leftRightSubscriber2 = new LeftRightSubscriber(groupJoinSubscription, false);
        groupJoinSubscription.disposables.b(leftRightSubscriber2);
        this.f33524b.j6(leftRightSubscriber);
        this.f33267c.d(leftRightSubscriber2);
    }
}
