package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ja<E> implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f6491a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1517a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f1518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f1519a;
    public boolean b;

    public ja() {
        this(10);
    }

    public ja(int i) {
        this.b = false;
        if (i == 0) {
            this.f1518a = ea.f5981a;
            this.f1519a = ea.f710a;
        } else {
            int iE = ea.e(i);
            this.f1518a = new int[iE];
            this.f1519a = new Object[iE];
        }
    }

    public void a(int i, E e) {
        int i2 = this.f1517a;
        if (i2 != 0 && i <= this.f1518a[i2 - 1]) {
            j(i, e);
            return;
        }
        if (this.b && this.f1517a >= this.f1518a.length) {
            d();
        }
        int i3 = this.f1517a;
        if (i3 >= this.f1518a.length) {
            int iE = ea.e(i3 + 1);
            int[] iArr = new int[iE];
            Object[] objArr = new Object[iE];
            int[] iArr2 = this.f1518a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr2 = this.f1519a;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f1518a = iArr;
            this.f1519a = objArr;
        }
        this.f1518a[i3] = i;
        this.f1519a[i3] = e;
        this.f1517a = i3 + 1;
    }

    public void b() {
        int i = this.f1517a;
        Object[] objArr = this.f1519a;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f1517a = 0;
        this.b = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ja<E> clone() {
        try {
            ja<E> jaVar = (ja) super.clone();
            jaVar.f1518a = (int[]) this.f1518a.clone();
            jaVar.f1519a = (Object[]) this.f1519a.clone();
            return jaVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final void d() {
        int i = this.f1517a;
        int[] iArr = this.f1518a;
        Object[] objArr = this.f1519a;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f6491a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.b = false;
        this.f1517a = i2;
    }

    public E e(int i) {
        return f(i, null);
    }

    public E f(int i, E e) {
        int iA = ea.a(this.f1518a, this.f1517a, i);
        if (iA >= 0) {
            Object[] objArr = this.f1519a;
            if (objArr[iA] != f6491a) {
                return (E) objArr[iA];
            }
        }
        return e;
    }

    public int g(int i) {
        if (this.b) {
            d();
        }
        return ea.a(this.f1518a, this.f1517a, i);
    }

    public int h(E e) {
        if (this.b) {
            d();
        }
        for (int i = 0; i < this.f1517a; i++) {
            if (this.f1519a[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public int i(int i) {
        if (this.b) {
            d();
        }
        return this.f1518a[i];
    }

    public void j(int i, E e) {
        int iA = ea.a(this.f1518a, this.f1517a, i);
        if (iA >= 0) {
            this.f1519a[iA] = e;
            return;
        }
        int i2 = ~iA;
        if (i2 < this.f1517a) {
            Object[] objArr = this.f1519a;
            if (objArr[i2] == f6491a) {
                this.f1518a[i2] = i;
                objArr[i2] = e;
                return;
            }
        }
        if (this.b && this.f1517a >= this.f1518a.length) {
            d();
            i2 = ~ea.a(this.f1518a, this.f1517a, i);
        }
        int i3 = this.f1517a;
        if (i3 >= this.f1518a.length) {
            int iE = ea.e(i3 + 1);
            int[] iArr = new int[iE];
            Object[] objArr2 = new Object[iE];
            int[] iArr2 = this.f1518a;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.f1519a;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f1518a = iArr;
            this.f1519a = objArr2;
        }
        int i4 = this.f1517a;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.f1518a;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            Object[] objArr4 = this.f1519a;
            System.arraycopy(objArr4, i2, objArr4, i5, this.f1517a - i2);
        }
        this.f1518a[i2] = i;
        this.f1519a[i2] = e;
        this.f1517a++;
    }

    public void k(int i) {
        int iA = ea.a(this.f1518a, this.f1517a, i);
        if (iA >= 0) {
            Object[] objArr = this.f1519a;
            Object obj = objArr[iA];
            Object obj2 = f6491a;
            if (obj != obj2) {
                objArr[iA] = obj2;
                this.b = true;
            }
        }
    }

    public int l() {
        if (this.b) {
            d();
        }
        return this.f1517a;
    }

    public E m(int i) {
        if (this.b) {
            d();
        }
        return (E) this.f1519a[i];
    }

    public String toString() {
        if (l() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1517a * 28);
        sb.append('{');
        for (int i = 0; i < this.f1517a; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(i(i));
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
