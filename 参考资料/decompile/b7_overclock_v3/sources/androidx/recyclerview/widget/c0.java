package androidx.recyclerview.widget;

import g.n0;
import g.p0;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class c0<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f6844j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f6845k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f6846l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f6847m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f6848n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f6849o = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T[] f6850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T[] f6851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6854e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f6855f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f6856g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f6857h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Class<T> f6858i;

    public static class a<T2> extends b<T2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b<T2> f6859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f f6860b;

        public a(b<T2> bVar) {
            this.f6859a = bVar;
            this.f6860b = new f(bVar);
        }

        @Override // androidx.recyclerview.widget.c0.b
        public boolean a(T2 t22, T2 t23) {
            return this.f6859a.a(t22, t23);
        }

        @Override // androidx.recyclerview.widget.c0.b
        public boolean b(T2 t22, T2 t23) {
            return this.f6859a.b(t22, t23);
        }

        @Override // androidx.recyclerview.widget.c0.b
        @p0
        public Object c(T2 t22, T2 t23) {
            return this.f6859a.c(t22, t23);
        }

        @Override // androidx.recyclerview.widget.c0.b, java.util.Comparator
        public int compare(T2 t22, T2 t23) {
            return this.f6859a.compare(t22, t23);
        }

        @Override // androidx.recyclerview.widget.c0.b
        public void d(int i10, int i11) {
            this.f6860b.onChanged(i10, i11, null);
        }

        public void e() {
            this.f6860b.a();
        }

        @Override // androidx.recyclerview.widget.c0.b, androidx.recyclerview.widget.t
        public void onChanged(int i10, int i11, Object obj) {
            this.f6860b.onChanged(i10, i11, obj);
        }

        @Override // androidx.recyclerview.widget.t
        public void onInserted(int i10, int i11) {
            this.f6860b.onInserted(i10, i11);
        }

        @Override // androidx.recyclerview.widget.t
        public void onMoved(int i10, int i11) {
            this.f6860b.onMoved(i10, i11);
        }

        @Override // androidx.recyclerview.widget.t
        public void onRemoved(int i10, int i11) {
            this.f6860b.onRemoved(i10, i11);
        }
    }

    public static abstract class b<T2> implements Comparator<T2>, t {
        public abstract boolean a(T2 t22, T2 t23);

        public abstract boolean b(T2 t22, T2 t23);

        @p0
        public Object c(T2 t22, T2 t23) {
            return null;
        }

        @Override // java.util.Comparator
        public abstract int compare(T2 t22, T2 t23);

        public abstract void d(int i10, int i11);

        public void onChanged(int i10, int i11, Object obj) {
            d(i10, i11);
        }
    }

    public c0(@n0 Class<T> cls, @n0 b<T> bVar) {
        this(cls, bVar, 10);
    }

    public final void A(@n0 T[] tArr) {
        boolean z10 = !(this.f6855f instanceof a);
        if (z10) {
            h();
        }
        this.f6852c = 0;
        this.f6853d = this.f6857h;
        this.f6851b = this.f6850a;
        this.f6854e = 0;
        int iD = D(tArr);
        this.f6850a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f6858i, iD));
        while (true) {
            int i10 = this.f6854e;
            if (i10 >= iD && this.f6852c >= this.f6853d) {
                break;
            }
            int i11 = this.f6852c;
            int i12 = this.f6853d;
            if (i11 >= i12) {
                int i13 = iD - i10;
                System.arraycopy(tArr, i10, this.f6850a, i10, i13);
                this.f6854e += i13;
                this.f6857h += i13;
                this.f6855f.onInserted(i10, i13);
                break;
            }
            if (i10 >= iD) {
                int i14 = i12 - i11;
                this.f6857h -= i14;
                this.f6855f.onRemoved(i10, i14);
                break;
            }
            T t10 = this.f6851b[i11];
            T t11 = tArr[i10];
            int iCompare = this.f6855f.compare(t10, t11);
            if (iCompare < 0) {
                B();
            } else if (iCompare > 0) {
                z(t11);
            } else if (this.f6855f.b(t10, t11)) {
                T[] tArr2 = this.f6850a;
                int i15 = this.f6854e;
                tArr2[i15] = t11;
                this.f6852c++;
                this.f6854e = i15 + 1;
                if (!this.f6855f.a(t10, t11)) {
                    b bVar = this.f6855f;
                    bVar.onChanged(this.f6854e - 1, 1, bVar.c(t10, t11));
                }
            } else {
                B();
                z(t11);
            }
        }
        this.f6851b = null;
        if (z10) {
            k();
        }
    }

    public final void B() {
        this.f6857h--;
        this.f6852c++;
        this.f6855f.onRemoved(this.f6854e, 1);
    }

    public int C() {
        return this.f6857h;
    }

    public final int D(@n0 T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f6855f);
        int i10 = 1;
        int i11 = 0;
        for (int i12 = 1; i12 < tArr.length; i12++) {
            T t10 = tArr[i12];
            if (this.f6855f.compare(tArr[i11], t10) == 0) {
                int iM = m(t10, tArr, i11, i10);
                if (iM != -1) {
                    tArr[iM] = t10;
                } else {
                    if (i10 != i12) {
                        tArr[i10] = t10;
                    }
                    i10++;
                }
            } else {
                if (i10 != i12) {
                    tArr[i10] = t10;
                }
                i11 = i10;
                i10++;
            }
        }
        return i10;
    }

    public final void E() {
        if (this.f6851b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public void F(int i10, T t10) {
        E();
        T tN = n(i10);
        boolean z10 = tN == t10 || !this.f6855f.a(tN, t10);
        if (tN != t10 && this.f6855f.compare(tN, t10) == 0) {
            this.f6850a[i10] = t10;
            if (z10) {
                b bVar = this.f6855f;
                bVar.onChanged(i10, 1, bVar.c(tN, t10));
                return;
            }
            return;
        }
        if (z10) {
            b bVar2 = this.f6855f;
            bVar2.onChanged(i10, 1, bVar2.c(tN, t10));
        }
        v(i10, false);
        int iB = b(t10, false);
        if (i10 != iB) {
            this.f6855f.onMoved(i10, iB);
        }
    }

    public int a(T t10) {
        E();
        return b(t10, true);
    }

    public final int b(T t10, boolean z10) {
        int iL = l(t10, this.f6850a, 0, this.f6857h, 1);
        if (iL == -1) {
            iL = 0;
        } else if (iL < this.f6857h) {
            T t11 = this.f6850a[iL];
            if (this.f6855f.b(t11, t10)) {
                if (this.f6855f.a(t11, t10)) {
                    this.f6850a[iL] = t10;
                    return iL;
                }
                this.f6850a[iL] = t10;
                b bVar = this.f6855f;
                bVar.onChanged(iL, 1, bVar.c(t11, t10));
                return iL;
            }
        }
        g(iL, t10);
        if (z10) {
            this.f6855f.onInserted(iL, 1);
        }
        return iL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(@n0 Collection<T> collection) {
        e(collection.toArray((Object[]) Array.newInstance((Class<?>) this.f6858i, collection.size())), true);
    }

    public void d(@n0 T... tArr) {
        e(tArr, false);
    }

    public void e(@n0 T[] tArr, boolean z10) {
        E();
        if (tArr.length == 0) {
            return;
        }
        if (z10) {
            f(tArr);
        } else {
            f(j(tArr));
        }
    }

    public final void f(T[] tArr) {
        if (tArr.length < 1) {
            return;
        }
        int iD = D(tArr);
        if (this.f6857h != 0) {
            q(tArr, iD);
            return;
        }
        this.f6850a = tArr;
        this.f6857h = iD;
        this.f6855f.onInserted(0, iD);
    }

    public final void g(int i10, T t10) {
        int i11 = this.f6857h;
        if (i10 > i11) {
            throw new IndexOutOfBoundsException("cannot add item to " + i10 + " because size is " + this.f6857h);
        }
        T[] tArr = this.f6850a;
        if (i11 == tArr.length) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f6858i, tArr.length + 10));
            System.arraycopy(this.f6850a, 0, tArr2, 0, i10);
            tArr2[i10] = t10;
            System.arraycopy(this.f6850a, i10, tArr2, i10 + 1, this.f6857h - i10);
            this.f6850a = tArr2;
        } else {
            System.arraycopy(tArr, i10, tArr, i10 + 1, i11 - i10);
            this.f6850a[i10] = t10;
        }
        this.f6857h++;
    }

    public void h() {
        E();
        b bVar = this.f6855f;
        if (bVar instanceof a) {
            return;
        }
        if (this.f6856g == null) {
            this.f6856g = new a(bVar);
        }
        this.f6855f = this.f6856g;
    }

    public void i() {
        E();
        int i10 = this.f6857h;
        if (i10 == 0) {
            return;
        }
        Arrays.fill(this.f6850a, 0, i10, (Object) null);
        this.f6857h = 0;
        this.f6855f.onRemoved(0, i10);
    }

    public final T[] j(T[] tArr) {
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f6858i, tArr.length));
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    public void k() {
        E();
        b bVar = this.f6855f;
        if (bVar instanceof a) {
            ((a) bVar).e();
        }
        b bVar2 = this.f6855f;
        a aVar = this.f6856g;
        if (bVar2 == aVar) {
            this.f6855f = aVar.f6859a;
        }
    }

    public final int l(T t10, T[] tArr, int i10, int i11, int i12) {
        while (i10 < i11) {
            int i13 = (i10 + i11) / 2;
            T t11 = tArr[i13];
            int iCompare = this.f6855f.compare(t11, t10);
            if (iCompare < 0) {
                i10 = i13 + 1;
            } else {
                if (iCompare == 0) {
                    if (this.f6855f.b(t11, t10)) {
                        return i13;
                    }
                    int iP = p(t10, i13, i10, i11);
                    return (i12 == 1 && iP == -1) ? i13 : iP;
                }
                i11 = i13;
            }
        }
        if (i12 == 1) {
            return i10;
        }
        return -1;
    }

    public final int m(T t10, T[] tArr, int i10, int i11) {
        while (i10 < i11) {
            if (this.f6855f.b(tArr[i10], t10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public T n(int i10) throws IndexOutOfBoundsException {
        int i11;
        if (i10 < this.f6857h && i10 >= 0) {
            T[] tArr = this.f6851b;
            return (tArr == null || i10 < (i11 = this.f6854e)) ? this.f6850a[i10] : tArr[(i10 - i11) + this.f6852c];
        }
        throw new IndexOutOfBoundsException("Asked to get item at " + i10 + " but size is " + this.f6857h);
    }

    public int o(T t10) {
        if (this.f6851b == null) {
            return l(t10, this.f6850a, 0, this.f6857h, 4);
        }
        int iL = l(t10, this.f6850a, 0, this.f6854e, 4);
        if (iL != -1) {
            return iL;
        }
        int iL2 = l(t10, this.f6851b, this.f6852c, this.f6853d, 4);
        if (iL2 != -1) {
            return (iL2 - this.f6852c) + this.f6854e;
        }
        return -1;
    }

    public final int p(T t10, int i10, int i11, int i12) {
        T t11;
        for (int i13 = i10 - 1; i13 >= i11; i13--) {
            T t12 = this.f6850a[i13];
            if (this.f6855f.compare(t12, t10) != 0) {
                break;
            }
            if (this.f6855f.b(t12, t10)) {
                return i13;
            }
        }
        do {
            i10++;
            if (i10 >= i12) {
                return -1;
            }
            t11 = this.f6850a[i10];
            if (this.f6855f.compare(t11, t10) != 0) {
                return -1;
            }
        } while (!this.f6855f.b(t11, t10));
        return i10;
    }

    public final void q(T[] tArr, int i10) {
        boolean z10 = !(this.f6855f instanceof a);
        if (z10) {
            h();
        }
        this.f6851b = this.f6850a;
        int i11 = 0;
        this.f6852c = 0;
        int i12 = this.f6857h;
        this.f6853d = i12;
        this.f6850a = (T[]) ((Object[]) Array.newInstance((Class<?>) this.f6858i, i12 + i10 + 10));
        this.f6854e = 0;
        while (true) {
            int i13 = this.f6852c;
            int i14 = this.f6853d;
            if (i13 >= i14 && i11 >= i10) {
                break;
            }
            if (i13 == i14) {
                int i15 = i10 - i11;
                System.arraycopy(tArr, i11, this.f6850a, this.f6854e, i15);
                int i16 = this.f6854e + i15;
                this.f6854e = i16;
                this.f6857h += i15;
                this.f6855f.onInserted(i16 - i15, i15);
                break;
            }
            if (i11 == i10) {
                int i17 = i14 - i13;
                System.arraycopy(this.f6851b, i13, this.f6850a, this.f6854e, i17);
                this.f6854e += i17;
                break;
            }
            T t10 = this.f6851b[i13];
            T t11 = tArr[i11];
            int iCompare = this.f6855f.compare(t10, t11);
            if (iCompare > 0) {
                T[] tArr2 = this.f6850a;
                int i18 = this.f6854e;
                int i19 = i18 + 1;
                this.f6854e = i19;
                tArr2[i18] = t11;
                this.f6857h++;
                i11++;
                this.f6855f.onInserted(i19 - 1, 1);
            } else if (iCompare == 0 && this.f6855f.b(t10, t11)) {
                T[] tArr3 = this.f6850a;
                int i20 = this.f6854e;
                this.f6854e = i20 + 1;
                tArr3[i20] = t11;
                i11++;
                this.f6852c++;
                if (!this.f6855f.a(t10, t11)) {
                    b bVar = this.f6855f;
                    bVar.onChanged(this.f6854e - 1, 1, bVar.c(t10, t11));
                }
            } else {
                T[] tArr4 = this.f6850a;
                int i21 = this.f6854e;
                this.f6854e = i21 + 1;
                tArr4[i21] = t10;
                this.f6852c++;
            }
        }
        this.f6851b = null;
        if (z10) {
            k();
        }
    }

    public void r(int i10) {
        E();
        T tN = n(i10);
        v(i10, false);
        int iB = b(tN, false);
        if (i10 != iB) {
            this.f6855f.onMoved(i10, iB);
        }
    }

    public boolean s(T t10) {
        E();
        return t(t10, true);
    }

    public final boolean t(T t10, boolean z10) {
        int iL = l(t10, this.f6850a, 0, this.f6857h, 2);
        if (iL == -1) {
            return false;
        }
        v(iL, z10);
        return true;
    }

    public T u(int i10) {
        E();
        T tN = n(i10);
        v(i10, true);
        return tN;
    }

    public final void v(int i10, boolean z10) {
        T[] tArr = this.f6850a;
        System.arraycopy(tArr, i10 + 1, tArr, i10, (this.f6857h - i10) - 1);
        int i11 = this.f6857h - 1;
        this.f6857h = i11;
        this.f6850a[i11] = null;
        if (z10) {
            this.f6855f.onRemoved(i10, 1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(@n0 Collection<T> collection) {
        y(collection.toArray((Object[]) Array.newInstance((Class<?>) this.f6858i, collection.size())), true);
    }

    public void x(@n0 T... tArr) {
        y(tArr, false);
    }

    public void y(@n0 T[] tArr, boolean z10) {
        E();
        if (z10) {
            A(tArr);
        } else {
            A(j(tArr));
        }
    }

    public final void z(T t10) {
        T[] tArr = this.f6850a;
        int i10 = this.f6854e;
        tArr[i10] = t10;
        int i11 = i10 + 1;
        this.f6854e = i11;
        this.f6857h++;
        this.f6855f.onInserted(i11 - 1, 1);
    }

    public c0(@n0 Class<T> cls, @n0 b<T> bVar, int i10) {
        this.f6858i = cls;
        this.f6850a = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i10));
        this.f6855f = bVar;
        this.f6857h = 0;
    }
}
