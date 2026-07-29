package ft;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

/* JADX INFO: loaded from: classes6.dex */
public class n extends l {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f28787j = 64;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f28788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f28789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f28790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[][] f28791i;

    public n(int i10, SecureRandom secureRandom) throws RuntimeException {
        super(secureRandom);
        if (i10 < 3) {
            throw new IllegalArgumentException("k must be at least 3");
        }
        this.f28776b = i10;
        int i11 = i10 / 64;
        this.f28788f = i11;
        int i12 = i10 & 63;
        this.f28789g = i12;
        if (i12 == 0) {
            this.f28789g = 64;
        } else {
            this.f28788f = i11 + 1;
        }
        i();
        if (this.f28790h >= 3) {
            throw new RuntimeException("\nThe type of this field is " + this.f28790h);
        }
        this.f28791i = (int[][]) Array.newInstance((Class<?>) int.class, this.f28776b, 2);
        for (int i13 = 0; i13 < this.f28776b; i13++) {
            int[][] iArr = this.f28791i;
            iArr[i13][0] = -1;
            iArr[i13][1] = -1;
        }
        h();
        b();
        this.f28778d = new Vector();
        this.f28779e = new Vector();
    }

    @Override // ft.l
    public void a(l lVar) {
        k kVarF;
        int i10 = this.f28776b;
        if (i10 != lVar.f28776b) {
            throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
        }
        f[] fVarArr = new f[i10];
        for (int i11 = 0; i11 < this.f28776b; i11++) {
            fVarArr[i11] = new f(this.f28776b);
        }
        do {
            kVarF = lVar.f(this.f28777c);
        } while (kVarF.e());
        k[] kVarArr = new p[this.f28776b];
        kVarArr[0] = (k) kVarF.clone();
        for (int i12 = 1; i12 < this.f28776b; i12++) {
            kVarArr[i12] = kVarArr[i12 - 1].s();
        }
        for (int i13 = 0; i13 < this.f28776b; i13++) {
            for (int i14 = 0; i14 < this.f28776b; i14++) {
                if (kVarArr[i13].w(i14)) {
                    int i15 = this.f28776b;
                    fVarArr[(i15 - i14) - 1].I((i15 - i13) - 1);
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
        f fVar;
        int i10 = this.f28790h;
        if (i10 == 1) {
            fVar = new f(this.f28776b + 1, "ALL");
        } else {
            if (i10 != 2) {
                return;
            }
            f fVar2 = new f(this.f28776b + 1, "ONE");
            f fVar3 = new f(this.f28776b + 1, "X");
            fVar3.b(fVar2);
            f fVar4 = fVar2;
            fVar = fVar3;
            int i11 = 1;
            while (i11 < this.f28776b) {
                f fVarK = fVar.K();
                fVarK.b(fVar4);
                i11++;
                fVar4 = fVar;
                fVar = fVarK;
            }
        }
        this.f28777c = fVar;
    }

    @Override // ft.l
    public k f(f fVar) {
        o oVarF;
        int iG;
        int iG2;
        o oVar = new o(fVar, this);
        while (oVar.g() > 1) {
            while (true) {
                m mVar = new m(this, this.f28775a);
                o oVar2 = new o(2, m.A(this));
                oVar2.o(1, mVar);
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

    public final void h() {
        int i10;
        int i11 = this.f28790h;
        if ((i11 & 7) == 0) {
            throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
        }
        int i12 = (this.f28776b * i11) + 1;
        int[] iArr = new int[i12];
        int iJ = i11 == 1 ? 1 : i11 == 2 ? i12 - 1 : j(i11, i12);
        int i13 = 0;
        int i14 = 1;
        while (true) {
            i10 = this.f28790h;
            if (i13 >= i10) {
                break;
            }
            int i15 = i14;
            for (int i16 = 0; i16 < this.f28776b; i16++) {
                iArr[i15] = i16;
                i15 = (i15 << 1) % i12;
                if (i15 < 0) {
                    i15 += i12;
                }
            }
            i14 = (i14 * iJ) % i12;
            if (i14 < 0) {
                i14 += i12;
            }
            i13++;
        }
        if (i10 != 1) {
            if (i10 != 2) {
                throw new RuntimeException("only type 1 or type 2 implemented");
            }
            int i17 = 1;
            while (i17 < i12 - 1) {
                int[][] iArr2 = this.f28791i;
                int i18 = i17 + 1;
                if (iArr2[iArr[i18]][0] == -1) {
                    iArr2[iArr[i18]][0] = iArr[i12 - i17];
                } else {
                    iArr2[iArr[i18]][1] = iArr[i12 - i17];
                }
                i17 = i18;
            }
            return;
        }
        int i19 = 1;
        while (i19 < i12 - 1) {
            int[][] iArr3 = this.f28791i;
            int i20 = i19 + 1;
            if (iArr3[iArr[i20]][0] == -1) {
                iArr3[iArr[i20]][0] = iArr[i12 - i19];
            } else {
                iArr3[iArr[i20]][1] = iArr[i12 - i19];
            }
            i19 = i20;
        }
        int i21 = this.f28776b >> 1;
        for (int i22 = 1; i22 <= i21; i22++) {
            int[][] iArr4 = this.f28791i;
            int i23 = i22 - 1;
            if (iArr4[i23][0] == -1) {
                iArr4[i23][0] = (i21 + i22) - 1;
            } else {
                iArr4[i23][1] = (i21 + i22) - 1;
            }
            int i24 = (i21 + i22) - 1;
            if (iArr4[i24][0] == -1) {
                iArr4[i24][0] = i23;
            } else {
                iArr4[i24][1] = i23;
            }
        }
    }

    public final void i() throws RuntimeException {
        if ((this.f28776b & 7) == 0) {
            throw new RuntimeException("The extension degree is divisible by 8!");
        }
        this.f28790h = 1;
        int iN = 0;
        while (iN != 1) {
            int i10 = (this.f28790h * this.f28776b) + 1;
            if (u.s(i10)) {
                int iK = u.K(2, i10);
                int i11 = this.f28790h;
                int i12 = this.f28776b;
                iN = u.n((i11 * i12) / iK, i12);
            }
            this.f28790h++;
        }
        int i13 = this.f28790h - 1;
        this.f28790h = i13;
        if (i13 == 1) {
            int i14 = (this.f28776b << 1) + 1;
            if (u.s(i14)) {
                int iK2 = u.K(2, i14);
                int i15 = this.f28776b;
                if (u.n((i15 << 1) / iK2, i15) == 1) {
                    this.f28790h++;
                }
            }
        }
    }

    public final int j(int i10, int i11) {
        int iK;
        Random random = new Random();
        int iNextInt = 0;
        while (iNextInt == 0) {
            int i12 = i11 - 1;
            iNextInt = random.nextInt() % i12;
            if (iNextInt < 0) {
                iNextInt += i12;
            }
        }
        while (true) {
            iK = u.K(iNextInt, i11);
            if (iK % i10 == 0 && iK != 0) {
                break;
            }
            while (iNextInt == 0) {
                int i13 = i11 - 1;
                iNextInt = random.nextInt() % i13;
                if (iNextInt < 0) {
                    iNextInt += i13;
                }
            }
        }
        int i14 = iNextInt;
        for (int i15 = 2; i15 <= i10 / iK; i15++) {
            i14 *= iNextInt;
        }
        return i14;
    }

    public int k() {
        return this.f28789g;
    }

    public int l() {
        return this.f28788f;
    }

    public int[][] m(int[][] iArr) {
        int i10 = this.f28776b;
        int i11 = this.f28776b;
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, i11, i11);
        for (int i12 = 0; i12 < this.f28776b; i12++) {
            iArr2[i12][i12] = 1;
        }
        for (int i13 = 0; i13 < this.f28776b; i13++) {
            int i14 = i13;
            while (true) {
                int i15 = this.f28776b;
                if (i14 < i15) {
                    iArr[(i15 - 1) - i13][i14] = iArr[i13][i13];
                    i14++;
                }
            }
        }
        return null;
    }
}
