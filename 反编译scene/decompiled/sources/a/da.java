package a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class da<E> implements Collection<E>, Set<E> {
    public static int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f516b = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Object[] f517b = new Object[0];
    public static int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static Object[] f518c;
    public static Object[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ha<E, E> f519a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f520a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f521a;

    public da() {
        this(0);
    }

    public da(int i) {
        if (i == 0) {
            this.f520a = f516b;
            this.f521a = f517b;
        } else {
            a(i);
        }
        this.f5876a = 0;
    }

    public static void c(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (da.class) {
                if (c < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    c++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (da.class) {
                if (b < 10) {
                    objArr[0] = f518c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f518c = objArr;
                    b++;
                }
            }
        }
    }

    public final void a(int i) {
        if (i == 8) {
            synchronized (da.class) {
                if (d != null) {
                    Object[] objArr = d;
                    this.f521a = objArr;
                    d = (Object[]) objArr[0];
                    this.f520a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    c--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (da.class) {
                if (f518c != null) {
                    Object[] objArr2 = f518c;
                    this.f521a = objArr2;
                    f518c = (Object[]) objArr2[0];
                    this.f520a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    b--;
                    return;
                }
            }
        }
        this.f520a = new int[i];
        this.f521a = new Object[i];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iE;
        if (e == null) {
            iE = f();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iE = e(e, iHashCode);
        }
        if (iE >= 0) {
            return false;
        }
        int i2 = ~iE;
        int i3 = this.f5876a;
        if (i3 >= this.f520a.length) {
            int i4 = 4;
            if (i3 >= 8) {
                i4 = (i3 >> 1) + i3;
            } else if (i3 >= 4) {
                i4 = 8;
            }
            int[] iArr = this.f520a;
            Object[] objArr = this.f521a;
            a(i4);
            int[] iArr2 = this.f520a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f521a, 0, objArr.length);
            }
            c(iArr, objArr, this.f5876a);
        }
        int i5 = this.f5876a;
        if (i2 < i5) {
            int[] iArr3 = this.f520a;
            int i6 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
            Object[] objArr2 = this.f521a;
            System.arraycopy(objArr2, i2, objArr2, i6, this.f5876a - i2);
        }
        this.f520a[i2] = i;
        this.f521a[i2] = e;
        this.f5876a++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        b(this.f5876a + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public void b(int i) {
        int[] iArr = this.f520a;
        if (iArr.length < i) {
            Object[] objArr = this.f521a;
            a(i);
            int i2 = this.f5876a;
            if (i2 > 0) {
                System.arraycopy(iArr, 0, this.f520a, 0, i2);
                System.arraycopy(objArr, 0, this.f521a, 0, this.f5876a);
            }
            c(iArr, objArr, this.f5876a);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i = this.f5876a;
        if (i != 0) {
            c(this.f520a, this.f521a, i);
            this.f520a = f516b;
            this.f521a = f517b;
            this.f5876a = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final ha<E, E> d() {
        if (this.f519a == null) {
            this.f519a = new ca(this);
        }
        return this.f519a;
    }

    public final int e(Object obj, int i) {
        int i2 = this.f5876a;
        if (i2 == 0) {
            return -1;
        }
        int iA = ea.a(this.f520a, i2, i);
        if (iA < 0 || obj.equals(this.f521a[iA])) {
            return iA;
        }
        int i3 = iA + 1;
        while (i3 < i2 && this.f520a[i3] == i) {
            if (obj.equals(this.f521a[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iA - 1; i4 >= 0 && this.f520a[i4] == i; i4--) {
            if (obj.equals(this.f521a[i4])) {
                return i4;
            }
        }
        return ~i3;
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
            for (int i = 0; i < this.f5876a; i++) {
                try {
                    if (!set.contains(h(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i = this.f5876a;
        if (i == 0) {
            return -1;
        }
        int iA = ea.a(this.f520a, i, 0);
        if (iA < 0 || this.f521a[iA] == null) {
            return iA;
        }
        int i2 = iA + 1;
        while (i2 < i && this.f520a[i2] == 0) {
            if (this.f521a[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iA - 1; i3 >= 0 && this.f520a[i3] == 0; i3--) {
            if (this.f521a[i3] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public E g(int i) {
        Object[] objArr = this.f521a;
        E e = (E) objArr[i];
        int i2 = this.f5876a;
        if (i2 <= 1) {
            c(this.f520a, objArr, i2);
            this.f520a = f516b;
            this.f521a = f517b;
            this.f5876a = 0;
        } else {
            int[] iArr = this.f520a;
            if (iArr.length <= 8 || i2 >= iArr.length / 3) {
                int i3 = this.f5876a - 1;
                this.f5876a = i3;
                if (i < i3) {
                    int[] iArr2 = this.f520a;
                    int i4 = i + 1;
                    System.arraycopy(iArr2, i4, iArr2, i, i3 - i);
                    Object[] objArr2 = this.f521a;
                    System.arraycopy(objArr2, i4, objArr2, i, this.f5876a - i);
                }
                this.f521a[this.f5876a] = null;
            } else {
                int i5 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                int[] iArr3 = this.f520a;
                Object[] objArr3 = this.f521a;
                a(i5);
                this.f5876a--;
                if (i > 0) {
                    System.arraycopy(iArr3, 0, this.f520a, 0, i);
                    System.arraycopy(objArr3, 0, this.f521a, 0, i);
                }
                int i6 = this.f5876a;
                if (i < i6) {
                    int i7 = i + 1;
                    System.arraycopy(iArr3, i7, this.f520a, i, i6 - i);
                    System.arraycopy(objArr3, i7, this.f521a, i, this.f5876a - i);
                }
            }
        }
        return e;
    }

    public E h(int i) {
        return (E) this.f521a[i];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f520a;
        int i = this.f5876a;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f5876a <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f5876a - 1; i >= 0; i--) {
            if (!collection.contains(this.f521a[i])) {
                g(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f5876a;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i = this.f5876a;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f521a, 0, objArr, 0, i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f5876a) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f5876a));
        }
        System.arraycopy(this.f521a, 0, tArr, 0, this.f5876a);
        int length = tArr.length;
        int i = this.f5876a;
        if (length > i) {
            tArr[i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f5876a * 14);
        sb.append('{');
        for (int i = 0; i < this.f5876a; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eH = h(i);
            if (eH != this) {
                sb.append(eH);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
