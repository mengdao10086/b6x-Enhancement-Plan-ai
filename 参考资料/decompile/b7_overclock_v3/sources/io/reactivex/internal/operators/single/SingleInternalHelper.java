package io.reactivex.internal.operators.single;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import xi.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class SingleInternalHelper {

    public enum NoSuchElementCallable implements Callable<NoSuchElementException> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public NoSuchElementException call() throws Exception {
            return new NoSuchElementException();
        }
    }

    public enum ToFlowable implements dj.o<o0, bu.c> {
        INSTANCE;

        @Override // dj.o
        public bu.c apply(o0 o0Var) {
            return new SingleToFlowable(o0Var);
        }
    }

    public enum ToObservable implements dj.o<o0, xi.z> {
        INSTANCE;

        @Override // dj.o
        public xi.z apply(o0 o0Var) {
            return new SingleToObservable(o0Var);
        }
    }

    public static final class a<T> implements Iterable<xi.j<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<? extends o0<? extends T>> f34964a;

        public a(Iterable<? extends o0<? extends T>> iterable) {
            this.f34964a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<xi.j<T>> iterator() {
            return new b(this.f34964a.iterator());
        }
    }

    public static final class b<T> implements Iterator<xi.j<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends o0<? extends T>> f34965a;

        public b(Iterator<? extends o0<? extends T>> it2) {
            this.f34965a = it2;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.j<T> next() {
            return new SingleToFlowable(this.f34965a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f34965a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public SingleInternalHelper() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Callable<NoSuchElementException> a() {
        return NoSuchElementCallable.INSTANCE;
    }

    public static <T> Iterable<? extends xi.j<T>> b(Iterable<? extends o0<? extends T>> iterable) {
        return new a(iterable);
    }

    public static <T> dj.o<o0<? extends T>, bu.c<? extends T>> c() {
        return ToFlowable.INSTANCE;
    }

    public static <T> dj.o<o0<? extends T>, xi.z<? extends T>> d() {
        return ToObservable.INSTANCE;
    }
}
