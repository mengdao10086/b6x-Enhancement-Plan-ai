package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelReduceFull<T> extends j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.a<? extends T> f34838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dj.c<T, T, T> f34839c;

    public static final class ParallelReduceFullInnerSubscriber<T> extends AtomicReference<bu.e> implements o<T> {
        private static final long serialVersionUID = -7954444275102466525L;
        public boolean done;
        public final ParallelReduceFullMainSubscriber<T> parent;
        public final dj.c<T, T, T> reducer;
        public T value;

        public ParallelReduceFullInnerSubscriber(ParallelReduceFullMainSubscriber<T> parallelReduceFullMainSubscriber, dj.c<T, T, T> cVar) {
            this.parent = parallelReduceFullMainSubscriber;
            this.reducer = cVar;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            this.parent.o(this.value);
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            if (this.done) {
                kj.a.Y(th2);
            } else {
                this.done = true;
                this.parent.a(th2);
            }
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.done) {
                return;
            }
            T t11 = this.value;
            if (t11 == null) {
                this.value = t10;
                return;
            }
            try {
                this.value = (T) io.reactivex.internal.functions.a.g(this.reducer.apply(t11, t10), "The reducer returned a null value");
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                get().cancel();
                onError(th2);
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public static final class ParallelReduceFullMainSubscriber<T> extends DeferredScalarSubscription<T> {
        private static final long serialVersionUID = -5370107872170712765L;
        public final AtomicReference<SlotPair<T>> current;
        public final AtomicReference<Throwable> error;
        public final dj.c<T, T, T> reducer;
        public final AtomicInteger remaining;
        public final ParallelReduceFullInnerSubscriber<T>[] subscribers;

        public ParallelReduceFullMainSubscriber(bu.d<? super T> dVar, int i10, dj.c<T, T, T> cVar) {
            super(dVar);
            this.current = new AtomicReference<>();
            this.remaining = new AtomicInteger();
            this.error = new AtomicReference<>();
            ParallelReduceFullInnerSubscriber<T>[] parallelReduceFullInnerSubscriberArr = new ParallelReduceFullInnerSubscriber[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                parallelReduceFullInnerSubscriberArr[i11] = new ParallelReduceFullInnerSubscriber<>(this, cVar);
            }
            this.subscribers = parallelReduceFullInnerSubscriberArr;
            this.reducer = cVar;
            this.remaining.lazySet(i10);
        }

        public void a(Throwable th2) {
            if (this.error.compareAndSet(null, th2)) {
                cancel();
                this.downstream.onError(th2);
            } else if (th2 != this.error.get()) {
                kj.a.Y(th2);
            }
        }

        @Override // io.reactivex.internal.subscriptions.DeferredScalarSubscription, bu.e
        public void cancel() {
            for (ParallelReduceFullInnerSubscriber<T> parallelReduceFullInnerSubscriber : this.subscribers) {
                parallelReduceFullInnerSubscriber.a();
            }
        }

        public SlotPair<T> n(T t10) {
            SlotPair<T> slotPair;
            int iB;
            while (true) {
                slotPair = this.current.get();
                if (slotPair == null) {
                    slotPair = new SlotPair<>();
                    if (!this.current.compareAndSet(null, slotPair)) {
                        continue;
                    }
                }
                iB = slotPair.b();
                if (iB >= 0) {
                    break;
                }
                this.current.compareAndSet(slotPair, null);
            }
            if (iB == 0) {
                slotPair.first = t10;
            } else {
                slotPair.second = t10;
            }
            if (!slotPair.a()) {
                return null;
            }
            this.current.compareAndSet(slotPair, null);
            return slotPair;
        }

        public void o(T t10) {
            if (t10 != null) {
                while (true) {
                    SlotPair<T> slotPairN = n(t10);
                    if (slotPairN == null) {
                        break;
                    }
                    try {
                        t10 = (T) io.reactivex.internal.functions.a.g(this.reducer.apply(slotPairN.first, slotPairN.second), "The reducer returned a null value");
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        a(th2);
                        return;
                    }
                }
            }
            if (this.remaining.decrementAndGet() == 0) {
                SlotPair<T> slotPair = this.current.get();
                this.current.lazySet(null);
                if (slotPair != null) {
                    c(slotPair.first);
                } else {
                    this.downstream.onComplete();
                }
            }
        }
    }

    public static final class SlotPair<T> extends AtomicInteger {
        private static final long serialVersionUID = 473971317683868662L;
        public T first;
        public final AtomicInteger releaseIndex = new AtomicInteger();
        public T second;

        public boolean a() {
            return this.releaseIndex.incrementAndGet() == 2;
        }

        public int b() {
            int i10;
            do {
                i10 = get();
                if (i10 >= 2) {
                    return -1;
                }
            } while (!compareAndSet(i10, i10 + 1));
            return i10;
        }
    }

    public ParallelReduceFull(jj.a<? extends T> aVar, dj.c<T, T, T> cVar) {
        this.f34838b = aVar;
        this.f34839c = cVar;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber = new ParallelReduceFullMainSubscriber(dVar, this.f34838b.F(), this.f34839c);
        dVar.onSubscribe(parallelReduceFullMainSubscriber);
        this.f34838b.Q(parallelReduceFullMainSubscriber.subscribers);
    }
}
