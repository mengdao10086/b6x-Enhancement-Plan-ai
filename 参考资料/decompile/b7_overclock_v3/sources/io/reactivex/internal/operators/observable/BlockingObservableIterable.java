package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes5.dex */
public final class BlockingObservableIterable<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<? extends T> f34107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34108b;

    public static final class BlockingObservableIterator<T> extends AtomicReference<io.reactivex.disposables.b> implements xi.g0<T>, Iterator<T>, io.reactivex.disposables.b {
        private static final long serialVersionUID = 6695226475494099826L;
        public final Condition condition;
        public volatile boolean done;
        public volatile Throwable error;
        public final Lock lock;
        public final io.reactivex.internal.queue.a<T> queue;

        public BlockingObservableIterator(int i10) {
            this.queue = new io.reactivex.internal.queue.a<>(i10);
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
            DisposableHelper.dispose(this);
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
                try {
                    io.reactivex.internal.util.c.b();
                    this.lock.lock();
                    while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                        try {
                            this.condition.await();
                        } finally {
                        }
                    }
                    this.lock.unlock();
                } catch (InterruptedException e10) {
                    DisposableHelper.dispose(this);
                    a();
                    throw ExceptionHelper.f(e10);
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
            return DisposableHelper.isDisposed(get());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        @Override // xi.g0
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // xi.g0
        public void onSubscribe(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }
    }

    public BlockingObservableIterable(xi.e0<? extends T> e0Var, int i10) {
        this.f34107a = e0Var;
        this.f34108b = i10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        BlockingObservableIterator blockingObservableIterator = new BlockingObservableIterator(this.f34108b);
        this.f34107a.c(blockingObservableIterator);
        return blockingObservableIterator;
    }
}
