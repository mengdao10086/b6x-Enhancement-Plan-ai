package androidx.collection;

import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class m<E> implements Cloneable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f2872e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f2874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f2875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f2876d;

    public m() {
        this(10);
    }

    public void a(int i10, E e10) {
        int i11 = this.f2876d;
        if (i11 != 0 && i10 <= this.f2874b[i11 - 1]) {
            n(i10, e10);
            return;
        }
        if (this.f2873a && i11 >= this.f2874b.length) {
            g();
        }
        int i12 = this.f2876d;
        if (i12 >= this.f2874b.length) {
            int iE = g.e(i12 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f2874b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f2875c;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2874b = iArr;
            this.f2875c = objArr;
        }
        this.f2874b[i12] = i10;
        this.f2875c[i12] = e10;
        this.f2876d = i12 + 1;
    }

    public void b() {
        int i10 = this.f2876d;
        Object[] objArr = this.f2875c;
        for (int i11 = 0; i11 < i10; i11++) {
            objArr[i11] = null;
        }
        this.f2876d = 0;
        this.f2873a = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public m<E> clone() {
        try {
            m<E> mVar = (m) super.clone();
            mVar.f2874b = (int[]) this.f2874b.clone();
            mVar.f2875c = (Object[]) this.f2875c.clone();
            return mVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    public boolean d(int i10) {
        return j(i10) >= 0;
    }

    public boolean e(E e10) {
        return k(e10) >= 0;
    }

    @Deprecated
    public void f(int i10) {
        q(i10);
    }

    public final void g() {
        int i10 = this.f2876d;
        int[] iArr = this.f2874b;
        Object[] objArr = this.f2875c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            Object obj = objArr[i12];
            if (obj != f2872e) {
                if (i12 != i11) {
                    iArr[i11] = iArr[i12];
                    objArr[i11] = obj;
                    objArr[i12] = null;
                }
                i11++;
            }
        }
        this.f2873a = false;
        this.f2876d = i11;
    }

    @p0
    public E h(int i10) {
        return i(i10, null);
    }

    public E i(int i10, E e10) {
        int iA = g.a(this.f2874b, this.f2876d, i10);
        if (iA >= 0) {
            Object[] objArr = this.f2875c;
            if (objArr[iA] != f2872e) {
                return (E) objArr[iA];
            }
        }
        return e10;
    }

    public int j(int i10) {
        if (this.f2873a) {
            g();
        }
        return g.a(this.f2874b, this.f2876d, i10);
    }

    public int k(E e10) {
        if (this.f2873a) {
            g();
        }
        for (int i10 = 0; i10 < this.f2876d; i10++) {
            if (this.f2875c[i10] == e10) {
                return i10;
            }
        }
        return -1;
    }

    public boolean l() {
        return x() == 0;
    }

    public int m(int i10) {
        if (this.f2873a) {
            g();
        }
        return this.f2874b[i10];
    }

    public void n(int i10, E e10) {
        int iA = g.a(this.f2874b, this.f2876d, i10);
        if (iA >= 0) {
            this.f2875c[iA] = e10;
            return;
        }
        int i11 = ~iA;
        int i12 = this.f2876d;
        if (i11 < i12) {
            Object[] objArr = this.f2875c;
            if (objArr[i11] == f2872e) {
                this.f2874b[i11] = i10;
                objArr[i11] = e10;
                return;
            }
        }
        if (this.f2873a && i12 >= this.f2874b.length) {
            g();
            i11 = ~g.a(this.f2874b, this.f2876d, i10);
        }
        int i13 = this.f2876d;
        if (i13 >= this.f2874b.length) {
            int iE = g.e(i13 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f2874b;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f2875c;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2874b = iArr;
            this.f2875c = objArr2;
        }
        int i14 = this.f2876d;
        if (i14 - i11 != 0) {
            int[] iArr3 = this.f2874b;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr4 = this.f2875c;
            System.arraycopy(objArr4, i11, objArr4, i15, this.f2876d - i11);
        }
        this.f2874b[i11] = i10;
        this.f2875c[i11] = e10;
        this.f2876d++;
    }

    public void o(@n0 m<? extends E> mVar) {
        int iX = mVar.x();
        for (int i10 = 0; i10 < iX; i10++) {
            n(mVar.m(i10), mVar.y(i10));
        }
    }

    @p0
    public E p(int i10, E e10) {
        E eH = h(i10);
        if (eH == null) {
            n(i10, e10);
        }
        return eH;
    }

    public void q(int i10) {
        int iA = g.a(this.f2874b, this.f2876d, i10);
        if (iA >= 0) {
            Object[] objArr = this.f2875c;
            Object obj = objArr[iA];
            Object obj2 = f2872e;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.f2873a = true;
            }
        }
    }

    public boolean r(int i10, Object obj) {
        int iJ = j(i10);
        if (iJ < 0) {
            return false;
        }
        E eY = y(iJ);
        if (obj != eY && (obj == null || !obj.equals(eY))) {
            return false;
        }
        s(iJ);
        return true;
    }

    public void s(int i10) {
        Object[] objArr = this.f2875c;
        Object obj = objArr[i10];
        Object obj2 = f2872e;
        if (obj != obj2) {
            objArr[i10] = obj2;
            this.f2873a = true;
        }
    }

    public void t(int i10, int i11) {
        int iMin = Math.min(this.f2876d, i11 + i10);
        while (i10 < iMin) {
            s(i10);
            i10++;
        }
    }

    public String toString() {
        if (x() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2876d * 28);
        sb2.append('{');
        for (int i10 = 0; i10 < this.f2876d; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(m(i10));
            sb2.append('=');
            E eY = y(i10);
            if (eY != this) {
                sb2.append(eY);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        return sb2.toString();
    }

    @p0
    public E u(int i10, E e10) {
        int iJ = j(i10);
        if (iJ < 0) {
            return null;
        }
        Object[] objArr = this.f2875c;
        E e11 = (E) objArr[iJ];
        objArr[iJ] = e10;
        return e11;
    }

    public boolean v(int i10, E e10, E e11) {
        int iJ = j(i10);
        if (iJ < 0) {
            return false;
        }
        Object obj = this.f2875c[iJ];
        if (obj != e10 && (e10 == null || !e10.equals(obj))) {
            return false;
        }
        this.f2875c[iJ] = e11;
        return true;
    }

    public void w(int i10, E e10) {
        if (this.f2873a) {
            g();
        }
        this.f2875c[i10] = e10;
    }

    public int x() {
        if (this.f2873a) {
            g();
        }
        return this.f2876d;
    }

    public E y(int i10) {
        if (this.f2873a) {
            g();
        }
        return (E) this.f2875c[i10];
    }

    public m(int i10) {
        this.f2873a = false;
        if (i10 == 0) {
            this.f2874b = g.f2825a;
            this.f2875c = g.f2827c;
        } else {
            int iE = g.e(i10);
            this.f2874b = new int[iE];
            this.f2875c = new Object[iE];
        }
    }
}
