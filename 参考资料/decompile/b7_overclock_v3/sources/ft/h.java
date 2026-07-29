package ft;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28768b;

    public h(int i10) {
        this.f28767a = 0;
        if (i10 >= 32) {
            throw new IllegalArgumentException(" Error: the degree of field is too large ");
        }
        if (i10 < 1) {
            throw new IllegalArgumentException(" Error: the degree of field is non-positive ");
        }
        this.f28767a = i10;
        this.f28768b = z.e(i10);
    }

    public h(int i10, int i11) {
        this.f28767a = 0;
        if (i10 != z.b(i11)) {
            throw new IllegalArgumentException(" Error: the degree is not correct");
        }
        if (!z.f(i11)) {
            throw new IllegalArgumentException(" Error: given polynomial is reducible");
        }
        this.f28767a = i10;
        this.f28768b = i11;
    }

    public h(h hVar) {
        this.f28767a = 0;
        this.f28767a = hVar.f28767a;
        this.f28768b = hVar.f28768b;
    }

    public h(byte[] bArr) {
        this.f28767a = 0;
        if (bArr.length != 4) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        int iF = v.f(bArr);
        this.f28768b = iF;
        if (!z.f(iF)) {
            throw new IllegalArgumentException("byte array is not an encoded finite field");
        }
        this.f28767a = z.b(this.f28768b);
    }

    public static String m(int i10) {
        if (i10 == 0) {
            return "0";
        }
        String str = ((byte) (i10 & 1)) == 1 ? "1" : "";
        int i11 = i10 >>> 1;
        int i12 = 1;
        while (i11 != 0) {
            if (((byte) (i11 & 1)) == 1) {
                str = str + "+x^" + i12;
            }
            i11 >>>= 1;
            i12++;
        }
        return str;
    }

    public int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public String b(int i10) {
        StringBuilder sb2;
        String str;
        String string = "";
        for (int i11 = 0; i11 < this.f28767a; i11++) {
            if ((((byte) i10) & 1) == 0) {
                sb2 = new StringBuilder();
                str = "0";
            } else {
                sb2 = new StringBuilder();
                str = "1";
            }
            sb2.append(str);
            sb2.append(string);
            string = sb2.toString();
            i10 >>>= 1;
        }
        return string;
    }

    public int c(int i10, int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        if (i10 == 1) {
            return 1;
        }
        if (i11 < 0) {
            i10 = j(i10);
            i11 = -i11;
        }
        int iL = 1;
        while (i11 != 0) {
            if ((i11 & 1) == 1) {
                iL = l(iL, i10);
            }
            i10 = l(i10, i10);
            i11 >>>= 1;
        }
        return iL;
    }

    public int d() {
        return this.f28767a;
    }

    public byte[] e() {
        return v.d(this.f28768b);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof h)) {
            h hVar = (h) obj;
            if (this.f28767a == hVar.f28767a && this.f28768b == hVar.f28768b) {
                return true;
            }
        }
        return false;
    }

    public int f() {
        return this.f28768b;
    }

    public int g(SecureRandom secureRandom) {
        return b0.a(secureRandom, 1 << this.f28767a);
    }

    public int h() {
        return i(org.bouncycastle.crypto.n.f());
    }

    public int hashCode() {
        return this.f28768b;
    }

    public int i(SecureRandom secureRandom) {
        int iA = b0.a(secureRandom, 1 << this.f28767a);
        int i10 = 0;
        while (iA == 0 && i10 < 1048576) {
            iA = b0.a(secureRandom, 1 << this.f28767a);
            i10++;
        }
        if (i10 == 1048576) {
            return 1;
        }
        return iA;
    }

    public int j(int i10) {
        return c(i10, (1 << this.f28767a) - 2);
    }

    public boolean k(int i10) {
        int i11 = this.f28767a;
        return i11 == 31 ? i10 >= 0 : i10 >= 0 && i10 < (1 << i11);
    }

    public int l(int i10, int i11) {
        return z.g(i10, i11, this.f28768b);
    }

    public int n(int i10) {
        for (int i11 = 1; i11 < this.f28767a; i11++) {
            i10 = l(i10, i10);
        }
        return i10;
    }

    public String toString() {
        return "Finite Field GF(2^" + this.f28767a + ") = GF(2)[X]/<" + m(this.f28768b) + "> ";
    }
}
