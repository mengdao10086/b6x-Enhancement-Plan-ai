package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends T> f33533a;

    public static final class a<T> extends io.reactivex.subscribers.b<xi.y<T>> implements Iterator<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Semaphore f33534b = new Semaphore(0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReference<xi.y<T>> f33535c = new AtomicReference<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public xi.y<T> f33536d;

        @Override // bu.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(xi.y<T> yVar) {
            if (this.f33535c.getAndSet(yVar) == null) {
                this.f33534b.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            xi.y<T> yVar = this.f33536d;
            if (yVar != null && yVar.g()) {
                throw ExceptionHelper.f(this.f33536d.d());
            }
            xi.y<T> yVar2 = this.f33536d;
            if ((yVar2 == null || yVar2.h()) && this.f33536d == null) {
                try {
                    io.reactivex.internal.util.c.b();
                    this.f33534b.acquire();
                    xi.y<T> andSet = this.f33535c.getAndSet(null);
                    this.f33536d = andSet;
                    if (andSet.g()) {
                        throw ExceptionHelper.f(andSet.d());
                    }
                } catch (InterruptedException e10) {
                    dispose();
                    this.f33536d = xi.y.b(e10);
                    throw ExceptionHelper.f(e10);
                }
            }
            return this.f33536d.h();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext() || !this.f33536d.h()) {
                throw new NoSuchElementException();
            }
            T tE = this.f33536d.e();
            this.f33536d = null;
            return tE;
        }

        @Override // bu.d
        public void onComplete() {
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            kj.a.Y(th2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public b(bu.c<? extends T> cVar) {
        this.f33533a = cVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        xi.j.Y2(this.f33533a).L3().j6(aVar);
        return aVar;
    }
}
