package ft;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k[] f28792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28793b;

    public o(int i10) {
        this.f28793b = i10;
        this.f28792a = new k[i10];
    }

    public o(int i10, k kVar) {
        this.f28793b = i10;
        this.f28792a = new k[i10];
        for (int i11 = 0; i11 < this.f28793b; i11++) {
            this.f28792a[i11] = (k) kVar.clone();
        }
    }

    public o(f fVar, l lVar) {
        int iD = lVar.d() + 1;
        this.f28793b = iD;
        this.f28792a = new k[iD];
        int i10 = 0;
        if (lVar instanceof n) {
            while (i10 < this.f28793b) {
                if (fVar.U(i10)) {
                    this.f28792a[i10] = m.z((n) lVar);
                } else {
                    this.f28792a[i10] = m.A((n) lVar);
                }
                i10++;
            }
            return;
        }
        if (!(lVar instanceof q)) {
            throw new IllegalArgumentException("PolynomialGF2n(Bitstring, GF2nField): B1 must be an instance of GF2nONBField or GF2nPolynomialField!");
        }
        while (i10 < this.f28793b) {
            if (fVar.U(i10)) {
                this.f28792a[i10] = p.z((q) lVar);
            } else {
                this.f28792a[i10] = p.A((q) lVar);
            }
            i10++;
        }
    }

    public o(o oVar) {
        int i10 = oVar.f28793b;
        this.f28792a = new k[i10];
        this.f28793b = i10;
        for (int i11 = 0; i11 < this.f28793b; i11++) {
            this.f28792a[i11] = (k) oVar.f28792a[i11].clone();
        }
    }

    public final o a(o oVar) {
        o oVar2;
        int i10 = 0;
        if (s() >= oVar.s()) {
            oVar2 = new o(s());
            while (i10 < oVar.s()) {
                oVar2.f28792a[i10] = (k) this.f28792a[i10].d(oVar.f28792a[i10]);
                i10++;
            }
            while (i10 < s()) {
                oVar2.f28792a[i10] = this.f28792a[i10];
                i10++;
            }
        } else {
            oVar2 = new o(oVar.s());
            while (i10 < s()) {
                oVar2.f28792a[i10] = (k) this.f28792a[i10].d(oVar.f28792a[i10]);
                i10++;
            }
            while (i10 < oVar.s()) {
                oVar2.f28792a[i10] = oVar.f28792a[i10];
                i10++;
            }
        }
        return oVar2;
    }

    public final void b() {
        for (int i10 = 0; i10 < this.f28793b; i10++) {
            this.f28792a[i10].m();
        }
    }

    public final k c(int i10) {
        return this.f28792a[i10];
    }

    public final o[] d(o oVar) {
        o oVar2;
        o[] oVarArr = new o[2];
        o oVar3 = new o(this);
        oVar3.r();
        int iG = oVar.g();
        k kVar = (k) oVar.f28792a[iG].f();
        if (oVar3.g() < iG) {
            oVarArr[0] = new o(this);
            oVarArr[0].b();
            oVarArr[0].r();
            oVarArr[1] = new o(this);
            oVar2 = oVarArr[1];
        } else {
            oVarArr[0] = new o(this);
            oVarArr[0].b();
            while (true) {
                int iG2 = oVar3.g() - iG;
                if (iG2 < 0) {
                    break;
                }
                k kVar2 = (k) oVar3.f28792a[oVar3.g()].b(kVar);
                o oVarN = oVar.n(kVar2);
                oVarN.q(iG2);
                oVar3 = oVar3.a(oVarN);
                oVar3.r();
                oVarArr[0].f28792a[iG2] = (k) kVar2.clone();
            }
            oVarArr[1] = oVar3;
            oVar2 = oVarArr[0];
        }
        oVar2.r();
        return oVarArr;
    }

    public final void e(int i10) {
        int i11 = this.f28793b;
        if (i10 <= i11) {
            return;
        }
        k[] kVarArr = new k[i10];
        System.arraycopy(this.f28792a, 0, kVarArr, 0, i11);
        l lVarO = this.f28792a[0].o();
        k[] kVarArr2 = this.f28792a;
        if (kVarArr2[0] instanceof p) {
            for (int i12 = this.f28793b; i12 < i10; i12++) {
                kVarArr[i12] = p.A((q) lVarO);
            }
        } else if (kVarArr2[0] instanceof m) {
            for (int i13 = this.f28793b; i13 < i10; i13++) {
                kVarArr[i13] = m.A((n) lVarO);
            }
        }
        this.f28793b = i10;
        this.f28792a = kVarArr;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (g() != oVar.g()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f28793b; i10++) {
            if (!this.f28792a[i10].equals(oVar.f28792a[i10])) {
                return false;
            }
        }
        return true;
    }

    public final o f(o oVar) {
        o oVar2 = new o(this);
        o oVar3 = new o(oVar);
        oVar2.r();
        oVar3.r();
        o oVar4 = oVar2;
        o oVarM = oVar3;
        while (!oVarM.h()) {
            o oVar5 = oVarM;
            oVarM = oVar4.m(oVarM);
            oVar4 = oVar5;
        }
        return oVar4.n((k) oVar4.f28792a[oVar4.g()].f());
    }

    public final int g() {
        for (int i10 = this.f28793b - 1; i10 >= 0; i10--) {
            if (!this.f28792a[i10].e()) {
                return i10;
            }
        }
        return -1;
    }

    public final boolean h() {
        for (int i10 = 0; i10 < this.f28793b; i10++) {
            k[] kVarArr = this.f28792a;
            if (kVarArr[i10] != null && !kVarArr[i10].e()) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return g() + this.f28792a.hashCode();
    }

    public final o i(o oVar) {
        if (s() != oVar.s()) {
            throw new IllegalArgumentException("PolynomialGF2n.multiply: this and b must have the same size!");
        }
        o oVar2 = new o((r0 << 1) - 1);
        for (int i10 = 0; i10 < s(); i10++) {
            for (int i11 = 0; i11 < oVar.s(); i11++) {
                k[] kVarArr = oVar2.f28792a;
                int i12 = i10 + i11;
                if (kVarArr[i12] == null) {
                    kVarArr[i12] = (k) this.f28792a[i10].b(oVar.f28792a[i11]);
                } else {
                    kVarArr[i12] = (k) kVarArr[i12].d(this.f28792a[i10].b(oVar.f28792a[i11]));
                }
            }
        }
        return oVar2;
    }

    public final o j(o oVar, o oVar2) {
        return i(oVar).l(oVar2);
    }

    public final o k(o oVar) throws RuntimeException {
        return d(oVar)[0];
    }

    public final o l(o oVar) throws RuntimeException {
        return m(oVar);
    }

    public final o m(o oVar) throws RuntimeException {
        return d(oVar)[1];
    }

    public final o n(k kVar) {
        o oVar = new o(s());
        for (int i10 = 0; i10 < s(); i10++) {
            oVar.f28792a[i10] = (k) this.f28792a[i10].b(kVar);
        }
        return oVar;
    }

    public final void o(int i10, k kVar) {
        if (!(kVar instanceof p) && !(kVar instanceof m)) {
            throw new IllegalArgumentException("PolynomialGF2n.set f must be an instance of either GF2nPolynomialElement or GF2nONBElement!");
        }
        this.f28792a[i10] = (k) kVar.clone();
    }

    public final o p(int i10) {
        if (i10 <= 0) {
            return new o(this);
        }
        o oVar = new o(this.f28793b + i10, this.f28792a[0]);
        oVar.b();
        for (int i11 = 0; i11 < this.f28793b; i11++) {
            oVar.f28792a[i11 + i10] = this.f28792a[i11];
        }
        return oVar;
    }

    public final void q(int i10) {
        if (i10 > 0) {
            int i11 = this.f28793b;
            l lVarO = this.f28792a[0].o();
            e(this.f28793b + i10);
            for (int i12 = i11 - 1; i12 >= 0; i12--) {
                k[] kVarArr = this.f28792a;
                kVarArr[i12 + i10] = kVarArr[i12];
            }
            k[] kVarArr2 = this.f28792a;
            if (kVarArr2[0] instanceof p) {
                for (int i13 = i10 - 1; i13 >= 0; i13--) {
                    this.f28792a[i13] = p.A((q) lVarO);
                }
                return;
            }
            if (kVarArr2[0] instanceof m) {
                for (int i14 = i10 - 1; i14 >= 0; i14--) {
                    this.f28792a[i14] = m.A((n) lVarO);
                }
            }
        }
    }

    public final void r() {
        int i10 = this.f28793b;
        do {
            i10--;
            if (!this.f28792a[i10].e()) {
                break;
            }
        } while (i10 > 0);
        int i11 = i10 + 1;
        if (i11 < this.f28793b) {
            k[] kVarArr = new k[i11];
            System.arraycopy(this.f28792a, 0, kVarArr, 0, i11);
            this.f28792a = kVarArr;
            this.f28793b = i11;
        }
    }

    public final int s() {
        return this.f28793b;
    }
}
