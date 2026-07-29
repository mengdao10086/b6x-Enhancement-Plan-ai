package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.y;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class i extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f35804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f35805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[][] f35806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f35807d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[][] f35808e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f35809f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f35810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ps.a[] f35811h;

    public i(f0 f0Var) {
        int i10 = 0;
        if (f0Var.K(0) instanceof t) {
            this.f35804a = t.I(f0Var.K(0));
        } else {
            this.f35805b = y.N(f0Var.K(0));
        }
        f0 f0Var2 = (f0) f0Var.K(1);
        this.f35806c = new byte[f0Var2.size()][];
        for (int i11 = 0; i11 < f0Var2.size(); i11++) {
            this.f35806c[i11] = ((z) f0Var2.K(i11)).J();
        }
        this.f35807d = ((z) ((f0) f0Var.K(2)).K(0)).J();
        f0 f0Var3 = (f0) f0Var.K(3);
        this.f35808e = new byte[f0Var3.size()][];
        for (int i12 = 0; i12 < f0Var3.size(); i12++) {
            this.f35808e[i12] = ((z) f0Var3.K(i12)).J();
        }
        this.f35809f = ((z) ((f0) f0Var.K(4)).K(0)).J();
        this.f35810g = ((z) ((f0) f0Var.K(5)).K(0)).J();
        f0 f0Var4 = (f0) f0Var.K(6);
        byte[][][][] bArr = new byte[f0Var4.size()][][][];
        byte[][][][] bArr2 = new byte[f0Var4.size()][][][];
        byte[][][] bArr3 = new byte[f0Var4.size()][][];
        byte[][] bArr4 = new byte[f0Var4.size()][];
        int i13 = 0;
        while (i13 < f0Var4.size()) {
            f0 f0Var5 = (f0) f0Var4.K(i13);
            f0 f0Var6 = (f0) f0Var5.K(i10);
            bArr[i13] = new byte[f0Var6.size()][][];
            for (int i14 = 0; i14 < f0Var6.size(); i14++) {
                f0 f0Var7 = (f0) f0Var6.K(i14);
                bArr[i13][i14] = new byte[f0Var7.size()][];
                for (int i15 = 0; i15 < f0Var7.size(); i15++) {
                    bArr[i13][i14][i15] = ((z) f0Var7.K(i15)).J();
                }
            }
            f0 f0Var8 = (f0) f0Var5.K(1);
            bArr2[i13] = new byte[f0Var8.size()][][];
            for (int i16 = 0; i16 < f0Var8.size(); i16++) {
                f0 f0Var9 = (f0) f0Var8.K(i16);
                bArr2[i13][i16] = new byte[f0Var9.size()][];
                for (int i17 = 0; i17 < f0Var9.size(); i17++) {
                    bArr2[i13][i16][i17] = ((z) f0Var9.K(i17)).J();
                }
            }
            f0 f0Var10 = (f0) f0Var5.K(2);
            bArr3[i13] = new byte[f0Var10.size()][];
            for (int i18 = 0; i18 < f0Var10.size(); i18++) {
                bArr3[i13][i18] = ((z) f0Var10.K(i18)).J();
            }
            bArr4[i13] = ((z) f0Var5.K(3)).J();
            i13++;
            i10 = 0;
        }
        int length = this.f35810g.length - 1;
        this.f35811h = new ps.a[length];
        int i19 = 0;
        while (i19 < length) {
            byte[] bArr5 = this.f35810g;
            int i20 = i19 + 1;
            this.f35811h[i19] = new ps.a(bArr5[i19], bArr5[i20], qs.c.f(bArr[i19]), qs.c.f(bArr2[i19]), qs.c.d(bArr3[i19]), qs.c.b(bArr4[i19]));
            i19 = i20;
        }
    }

    public i(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, ps.a[] aVarArr) {
        this.f35804a = new t(1L);
        this.f35806c = qs.c.c(sArr);
        this.f35807d = qs.c.a(sArr2);
        this.f35808e = qs.c.c(sArr3);
        this.f35809f = qs.c.a(sArr4);
        this.f35810g = qs.c.h(iArr);
        this.f35811h = aVarArr;
    }

    public static i z(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    public short[][] A() {
        return qs.c.d(this.f35806c);
    }

    public short[][] B() {
        return qs.c.d(this.f35808e);
    }

    public ps.a[] C() {
        return this.f35811h;
    }

    public t D() {
        return this.f35804a;
    }

    public int[] E() {
        return qs.c.g(this.f35810g);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        gm.h hVar = this.f35804a;
        if (hVar == null) {
            hVar = this.f35805b;
        }
        iVar.a(hVar);
        gm.i iVar2 = new gm.i();
        for (int i10 = 0; i10 < this.f35806c.length; i10++) {
            iVar2.a(new f2(this.f35806c[i10]));
        }
        iVar.a(new j2(iVar2));
        gm.i iVar3 = new gm.i();
        iVar3.a(new f2(this.f35807d));
        iVar.a(new j2(iVar3));
        gm.i iVar4 = new gm.i();
        for (int i11 = 0; i11 < this.f35808e.length; i11++) {
            iVar4.a(new f2(this.f35808e[i11]));
        }
        iVar.a(new j2(iVar4));
        gm.i iVar5 = new gm.i();
        iVar5.a(new f2(this.f35809f));
        iVar.a(new j2(iVar5));
        gm.i iVar6 = new gm.i();
        iVar6.a(new f2(this.f35810g));
        iVar.a(new j2(iVar6));
        gm.i iVar7 = new gm.i();
        for (int i12 = 0; i12 < this.f35811h.length; i12++) {
            gm.i iVar8 = new gm.i();
            byte[][][] bArrE = qs.c.e(this.f35811h[i12].a());
            gm.i iVar9 = new gm.i();
            for (int i13 = 0; i13 < bArrE.length; i13++) {
                gm.i iVar10 = new gm.i();
                for (int i14 = 0; i14 < bArrE[i13].length; i14++) {
                    iVar10.a(new f2(bArrE[i13][i14]));
                }
                iVar9.a(new j2(iVar10));
            }
            iVar8.a(new j2(iVar9));
            byte[][][] bArrE2 = qs.c.e(this.f35811h[i12].b());
            gm.i iVar11 = new gm.i();
            for (int i15 = 0; i15 < bArrE2.length; i15++) {
                gm.i iVar12 = new gm.i();
                for (int i16 = 0; i16 < bArrE2[i15].length; i16++) {
                    iVar12.a(new f2(bArrE2[i15][i16]));
                }
                iVar11.a(new j2(iVar12));
            }
            iVar8.a(new j2(iVar11));
            byte[][] bArrC = qs.c.c(this.f35811h[i12].d());
            gm.i iVar13 = new gm.i();
            for (byte[] bArr : bArrC) {
                iVar13.a(new f2(bArr));
            }
            iVar8.a(new j2(iVar13));
            iVar8.a(new f2(qs.c.a(this.f35811h[i12].c())));
            iVar7.a(new j2(iVar8));
        }
        iVar.a(new j2(iVar7));
        return new j2(iVar);
    }

    public short[] x() {
        return qs.c.b(this.f35807d);
    }

    public short[] y() {
        return qs.c.b(this.f35809f);
    }
}
