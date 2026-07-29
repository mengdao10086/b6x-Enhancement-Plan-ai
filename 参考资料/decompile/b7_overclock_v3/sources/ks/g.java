package ks;

import java.lang.reflect.Array;
import java.util.Vector;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class g extends d {
    public int[] A;
    public int[] B;
    public int C;
    public s D;
    public ls.a K0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f39146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[][] f39147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[][] f39148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[][][] f39149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[][][] f39150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n[][] f39151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public n[][] f39152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Vector[] f39153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Vector[] f39154k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f39155k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int[] f39156k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Vector[][] f39157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Vector[][] f39158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[][][] f39159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public e[] f39160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e[] f39161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public e[] f39162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f39163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public f f39164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte[][] f39165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public i[] f39166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[][] f39167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public j[] f39168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public a f39169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f39170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int[] f39171z;

    public g(g gVar) {
        super(true, gVar.d());
        this.f39170y = false;
        this.f39146c = org.bouncycastle.util.a.s(gVar.f39146c);
        this.f39147d = org.bouncycastle.util.a.y(gVar.f39147d);
        this.f39148e = org.bouncycastle.util.a.y(gVar.f39148e);
        this.f39149f = org.bouncycastle.util.a.z(gVar.f39149f);
        this.f39150g = org.bouncycastle.util.a.z(gVar.f39150g);
        this.f39151h = gVar.f39151h;
        this.f39152i = gVar.f39152i;
        this.f39153j = gVar.f39153j;
        this.f39154k = gVar.f39154k;
        this.f39157l = gVar.f39157l;
        this.f39158m = gVar.f39158m;
        this.f39159n = org.bouncycastle.util.a.z(gVar.f39159n);
        this.f39160o = gVar.f39160o;
        this.f39161p = gVar.f39161p;
        this.f39162q = gVar.f39162q;
        this.f39163r = gVar.f39163r;
        this.f39164s = gVar.f39164s;
        this.f39165t = org.bouncycastle.util.a.y(gVar.f39165t);
        this.f39166u = gVar.f39166u;
        this.f39167v = gVar.f39167v;
        this.f39168w = gVar.f39168w;
        this.f39169x = gVar.f39169x;
        this.f39171z = gVar.f39171z;
        this.A = gVar.A;
        this.B = gVar.B;
        this.C = gVar.C;
        this.D = gVar.D;
        this.f39155k0 = gVar.f39155k0;
        this.K0 = gVar.K0;
        this.f39156k1 = gVar.f39156k1;
    }

    public g(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, n[][] nVarArr, n[][] nVarArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, e[] eVarArr, e[] eVarArr2, e[] eVarArr3, int[] iArr2, byte[][] bArr6, i[] iVarArr, byte[][] bArr7, j[] jVarArr, f fVar, a aVar) {
        super(true, fVar);
        this.f39170y = false;
        s sVar = aVar.get();
        this.D = sVar;
        this.f39155k0 = sVar.h();
        this.f39164s = fVar;
        this.A = fVar.d();
        this.B = fVar.b();
        this.f39171z = fVar.a();
        int iC = this.f39164s.c();
        this.C = iC;
        if (iArr == null) {
            this.f39146c = new int[iC];
            for (int i10 = 0; i10 < this.C; i10++) {
                this.f39146c[i10] = 0;
            }
        } else {
            this.f39146c = iArr;
        }
        this.f39147d = bArr;
        this.f39148e = bArr2;
        this.f39149f = org.bouncycastle.util.a.z(bArr3);
        this.f39150g = bArr4;
        int i11 = 2;
        if (bArr5 == null) {
            this.f39159n = new byte[this.C][][];
            int i12 = 0;
            while (i12 < this.C) {
                this.f39159n[i12] = (byte[][]) Array.newInstance((Class<?>) byte.class, (int) Math.floor(this.f39171z[i12] / i11), this.f39155k0);
                i12++;
                i11 = 2;
            }
        } else {
            this.f39159n = bArr5;
        }
        if (vectorArr == null) {
            this.f39153j = new Vector[this.C];
            for (int i13 = 0; i13 < this.C; i13++) {
                this.f39153j[i13] = new Vector();
            }
        } else {
            this.f39153j = vectorArr;
        }
        if (vectorArr2 == null) {
            this.f39154k = new Vector[this.C - 1];
            int i14 = 0;
            for (int i15 = 1; i14 < this.C - i15; i15 = 1) {
                this.f39154k[i14] = new Vector();
                i14++;
            }
        } else {
            this.f39154k = vectorArr2;
        }
        this.f39151h = nVarArr;
        this.f39152i = nVarArr2;
        this.f39157l = vectorArr3;
        this.f39158m = vectorArr4;
        this.f39165t = bArr6;
        this.f39169x = aVar;
        if (iVarArr == null) {
            this.f39166u = new i[this.C - 1];
            int i16 = 0;
            for (int i17 = 1; i16 < this.C - i17; i17 = 1) {
                int i18 = i16 + 1;
                this.f39166u[i16] = new i(this.f39171z[i18], this.B[i18], this.f39169x);
                i16 = i18;
            }
        } else {
            this.f39166u = iVarArr;
        }
        this.f39167v = bArr7;
        this.f39156k1 = new int[this.C];
        for (int i19 = 0; i19 < this.C; i19++) {
            this.f39156k1[i19] = 1 << this.f39171z[i19];
        }
        this.K0 = new ls.a(this.D);
        int i20 = this.C;
        if (i20 <= 1) {
            this.f39160o = new e[0];
        } else if (eVarArr == null) {
            this.f39160o = new e[i20 - 2];
            int i21 = 0;
            while (i21 < this.C - 2) {
                int i22 = i21 + 1;
                this.f39160o[i21] = new e(aVar.get(), this.A[i22], this.f39156k1[i21 + 2], this.f39148e[i21]);
                i21 = i22;
            }
        } else {
            this.f39160o = eVarArr;
        }
        if (eVarArr2 == null) {
            this.f39161p = new e[this.C - 1];
            int i23 = 0;
            for (int i24 = 1; i23 < this.C - i24; i24 = 1) {
                int i25 = i23 + 1;
                this.f39161p[i23] = new e(aVar.get(), this.A[i23], this.f39156k1[i25], this.f39147d[i23]);
                i23 = i25;
            }
        } else {
            this.f39161p = eVarArr2;
        }
        if (eVarArr3 == null) {
            this.f39162q = new e[this.C - 1];
            int i26 = 0;
            for (int i27 = 1; i26 < this.C - i27; i27 = 1) {
                int i28 = i26 + 1;
                this.f39162q[i26] = new e(aVar.get(), this.A[i26], this.f39156k1[i28]);
                i26 = i28;
            }
        } else {
            this.f39162q = eVarArr3;
        }
        if (iArr2 == null) {
            this.f39163r = new int[this.C - 1];
            int i29 = 0;
            for (int i30 = 1; i29 < this.C - i30; i30 = 1) {
                this.f39163r[i29] = -1;
                i29++;
            }
        } else {
            this.f39163r = iArr2;
        }
        int i31 = this.f39155k0;
        byte[] bArr8 = new byte[i31];
        byte[] bArr9 = new byte[i31];
        if (jVarArr != null) {
            this.f39168w = jVarArr;
            return;
        }
        this.f39168w = new j[this.C - 1];
        int i32 = 0;
        while (i32 < this.C - 1) {
            System.arraycopy(bArr[i32], 0, bArr8, 0, this.f39155k0);
            this.K0.c(bArr8);
            byte[] bArrC = this.K0.c(bArr8);
            int i33 = i32 + 1;
            this.f39168w[i32] = new j(aVar.get(), this.A[i32], this.f39171z[i33]);
            this.f39168w[i32].f(bArrC, bArr6[i32]);
            i32 = i33;
        }
    }

    public g(byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, n[][] nVarArr, n[][] nVarArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][] bArr5, byte[][] bArr6, f fVar, a aVar) {
        this(null, bArr, bArr2, bArr3, bArr4, null, nVarArr, nVarArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, null, null, null, null, bArr5, null, bArr6, null, fVar, aVar);
    }

    public final void e(int i10) {
        int i11;
        byte[] bArrC;
        int i12 = this.f39146c[i10];
        int i13 = this.f39171z[i10];
        int i14 = this.B[i10];
        int i15 = 0;
        while (true) {
            i11 = i13 - i14;
            if (i15 >= i11) {
                break;
            }
            this.f39151h[i10][i15].m(this.K0);
            i15++;
        }
        int iN = n(i12);
        byte[] bArr = new byte[this.f39155k0];
        byte[] bArrC2 = this.K0.c(this.f39147d[i10]);
        int i16 = (i12 >>> (iN + 1)) & 1;
        int i17 = this.f39155k0;
        byte[] bArr2 = new byte[i17];
        int i18 = i13 - 1;
        if (iN < i18 && i16 == 0) {
            System.arraycopy(this.f39149f[i10][iN], 0, bArr2, 0, i17);
        }
        int i19 = this.f39155k0;
        byte[] bArr3 = new byte[i19];
        if (iN == 0) {
            if (i10 == this.C - 1) {
                bArrC = new ls.d(bArrC2, this.f39169x.get(), this.A[i10]).c();
            } else {
                byte[] bArr4 = new byte[i19];
                System.arraycopy(this.f39147d[i10], 0, bArr4, 0, i19);
                this.K0.c(bArr4);
                byte[] bArrA = this.f39161p[i10].a();
                this.f39161p[i10].e(bArr4);
                bArrC = bArrA;
            }
            System.arraycopy(bArrC, 0, this.f39149f[i10][0], 0, this.f39155k0);
        } else {
            int i20 = i19 << 1;
            byte[] bArr5 = new byte[i20];
            System.arraycopy(this.f39149f[i10][iN - 1], 0, bArr5, 0, i19);
            byte[] bArr6 = this.f39159n[i10][(int) Math.floor(r12 / 2)];
            int i21 = this.f39155k0;
            System.arraycopy(bArr6, 0, bArr5, i21, i21);
            this.D.update(bArr5, 0, i20);
            this.f39149f[i10][iN] = new byte[this.D.h()];
            this.D.c(this.f39149f[i10][iN], 0);
            for (int i22 = 0; i22 < iN; i22++) {
                if (i22 < i11) {
                    if (this.f39151h[i10][i22].n()) {
                        System.arraycopy(this.f39151h[i10][i22].b(), 0, this.f39149f[i10][i22], 0, this.f39155k0);
                        this.f39151h[i10][i22].a();
                    } else {
                        System.err.println("Treehash (" + i10 + ag.c.f654g + i22 + ") not finished when needed in AuthPathComputation");
                    }
                }
                if (i22 < i18 && i22 >= i11) {
                    int i23 = i22 - i11;
                    if (this.f39157l[i10][i23].size() > 0) {
                        System.arraycopy(this.f39157l[i10][i23].lastElement(), 0, this.f39149f[i10][i22], 0, this.f39155k0);
                        Vector[][] vectorArr = this.f39157l;
                        vectorArr[i10][i23].removeElementAt(vectorArr[i10][i23].size() - 1);
                    }
                }
                if (i22 < i11 && ((1 << i22) * 3) + i12 < this.f39156k1[i10]) {
                    this.f39151h[i10][i22].i();
                }
            }
        }
        if (iN < i18 && i16 == 0) {
            System.arraycopy(bArr2, 0, this.f39159n[i10][(int) Math.floor(iN / 2)], 0, this.f39155k0);
        }
        if (i10 != this.C - 1) {
            this.f39163r[i10] = j(i10);
            return;
        }
        for (int i24 = 1; i24 <= i11 / 2; i24++) {
            int iJ = j(i10);
            if (iJ >= 0) {
                try {
                    byte[] bArr7 = new byte[this.f39155k0];
                    System.arraycopy(this.f39151h[i10][iJ].e(), 0, bArr7, 0, this.f39155k0);
                    this.f39151h[i10][iJ].l(this.K0, new ls.d(this.K0.c(bArr7), this.f39169x.get(), this.A[i10]).c());
                } catch (Exception e10) {
                    System.out.println(e10);
                }
            }
        }
    }

    public byte[][][] f() {
        return org.bouncycastle.util.a.z(this.f39149f);
    }

    public byte[][] g() {
        return org.bouncycastle.util.a.y(this.f39147d);
    }

    public int h(int i10) {
        return this.f39146c[i10];
    }

    public int[] i() {
        return this.f39146c;
    }

    public final int j(int i10) {
        int i11 = -1;
        for (int i12 = 0; i12 < this.f39171z[i10] - this.B[i10]; i12++) {
            if (this.f39151h[i10][i12].o() && !this.f39151h[i10][i12].n() && (i11 == -1 || this.f39151h[i10][i12].d() < this.f39151h[i10][i11].d())) {
                i11 = i12;
            }
        }
        return i11;
    }

    public a k() {
        return this.f39169x;
    }

    public int l(int i10) {
        return this.f39156k1[i10];
    }

    public byte[] m(int i10) {
        return this.f39167v[i10];
    }

    public final int n(int i10) {
        if (i10 == 0) {
            return -1;
        }
        int i11 = 0;
        int i12 = 1;
        while (i10 % i12 == 0) {
            i12 *= 2;
            i11++;
        }
        return i11 - 1;
    }

    public boolean o() {
        return this.f39170y;
    }

    public void p() {
        this.f39170y = true;
    }

    public g q() {
        g gVar = new g(this);
        gVar.r(this.f39164s.c() - 1);
        return gVar;
    }

    public final void r(int i10) {
        int i11 = this.C;
        if (i10 == i11 - 1) {
            int[] iArr = this.f39146c;
            iArr[i10] = iArr[i10] + 1;
        }
        if (this.f39146c[i10] != this.f39156k1[i10]) {
            t(i10);
        } else if (i11 != 1) {
            s(i10);
            this.f39146c[i10] = 0;
        }
    }

    public final void s(int i10) {
        if (i10 > 0) {
            int[] iArr = this.f39146c;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
            int i12 = i10;
            boolean z10 = true;
            do {
                i12--;
                if (this.f39146c[i12] < this.f39156k1[i12]) {
                    z10 = false;
                }
                if (!z10) {
                    break;
                }
            } while (i12 > 0);
            if (z10) {
                return;
            }
            this.K0.c(this.f39147d[i10]);
            this.f39168w[i11].h();
            if (i10 > 1) {
                e[] eVarArr = this.f39160o;
                int i13 = i11 - 1;
                eVarArr[i13] = eVarArr[i13].f();
            }
            e[] eVarArr2 = this.f39161p;
            eVarArr2[i11] = eVarArr2[i11].f();
            if (this.f39163r[i11] >= 0) {
                e[] eVarArr3 = this.f39162q;
                eVarArr3[i11] = eVarArr3[i11].f();
                try {
                    this.f39151h[i11][this.f39163r[i11]].l(this.K0, this.f39162q[i11].a());
                    this.f39151h[i11][this.f39163r[i11]].n();
                } catch (Exception e10) {
                    System.out.println(e10);
                }
            }
            u(i10);
            this.f39167v[i11] = this.f39168w[i11].b();
            for (int i14 = 0; i14 < this.f39171z[i10] - this.B[i10]; i14++) {
                n[] nVarArr = this.f39151h[i10];
                n[][] nVarArr2 = this.f39152i;
                nVarArr[i14] = nVarArr2[i11][i14];
                nVarArr2[i11][i14] = this.f39166u[i11].g()[i14];
            }
            for (int i15 = 0; i15 < this.f39171z[i10]; i15++) {
                System.arraycopy(this.f39150g[i11][i15], 0, this.f39149f[i10][i15], 0, this.f39155k0);
                System.arraycopy(this.f39166u[i11].a()[i15], 0, this.f39150g[i11][i15], 0, this.f39155k0);
            }
            for (int i16 = 0; i16 < this.B[i10] - 1; i16++) {
                Vector[] vectorArr = this.f39157l[i10];
                Vector[][] vectorArr2 = this.f39158m;
                vectorArr[i16] = vectorArr2[i11][i16];
                vectorArr2[i11][i16] = this.f39166u[i11].b()[i16];
            }
            Vector[] vectorArr3 = this.f39153j;
            Vector[] vectorArr4 = this.f39154k;
            vectorArr3[i10] = vectorArr4[i11];
            vectorArr4[i11] = this.f39166u[i11].d();
            this.f39165t[i11] = this.f39166u[i11].c();
            int i17 = this.f39155k0;
            byte[] bArr = new byte[i17];
            byte[] bArr2 = new byte[i17];
            System.arraycopy(this.f39147d[i11], 0, bArr2, 0, i17);
            this.K0.c(bArr2);
            this.K0.c(bArr2);
            this.f39168w[i11].f(this.K0.c(bArr2), this.f39165t[i11]);
            r(i11);
        }
    }

    public final void t(int i10) {
        e(i10);
        if (i10 > 0) {
            if (i10 > 1) {
                e[] eVarArr = this.f39160o;
                int i11 = (i10 - 1) - 1;
                eVarArr[i11] = eVarArr[i11].f();
            }
            e[] eVarArr2 = this.f39161p;
            int i12 = i10 - 1;
            eVarArr2[i12] = eVarArr2[i12].f();
            int iFloor = (int) Math.floor(((double) (l(i10) * 2)) / ((double) (this.f39171z[i12] - this.B[i12])));
            int[] iArr = this.f39146c;
            if (iArr[i10] % iFloor == 1) {
                if (iArr[i10] > 1 && this.f39163r[i12] >= 0) {
                    try {
                        this.f39151h[i12][this.f39163r[i12]].l(this.K0, this.f39162q[i12].a());
                        this.f39151h[i12][this.f39163r[i12]].n();
                    } catch (Exception e10) {
                        System.out.println(e10);
                    }
                }
                this.f39163r[i12] = j(i12);
                int[] iArr2 = this.f39163r;
                if (iArr2[i12] >= 0) {
                    this.f39162q[i12] = new e(this.f39169x.get(), this.A[i12], iFloor, this.f39151h[i12][iArr2[i12]].e());
                    e[] eVarArr3 = this.f39162q;
                    eVarArr3[i12] = eVarArr3[i12].f();
                }
            } else if (this.f39163r[i12] >= 0) {
                e[] eVarArr4 = this.f39162q;
                eVarArr4[i12] = eVarArr4[i12].f();
            }
            this.f39168w[i12].h();
            if (this.f39146c[i10] == 1) {
                this.f39166u[i12].h(new Vector());
            }
            u(i10);
        }
    }

    public final void u(int i10) {
        byte[] bArr = new byte[this.f39155k0];
        int i11 = i10 - 1;
        byte[] bArrC = this.K0.c(this.f39148e[i11]);
        if (i10 == this.C - 1) {
            this.f39166u[i11].k(this.f39148e[i11], new ls.d(bArrC, this.f39169x.get(), this.A[i10]).c());
        } else {
            this.f39166u[i11].k(this.f39148e[i11], this.f39160o[i11].a());
            this.f39160o[i11].e(this.f39148e[i11]);
        }
    }
}
