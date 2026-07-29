package ks;

import com.blankj.utilcode.util.i0;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Array;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f39173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n[] f39175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Vector[] f39176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f39177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[][] f39178f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f39179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Vector f39180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Vector f39181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f39182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f39183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int[] f39184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f39185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f39186n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f39187o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f39188p;

    public i(int i10, int i11, a aVar) {
        this.f39173a = i10;
        this.f39183k = aVar;
        s sVar = aVar.get();
        this.f39182j = sVar;
        int iH = sVar.h();
        this.f39174b = iH;
        this.f39179g = i11;
        this.f39184l = new int[i10];
        int[] iArr = {i10, iH};
        this.f39178f = (byte[][]) Array.newInstance((Class<?>) byte.class, iArr);
        this.f39177e = new byte[this.f39174b];
        this.f39176d = new Vector[this.f39179g - 1];
        for (int i12 = 0; i12 < i11 - 1; i12++) {
            this.f39176d[i12] = new Vector();
        }
    }

    public byte[][] a() {
        return m.f(this.f39178f);
    }

    public Vector[] b() {
        return m.a(this.f39176d);
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p(this.f39177e);
    }

    public Vector d() {
        Vector vector = new Vector();
        Enumeration enumerationElements = this.f39180h.elements();
        while (enumerationElements.hasMoreElements()) {
            vector.addElement(enumerationElements.nextElement());
        }
        return vector;
    }

    public byte[][] e() {
        Vector vector = this.f39180h;
        int size = vector == null ? 0 : vector.size();
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39173a + 1 + size, 64);
        bArr[0] = this.f39177e;
        int i10 = 0;
        while (i10 < this.f39173a) {
            int i11 = i10 + 1;
            bArr[i11] = this.f39178f[i10];
            i10 = i11;
        }
        for (int i12 = 0; i12 < size; i12++) {
            bArr[this.f39173a + 1 + i12] = (byte[]) this.f39180h.elementAt(i12);
        }
        return bArr;
    }

    public int[] f() {
        Vector vector = this.f39180h;
        int size = vector == null ? 0 : vector.size();
        int i10 = this.f39173a;
        int[] iArr = new int[i10 + 8 + size];
        iArr[0] = i10;
        iArr[1] = this.f39174b;
        iArr[2] = this.f39179g;
        iArr[3] = this.f39187o;
        iArr[4] = this.f39188p;
        if (this.f39186n) {
            iArr[5] = 1;
        } else {
            iArr[5] = 0;
        }
        if (this.f39185m) {
            iArr[6] = 1;
        } else {
            iArr[6] = 0;
        }
        iArr[7] = size;
        for (int i11 = 0; i11 < this.f39173a; i11++) {
            iArr[i11 + 8] = this.f39184l[i11];
        }
        for (int i12 = 0; i12 < size; i12++) {
            iArr[this.f39173a + 8 + i12] = ((Integer) this.f39181i.elementAt(i12)).intValue();
        }
        return iArr;
    }

    public n[] g() {
        return m.e(this.f39175c);
    }

    public void h(Vector vector) {
        int i10;
        this.f39175c = new n[this.f39173a - this.f39179g];
        int i11 = 0;
        while (true) {
            i10 = this.f39173a;
            if (i11 >= i10 - this.f39179g) {
                break;
            }
            this.f39175c[i11] = new n(vector, i11, this.f39183k.get());
            i11++;
        }
        this.f39184l = new int[i10];
        this.f39178f = (byte[][]) Array.newInstance((Class<?>) byte.class, i10, this.f39174b);
        this.f39177e = new byte[this.f39174b];
        this.f39180h = new Vector();
        this.f39181i = new Vector();
        this.f39185m = true;
        this.f39186n = false;
        for (int i12 = 0; i12 < this.f39173a; i12++) {
            this.f39184l[i12] = -1;
        }
        this.f39176d = new Vector[this.f39179g - 1];
        for (int i13 = 0; i13 < this.f39179g - 1; i13++) {
            this.f39176d[i13] = new Vector();
        }
        this.f39187o = 3;
        this.f39188p = 0;
    }

    public void i(byte[] bArr, int i10) {
        this.f39175c[i10].j(bArr);
    }

    public void j(byte[] bArr) {
        if (this.f39186n) {
            System.out.print("Too much updates for Tree!!");
            return;
        }
        if (!this.f39185m) {
            System.err.println("GMSSRootCalc not initialized!");
            return;
        }
        int[] iArr = this.f39184l;
        iArr[0] = iArr[0] + 1;
        if (iArr[0] == 1) {
            System.arraycopy(bArr, 0, this.f39178f[0], 0, this.f39174b);
        } else if (iArr[0] == 3 && this.f39173a > this.f39179g) {
            this.f39175c[0].k(bArr);
        }
        int[] iArr2 = this.f39184l;
        if ((iArr2[0] - 3) % 2 == 0 && iArr2[0] >= 3 && this.f39173a == this.f39179g) {
            this.f39176d[0].insertElementAt(bArr, 0);
        }
        if (this.f39184l[0] == 0) {
            this.f39180h.addElement(bArr);
            this.f39181i.addElement(org.bouncycastle.util.j.g(0));
            return;
        }
        int i10 = this.f39174b;
        byte[] bArr2 = new byte[i10];
        int i11 = i10 << 1;
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, 0, i10);
        int i12 = 0;
        while (this.f39180h.size() > 0 && i12 == ((Integer) this.f39181i.lastElement()).intValue()) {
            System.arraycopy(this.f39180h.lastElement(), 0, bArr3, 0, this.f39174b);
            Vector vector = this.f39180h;
            vector.removeElementAt(vector.size() - 1);
            Vector vector2 = this.f39181i;
            vector2.removeElementAt(vector2.size() - 1);
            int i13 = this.f39174b;
            System.arraycopy(bArr2, 0, bArr3, i13, i13);
            this.f39182j.update(bArr3, 0, i11);
            bArr2 = new byte[this.f39182j.h()];
            this.f39182j.c(bArr2, 0);
            i12++;
            if (i12 < this.f39173a) {
                int[] iArr3 = this.f39184l;
                iArr3[i12] = iArr3[i12] + 1;
                if (iArr3[i12] == 1) {
                    System.arraycopy(bArr2, 0, this.f39178f[i12], 0, this.f39174b);
                }
                if (i12 >= this.f39173a - this.f39179g) {
                    if (i12 == 0) {
                        System.out.println("M���P");
                    }
                    int[] iArr4 = this.f39184l;
                    if ((iArr4[i12] - 3) % 2 == 0 && iArr4[i12] >= 3) {
                        this.f39176d[i12 - (this.f39173a - this.f39179g)].insertElementAt(bArr2, 0);
                    }
                } else if (this.f39184l[i12] == 3) {
                    this.f39175c[i12].k(bArr2);
                }
            }
        }
        this.f39180h.addElement(bArr2);
        this.f39181i.addElement(org.bouncycastle.util.j.g(i12));
        if (i12 == this.f39173a) {
            this.f39186n = true;
            this.f39185m = false;
            this.f39177e = (byte[]) this.f39180h.lastElement();
        }
    }

    public void k(byte[] bArr, byte[] bArr2) {
        int i10 = this.f39188p;
        if (i10 < this.f39173a - this.f39179g && this.f39187o - 2 == this.f39184l[0]) {
            i(bArr, i10);
            this.f39188p++;
            this.f39187o *= 2;
        }
        j(bArr2);
    }

    public boolean l() {
        return this.f39186n;
    }

    public boolean m() {
        return this.f39185m;
    }

    public String toString() {
        Vector vector = this.f39180h;
        int size = vector == null ? 0 : vector.size();
        String str = "";
        for (int i10 = 0; i10 < this.f39173a + 8 + size; i10++) {
            str = str + f()[i10] + i0.f11861z;
        }
        for (int i11 = 0; i11 < this.f39173a + 1 + size; i11++) {
            str = str + new String(jt.h.h(e()[i11])) + i0.f11861z;
        }
        return str + GlideException.a.f12263d + this.f39183k.get().h();
    }
}
