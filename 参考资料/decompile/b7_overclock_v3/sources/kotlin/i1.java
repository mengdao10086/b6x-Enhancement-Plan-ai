package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nUByteArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UByteArray.kt\nkotlin/UByteArray\n*L\n62#1:87,3\n*E\n"})
@s
@v0(version = "1.3")
@hk.f
public final class i1 implements Collection<h1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final byte[] f37779a;

    public static final class a implements Iterator<h1>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final byte[] f37780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37781b;

        public a(@yt.k byte[] array) {
            kotlin.jvm.internal.f0.p(array, "array");
            this.f37780a = array;
        }

        public byte a() {
            int i10 = this.f37781b;
            byte[] bArr = this.f37780a;
            if (i10 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f37781b));
            }
            this.f37781b = i10 + 1;
            return h1.j(bArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f37781b < this.f37780a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ h1 next() {
            return h1.d(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @s0
    public /* synthetic */ i1(byte[] bArr) {
        this.f37779a = bArr;
    }

    public static final /* synthetic */ i1 b(byte[] bArr) {
        return new i1(bArr);
    }

    @yt.k
    public static byte[] d(int i10) {
        return e(new byte[i10]);
    }

    @s0
    @yt.k
    public static byte[] e(@yt.k byte[] storage) {
        kotlin.jvm.internal.f0.p(storage, "storage");
        return storage;
    }

    public static boolean j(byte[] bArr, byte b10) {
        return ArraysKt___ArraysKt.N8(bArr, b10);
    }

    public static boolean l(byte[] bArr, @yt.k Collection<h1> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (!((obj instanceof h1) && ArraysKt___ArraysKt.N8(bArr, ((h1) obj).j0()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean m(byte[] bArr, Object obj) {
        return (obj instanceof i1) && kotlin.jvm.internal.f0.g(bArr, ((i1) obj).y());
    }

    public static final boolean o(byte[] bArr, byte[] bArr2) {
        return kotlin.jvm.internal.f0.g(bArr, bArr2);
    }

    public static final byte p(byte[] bArr, int i10) {
        return h1.j(bArr[i10]);
    }

    public static int r(byte[] bArr) {
        return bArr.length;
    }

    @s0
    public static /* synthetic */ void s() {
    }

    public static int t(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    public static boolean u(byte[] bArr) {
        return bArr.length == 0;
    }

    @yt.k
    public static Iterator<h1> v(byte[] bArr) {
        return new a(bArr);
    }

    public static final void w(byte[] bArr, int i10, byte b10) {
        bArr[i10] = b10;
    }

    public static String x(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    public boolean a(byte b10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(h1 h1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends h1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof h1) {
            return g(((h1) obj).j0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@yt.k Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return l(this.f37779a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m(this.f37779a, obj);
    }

    public boolean g(byte b10) {
        return j(this.f37779a, b10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return t(this.f37779a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f37779a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<h1> iterator() {
        return v(this.f37779a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f37779a);
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
        return x(this.f37779a);
    }

    public final /* synthetic */ byte[] y() {
        return this.f37779a;
    }
}
