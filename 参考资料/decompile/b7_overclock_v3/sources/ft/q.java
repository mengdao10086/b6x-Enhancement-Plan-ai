package ft;

import java.security.SecureRandom;
import java.util.Vector;

/* JADX INFO: loaded from: classes6.dex */
public class q extends l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f[] f28796f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f28797g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f28798h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f28799i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f28800j;

    public q(int i10, SecureRandom secureRandom) {
        super(secureRandom);
        this.f28797g = false;
        this.f28798h = false;
        this.f28800j = new int[3];
        if (i10 < 3) {
            throw new IllegalArgumentException("k must be at least 3");
        }
        this.f28776b = i10;
        b();
        i();
        this.f28778d = new Vector();
        this.f28779e = new Vector();
    }

    public q(int i10, SecureRandom secureRandom, f fVar) throws RuntimeException {
        super(secureRandom);
        this.f28797g = false;
        this.f28798h = false;
        this.f28800j = new int[3];
        if (i10 < 3) {
            throw new IllegalArgumentException("degree must be at least 3");
        }
        if (fVar.l() != i10 + 1) {
            throw new RuntimeException();
        }
        if (!fVar.o()) {
            throw new RuntimeException();
        }
        this.f28776b = i10;
        this.f28777c = fVar;
        i();
        int i11 = 2;
        for (int i12 = 1; i12 < this.f28777c.l() - 1; i12++) {
            if (this.f28777c.U(i12)) {
                i11++;
                if (i11 == 3) {
                    this.f28799i = i12;
                }
                if (i11 <= 5) {
                    this.f28800j[i11 - 3] = i12;
                }
            }
        }
        if (i11 == 3) {
            this.f28797g = true;
        }
        if (i11 == 5) {
            this.f28798h = true;
        }
        this.f28778d = new Vector();
        this.f28779e = new Vector();
    }

    public q(int i10, SecureRandom secureRandom, boolean z10) {
        super(secureRandom);
        this.f28797g = false;
        this.f28798h = false;
        this.f28800j = new int[3];
        if (i10 < 3) {
            throw new IllegalArgumentException("k must be at least 3");
        }
        this.f28776b = i10;
        if (z10) {
            b();
        } else {
            h();
        }
        i();
        this.f28778d = new Vector();
        this.f28779e = new Vector();
    }

    @Override // ft.l
    public void a(l lVar) {
        k kVarF;
        k[] kVarArr;
        int i10 = this.f28776b;
        if (i10 != lVar.f28776b) {
            throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
        }
        boolean z10 = lVar instanceof n;
        if (z10) {
            lVar.a(this);
            return;
        }
        f[] fVarArr = new f[i10];
        for (int i11 = 0; i11 < this.f28776b; i11++) {
            fVarArr[i11] = new f(this.f28776b);
        }
        do {
            kVarF = lVar.f(this.f28777c);
        } while (kVarF.e());
        if (kVarF instanceof m) {
            int i12 = this.f28776b;
            kVarArr = new m[i12];
            kVarArr[i12 - 1] = m.z((n) lVar);
        } else {
            int i13 = this.f28776b;
            kVarArr = new p[i13];
            kVarArr[i13 - 1] = p.z((q) lVar);
        }
        int i14 = this.f28776b;
        kVarArr[i14 - 2] = kVarF;
        for (int i15 = i14 - 3; i15 >= 0; i15--) {
            kVarArr[i15] = (k) kVarArr[i15 + 1].b(kVarF);
        }
        if (z10) {
            for (int i16 = 0; i16 < this.f28776b; i16++) {
                int i17 = 0;
                while (true) {
                    if (i17 < this.f28776b) {
                        if (kVarArr[i16].w((r4 - i17) - 1)) {
                            int i18 = this.f28776b;
                            fVarArr[(i18 - i17) - 1].I((i18 - i16) - 1);
                        }
                        i17++;
                    }
                }
            }
        } else {
            for (int i19 = 0; i19 < this.f28776b; i19++) {
                for (int i20 = 0; i20 < this.f28776b; i20++) {
                    if (kVarArr[i19].w(i20)) {
                        int i21 = this.f28776b;
                        fVarArr[(i21 - i20) - 1].I((i21 - i19) - 1);
                    }
                }
            }
        }
        this.f28778d.addElement(lVar);
        this.f28779e.addElement(fVarArr);
        lVar.f28778d.addElement(this);
        lVar.f28779e.addElement(g(fVarArr));
    }

    @Override // ft.l
    public void b() {
        if (q() || o()) {
            return;
        }
        p();
    }

    @Override // ft.l
    public k f(f fVar) {
        o oVarF;
        int iG;
        int iG2;
        o oVar = new o(fVar, this);
        while (oVar.g() > 1) {
            while (true) {
                p pVar = new p(this, this.f28775a);
                o oVar2 = new o(2, p.A(this));
                oVar2.o(1, pVar);
                o oVar3 = new o(oVar2);
                for (int i10 = 1; i10 <= this.f28776b - 1; i10++) {
                    oVar3 = oVar3.j(oVar3, oVar).a(oVar2);
                }
                oVarF = oVar3.f(oVar);
                iG = oVarF.g();
                iG2 = oVar.g();
                if (iG != 0 && iG != iG2) {
                    break;
                }
            }
            oVar = (iG << 1) > iG2 ? oVar.k(oVarF) : new o(oVarF);
        }
        return oVar.c(0);
    }

    public void h() {
        if (q() || o()) {
            return;
        }
        p();
    }

    public final void i() {
        int i10 = this.f28776b;
        f[] fVarArr = new f[i10 - 1];
        this.f28796f = new f[i10];
        int i11 = 0;
        while (true) {
            f[] fVarArr2 = this.f28796f;
            if (i11 >= fVarArr2.length) {
                break;
            }
            fVarArr2[i11] = new f(this.f28776b, "ZERO");
            i11++;
        }
        for (int i12 = 0; i12 < this.f28776b - 1; i12++) {
            fVarArr[i12] = new f(1, "ONE").L(this.f28776b + i12).G(this.f28777c);
        }
        for (int i13 = 1; i13 <= Math.abs(this.f28776b >> 1); i13++) {
            int i14 = 1;
            while (true) {
                int i15 = this.f28776b;
                if (i14 <= i15) {
                    if (fVarArr[i15 - (i13 << 1)].U(i15 - i14)) {
                        this.f28796f[i14 - 1].I(this.f28776b - i13);
                    }
                    i14++;
                }
            }
        }
        int iAbs = Math.abs(this.f28776b >> 1) + 1;
        while (true) {
            int i16 = this.f28776b;
            if (iAbs > i16) {
                return;
            }
            this.f28796f[((iAbs << 1) - i16) - 1].I(i16 - iAbs);
            iAbs++;
        }
    }

    public int[] j() throws RuntimeException {
        if (!this.f28798h) {
            throw new RuntimeException();
        }
        int[] iArr = new int[3];
        System.arraycopy(this.f28800j, 0, iArr, 0, 3);
        return iArr;
    }

    public f k(int i10) {
        return new f(this.f28796f[i10]);
    }

    public int l() throws RuntimeException {
        if (this.f28797g) {
            return this.f28799i;
        }
        throw new RuntimeException();
    }

    public boolean m() {
        return this.f28798h;
    }

    public boolean n() {
        return this.f28797g;
    }

    public final boolean o() {
        f fVar = new f(this.f28776b + 1);
        this.f28777c = fVar;
        fVar.I(0);
        this.f28777c.I(this.f28776b);
        int i10 = 1;
        boolean zO = false;
        while (i10 <= this.f28776b - 3 && !zO) {
            this.f28777c.I(i10);
            int i11 = i10 + 1;
            int i12 = i11;
            while (i12 <= this.f28776b - 2 && !zO) {
                this.f28777c.I(i12);
                int i13 = i12 + 1;
                for (int i14 = i13; i14 <= this.f28776b - 1 && !zO; i14++) {
                    this.f28777c.I(i14);
                    if (((((this.f28776b & 1) != 0) | ((i10 & 1) != 0) | ((i12 & 1) != 0)) || ((i14 & 1) != 0)) && (zO = this.f28777c.o())) {
                        this.f28798h = true;
                        int[] iArr = this.f28800j;
                        iArr[0] = i10;
                        iArr[1] = i12;
                        iArr[2] = i14;
                        return zO;
                    }
                    this.f28777c.H(i14);
                }
                this.f28777c.H(i12);
                i12 = i13;
            }
            this.f28777c.H(i10);
            i10 = i11;
        }
        return zO;
    }

    public final boolean p() {
        this.f28777c = new f(this.f28776b + 1);
        do {
            this.f28777c.B();
            this.f28777c.I(this.f28776b);
            this.f28777c.I(0);
        } while (!this.f28777c.o());
        return true;
    }

    public final boolean q() {
        f fVar = new f(this.f28776b + 1);
        this.f28777c = fVar;
        boolean zO = false;
        fVar.I(0);
        this.f28777c.I(this.f28776b);
        for (int i10 = 1; i10 < this.f28776b && !zO; i10++) {
            this.f28777c.I(i10);
            boolean zO2 = this.f28777c.o();
            if (zO2) {
                this.f28797g = true;
                this.f28799i = i10;
                return zO2;
            }
            this.f28777c.H(i10);
            zO = this.f28777c.o();
        }
        return zO;
    }
}
