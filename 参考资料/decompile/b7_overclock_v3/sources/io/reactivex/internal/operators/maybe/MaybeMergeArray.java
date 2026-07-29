package io.reactivex.internal.operators.maybe;

import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class MaybeMergeArray<T> extends xi.j<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xi.w<? extends T>[] f33878b;

    public static final class ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements a<T> {
        private static final long serialVersionUID = -4025173261791142821L;
        public int consumerIndex;
        public final AtomicInteger producerIndex = new AtomicInteger();

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int f() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public void i() {
            poll();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int l() {
            return this.consumerIndex;
        }

        @Override // fj.o
        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.a, fj.o
        @bj.f
        public T poll() {
            T t10 = (T) super.poll();
            if (t10 != null) {
                this.consumerIndex++;
            }
            return t10;
        }

        @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, fj.o
        public boolean offer(T t10) {
            this.producerIndex.getAndIncrement();
            return super.offer(t10);
        }
    }

    public static final class MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements xi.t<T> {
        private static final long serialVersionUID = -660395290758764731L;
        public volatile boolean cancelled;
        public long consumed;
        public final bu.d<? super T> downstream;
        public boolean outputFused;
        public final a<Object> queue;
        public final int sourceCount;
        public final io.reactivex.disposables.a set = new io.reactivex.disposables.a();
        public final AtomicLong requested = new AtomicLong();
        public final AtomicThrowable error = new AtomicThrowable();

        public MergeMaybeObserver(bu.d<? super T> dVar, int i10, a<Object> aVar) {
            this.downstream = dVar;
            this.sourceCount = i10;
            this.queue = aVar;
        }

        public void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            if (this.outputFused) {
                c();
            } else {
                h();
            }
        }

        public void c() {
            bu.d<? super T> dVar = this.downstream;
            a<Object> aVar = this.queue;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                Throwable th2 = this.error.get();
                if (th2 != null) {
                    aVar.clear();
                    dVar.onError(th2);
                    return;
                }
                boolean z10 = aVar.f() == this.sourceCount;
                if (!aVar.isEmpty()) {
                    dVar.onNext(null);
                }
                if (z10) {
                    dVar.onComplete();
                    return;
                } else {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            aVar.clear();
        }

        @Override // bu.e
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // fj.o
        public void clear() {
            this.queue.clear();
        }

        public void h() {
            bu.d<? super T> dVar = this.downstream;
            a<Object> aVar = this.queue;
            long j10 = this.consumed;
            int iAddAndGet = 1;
            do {
                long j11 = this.requested.get();
                while (j10 != j11) {
                    if (this.cancelled) {
                        aVar.clear();
                        return;
                    }
                    if (this.error.get() != null) {
                        aVar.clear();
                        dVar.onError(this.error.c());
                        return;
                    } else {
                        if (aVar.l() == this.sourceCount) {
                            dVar.onComplete();
                            return;
                        }
                        Object objPoll = aVar.poll();
                        if (objPoll == null) {
                            break;
                        } else if (objPoll != NotificationLite.COMPLETE) {
                            dVar.onNext(objPoll);
                            j10++;
                        }
                    }
                }
                if (j10 == j11) {
                    if (this.error.get() != null) {
                        aVar.clear();
                        dVar.onError(this.error.c());
                        return;
                    } else {
                        while (aVar.peek() == NotificationLite.COMPLETE) {
                            aVar.i();
                        }
                        if (aVar.l() == this.sourceCount) {
                            dVar.onComplete();
                            return;
                        }
                    }
                }
                this.consumed = j10;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        public boolean k() {
            return this.cancelled;
        }

        @Override // xi.t
        public void onComplete() {
            this.queue.offer(NotificationLite.COMPLETE);
            b();
        }

        @Override // xi.t
        public void onError(Throwable th2) {
            if (!this.error.a(th2)) {
                kj.a.Y(th2);
                return;
            }
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            b();
        }

        @Override // xi.t
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            this.set.b(bVar);
        }

        @Override // xi.t
        public void onSuccess(T t10) {
            this.queue.offer(t10);
            b();
        }

        @Override // fj.o
        @bj.f
        public T poll() throws Exception {
            T t10;
            do {
                t10 = (T) this.queue.poll();
            } while (t10 == NotificationLite.COMPLETE);
            return t10;
        }

        @Override // bu.e
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }

        @Override // fj.k
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public interface a<T> extends fj.o<T> {
        int f();

        void i();

        int l();

        T peek();

        @Override // java.util.Queue, io.reactivex.internal.operators.maybe.MaybeMergeArray.a, fj.o
        @bj.f
        T poll();
    }

    public MaybeMergeArray(xi.w<? extends T>[] wVarArr) {
        this.f33878b = wVarArr;
    }

    @Override // xi.j
    public void k6(bu.d<? super T> dVar) {
        xi.w[] wVarArr = this.f33878b;
        int length = wVarArr.length;
        MergeMaybeObserver mergeMaybeObserver = new MergeMaybeObserver(dVar, length, length <= xi.j.Y() ? new MpscFillOnceSimpleQueue(length) : new ClqSimpleQueue());
        dVar.onSubscribe(mergeMaybeObserver);
        AtomicThrowable atomicThrowable = mergeMaybeObserver.error;
        for (xi.w wVar : wVarArr) {
            if (mergeMaybeObserver.k() || atomicThrowable.get() != null) {
                return;
            }
            wVar.a(mergeMaybeObserver);
        }
    }

    public static final class MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements a<T> {
        private static final long serialVersionUID = -7969063454040569579L;
        public int consumerIndex;
        public final AtomicInteger producerIndex;

        public MpscFillOnceSimpleQueue(int i10) {
            super(i10);
            this.producerIndex = new AtomicInteger();
        }

        @Override // fj.o
        public void clear() {
            while (poll() != null && !isEmpty()) {
            }
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int f() {
            return this.producerIndex.get();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public void i() {
            int i10 = this.consumerIndex;
            lazySet(i10, null);
            this.consumerIndex = i10 + 1;
        }

        @Override // fj.o
        public boolean isEmpty() {
            return this.consumerIndex == f();
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public int l() {
            return this.consumerIndex;
        }

        @Override // fj.o
        public boolean offer(T t10) {
            io.reactivex.internal.functions.a.g(t10, "value is null");
            int andIncrement = this.producerIndex.getAndIncrement();
            if (andIncrement >= length()) {
                return false;
            }
            lazySet(andIncrement, t10);
            return true;
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a
        public T peek() {
            int i10 = this.consumerIndex;
            if (i10 == length()) {
                return null;
            }
            return get(i10);
        }

        @Override // io.reactivex.internal.operators.maybe.MaybeMergeArray.a, java.util.Queue, fj.o
        @bj.f
        public T poll() {
            int i10 = this.consumerIndex;
            if (i10 == length()) {
                return null;
            }
            AtomicInteger atomicInteger = this.producerIndex;
            do {
                T t10 = get(i10);
                if (t10 != null) {
                    this.consumerIndex = i10 + 1;
                    lazySet(i10, null);
                    return t10;
                }
            } while (atomicInteger.get() != i10);
            return null;
        }

        @Override // fj.o
        public boolean offer(T t10, T t11) {
            throw new UnsupportedOperationException();
        }
    }
}
