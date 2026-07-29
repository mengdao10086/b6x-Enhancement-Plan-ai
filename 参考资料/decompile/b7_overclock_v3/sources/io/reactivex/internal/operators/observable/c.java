package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.e0<T> f34448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f34449b;

    public static final class a<T> extends io.reactivex.observers.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Object f34450b;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.c$a$a, reason: collision with other inner class name */
        public final class C0387a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f34451a;

            public C0387a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f34451a = a.this.f34450b;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f34451a == null) {
                        this.f34451a = a.this.f34450b;
                    }
                    if (NotificationLite.isComplete(this.f34451a)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.f34451a)) {
                        throw ExceptionHelper.f(NotificationLite.getError(this.f34451a));
                    }
                    return (T) NotificationLite.getValue(this.f34451a);
                } finally {
                    this.f34451a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public a(T t10) {
            this.f34450b = NotificationLite.next(t10);
        }

        public a<T>.C0387a c() {
            return new C0387a();
        }

        @Override // xi.g0
        public void onComplete() {
            this.f34450b = NotificationLite.complete();
        }

        @Override // xi.g0
        public void onError(Throwable th2) {
            this.f34450b = NotificationLite.error(th2);
        }

        @Override // xi.g0
        public void onNext(T t10) {
            this.f34450b = NotificationLite.next(t10);
        }
    }

    public c(xi.e0<T> e0Var, T t10) {
        this.f34448a = e0Var;
        this.f34449b = t10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f34449b);
        this.f34448a.c(aVar);
        return aVar.c();
    }
}
