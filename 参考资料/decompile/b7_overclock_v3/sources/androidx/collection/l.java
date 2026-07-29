package androidx.collection;

import g.n0;
import g.p0;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class l<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f2860d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f2861e = "ArrayMap";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f2862f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f2863g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f2864h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public static Object[] f2865i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f2866j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public static Object[] f2867k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static int f2868l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f2869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f2870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2871c;

    public l() {
        this.f2869a = g.f2825a;
        this.f2870b = g.f2827c;
        this.f2871c = 0;
    }

    private void a(int i10) {
        if (i10 == 8) {
            synchronized (l.class) {
                Object[] objArr = f2867k;
                if (objArr != null) {
                    this.f2870b = objArr;
                    f2867k = (Object[]) objArr[0];
                    this.f2869a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2868l--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (l.class) {
                Object[] objArr2 = f2865i;
                if (objArr2 != null) {
                    this.f2870b = objArr2;
                    f2865i = (Object[]) objArr2[0];
                    this.f2869a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2866j--;
                    return;
                }
            }
        }
        this.f2869a = new int[i10];
        this.f2870b = new Object[i10 << 1];
    }

    public static int b(int[] iArr, int i10, int i11) {
        try {
            return g.a(iArr, i10, i11);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static void d(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (l.class) {
                if (f2868l < 10) {
                    objArr[0] = f2867k;
                    objArr[1] = iArr;
                    for (int i11 = (i10 << 1) - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f2867k = objArr;
                    f2868l++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (l.class) {
                if (f2866j < 10) {
                    objArr[0] = f2865i;
                    objArr[1] = iArr;
                    for (int i12 = (i10 << 1) - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f2865i = objArr;
                    f2866j++;
                }
            }
        }
    }

    public void c(int i10) {
        int i11 = this.f2871c;
        int[] iArr = this.f2869a;
        if (iArr.length < i10) {
            Object[] objArr = this.f2870b;
            a(i10);
            if (this.f2871c > 0) {
                System.arraycopy(iArr, 0, this.f2869a, 0, i11);
                System.arraycopy(objArr, 0, this.f2870b, 0, i11 << 1);
            }
            d(iArr, objArr, i11);
        }
        if (this.f2871c != i11) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i10 = this.f2871c;
        if (i10 > 0) {
            int[] iArr = this.f2869a;
            Object[] objArr = this.f2870b;
            this.f2869a = g.f2825a;
            this.f2870b = g.f2827c;
            this.f2871c = 0;
            d(iArr, objArr, i10);
        }
        if (this.f2871c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@p0 Object obj) {
        return g(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return j(obj) >= 0;
    }

    public int e(Object obj, int i10) {
        int i11 = this.f2871c;
        if (i11 == 0) {
            return -1;
        }
        int iB = b(this.f2869a, i11, i10);
        if (iB < 0 || obj.equals(this.f2870b[iB << 1])) {
            return iB;
        }
        int i12 = iB + 1;
        while (i12 < i11 && this.f2869a[i12] == i10) {
            if (obj.equals(this.f2870b[i12 << 1])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = iB - 1; i13 >= 0 && this.f2869a[i13] == i10; i13--) {
            if (obj.equals(this.f2870b[i13 << 1])) {
                return i13;
            }
        }
        return ~i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (size() != lVar.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f2871c; i10++) {
                try {
                    K k10 = k(i10);
                    V vO = o(i10);
                    Object obj2 = lVar.get(k10);
                    if (vO == null) {
                        if (obj2 != null || !lVar.containsKey(k10)) {
                            return false;
                        }
                    } else if (!vO.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i11 = 0; i11 < this.f2871c; i11++) {
                try {
                    K k11 = k(i11);
                    V vO2 = o(i11);
                    Object obj3 = map.get(k11);
                    if (vO2 == null) {
                        if (obj3 != null || !map.containsKey(k11)) {
                            return false;
                        }
                    } else if (!vO2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int g(@p0 Object obj) {
        return obj == null ? h() : e(obj, obj.hashCode());
    }

    @p0
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v10) {
        int iG = g(obj);
        return iG >= 0 ? (V) this.f2870b[(iG << 1) + 1] : v10;
    }

    public int h() {
        int i10 = this.f2871c;
        if (i10 == 0) {
            return -1;
        }
        int iB = b(this.f2869a, i10, 0);
        if (iB < 0 || this.f2870b[iB << 1] == null) {
            return iB;
        }
        int i11 = iB + 1;
        while (i11 < i10 && this.f2869a[i11] == 0) {
            if (this.f2870b[i11 << 1] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = iB - 1; i12 >= 0 && this.f2869a[i12] == 0; i12--) {
            if (this.f2870b[i12 << 1] == null) {
                return i12;
            }
        }
        return ~i11;
    }

    public int hashCode() {
        int[] iArr = this.f2869a;
        Object[] objArr = this.f2870b;
        int i10 = this.f2871c;
        int i11 = 1;
        int i12 = 0;
        int iHashCode = 0;
        while (i12 < i10) {
            Object obj = objArr[i11];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i12];
            i12++;
            i11 += 2;
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.f2871c <= 0;
    }

    int j(Object obj) {
        int i10 = this.f2871c * 2;
        Object[] objArr = this.f2870b;
        if (obj == null) {
            for (int i11 = 1; i11 < i10; i11 += 2) {
                if (objArr[i11] == null) {
                    return i11 >> 1;
                }
            }
            return -1;
        }
        for (int i12 = 1; i12 < i10; i12 += 2) {
            if (obj.equals(objArr[i12])) {
                return i12 >> 1;
            }
        }
        return -1;
    }

    public K k(int i10) {
        return (K) this.f2870b[i10 << 1];
    }

    public void l(@n0 l<? extends K, ? extends V> lVar) {
        int i10 = lVar.f2871c;
        c(this.f2871c + i10);
        if (this.f2871c != 0) {
            for (int i11 = 0; i11 < i10; i11++) {
                put(lVar.k(i11), lVar.o(i11));
            }
        } else if (i10 > 0) {
            System.arraycopy(lVar.f2869a, 0, this.f2869a, 0, i10);
            System.arraycopy(lVar.f2870b, 0, this.f2870b, 0, i10 << 1);
            this.f2871c = i10;
        }
    }

    public V m(int i10) {
        Object[] objArr = this.f2870b;
        int i11 = i10 << 1;
        V v10 = (V) objArr[i11 + 1];
        int i12 = this.f2871c;
        int i13 = 0;
        if (i12 <= 1) {
            d(this.f2869a, objArr, i12);
            this.f2869a = g.f2825a;
            this.f2870b = g.f2827c;
        } else {
            int i14 = i12 - 1;
            int[] iArr = this.f2869a;
            if (iArr.length <= 8 || i12 >= iArr.length / 3) {
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    int i16 = i14 - i10;
                    System.arraycopy(iArr, i15, iArr, i10, i16);
                    Object[] objArr2 = this.f2870b;
                    System.arraycopy(objArr2, i15 << 1, objArr2, i11, i16 << 1);
                }
                Object[] objArr3 = this.f2870b;
                int i17 = i14 << 1;
                objArr3[i17] = null;
                objArr3[i17 + 1] = null;
            } else {
                a(i12 > 8 ? i12 + (i12 >> 1) : 8);
                if (i12 != this.f2871c) {
                    throw new ConcurrentModificationException();
                }
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f2869a, 0, i10);
                    System.arraycopy(objArr, 0, this.f2870b, 0, i11);
                }
                if (i10 < i14) {
                    int i18 = i10 + 1;
                    int i19 = i14 - i10;
                    System.arraycopy(iArr, i18, this.f2869a, i10, i19);
                    System.arraycopy(objArr, i18 << 1, this.f2870b, i11, i19 << 1);
                }
            }
            i13 = i14;
        }
        if (i12 != this.f2871c) {
            throw new ConcurrentModificationException();
        }
        this.f2871c = i13;
        return v10;
    }

    public V n(int i10, V v10) {
        int i11 = (i10 << 1) + 1;
        Object[] objArr = this.f2870b;
        V v11 = (V) objArr[i11];
        objArr[i11] = v10;
        return v11;
    }

    public V o(int i10) {
        return (V) this.f2870b[(i10 << 1) + 1];
    }

    @p0
    public V put(K k10, V v10) {
        int i10;
        int iE;
        int i11 = this.f2871c;
        if (k10 == null) {
            iE = h();
            i10 = 0;
        } else {
            int iHashCode = k10.hashCode();
            i10 = iHashCode;
            iE = e(k10, iHashCode);
        }
        if (iE >= 0) {
            int i12 = (iE << 1) + 1;
            Object[] objArr = this.f2870b;
            V v11 = (V) objArr[i12];
            objArr[i12] = v10;
            return v11;
        }
        int i13 = ~iE;
        int[] iArr = this.f2869a;
        if (i11 >= iArr.length) {
            int i14 = 4;
            if (i11 >= 8) {
                i14 = (i11 >> 1) + i11;
            } else if (i11 >= 4) {
                i14 = 8;
            }
            Object[] objArr2 = this.f2870b;
            a(i14);
            if (i11 != this.f2871c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f2869a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f2870b, 0, objArr2.length);
            }
            d(iArr, objArr2, i11);
        }
        if (i13 < i11) {
            int[] iArr3 = this.f2869a;
            int i15 = i13 + 1;
            System.arraycopy(iArr3, i13, iArr3, i15, i11 - i13);
            Object[] objArr3 = this.f2870b;
            System.arraycopy(objArr3, i13 << 1, objArr3, i15 << 1, (this.f2871c - i13) << 1);
        }
        int i16 = this.f2871c;
        if (i11 == i16) {
            int[] iArr4 = this.f2869a;
            if (i13 < iArr4.length) {
                iArr4[i13] = i10;
                Object[] objArr4 = this.f2870b;
                int i17 = i13 << 1;
                objArr4[i17] = k10;
                objArr4[i17 + 1] = v10;
                this.f2871c = i16 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    @p0
    public V putIfAbsent(K k10, V v10) {
        V v11 = get(k10);
        return v11 == null ? put(k10, v10) : v11;
    }

    @p0
    public V remove(Object obj) {
        int iG = g(obj);
        if (iG >= 0) {
            return m(iG);
        }
        return null;
    }

    @p0
    public V replace(K k10, V v10) {
        int iG = g(k10);
        if (iG >= 0) {
            return n(iG, v10);
        }
        return null;
    }

    public int size() {
        return this.f2871c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2871c * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f2871c; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            K k10 = k(i10);
            if (k10 != this) {
                sb2.append(k10);
            } else {
                sb2.append("(this Map)");
            }
            sb2.append('=');
            V vO = o(i10);
            if (vO != this) {
                sb2.append(vO);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int iG = g(obj);
        if (iG < 0) {
            return false;
        }
        V vO = o(iG);
        if (obj2 != vO && (obj2 == null || !obj2.equals(vO))) {
            return false;
        }
        m(iG);
        return true;
    }

    public boolean replace(K k10, V v10, V v11) {
        int iG = g(k10);
        if (iG < 0) {
            return false;
        }
        V vO = o(iG);
        if (vO != v10 && (v10 == null || !v10.equals(vO))) {
            return false;
        }
        n(iG, v11);
        return true;
    }

    public l(int i10) {
        if (i10 == 0) {
            this.f2869a = g.f2825a;
            this.f2870b = g.f2827c;
        } else {
            a(i10);
        }
        this.f2871c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(l<K, V> lVar) {
        this();
        if (lVar != 0) {
            l(lVar);
        }
    }
}
