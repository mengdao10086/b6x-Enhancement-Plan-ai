package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nUShortArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UShortArray.kt\nkotlin/UShortArray\n*L\n62#1:87,3\n*E\n"})
@s
@v0(version = "1.3")
@hk.f
public final class w1 implements Collection<v1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final short[] f38226a;

    public static final class a implements Iterator<v1>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final short[] f38227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f38228b;

        public a(@yt.k short[] array) {
            kotlin.jvm.internal.f0.p(array, "array");
            this.f38227a = array;
        }

        public short a() {
            int i10 = this.f38228b;
            short[] sArr = this.f38227a;
            if (i10 >= sArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f38228b));
            }
            this.f38228b = i10 + 1;
            return v1.j(sArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f38228b < this.f38227a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ v1 next() {
            return v1.d(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @s0
    public /* synthetic */ w1(short[] sArr) {
        this.f38226a = sArr;
    }

    public static final /* synthetic */ w1 b(short[] sArr) {
        return new w1(sArr);
    }

    @yt.k
    public static short[] d(int i10) {
        return e(new short[i10]);
    }

    @s0
    @yt.k
    public static short[] e(@yt.k short[] storage) {
        kotlin.jvm.internal.f0.p(storage, "storage");
        return storage;
    }

    public static boolean j(short[] sArr, short s10) {
        return ArraysKt___ArraysKt.U8(sArr, s10);
    }

    public static boolean l(short[] sArr, @yt.k Collection<v1> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (!((obj instanceof v1) && ArraysKt___ArraysKt.U8(sArr, ((v1) obj).j0()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean m(short[] sArr, Object obj) {
        return (obj instanceof w1) && kotlin.jvm.internal.f0.g(sArr, ((w1) obj).y());
    }

    public static final boolean o(short[] sArr, short[] sArr2) {
        return kotlin.jvm.internal.f0.g(sArr, sArr2);
    }

    public static final short p(short[] sArr, int i10) {
        return v1.j(sArr[i10]);
    }

    public static int r(short[] sArr) {
        return sArr.length;
    }

    @s0
    public static /* synthetic */ void s() {
    }

    public static int t(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    public static boolean u(short[] sArr) {
        return sArr.length == 0;
    }

    @yt.k
    public static Iterator<v1> v(short[] sArr) {
        return new a(sArr);
    }

    public static final void w(short[] sArr, int i10, short s10) {
        sArr[i10] = s10;
    }

    public static String x(short[] sArr) {
        return "UShortArray(storage=" + Arrays.toString(sArr) + ')';
    }

    public boolean a(short s10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(v1 v1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends v1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof v1) {
            return g(((v1) obj).j0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@yt.k Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return l(this.f38226a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m(this.f38226a, obj);
    }

    public boolean g(short s10) {
        return j(this.f38226a, s10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return t(this.f38226a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f38226a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<v1> iterator() {
        return v(this.f38226a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f38226a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.t.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }

    public String toString() {
        return x(this.f38226a);
    }

    public final /* synthetic */ short[] y() {
        return this.f38226a;
    }
}
