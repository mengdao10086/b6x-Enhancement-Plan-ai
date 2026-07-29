package kotlin.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,207:1\n205#1:209\n205#1:210\n205#1:211\n1#2:208\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n106#1:209\n176#1:210\n189#1:211\n*E\n"})
public final class a1<T> extends b<T> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Object[] f37678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f37679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f37680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f37681e;

    @kotlin.jvm.internal.t0({"SMAP\nSlidingWindow.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n+ 2 SlidingWindow.kt\nkotlin/collections/RingBuffer\n*L\n1#1,207:1\n205#2:208\n*S KotlinDebug\n*F\n+ 1 SlidingWindow.kt\nkotlin/collections/RingBuffer$iterator$1\n*L\n121#1:208\n*E\n"})
    public static final class a extends kotlin.collections.a<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f37683d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ a1<T> f37684e;

        public a(a1<T> a1Var) {
            this.f37684e = a1Var;
            this.f37682c = a1Var.size();
            this.f37683d = a1Var.f37680d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.a
        public void a() {
            if (this.f37682c == 0) {
                b();
                return;
            }
            d(this.f37684e.f37678b[this.f37683d]);
            this.f37683d = (this.f37683d + 1) % this.f37684e.f37679c;
            this.f37682c--;
        }
    }

    public a1(@yt.k Object[] buffer, int i10) {
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        this.f37678b = buffer;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i10).toString());
        }
        if (i10 <= buffer.length) {
            this.f37679c = buffer.length;
            this.f37681e = i10;
            return;
        }
        throw new IllegalArgumentException(("ring buffer filled size: " + i10 + " cannot be larger than the buffer size: " + buffer.length).toString());
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
    public int a() {
        return this.f37681e;
    }

    @Override // kotlin.collections.b, java.util.List
    public T get(int i10) {
        b.f37685a.b(i10, size());
        return (T) this.f37678b[(this.f37680d + i10) % this.f37679c];
    }

    @Override // kotlin.collections.b, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void m(T t10) {
        if (q()) {
            throw new IllegalStateException("ring buffer is full");
        }
        this.f37678b[(this.f37680d + size()) % this.f37679c] = t10;
        this.f37681e = size() + 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public final a1<T> o(int i10) {
        Object[] array;
        int i11 = this.f37679c;
        int iB = qk.v.B(i11 + (i11 >> 1) + 1, i10);
        if (this.f37680d == 0) {
            array = Arrays.copyOf(this.f37678b, iB);
            kotlin.jvm.internal.f0.o(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[iB]);
        }
        return new a1<>(array, size());
    }

    public final int p(int i10, int i11) {
        return (i10 + i11) % this.f37679c;
    }

    public final boolean q() {
        return size() == this.f37679c;
    }

    public final void r(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("n shouldn't be negative but it is " + i10).toString());
        }
        if (!(i10 <= size())) {
            throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i10 + ", size = " + size()).toString());
        }
        if (i10 > 0) {
            int i11 = this.f37680d;
            int i12 = (i11 + i10) % this.f37679c;
            if (i11 > i12) {
                m.n2(this.f37678b, null, i11, this.f37679c);
                m.n2(this.f37678b, null, 0, i12);
            } else {
                m.n2(this.f37678b, null, i11, i12);
            }
            this.f37680d = i12;
            this.f37681e = size() - i10;
        }
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @yt.k
    public <T> T[] toArray(@yt.k T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.f0.o(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i10 = 0;
        int i11 = 0;
        for (int i12 = this.f37680d; i11 < size && i12 < this.f37679c; i12++) {
            array[i11] = this.f37678b[i12];
            i11++;
        }
        while (i11 < size) {
            array[i11] = this.f37678b[i10];
            i11++;
            i10++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public a1(int i10) {
        this(new Object[i10], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @yt.k
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
