package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableGroupJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.observable.a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<? extends TRight> f34190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> f34191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super TRight, ? extends xi.e0<TRightEnd>> f34192d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.c<? super TLeft, ? super xi.z<TRight>, ? extends R> f34193e;

    public static final class GroupJoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f34194a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f34195b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Integer f34196c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Integer f34197d = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public volatile boolean cancelled;
        public final xi.g0<? super R> downstream;
        public final dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final dj.c<? super TLeft, ? super xi.z<TRight>, ? extends R> resultSelector;
        public final dj.o<? super TRight, ? extends xi.e0<TRightEnd>> rightEnd;
        public int rightIndex;
        public final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        public final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(xi.z.U());
        public final Map<Integer, UnicastSubject<TRight>> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public GroupJoinDisposable(xi.g0<? super R> g0Var, dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> oVar, dj.o<? super TRight, ? extends xi.e0<TRightEnd>> oVar2, dj.c<? super TLeft, ? super xi.z<TRight>, ? extends R> cVar) {
            this.downstream = g0Var;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void a(Throwable th2) {
            if (!ExceptionHelper.a(this.error, th2)) {
                kj.a.Y(th2);
            } else {
                this.active.decrementAndGet();
                i();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void b(Throwable th2) {
            if (ExceptionHelper.a(this.error, th2)) {
                i();
            } else {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void c(boolean z10, Object obj) {
            synchronized (this) {
                this.queue.offer(z10 ? f34194a : f34195b, obj);
            }
            i();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void d(boolean z10, LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.offer(z10 ? f34196c : f34197d, leftRightEndObserver);
            }
            i();
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            h();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void f(LeftRightObserver leftRightObserver) {
            this.disposables.c(leftRightObserver);
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
            io.reactivex.internal.queue.a<?> aVar = this.queue;
            xi.g0<? super R> g0Var = this.downstream;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    aVar.clear();
                    h();
                    k(g0Var);
                    return;
                }
                boolean z10 = this.active.get() == 0;
                Integer num = (Integer) aVar.poll();
                boolean z11 = num == null;
                if (z10 && z11) {
                    Iterator<UnicastSubject<TRight>> it2 = this.lefts.values().iterator();
                    while (it2.hasNext()) {
                        it2.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    g0Var.onComplete();
                    return;
                }
                if (z11) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = aVar.poll();
                    if (num == f34194a) {
                        UnicastSubject unicastSubjectN8 = UnicastSubject.n8();
                        int i10 = this.leftIndex;
                        this.leftIndex = i10 + 1;
                        this.lefts.put(Integer.valueOf(i10), (UnicastSubject<TRight>) unicastSubjectN8);
                        try {
                            xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver = new LeftRightEndObserver(this, true, i10);
                            this.disposables.b(leftRightEndObserver);
                            e0Var.c(leftRightEndObserver);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(g0Var);
                                return;
                            } else {
                                try {
                                    g0Var.onNext((Object) io.reactivex.internal.functions.a.g(this.resultSelector.apply(objPoll, unicastSubjectN8), "The resultSelector returned a null value"));
                                    Iterator<TRight> it3 = this.rights.values().iterator();
                                    while (it3.hasNext()) {
                                        unicastSubjectN8.onNext(it3.next());
                                    }
                                } catch (Throwable th2) {
                                    l(th2, g0Var, aVar);
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            l(th3, g0Var, aVar);
                            return;
                        }
                    } else if (num == f34195b) {
                        int i11 = this.rightIndex;
                        this.rightIndex = i11 + 1;
                        this.rights.put(Integer.valueOf(i11), (TRight) objPoll);
                        try {
                            xi.e0 e0Var2 = (xi.e0) io.reactivex.internal.functions.a.g(this.rightEnd.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            LeftRightEndObserver leftRightEndObserver2 = new LeftRightEndObserver(this, false, i11);
                            this.disposables.b(leftRightEndObserver2);
                            e0Var2.c(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(g0Var);
                                return;
                            } else {
                                Iterator<UnicastSubject<TRight>> it4 = this.lefts.values().iterator();
                                while (it4.hasNext()) {
                                    it4.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th4) {
                            l(th4, g0Var, aVar);
                            return;
                        }
                    } else if (num == f34196c) {
                        LeftRightEndObserver leftRightEndObserver3 = (LeftRightEndObserver) objPoll;
                        UnicastSubject<TRight> unicastSubjectRemove = this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.a(leftRightEndObserver3);
                        if (unicastSubjectRemove != null) {
                            unicastSubjectRemove.onComplete();
                        }
                    } else if (num == f34197d) {
                        LeftRightEndObserver leftRightEndObserver4 = (LeftRightEndObserver) objPoll;
                        this.rights.remove(Integer.valueOf(leftRightEndObserver4.index));
                        this.disposables.a(leftRightEndObserver4);
                    }
                }
            }
            aVar.clear();
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void k(xi.g0<?> g0Var) {
            Throwable thC = ExceptionHelper.c(this.error);
            Iterator<UnicastSubject<TRight>> it2 = this.lefts.values().iterator();
            while (it2.hasNext()) {
                it2.next().onError(thC);
            }
            this.lefts.clear();
            this.rights.clear();
            g0Var.onError(thC);
        }

        public void l(Throwable th2, xi.g0<?> g0Var, io.reactivex.internal.queue.a<?> aVar) {
            io.reactivex.exceptions.a.b(th2);
            ExceptionHelper.a(this.error, th2);
            aVar.clear();
            h();
            k(g0Var);
        }
    }

    public static final class LeftRightEndObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1883890389173668373L;
        public final int index;
        public final boolean isLeft;
        public final a parent;

        public LeftRightEndObserver(a aVar, boolean z10, int i10) {
            this.parent = aVar;
            this.isLeft = z10;
            this.index = i10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.parent.d(this.isLeft, this);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.parent.b(th2);
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.d(this.isLeft, this);
            }
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public static final class LeftRightObserver extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<Object>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 1883890389173668373L;
        public final boolean isLeft;
        public final a parent;

        public LeftRightObserver(a aVar, boolean z10) {
            this.parent = aVar;
            this.isLeft = z10;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // xi.g0
        public void onComplete() {
            this.parent.f(this);
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.parent.a(th2);
        }

        @Override // xi.g0
        public void onNext(Object obj) {
            this.parent.c(this.isLeft, obj);
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public interface a {
        void a(Throwable th2);

        void b(Throwable th2);

        void c(boolean z10, Object obj);

        void d(boolean z10, LeftRightEndObserver leftRightEndObserver);

        void f(LeftRightObserver leftRightObserver);
    }

    public ObservableGroupJoin(xi.e0<TLeft> e0Var, xi.e0<? extends TRight> e0Var2, dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> oVar, dj.o<? super TRight, ? extends xi.e0<TRightEnd>> oVar2, dj.c<? super TLeft, ? super xi.z<TRight>, ? extends R> cVar) {
        super(e0Var);
        this.f34190b = e0Var2;
        this.f34191c = oVar;
        this.f34192d = oVar2;
        this.f34193e = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        GroupJoinDisposable groupJoinDisposable = new GroupJoinDisposable(g0Var, this.f34191c, this.f34192d, this.f34193e);
        g0Var.onSubscribe(groupJoinDisposable);
        LeftRightObserver leftRightObserver = new LeftRightObserver(groupJoinDisposable, true);
        groupJoinDisposable.disposables.b(leftRightObserver);
        LeftRightObserver leftRightObserver2 = new LeftRightObserver(groupJoinDisposable, false);
        groupJoinDisposable.disposables.b(leftRightObserver2);
        this.f34421a.c(leftRightObserver);
        this.f34190b.c(leftRightObserver2);
    }
}
