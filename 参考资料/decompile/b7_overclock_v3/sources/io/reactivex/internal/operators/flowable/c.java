package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> implements Iterable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xi.j<T> f33542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f33543b;

    public static final class a<T> extends io.reactivex.subscribers.a<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile Object f33544b;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.c$a$a, reason: collision with other inner class name */
        public final class C0384a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f33545a;

            public C0384a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                this.f33545a = a.this.f33544b;
                return !NotificationLite.isComplete(r0);
            }

            @Override // java.util.Iterator
            public T next() {
                try {
                    if (this.f33545a == null) {
                        this.f33545a = a.this.f33544b;
                    }
                    if (NotificationLite.isComplete(this.f33545a)) {
                        throw new NoSuchElementException();
                    }
                    if (NotificationLite.isError(this.f33545a)) {
                        throw ExceptionHelper.f(NotificationLite.getError(this.f33545a));
                    }
                    return (T) NotificationLite.getValue(this.f33545a);
                } finally {
                    this.f33545a = null;
                }
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        public a(T t10) {
            this.f33544b = NotificationLite.next(t10);
        }

        public a<T>.C0384a d() {
            return new C0384a();
        }

        @Override // bu.d
        public void onComplete() {
            this.f33544b = NotificationLite.complete();
        }

        @Override // bu.d
        public void onError(Throwable th2) {
            this.f33544b = NotificationLite.error(th2);
        }

        @Override // bu.d
        public void onNext(T t10) {
            this.f33544b = NotificationLite.next(t10);
        }
    }

    public c(xi.j<T> jVar, T t10) {
        this.f33542a = jVar;
        this.f33543b = t10;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a(this.f33543b);
        this.f33542a.j6(aVar);
        return aVar.d();
    }
}
