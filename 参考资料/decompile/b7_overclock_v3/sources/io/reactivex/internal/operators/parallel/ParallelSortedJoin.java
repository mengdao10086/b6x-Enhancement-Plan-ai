package io.reactivex.internal.operators.parallel;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import xi.j;
import xi.o;

/* JADX INFO: loaded from: classes5.dex */
public final class ParallelSortedJoin<T> extends j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final jj.a<List<T>> f34846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator<? super T> f34847c;

    public static final class SortedJoinInnerSubscriber<T> extends AtomicReference<bu.e> implements o<List<T>> {
        private static final long serialVersionUID = 6751017204873808094L;
        public final int index;
        public final SortedJoinSubscription<T> parent;

        public SortedJoinInnerSubscriber(SortedJoinSubscription<T> sortedJoinSubscription, int i10) {
            this.parent = sortedJoinSubscription;
            this.index = i10;
        }

        public void a() {
            SubscriptionHelper.cancel(this);
        }

        @Override // bu.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(List<T> list) {
            this.parent.d(list, this.index);
        }

        @Override // bu.d
        public void onComplete() {
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.parent.c(th2);
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, Long.MAX_VALUE);
        }
    }

    public static final class SortedJoinSubscription<T> extends AtomicInteger implements bu.e {
        private static final long serialVersionUID = 3481980673745556697L;
        public volatile boolean cancelled;
        public final Comparator<? super T> comparator;
        public final bu.d<? super T> downstream;
        public final int[] indexes;
        public final List<T>[] lists;
        public final SortedJoinInnerSubscriber<T>[] subscribers;
        public final AtomicLong requested = new AtomicLong();
        public final AtomicInteger remaining = new AtomicInteger();
        public final AtomicReference<Throwable> error = new AtomicReference<>();

        public SortedJoinSubscription(bu.d<? super T> dVar, int i10, Comparator<? super T> comparator) {
            this.downstream = dVar;
            this.comparator = comparator;
            SortedJoinInnerSubscriber<T>[] sortedJoinInnerSubscriberArr = new SortedJoinInnerSubscriber[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                sortedJoinInnerSubscriberArr[i11] = new SortedJoinInnerSubscriber<>(this, i11);
            }
            this.subscribers = sortedJoinInnerSubscriberArr;
            this.lists = new List[i10];
            this.indexes = new int[i10];
            this.remaining.lazySet(i10);
        }

        public void a() {
            for (SortedJoinInnerSubscriber<T> sortedJoinInnerSubscriber : this.subscribers) {
                sortedJoinInnerSubscriber.a();
            }
        }

        public void b() {
            boolean z10;
            if (getAndIncrement() != 0) {
                return;
            }
            bu.d<? super T> dVar = this.downstream;
            List<T>[] listArr = this.lists;
            int[] iArr = this.indexes;
            int length = iArr.length;
            int i10 = 1;
            while (true) {
                long j10 = this.requested.get();
                long j11 = 0;
                while (j11 != j10) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th2 = this.error.get();
                    if (th2 != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        dVar.onError(th2);
                        return;
                    }
                    int i11 = -1;
                    T t10 = null;
                    for (int i12 = 0; i12 < length; i12++) {
                        List<T> list = listArr[i12];
                        int i13 = iArr[i12];
                        if (list.size() != i13) {
                            if (t10 == null) {
                                t10 = list.get(i13);
                            } else {
                                T t11 = list.get(i13);
                                try {
                                    if (this.comparator.compare(t10, t11) > 0) {
                                        t10 = t11;
                                    }
                                } catch (Throwable th3) {
                                    io.reactivex.exceptions.a.b(th3);
                                    a();
                                    Arrays.fill(listArr, (Object) null);
                                    if (!this.error.compareAndSet(null, th3)) {
                                        kj.a.Y(th3);
                                    }
                                    dVar.onError(this.error.get());
                                    return;
                                }
                            }
                            i11 = i12;
                        }
                    }
                    if (t10 == null) {
                        Arrays.fill(listArr, (Object) null);
                        dVar.onComplete();
                        return;
                    } else {
                        dVar.onNext(t10);
                        iArr[i11] = iArr[i11] + 1;
                        j11++;
                    }
                }
                if (j11 == j10) {
                    if (this.cancelled) {
                        Arrays.fill(listArr, (Object) null);
                        return;
                    }
                    Throwable th4 = this.error.get();
                    if (th4 != null) {
                        a();
                        Arrays.fill(listArr, (Object) null);
                        dVar.onError(th4);
                        return;
                    }
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length) {
                            z10 = true;
                            break;
                        } else {
                            if (iArr[i14] != listArr[i14].size()) {
                                z10 = false;
                                break;
                            }
                            i14++;
                        }
                    }
                    if (z10) {
                        Arrays.fill(listArr, (Object) null);
                        dVar.onComplete();
                        return;
                    }
                }
                if (j11 != 0 && j10 != Long.MAX_VALUE) {
                    this.requested.addAndGet(-j11);
                }
                int iAddAndGet = get();
                if (iAddAndGet == i10 && (iAddAndGet = addAndGet(-i10)) == 0) {
                    return;
                } else {
                    i10 = iAddAndGet;
                }
            }
        }

        public void c(Throwable th2) {
            if (this.error.compareAndSet(null, th2)) {
                b();
            } else if (th2 != this.error.get()) {
                kj.a.Y(th2);
            }
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            a();
            if (getAndIncrement() == 0) {
                Arrays.fill(this.lists, (Object) null);
            }
        }

        public void d(List<T> list, int i10) {
            this.lists[i10] = list;
            if (this.remaining.decrementAndGet() == 0) {
                b();
            }
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                if (this.remaining.get() == 0) {
                    b();
                }
            }
        }
    }

    public ParallelSortedJoin(jj.a<List<T>> aVar, Comparator<? super T> comparator) {
        this.f34846b = aVar;
        this.f34847c = comparator;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        SortedJoinSubscription sortedJoinSubscription = new SortedJoinSubscription(dVar, this.f34846b.F(), this.f34847c);
        dVar.onSubscribe(sortedJoinSubscription);
        this.f34846b.Q(sortedJoinSubscription.subscribers);
    }
}
