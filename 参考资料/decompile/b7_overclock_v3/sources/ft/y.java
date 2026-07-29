package ft;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final char f28822d = 'I';

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f28823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f28825c;

    public y(h hVar) {
        this.f28823a = hVar;
        this.f28824b = -1;
        this.f28825c = new int[1];
    }

    public y(h hVar, int i10) {
        this.f28823a = hVar;
        this.f28824b = i10;
        int[] iArr = new int[i10 + 1];
        this.f28825c = iArr;
        iArr[i10] = 1;
    }

    public y(h hVar, int i10, char c10, SecureRandom secureRandom) {
        this.f28823a = hVar;
        if (c10 == 'I') {
            this.f28825c = g(i10, secureRandom);
            f();
        } else {
            throw new IllegalArgumentException(" Error: type " + c10 + " is not defined for GF2smallmPolynomial");
        }
    }

    public y(h hVar, byte[] bArr) {
        this.f28823a = hVar;
        int i10 = 8;
        int i11 = 1;
        while (hVar.d() > i10) {
            i11++;
            i10 += 8;
        }
        if (bArr.length % i11 != 0) {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
        this.f28825c = new int[bArr.length / i11];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f28825c;
            if (i12 >= iArr.length) {
                if (iArr.length != 1 && iArr[iArr.length - 1] == 0) {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
                f();
                return;
            }
            int i14 = 0;
            while (i14 < i10) {
                int[] iArr2 = this.f28825c;
                iArr2[i12] = ((bArr[i13] & 255) << i14) ^ iArr2[i12];
                i14 += 8;
                i13++;
            }
            if (!this.f28823a.k(this.f28825c[i12])) {
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            i12++;
        }
    }

    public y(h hVar, int[] iArr) {
        this.f28823a = hVar;
        this.f28825c = L(iArr);
        f();
    }

    public y(j jVar) {
        this(jVar.f(), jVar.g());
    }

    public y(y yVar) {
        this.f28823a = yVar.f28823a;
        this.f28824b = yVar.f28824b;
        this.f28825c = t.a(yVar.f28825c);
    }

    public static int[] I(int[] iArr, int i10) {
        int iE = e(iArr);
        if (iE == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[iE + i10 + 1];
        System.arraycopy(iArr, 0, iArr2, i10, iE + 1);
        return iArr2;
    }

    public static int[] L(int[] iArr) {
        int iE = e(iArr);
        if (iE == -1) {
            return new int[1];
        }
        int i10 = iE + 1;
        if (iArr.length == i10) {
            return t.a(iArr);
        }
        int[] iArr2 = new int[i10];
        System.arraycopy(iArr, 0, iArr2, 0, i10);
        return iArr2;
    }

    public static int e(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    public static int q(int[] iArr) {
        int iE = e(iArr);
        if (iE == -1) {
            return 0;
        }
        return iArr[iE];
    }

    public static boolean r(int[] iArr, int[] iArr2) {
        int iE = e(iArr);
        if (iE != e(iArr2)) {
            return false;
        }
        for (int i10 = 0; i10 <= iE; i10++) {
            if (iArr[i10] != iArr2[i10]) {
                return false;
            }
        }
        return true;
    }

    public y[] A(y yVar) {
        int i10 = yVar.f28824b >> 1;
        int[] iArrL = L(yVar.f28825c);
        int[] iArrU = u(this.f28825c, yVar.f28825c);
        int[] iArr = {0};
        int[] iArr2 = {1};
        while (e(iArrU) > i10) {
            int[][] iArrI = i(iArrL, iArrU);
            int[] iArr3 = iArrI[1];
            int[] iArrB = b(iArr, z(iArrI[0], iArr2, yVar.f28825c));
            iArr = iArr2;
            iArr2 = iArrB;
            iArrL = iArrU;
            iArrU = iArr3;
        }
        return new y[]{new y(this.f28823a, iArrU), new y(this.f28823a, iArr2)};
    }

    public y B(y[] yVarArr) {
        int length = yVarArr.length;
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        int i10 = 0;
        while (true) {
            int[] iArr3 = this.f28825c;
            if (i10 >= iArr3.length) {
                break;
            }
            iArr2[i10] = this.f28823a.l(iArr3[i10], iArr3[i10]);
            i10++;
        }
        for (int i11 = 0; i11 < length; i11++) {
            for (int i12 = 0; i12 < length; i12++) {
                if (i11 < yVarArr[i12].f28825c.length) {
                    iArr[i11] = this.f28823a.a(iArr[i11], this.f28823a.l(yVarArr[i12].f28825c[i11], iArr2[i12]));
                }
            }
        }
        return new y(this.f28823a, iArr);
    }

    public y C(y yVar) {
        int[] iArrA = t.a(this.f28825c);
        int[] iArrZ = z(iArrA, iArrA, yVar.f28825c);
        while (!r(iArrZ, this.f28825c)) {
            iArrA = L(iArrZ);
            iArrZ = z(iArrA, iArrA, yVar.f28825c);
        }
        return new y(this.f28823a, iArrA);
    }

    public y D(y[] yVarArr) {
        int length = yVarArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            for (int i11 = 0; i11 < length; i11++) {
                if (i10 < yVarArr[i11].f28825c.length) {
                    int[] iArr2 = this.f28825c;
                    if (i11 < iArr2.length) {
                        iArr[i10] = this.f28823a.a(iArr[i10], this.f28823a.l(yVarArr[i11].f28825c[i10], iArr2[i11]));
                    }
                }
            }
        }
        for (int i12 = 0; i12 < length; i12++) {
            iArr[i12] = this.f28823a.n(iArr[i12]);
        }
        return new y(this.f28823a, iArr);
    }

    public void E(int i10) {
        if (!this.f28823a.k(i10)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        this.f28825c = G(this.f28825c, i10);
        f();
    }

    public y F(int i10) {
        if (!this.f28823a.k(i10)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        return new y(this.f28823a, G(this.f28825c, i10));
    }

    public final int[] G(int[] iArr, int i10) {
        int iE = e(iArr);
        if (iE == -1 || i10 == 0) {
            return new int[1];
        }
        if (i10 == 1) {
            return t.a(iArr);
        }
        int[] iArr2 = new int[iE + 1];
        while (iE >= 0) {
            iArr2[iE] = this.f28823a.l(iArr[iE], i10);
            iE--;
        }
        return iArr2;
    }

    public y H(int i10) {
        return new y(this.f28823a, I(this.f28825c, i10));
    }

    public y J(y yVar) {
        return new y(this.f28823a, K(this.f28825c, yVar.f28825c));
    }

    public final int[] K(int[] iArr, int[] iArr2) {
        if (e(iArr) < e(iArr2)) {
            iArr2 = iArr;
            iArr = iArr2;
        }
        int[] iArrL = L(iArr);
        int[] iArrL2 = L(iArr2);
        if (iArrL2.length == 1) {
            return G(iArrL, iArrL2[0]);
        }
        int length = iArrL.length;
        int length2 = iArrL2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        if (length2 != length) {
            int[] iArr4 = new int[length2];
            int i10 = length - length2;
            int[] iArr5 = new int[i10];
            System.arraycopy(iArrL, 0, iArr4, 0, length2);
            System.arraycopy(iArrL, length2, iArr5, 0, i10);
            return b(K(iArr4, iArrL2), I(K(iArr5, iArrL2), length2));
        }
        int i11 = (length + 1) >>> 1;
        int i12 = length - i11;
        int[] iArr6 = new int[i11];
        int[] iArr7 = new int[i11];
        int[] iArr8 = new int[i12];
        int[] iArr9 = new int[i12];
        System.arraycopy(iArrL, 0, iArr6, 0, i11);
        System.arraycopy(iArrL, i11, iArr8, 0, i12);
        System.arraycopy(iArrL2, 0, iArr7, 0, i11);
        System.arraycopy(iArrL2, i11, iArr9, 0, i12);
        int[] iArrB = b(iArr6, iArr8);
        int[] iArrB2 = b(iArr7, iArr9);
        int[] iArrK = K(iArr6, iArr7);
        int[] iArrK2 = K(iArrB, iArrB2);
        int[] iArrK3 = K(iArr8, iArr9);
        return b(I(b(b(b(iArrK2, iArrK), iArrK3), I(iArrK3, i11)), i11), iArrK);
    }

    public y a(y yVar) {
        return new y(this.f28823a, b(this.f28825c, yVar.f28825c));
    }

    public final int[] b(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.f28823a.a(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    public y c(int i10) {
        int[] iArr = new int[i10 + 1];
        iArr[i10] = 1;
        return new y(this.f28823a, b(this.f28825c, iArr));
    }

    public void d(y yVar) {
        this.f28825c = b(this.f28825c, yVar.f28825c);
        f();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof y)) {
            y yVar = (y) obj;
            if (this.f28823a.equals(yVar.f28823a) && this.f28824b == yVar.f28824b && r(this.f28825c, yVar.f28825c)) {
                return true;
            }
        }
        return false;
    }

    public final void f() {
        int length = this.f28825c.length;
        do {
            this.f28824b = length - 1;
            length = this.f28824b;
            if (length < 0) {
                return;
            }
        } while (this.f28825c[length] == 0);
    }

    public final int[] g(int i10, SecureRandom secureRandom) {
        int[] iArr = new int[i10 + 1];
        iArr[i10] = 1;
        iArr[0] = this.f28823a.i(secureRandom);
        for (int i11 = 1; i11 < i10; i11++) {
            iArr[i11] = this.f28823a.g(secureRandom);
        }
        while (!s(iArr)) {
            int iA = b0.a(secureRandom, i10);
            if (iA == 0) {
                iArr[0] = this.f28823a.i(secureRandom);
            } else {
                iArr[iA] = this.f28823a.g(secureRandom);
            }
        }
        return iArr;
    }

    public y[] h(y yVar) {
        int[][] iArrI = i(this.f28825c, yVar.f28825c);
        return new y[]{new y(this.f28823a, iArrI[0]), new y(this.f28823a, iArrI[1])};
    }

    public int hashCode() {
        int iHashCode = this.f28823a.hashCode();
        int i10 = 0;
        while (true) {
            int[] iArr = this.f28825c;
            if (i10 >= iArr.length) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 31) + iArr[i10];
            i10++;
        }
    }

    public final int[][] i(int[] iArr, int[] iArr2) {
        int iE = e(iArr2);
        int iE2 = e(iArr) + 1;
        if (iE == -1) {
            throw new ArithmeticException("Division by zero.");
        }
        int[][] iArr3 = {new int[1], new int[iE2]};
        int iJ = this.f28823a.j(q(iArr2));
        iArr3[0][0] = 0;
        System.arraycopy(iArr, 0, iArr3[1], 0, iArr3[1].length);
        while (iE <= e(iArr3[1])) {
            int[] iArr4 = {this.f28823a.l(q(iArr3[1]), iJ)};
            int[] iArrG = G(iArr2, iArr4[0]);
            int iE3 = e(iArr3[1]) - iE;
            int[] iArrI = I(iArrG, iE3);
            iArr3[0] = b(I(iArr4, iE3), iArr3[0]);
            iArr3[1] = b(iArrI, iArr3[1]);
        }
        return iArr3;
    }

    public int j(int i10) {
        int[] iArr = this.f28825c;
        int i11 = this.f28824b;
        int iL = iArr[i11];
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            iL = this.f28823a.l(iL, i10) ^ this.f28825c[i12];
        }
        return iL;
    }

    public y k(y yVar) {
        return new y(this.f28823a, l(this.f28825c, yVar.f28825c));
    }

    public final int[] l(int[] iArr, int[] iArr2) {
        if (e(iArr) == -1) {
            return iArr2;
        }
        while (e(iArr2) != -1) {
            int[] iArrU = u(iArr, iArr2);
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            int length2 = iArrU.length;
            int[] iArr4 = new int[length2];
            System.arraycopy(iArrU, 0, iArr4, 0, length2);
            iArr2 = iArr4;
            iArr = iArr3;
        }
        return G(iArr, this.f28823a.j(q(iArr)));
    }

    public int m(int i10) {
        if (i10 < 0 || i10 > this.f28824b) {
            return 0;
        }
        return this.f28825c[i10];
    }

    public int n() {
        int[] iArr = this.f28825c;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    public byte[] o() {
        int i10 = 8;
        int i11 = 1;
        while (this.f28823a.d() > i10) {
            i11++;
            i10 += 8;
        }
        byte[] bArr = new byte[this.f28825c.length * i11];
        int i12 = 0;
        for (int i13 = 0; i13 < this.f28825c.length; i13++) {
            int i14 = 0;
            while (i14 < i10) {
                bArr[i12] = (byte) (this.f28825c[i13] >>> i14);
                i14 += 8;
                i12++;
            }
        }
        return bArr;
    }

    public int p() {
        int i10 = this.f28824b;
        if (i10 == -1) {
            return 0;
        }
        return this.f28825c[i10];
    }

    public final boolean s(int[] iArr) {
        if (iArr[0] == 0) {
            return false;
        }
        int iE = e(iArr) >> 1;
        int[] iArrL = {0, 1};
        int[] iArr2 = {0, 1};
        int iD = this.f28823a.d();
        for (int i10 = 0; i10 < iE; i10++) {
            for (int i11 = iD - 1; i11 >= 0; i11--) {
                iArrL = z(iArrL, iArrL, iArr);
            }
            iArrL = L(iArrL);
            if (e(l(b(iArrL, iArr2), iArr)) != 0) {
                return false;
            }
        }
        return true;
    }

    public y t(y yVar) {
        return new y(this.f28823a, u(this.f28825c, yVar.f28825c));
    }

    public String toString() {
        String str = " Polynomial over " + this.f28823a.toString() + ": \n";
        for (int i10 = 0; i10 < this.f28825c.length; i10++) {
            str = str + this.f28823a.b(this.f28825c[i10]) + "Y^" + i10 + com.google.android.material.badge.a.f19590u;
        }
        return str + ";";
    }

    public final int[] u(int[] iArr, int[] iArr2) {
        int iE = e(iArr2);
        if (iE == -1) {
            throw new ArithmeticException("Division by zero");
        }
        int length = iArr.length;
        int[] iArrB = new int[length];
        int iJ = this.f28823a.j(q(iArr2));
        System.arraycopy(iArr, 0, iArrB, 0, length);
        while (iE <= e(iArrB)) {
            iArrB = b(G(I(iArr2, e(iArrB) - iE), this.f28823a.l(q(iArrB), iJ)), iArrB);
        }
        return iArrB;
    }

    public y v(y yVar, y yVar2) {
        return new y(this.f28823a, w(this.f28825c, yVar.f28825c, yVar2.f28825c));
    }

    public final int[] w(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrL = L(iArr3);
        int[] iArrU = u(iArr2, iArr3);
        int[] iArrL2 = {0};
        int[] iArrU2 = u(iArr, iArr3);
        while (e(iArrU) != -1) {
            int[][] iArrI = i(iArrL, iArrU);
            int[] iArrL3 = L(iArrU);
            int[] iArrL4 = L(iArrI[1]);
            int[] iArrB = b(iArrL2, z(iArrI[0], iArrU2, iArr3));
            iArrL2 = L(iArrU2);
            iArrU2 = L(iArrB);
            iArrL = iArrL3;
            iArrU = iArrL4;
        }
        return G(iArrL2, this.f28823a.j(q(iArrL)));
    }

    public y x(y yVar) {
        return new y(this.f28823a, w(new int[]{1}, this.f28825c, yVar.f28825c));
    }

    public y y(y yVar, y yVar2) {
        return new y(this.f28823a, z(this.f28825c, yVar.f28825c, yVar2.f28825c));
    }

    public final int[] z(int[] iArr, int[] iArr2, int[] iArr3) {
        return u(K(iArr, iArr2), iArr3);
    }
}
