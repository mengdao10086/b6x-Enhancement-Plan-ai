package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingFlowableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33155b;

    public static final class BlockingFlowableIterator<T> extends AtomicReference<bu.e> implements xi.o<T>, Iterator<T>, Runnable, io.reactivex.disposables.b {
        private static final long serialVersionUID = 6695226475494099826L;
        public final long batchSize;
        public final Condition condition;
        public volatile boolean done;
        public volatile Throwable error;
        public final long limit;
        public final Lock lock;
        public long produced;
        public final SpscArrayQueue<T> queue;

        public BlockingFlowableIterator(int i10) {
            this.queue = new SpscArrayQueue<>(i10);
            this.batchSize = i10;
            this.limit = i10 - (i10 >> 2);
            ReentrantLock reentrantLock = new ReentrantLock();
            this.lock = reentrantLock;
            this.condition = reentrantLock.newCondition();
        }

        public void a() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            SubscriptionHelper.cancel(this);
            a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!isDisposed()) {
                boolean z10 = this.done;
                boolean zIsEmpty = this.queue.isEmpty();
                if (z10) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        throw ExceptionHelper.f(th2);
                    }
                    if (zIsEmpty) {
                        return false;
                    }
                }
                if (!zIsEmpty) {
                    return true;
                }
                io.reactivex.internal.util.c.b();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                    try {
                        try {
                            this.condition.await();
                        } catch (InterruptedException e10) {
                            run();
                            throw ExceptionHelper.f(e10);
                        }
                    } finally {
                        this.lock.unlock();
                    }
                }
            }
            Throwable th3 = this.error;
            if (th3 == null) {
                return false;
            }
            throw ExceptionHelper.f(th3);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == SubscriptionHelper.CANCELLED;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tPoll = this.queue.poll();
            long j10 = this.produced + 1;
            if (j10 == this.limit) {
                this.produced = 0L;
                get().request(j10);
            } else {
                this.produced = j10;
            }
            return tPoll;
        }

        @Override // bu.d
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // bu.d
        public void onNext(T t10) {
            if (this.queue.offer(t10)) {
                a();
            } else {
                SubscriptionHelper.cancel(this);
                onError(new MissingBackpressureException("Queue full?!"));
            }
        }

        @Override // xi.o, bu.d
        public void onSubscribe(bu.e eVar) {
            SubscriptionHelper.setOnce(this, eVar, this.batchSize);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.lang.Runnable
        public void run() {
            SubscriptionHelper.cancel(this);
            a();
        }
    }

    public BlockingFlowableIterable(xi.j<T> jVar, int i10) {
        this.f33154a = jVar;
        this.f33155b = i10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingFlowableIterator blockingFlowableIterator = new BlockingFlowableIterator(this.f33155b);
        this.f33154a.j6(blockingFlowableIterator);
        return blockingFlowableIterator;
    }
}
