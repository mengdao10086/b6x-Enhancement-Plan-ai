package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34434a;

    public static final class a<T> extends io.reactivex.observers.d<xi.y<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public xi.y<T> f34435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Semaphore f34436c = new Semaphore(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReference<xi.y<T>> f34437d = new AtomicReference<>();

        @Override // xi.g0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(xi.y<T> yVar) {
            if (this.f34437d.getAndSet(yVar) == null) {
                this.f34436c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            xi.y<T> yVar = this.f34435b;
            if (yVar != null && yVar.g()) {
                throw ExceptionHelper.f(this.f34435b.d());
            }
            if (this.f34435b == null) {
                try {
                    io.reactivex.internal.util.c.b();
                    this.f34436c.acquire();
                    xi.y<T> andSet = this.f34437d.getAndSet(null);
                    this.f34435b = andSet;
                    if (andSet.g()) {
                        throw ExceptionHelper.f(andSet.d());
                    }
                } catch (InterruptedException e10) {
                    dispose();
                    this.f34435b = xi.y.b(e10);
                    throw ExceptionHelper.f(e10);
                }
            }
            return this.f34435b.h();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tE = this.f34435b.e();
            this.f34435b = null;
            return tE;
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            kj.a.Y(th2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public b(xi.e0<T> e0Var) {
        this.f34434a = e0Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        xi.z.P7(this.f34434a).B3().c(aVar);
        return aVar;
    }
}
