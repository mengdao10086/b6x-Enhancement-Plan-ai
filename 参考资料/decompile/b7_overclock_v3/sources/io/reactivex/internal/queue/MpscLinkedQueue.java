package io.reactivex.internal.queue;

import bj.f;
import fj.n;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class MpscLinkedQueue<T> implements n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f35093a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f35094b = new AtomicReference<>();

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        public E a() {
            E eB = b();
            f(null);
            return eB;
        }

        public E b() {
            return this.value;
        }

        public LinkedQueueNode<E> c() {
            return get();
        }

        public void d(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void f(E e10) {
            this.value = e10;
        }

        public LinkedQueueNode(E e10) {
            f(e10);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    public LinkedQueueNode<T> a() {
        return this.f35094b.get();
    }

    public LinkedQueueNode<T> b() {
        return this.f35094b.get();
    }

    public LinkedQueueNode<T> c() {
        return this.f35093a.get();
    }

    @Override // fj.o
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    public void d(LinkedQueueNode<T> linkedQueueNode) {
        this.f35094b.lazySet(linkedQueueNode);
    }

    public LinkedQueueNode<T> e(LinkedQueueNode<T> linkedQueueNode) {
        return this.f35093a.getAndSet(linkedQueueNode);
    }

    @Override // fj.o
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // fj.o
    public boolean offer(T t10) {
        Objects.requireNonNull(t10, "Null is not a valid element");
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t10);
        e(linkedQueueNode).d(linkedQueueNode);
        return true;
    }

    @Override // fj.n, fj.o
    @f
    public T poll() {
        LinkedQueueNode<T> linkedQueueNodeC;
        LinkedQueueNode<T> linkedQueueNodeA = a();
        LinkedQueueNode<T> linkedQueueNodeC2 = linkedQueueNodeA.c();
        if (linkedQueueNodeC2 != null) {
            T tA = linkedQueueNodeC2.a();
            d(linkedQueueNodeC2);
            return tA;
        }
        if (linkedQueueNodeA == c()) {
            return null;
        }
        do {
            linkedQueueNodeC = linkedQueueNodeA.c();
        } while (linkedQueueNodeC == null);
        T tA2 = linkedQueueNodeC.a();
        d(linkedQueueNodeC);
        return tA2;
    }

    @Override // fj.o
    public boolean offer(T t10, T t11) {
        offer(t10);
        offer(t11);
        return true;
    }
}
