package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34467a;

    public static final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T> f34468a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.e0<T> f34469b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f34470c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f34471d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f34472e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Throwable f34473f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f34474g;

        public a(xi.e0<T> e0Var, b<T> bVar) {
            this.f34469b = e0Var;
            this.f34468a = bVar;
        }

        public final boolean a() {
            if (!this.f34474g) {
                this.f34474g = true;
                this.f34468a.c();
                new z0(this.f34469b).c(this.f34468a);
            }
            try {
                xi.y<T> yVarD = this.f34468a.d();
                if (yVarD.h()) {
                    this.f34472e = false;
                    this.f34470c = yVarD.e();
                    return true;
                }
                this.f34471d = false;
                if (yVarD.f()) {
                    return false;
                }
                Throwable thD = yVarD.d();
                this.f34473f = thD;
                throw ExceptionHelper.f(thD);
            } catch (InterruptedException e10) {
                this.f34468a.dispose();
                this.f34473f = e10;
                throw ExceptionHelper.f(e10);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th2 = this.f34473f;
            if (th2 != null) {
                throw ExceptionHelper.f(th2);
            }
            if (this.f34471d) {
                return !this.f34472e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th2 = this.f34473f;
            if (th2 != null) {
                throw ExceptionHelper.f(th2);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f34472e = true;
            return this.f34470c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class b<T> extends io.reactivex.observers.d<xi.y<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BlockingQueue<xi.y<T>> f34475b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f34476c = new AtomicInteger();

        @Override // xi.g0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onNext(xi.y<T> yVar) {
            if (this.f34476c.getAndSet(0) == 1 || !yVar.h()) {
                while (!this.f34475b.offer(yVar)) {
                    xi.y<T> yVarPoll = this.f34475b.poll();
                    if (yVarPoll != null && !yVarPoll.h()) {
                        yVar = yVarPoll;
                    }
                }
            }
        }

        public void c() {
            this.f34476c.set(1);
        }

        public xi.y<T> d() throws InterruptedException {
            c();
            io.reactivex.internal.util.c.b();
            return this.f34475b.take();
        }

        @Override // xi.g0
        public void onComplete() {
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            kj.a.Y(th2);
        }
    }

    public d(xi.e0<T> e0Var) {
        this.f34467a = e0Var;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f34467a, new b());
    }
}
