package androidx.collection;

import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class h<E> implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f2828e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long[] f2830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2832d;

    public h() {
        this(10);
    }

    public void a(long j10, E e10) {
        int i10 = this.f2832d;
        if (i10 != 0 && j10 <= this.f2830b[i10 - 1]) {
            n(j10, e10);
            return;
        }
        if (this.f2829a && i10 >= this.f2830b.length) {
            g();
        }
        int i11 = this.f2832d;
        if (i11 >= this.f2830b.length) {
            int iF = g.f(i11 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f2830b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f2831c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2830b = jArr;
            this.f2831c = objArr;
        }
        this.f2830b[i11] = j10;
        this.f2831c[i11] = e10;
        this.f2832d = i11 + 1;
    }

    public void b() {
        int i10 = this.f2832d;
        Object[] objArr = this.f2831c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f2832d = 0;
        this.f2829a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h<E> clone() {
        try {
            h<E> hVar = (h) super.clone();
            hVar.f2830b = (long[]) this.f2830b.clone();
            hVar.f2831c = (Object[]) this.f2831c.clone();
            return hVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean d(long j10) {
        return j(j10) >= 0;
    }

    public boolean e(E e10) {
        return k(e10) >= 0;
    }

    @Deprecated
    public void f(long j10) {
        q(j10);
    }

    public final void g() {
        int i10 = this.f2832d;
        long[] jArr = this.f2830b;
        Object[] objArr = this.f2831c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f2828e) {
                if (i12 != i11) {
                    jArr[i11] = jArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f2829a = false;
        this.f2832d = i11;
    }

    @p0
    public E h(long j10) {
        return i(j10, null);
    }

    public E i(long j10, E e10) {
        int iB = g.b(this.f2830b, this.f2832d, j10);
        if (iB >= 0) {
            Object[] objArr = this.f2831c;
            if (objArr[iB] != f2828e) {
                return (E) objArr[iB];
            }
        }
        return e10;
    }

    public int j(long j10) {
        if (this.f2829a) {
            g();
        }
        return g.b(this.f2830b, this.f2832d, j10);
    }

    public int k(E e10) {
        if (this.f2829a) {
            g();
        }
        for (int i10 = 0; i10 < this.f2832d; i10++) {
            if (this.f2831c[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    public boolean l() {
        return w() == 0;
    }

    public long m(int i10) {
        if (this.f2829a) {
            g();
        }
        return this.f2830b[i10];
    }

    public void n(long j10, E e10) {
        int iB = g.b(this.f2830b, this.f2832d, j10);
        if (iB >= 0) {
            this.f2831c[iB] = e10;
            return;
        }
        int i10 = ~iB;
        int i11 = this.f2832d;
        if (i10 < i11) {
            Object[] objArr = this.f2831c;
            if (objArr[i10] == f2828e) {
                this.f2830b[i10] = j10;
                objArr[i10] = e10;
                return;
            }
        }
        if (this.f2829a && i11 >= this.f2830b.length) {
            g();
            i10 = ~g.b(this.f2830b, this.f2832d, j10);
        }
        int i12 = this.f2832d;
        if (i12 >= this.f2830b.length) {
            int iF = g.f(i12 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f2830b;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f2831c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2830b = jArr;
            this.f2831c = objArr2;
        }
        int i13 = this.f2832d;
        if (i13 - i10 != 0) {
            long[] jArr3 = this.f2830b;
            int i14 = i10 + 1;
            System.arraycopy(jArr3, i10, jArr3, i14, i13 - i10);
            Object[] objArr4 = this.f2831c;
            System.arraycopy(objArr4, i10, objArr4, i14, this.f2832d - i10);
        }
        this.f2830b[i10] = j10;
        this.f2831c[i10] = e10;
        this.f2832d++;
    }

    public void o(@n0 h<? extends E> hVar) {
        int iW = hVar.w();
        for (int i10 = 0; i10 < iW; i10++) {
            n(hVar.m(i10), hVar.x(i10));
        }
    }

    @p0
    public E p(long j10, E e10) {
        E eH = h(j10);
        if (eH == null) {
            n(j10, e10);
        }
        return eH;
    }

    public void q(long j10) {
        int iB = g.b(this.f2830b, this.f2832d, j10);
        if (iB >= 0) {
            Object[] objArr = this.f2831c;
            Object obj = objArr[iB];
            Object obj2 = f2828e;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.f2829a = true;
            }
        }
    }

    public boolean r(long j10, Object obj) {
        int iJ = j(j10);
        if (iJ < 0) {
            return false;
        }
        E eX = x(iJ);
        if (obj != eX && (obj == null || !obj.equals(eX))) {
            return false;
        }
        s(iJ);
        return true;
    }

    public void s(int i10) {
        Object[] objArr = this.f2831c;
        Object obj = objArr[i10];
        Object obj2 = f2828e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f2829a = true;
        }
    }

    @p0
    public E t(long j10, E e10) {
        int iJ = j(j10);
        if (iJ < 0) {
            return null;
        }
        Object[] objArr = this.f2831c;
        E e11 = (E) objArr[iJ];
        objArr[iJ] = e10;
        return e11;
    }

    public String toString() {
        if (w() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2832d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f2832d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(m(i10));
            sb2.append('=');
            E eX = x(i10);
            if (eX != this) {
                sb2.append(eX);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    public boolean u(long j10, E e10, E e11) {
        int iJ = j(j10);
        if (iJ < 0) {
            return false;
        }
        Object obj = this.f2831c[iJ];
        if (obj != e10 && (e10 == null || !e10.equals(obj))) {
            return false;
        }
        this.f2831c[iJ] = e11;
        return true;
    }

    public void v(int i10, E e10) {
        if (this.f2829a) {
            g();
        }
        this.f2831c[i10] = e10;
    }

    public int w() {
        if (this.f2829a) {
            g();
        }
        return this.f2832d;
    }

    public E x(int i10) {
        if (this.f2829a) {
            g();
        }
        return (E) this.f2831c[i10];
    }

    public h(int i10) {
        this.f2829a = false;
        if (i10 == 0) {
            this.f2830b = g.f2826b;
            this.f2831c = g.f2827c;
        } else {
            int iF = g.f(i10);
            this.f2830b = new long[iF];
            this.f2831c = new Object[iF];
        }
    }
}
