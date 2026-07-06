package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fa<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f6086a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f862a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f863a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f864a;
    public boolean b;

    public fa() {
        this(10);
    }

    public fa(int i) {
        this.b = false;
        if (i == 0) {
            this.f863a = ea.f709a;
            this.f864a = ea.f710a;
        } else {
            int iF = ea.f(i);
            this.f863a = new long[iF];
            this.f864a = new Object[iF];
        }
    }

    public void a(long j, E e) {
        int i = this.f862a;
        if (i != 0 && j <= this.f863a[i - 1]) {
            i(j, e);
            return;
        }
        if (this.b && this.f862a >= this.f863a.length) {
            d();
        }
        int i2 = this.f862a;
        if (i2 >= this.f863a.length) {
            int iF = ea.f(i2 + 1);
            long[] jArr = new long[iF];
            Object[] objArr = new Object[iF];
            long[] jArr2 = this.f863a;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f864a;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f863a = jArr;
            this.f864a = objArr;
        }
        this.f863a[i2] = j;
        this.f864a[i2] = e;
        this.f862a = i2 + 1;
    }

    public void b() {
        int i = this.f862a;
        Object[] objArr = this.f864a;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f862a = 0;
        this.b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public fa<E> clone() {
        try {
            fa<E> faVar = (fa) super.clone();
            faVar.f863a = (long[]) this.f863a.clone();
            faVar.f864a = (Object[]) this.f864a.clone();
            return faVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void d() {
        int i = this.f862a;
        long[] jArr = this.f863a;
        Object[] objArr = this.f864a;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f6086a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.f862a = i2;
    }

    public E e(long j) {
        return f(j, null);
    }

    public E f(long j, E e) {
        int iB = ea.b(this.f863a, this.f862a, j);
        if (iB >= 0) {
            Object[] objArr = this.f864a;
            if (objArr[iB] != f6086a) {
                return (E) objArr[iB];
            }
        }
        return e;
    }

    public int g(long j) {
        if (this.b) {
            d();
        }
        return ea.b(this.f863a, this.f862a, j);
    }

    public long h(int i) {
        if (this.b) {
            d();
        }
        return this.f863a[i];
    }

    public void i(long j, E e) {
        int iB = ea.b(this.f863a, this.f862a, j);
        if (iB >= 0) {
            this.f864a[iB] = e;
            return;
        }
        int i = ~iB;
        if (i < this.f862a) {
            Object[] objArr = this.f864a;
            if (objArr[i] == f6086a) {
                this.f863a[i] = j;
                objArr[i] = e;
                return;
            }
        }
        if (this.b && this.f862a >= this.f863a.length) {
            d();
            i = ~ea.b(this.f863a, this.f862a, j);
        }
        int i2 = this.f862a;
        if (i2 >= this.f863a.length) {
            int iF = ea.f(i2 + 1);
            long[] jArr = new long[iF];
            Object[] objArr2 = new Object[iF];
            long[] jArr2 = this.f863a;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f864a;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f863a = jArr;
            this.f864a = objArr2;
        }
        int i3 = this.f862a;
        if (i3 - i != 0) {
            long[] jArr3 = this.f863a;
            int i4 = i + 1;
            System.arraycopy(jArr3, i, jArr3, i4, i3 - i);
            Object[] objArr4 = this.f864a;
            System.arraycopy(objArr4, i, objArr4, i4, this.f862a - i);
        }
        this.f863a[i] = j;
        this.f864a[i] = e;
        this.f862a++;
    }

    public void j(long j) {
        int iB = ea.b(this.f863a, this.f862a, j);
        if (iB >= 0) {
            Object[] objArr = this.f864a;
            Object obj = objArr[iB];
            Object obj2 = f6086a;
            if (obj != obj2) {
                objArr[iB] = obj2;
                this.b = true;
            }
        }
    }

    public void k(int i) {
        Object[] objArr = this.f864a;
        Object obj = objArr[i];
        Object obj2 = f6086a;
        if (obj != obj2) {
            objArr[i] = obj2;
            this.b = true;
        }
    }

    public int l() {
        if (this.b) {
            d();
        }
        return this.f862a;
    }

    public E m(int i) {
        if (this.b) {
            d();
        }
        return (E) this.f864a[i];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f862a * 28);
        sb.append('{');
        for (int i = 0; i < this.f862a; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(h(i));
            sb.append('=');
            E eM = m(i);
            if (eM != this) {
                sb.append(eM);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
