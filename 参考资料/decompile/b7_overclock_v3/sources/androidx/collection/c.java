package androidx.collection;

import g.n0;
import g.p0;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class c<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean f2802e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f2803f = "ArraySet";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f2804g = new int[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Object[] f2805h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2806i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f2807j = 10;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public static Object[] f2808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f2809l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public static Object[] f2810m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static int f2811n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f2812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f2813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k<E, E> f2815d;

    public class a extends k<E, E> {
        public a() {
        }

        @Override // androidx.collection.k
        public void a() {
            c.this.clear();
        }

        @Override // androidx.collection.k
        public Object b(int i10, int i11) {
            return c.this.f2813b[i10];
        }

        @Override // androidx.collection.k
        public Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.k
        public int d() {
            return c.this.f2814c;
        }

        @Override // androidx.collection.k
        public int e(Object obj) {
            return c.this.indexOf(obj);
        }

        @Override // androidx.collection.k
        public int f(Object obj) {
            return c.this.indexOf(obj);
        }

        @Override // androidx.collection.k
        public void g(E e10, E e11) {
            c.this.add(e10);
        }

        @Override // androidx.collection.k
        public void h(int i10) {
            c.this.l(i10);
        }

        @Override // androidx.collection.k
        public E i(int i10, E e10) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public c() {
        this(0);
    }

    public static void e(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (f2811n < 10) {
                    objArr[0] = f2810m;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f2810m = objArr;
                    f2811n++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (c.class) {
                if (f2809l < 10) {
                    objArr[0] = f2808k;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f2808k = objArr;
                    f2809l++;
                }
            }
        }
    }

    public void a(@n0 c<? extends E> cVar) {
        int i10 = cVar.f2814c;
        d(this.f2814c + i10);
        if (this.f2814c != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                add(cVar.m(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(cVar.f2812a, 0, this.f2812a, 0, i10);
            System.arraycopy(cVar.f2813b, 0, this.f2813b, 0, i10);
            this.f2814c = i10;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@p0 E e10) {
        int i10;
        int iG;
        if (e10 == null) {
            iG = i();
            i10 = 0;
        } else {
            int iHashCode = e10.hashCode();
            i10 = iHashCode;
            iG = g(e10, iHashCode);
        }
        if (iG >= 0) {
            return false;
        }
        int i11 = ~iG;
        int i12 = this.f2814c;
        int[] iArr = this.f2812a;
        if (i12 >= iArr.length) {
            int i13 = 4;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 >= 4) {
                i13 = 8;
            }
            Object[] objArr = this.f2813b;
            b(i13);
            int[] iArr2 = this.f2812a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f2813b, 0, objArr.length);
            }
            e(iArr, objArr, this.f2814c);
        }
        int i14 = this.f2814c;
        if (i11 < i14) {
            int[] iArr3 = this.f2812a;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f2813b;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f2814c - i11);
        }
        this.f2812a[i11] = i10;
        this.f2813b[i11] = e10;
        this.f2814c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@n0 Collection<? extends E> collection) {
        d(this.f2814c + collection.size());
        Iterator<? extends E> it2 = collection.iterator();
        boolean zAdd = false;
        while (it2.hasNext()) {
            zAdd |= add(it2.next());
        }
        return zAdd;
    }

    public final void b(int i10) {
        if (i10 == 8) {
            synchronized (c.class) {
                Object[] objArr = f2810m;
                if (objArr != null) {
                    this.f2813b = objArr;
                    f2810m = (Object[]) objArr[0];
                    this.f2812a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2811n--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (c.class) {
                Object[] objArr2 = f2808k;
                if (objArr2 != null) {
                    this.f2813b = objArr2;
                    f2808k = (Object[]) objArr2[0];
                    this.f2812a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2809l--;
                    return;
                }
            }
        }
        this.f2812a = new int[i10];
        this.f2813b = new Object[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f2814c;
        if (i10 != 0) {
            e(this.f2812a, this.f2813b, i10);
            this.f2812a = f2804g;
            this.f2813b = f2805h;
            this.f2814c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@p0 Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@n0 Collection<?> collection) {
        Iterator<?> it2 = collection.iterator();
        while (it2.hasNext()) {
            if (!contains(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public void d(int i10) {
        int[] iArr = this.f2812a;
        if (iArr.length < i10) {
            Object[] objArr = this.f2813b;
            b(i10);
            int i11 = this.f2814c;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f2812a, 0, i11);
                System.arraycopy(objArr, 0, this.f2813b, 0, this.f2814c);
            }
            e(iArr, objArr, this.f2814c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f2814c; i10++) {
                try {
                    if (!set.contains(m(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final k<E, E> f() {
        if (this.f2815d == null) {
            this.f2815d = new a();
        }
        return this.f2815d;
    }

    public final int g(Object obj, int i10) {
        int i11 = this.f2814c;
        if (i11 == 0) {
            return -1;
        }
        int iA = g.a(this.f2812a, i11, i10);
        if (iA < 0 || obj.equals(this.f2813b[iA])) {
            return iA;
        }
        int i12 = iA + 1;
        while (i12 < i11 && this.f2812a[i12] == i10) {
            if (obj.equals(this.f2813b[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iA - 1; i13 >= 0 && this.f2812a[i13] == i10; i13--) {
            if (obj.equals(this.f2813b[i13])) {
                return i13;
            }
        }
        return ~i12;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f2812a;
        int i10 = this.f2814c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public final int i() {
        int i10 = this.f2814c;
        if (i10 == 0) {
            return -1;
        }
        int iA = g.a(this.f2812a, i10, 0);
        if (iA < 0 || this.f2813b[iA] == null) {
            return iA;
        }
        int i11 = iA + 1;
        while (i11 < i10 && this.f2812a[i11] == 0) {
            if (this.f2813b[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iA - 1; i12 >= 0 && this.f2812a[i12] == 0; i12--) {
            if (this.f2813b[i12] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public int indexOf(@p0 Object obj) {
        return obj == null ? i() : g(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f2814c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return f().m().iterator();
    }

    public boolean j(@n0 c<? extends E> cVar) {
        int i10 = cVar.f2814c;
        int i11 = this.f2814c;
        for (int i12 = 0; i12 < i10; i12++) {
            remove(cVar.m(i12));
        }
        return i11 != this.f2814c;
    }

    public E l(int i10) {
        Object[] objArr = this.f2813b;
        E e10 = (E) objArr[i10];
        int i11 = this.f2814c;
        if (i11 <= 1) {
            e(this.f2812a, objArr, i11);
            this.f2812a = f2804g;
            this.f2813b = f2805h;
            this.f2814c = 0;
        } else {
            int[] iArr = this.f2812a;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i12 = i11 - 1;
                this.f2814c = i12;
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                    Object[] objArr2 = this.f2813b;
                    System.arraycopy(objArr2, i13, objArr2, i10, this.f2814c - i10);
                }
                this.f2813b[this.f2814c] = null;
            } else {
                b(i11 > 8 ? i11 + (i11 >> 1) : 8);
                this.f2814c--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f2812a, 0, i10);
                    System.arraycopy(objArr, 0, this.f2813b, 0, i10);
                }
                int i14 = this.f2814c;
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    System.arraycopy(iArr, i15, this.f2812a, i10, i14 - i10);
                    System.arraycopy(objArr, i15, this.f2813b, i10, this.f2814c - i10);
                }
            }
        }
        return e10;
    }

    @p0
    public E m(int i10) {
        return (E) this.f2813b[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@p0 Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        l(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@n0 Collection<?> collection) {
        Iterator<?> it2 = collection.iterator();
        boolean zRemove = false;
        while (it2.hasNext()) {
            zRemove |= remove(it2.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@n0 Collection<?> collection) {
        boolean z10 = false;
        for (int i10 = this.f2814c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f2813b[i10])) {
                l(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f2814c;
    }

    @Override // java.util.Collection, java.util.Set
    @n0
    public Object[] toArray() {
        int i10 = this.f2814c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f2813b, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2814c * 14);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f2814c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            E eM = m(i10);
            if (eM != this) {
                sb2.append(eM);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public c(int i10) {
        if (i10 == 0) {
            this.f2812a = f2804g;
            this.f2813b = f2805h;
        } else {
            b(i10);
        }
        this.f2814c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @n0
    public <T> T[] toArray(@n0 T[] tArr) {
        if (tArr.length < this.f2814c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f2814c));
        }
        System.arraycopy(this.f2813b, 0, tArr, 0, this.f2814c);
        int length = tArr.length;
        int i10 = this.f2814c;
        if (length > i10) {
            tArr[i10] = null;
        }
        return tArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@p0 c<E> cVar) {
        this();
        if (cVar != 0) {
            a(cVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@p0 Collection<E> collection) {
        this();
        if (collection != 0) {
            addAll(collection);
        }
    }
}
