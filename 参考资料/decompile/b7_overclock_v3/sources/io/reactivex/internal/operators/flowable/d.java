package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ExceptionHelper;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bu.c<? extends T> f33555a;

    public static final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T> f33556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final bu.c<? extends T> f33557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f33558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33559d = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f33560e = true;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Throwable f33561f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f33562g;

        public a(bu.c<? extends T> cVar, b<T> bVar) {
            this.f33557b = cVar;
            this.f33556a = bVar;
        }

        public final boolean a() {
            try {
                if (!this.f33562g) {
                    this.f33562g = true;
                    this.f33556a.e();
                    xi.j.Y2(this.f33557b).L3().j6(this.f33556a);
                }
                xi.y<T> yVarF = this.f33556a.f();
                if (yVarF.h()) {
                    this.f33560e = false;
                    this.f33558c = yVarF.e();
                    return true;
                }
                this.f33559d = false;
                if (yVarF.f()) {
                    return false;
                }
                if (!yVarF.g()) {
                    throw new IllegalStateException("Should not reach here");
                }
                Throwable thD = yVarF.d();
                this.f33561f = thD;
                throw ExceptionHelper.f(thD);
            } catch (InterruptedException e10) {
                this.f33556a.dispose();
                this.f33561f = e10;
                throw ExceptionHelper.f(e10);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th2 = this.f33561f;
            if (th2 != null) {
                throw ExceptionHelper.f(th2);
            }
            if (this.f33559d) {
                return !this.f33560e || a();
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th2 = this.f33561f;
            if (th2 != null) {
                throw ExceptionHelper.f(th2);
            }
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            this.f33560e = true;
            return this.f33558c;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class b<T> extends io.reactivex.subscribers.b<xi.y<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BlockingQueue<xi.y<T>> f33563b = new ArrayBlockingQueue(1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f33564c = new AtomicInteger();

        @Override // bu.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onNext(xi.y<T> yVar) {
            if (this.f33564c.getAndSet(0) == 1 || !yVar.h()) {
                while (!this.f33563b.offer(yVar)) {
                    xi.y<T> yVarPoll = this.f33563b.poll();
                    if (yVarPoll != null && !yVarPoll.h()) {
                        yVar = yVarPoll;
                    }
                }
            }
        }

        public void e() {
            this.f33564c.set(1);
        }

        public xi.y<T> f() throws InterruptedException {
            e();
            io.reactivex.internal.util.c.b();
            return this.f33563b.take();
        }

        @Override // bu.d
        public void onComplete() {
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            kj.a.Y(th2);
        }
    }

    public d(bu.c<? extends T> cVar) {
        this.f33555a = cVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f33555a, new b());
    }
}
