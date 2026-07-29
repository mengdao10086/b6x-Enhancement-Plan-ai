package io.reactivex.internal.queue;

import bj.f;
import fj.n;
import io.reactivex.internal.util.l;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes5.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements n<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Integer f35095a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    public final AtomicLong consumerIndex;
    public final int lookAheadStep;
    public final int mask;
    public final AtomicLong producerIndex;
    public long producerLookAhead;

    public SpscArrayQueue(int i10) {
        super(l.b(i10));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i10 / 4, f35095a.intValue());
    }

    public int a(long j10) {
        return this.mask & ((int) j10);
    }

    public int b(long j10, int i10) {
        return ((int) j10) & i10;
    }

    public E c(int i10) {
        return get(i10);
    }

    @Override // fj.o
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public void d(long j10) {
        this.consumerIndex.lazySet(j10);
    }

    public void h(int i10, E e10) {
        lazySet(i10, e10);
    }

    @Override // fj.o
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public void k(long j10) {
        this.producerIndex.lazySet(j10);
    }

    @Override // fj.o
    public boolean offer(E e10) {
        Objects.requireNonNull(e10, "Null is not a valid element");
        int i10 = this.mask;
        long j10 = this.producerIndex.get();
        int iB = b(j10, i10);
        if (j10 >= this.producerLookAhead) {
            long j11 = ((long) this.lookAheadStep) + j10;
            if (c(b(j11, i10)) == null) {
                this.producerLookAhead = j11;
            } else if (c(iB) != null) {
                return false;
            }
        }
        h(iB, e10);
        k(j10 + 1);
        return true;
    }

    @Override // fj.n, fj.o
    @f
    public E poll() {
        long j10 = this.consumerIndex.get();
        int iA = a(j10);
        E eC = c(iA);
        if (eC == null) {
            return null;
        }
        d(j10 + 1);
        h(iA, null);
        return eC;
    }

    @Override // fj.o
    public boolean offer(E e10, E e11) {
        return offer(e10) && offer(e11);
    }
}
