package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.e0<? extends TRight> f34234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> f34235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dj.o<? super TRight, ? extends xi.e0<TRightEnd>> f34236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final dj.c<? super TLeft, ? super TRight, ? extends R> f34237e;

    public static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements io.reactivex.disposables.b, ObservableGroupJoin.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Integer f34238a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f34239b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Integer f34240c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Integer f34241d = 4;
        private static final long serialVersionUID = -6071216598687999801L;
        public volatile boolean cancelled;
        public final xi.g0<? super R> downstream;
        public final dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> leftEnd;
        public int leftIndex;
        public final dj.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        public final dj.o<? super TRight, ? extends xi.e0<TRightEnd>> rightEnd;
        public int rightIndex;
        public final io.reactivex.disposables.a disposables = new io.reactivex.disposables.a();
        public final io.reactivex.internal.queue.a<Object> queue = new io.reactivex.internal.queue.a<>(xi.z.U());
        public final Map<Integer, TLeft> lefts = new LinkedHashMap();
        public final Map<Integer, TRight> rights = new LinkedHashMap();
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final AtomicInteger active = new AtomicInteger(2);

        public JoinDisposable(xi.g0<? super R> g0Var, dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> oVar, dj.o<? super TRight, ? extends xi.e0<TRightEnd>> oVar2, dj.c<? super TLeft, ? super TRight, ? extends R> cVar) {
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
                this.queue.offer(z10 ? f34238a : f34239b, obj);
            }
            i();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableGroupJoin.a
        public void d(boolean z10, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                this.queue.offer(z10 ? f34240c : f34241d, leftRightEndObserver);
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
        public void f(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
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
                    if (num == f34238a) {
                        int i10 = this.leftIndex;
                        this.leftIndex = i10 + 1;
                        this.lefts.put(Integer.valueOf(i10), (TLeft) objPoll);
                        try {
                            xi.e0 e0Var = (xi.e0) io.reactivex.internal.functions.a.g(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i10);
                            this.disposables.b(leftRightEndObserver);
                            e0Var.c(leftRightEndObserver);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(g0Var);
                                return;
                            } else {
                                Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    try {
                                        g0Var.onNext((Object) io.reactivex.internal.functions.a.g(this.resultSelector.apply(objPoll, it2.next()), "The resultSelector returned a null value"));
                                    } catch (Throwable th2) {
                                        l(th2, g0Var, aVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            l(th3, g0Var, aVar);
                            return;
                        }
                    } else if (num == f34239b) {
                        int i11 = this.rightIndex;
                        this.rightIndex = i11 + 1;
                        this.rights.put(Integer.valueOf(i11), (TRight) objPoll);
                        try {
                            xi.e0 e0Var2 = (xi.e0) io.reactivex.internal.functions.a.g(this.rightEnd.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i11);
                            this.disposables.b(leftRightEndObserver2);
                            e0Var2.c(leftRightEndObserver2);
                            if (this.error.get() != null) {
                                aVar.clear();
                                h();
                                k(g0Var);
                                return;
                            } else {
                                Iterator<TLeft> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    try {
                                        g0Var.onNext((Object) io.reactivex.internal.functions.a.g(this.resultSelector.apply(it3.next(), objPoll), "The resultSelector returned a null value"));
                                    } catch (Throwable th4) {
                                        l(th4, g0Var, aVar);
                                        return;
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            l(th5, g0Var, aVar);
                            return;
                        }
                    } else if (num == f34240c) {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
                        this.lefts.remove(Integer.valueOf(leftRightEndObserver3.index));
                        this.disposables.a(leftRightEndObserver3);
                    } else {
                        ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver4 = (ObservableGroupJoin.LeftRightEndObserver) objPoll;
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

    public ObservableJoin(xi.e0<TLeft> e0Var, xi.e0<? extends TRight> e0Var2, dj.o<? super TLeft, ? extends xi.e0<TLeftEnd>> oVar, dj.o<? super TRight, ? extends xi.e0<TRightEnd>> oVar2, dj.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(e0Var);
        this.f34234b = e0Var2;
        this.f34235c = oVar;
        this.f34236d = oVar2;
        this.f34237e = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // xi.z
    public void I5(xi.g0<? super R> g0Var) {
        JoinDisposable joinDisposable = new JoinDisposable(g0Var, this.f34235c, this.f34236d, this.f34237e);
        g0Var.onSubscribe(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.disposables.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.disposables.b(leftRightObserver2);
        this.f34421a.c(leftRightObserver);
        this.f34234b.c(leftRightObserver2);
    }
}
