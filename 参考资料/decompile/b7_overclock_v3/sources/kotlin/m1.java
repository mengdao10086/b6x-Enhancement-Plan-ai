package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nUIntArray.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,86:1\n1726#2,3:87\n*S KotlinDebug\n*F\n+ 1 UIntArray.kt\nkotlin/UIntArray\n*L\n62#1:87,3\n*E\n"})
@s
@v0(version = "1.3")
@hk.f
public final class m1 implements Collection<l1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final int[] f37989a;

    public static final class a implements Iterator<l1>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final int[] f37990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37991b;

        public a(@yt.k int[] array) {
            kotlin.jvm.internal.f0.p(array, "array");
            this.f37990a = array;
        }

        public int a() {
            int i10 = this.f37991b;
            int[] iArr = this.f37990a;
            if (i10 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.f37991b));
            }
            this.f37991b = i10 + 1;
            return l1.j(iArr[i10]);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f37991b < this.f37990a.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ l1 next() {
            return l1.d(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @s0
    public /* synthetic */ m1(int[] iArr) {
        this.f37989a = iArr;
    }

    public static final /* synthetic */ m1 b(int[] iArr) {
        return new m1(iArr);
    }

    @yt.k
    public static int[] d(int i10) {
        return e(new int[i10]);
    }

    @s0
    @yt.k
    public static int[] e(@yt.k int[] storage) {
        kotlin.jvm.internal.f0.p(storage, "storage");
        return storage;
    }

    public static boolean j(int[] iArr, int i10) {
        return ArraysKt___ArraysKt.R8(iArr, i10);
    }

    public static boolean l(int[] iArr, @yt.k Collection<l1> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (!elements.isEmpty()) {
            for (Object obj : elements) {
                if (!((obj instanceof l1) && ArraysKt___ArraysKt.R8(iArr, ((l1) obj).l0()))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean m(int[] iArr, Object obj) {
        return (obj instanceof m1) && kotlin.jvm.internal.f0.g(iArr, ((m1) obj).y());
    }

    public static final boolean o(int[] iArr, int[] iArr2) {
        return kotlin.jvm.internal.f0.g(iArr, iArr2);
    }

    public static final int p(int[] iArr, int i10) {
        return l1.j(iArr[i10]);
    }

    public static int r(int[] iArr) {
        return iArr.length;
    }

    @s0
    public static /* synthetic */ void s() {
    }

    public static int t(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public static boolean u(int[] iArr) {
        return iArr.length == 0;
    }

    @yt.k
    public static Iterator<l1> v(int[] iArr) {
        return new a(iArr);
    }

    public static final void w(int[] iArr, int i10, int i11) {
        iArr[i10] = i11;
    }

    public static String x(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    public boolean a(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(l1 l1Var) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends l1> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof l1) {
            return g(((l1) obj).l0());
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@yt.k Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        return l(this.f37989a, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return m(this.f37989a, obj);
    }

    public boolean g(int i10) {
        return j(this.f37989a, i10);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return t(this.f37989a);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return u(this.f37989a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    @yt.k
    public Iterator<l1> iterator() {
        return v(this.f37989a);
    }

    @Override // java.util.Collection
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public int size() {
        return r(this.f37989a);
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
        return x(this.f37989a);
    }

    public final /* synthetic */ int[] y() {
        return this.f37989a;
    }
}
