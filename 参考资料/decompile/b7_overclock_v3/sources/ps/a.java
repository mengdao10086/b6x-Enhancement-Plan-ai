package ps;

import java.lang.reflect.Array;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f47014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f47015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f47016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[][][] f47017d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public short[][][] f47018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public short[][] f47019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short[] f47020g;

    public a(byte b10, byte b11, short[][][] sArr, short[][][] sArr2, short[][] sArr3, short[] sArr4) {
        int i10 = b10 & 255;
        this.f47014a = i10;
        int i11 = b11 & 255;
        this.f47015b = i11;
        this.f47016c = i11 - i10;
        this.f47017d = sArr;
        this.f47018e = sArr2;
        this.f47019f = sArr3;
        this.f47020g = sArr4;
    }

    public a(int i10, int i11, SecureRandom secureRandom) {
        this.f47014a = i10;
        this.f47015b = i11;
        int i12 = i11 - i10;
        this.f47016c = i12;
        this.f47017d = (short[][][]) Array.newInstance((Class<?>) short.class, i12, i12, i10);
        int i13 = this.f47016c;
        int i14 = this.f47014a;
        this.f47018e = (short[][][]) Array.newInstance((Class<?>) short.class, i13, i14, i14);
        this.f47019f = (short[][]) Array.newInstance((Class<?>) short.class, this.f47016c, this.f47015b);
        int i15 = this.f47016c;
        this.f47020g = new short[i15];
        for (int i16 = 0; i16 < i15; i16++) {
            for (int i17 = 0; i17 < this.f47016c; i17++) {
                for (int i18 = 0; i18 < this.f47014a; i18++) {
                    this.f47017d[i16][i17][i18] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i19 = 0; i19 < i15; i19++) {
            for (int i20 = 0; i20 < this.f47014a; i20++) {
                for (int i21 = 0; i21 < this.f47014a; i21++) {
                    this.f47018e[i19][i20][i21] = (short) (secureRandom.nextInt() & 255);
                }
            }
        }
        for (int i22 = 0; i22 < i15; i22++) {
            for (int i23 = 0; i23 < this.f47015b; i23++) {
                this.f47019f[i22][i23] = (short) (secureRandom.nextInt() & 255);
            }
        }
        for (int i24 = 0; i24 < i15; i24++) {
            this.f47020g[i24] = (short) (secureRandom.nextInt() & 255);
        }
    }

    public short[][][] a() {
        return this.f47017d;
    }

    public short[][][] b() {
        return this.f47018e;
    }

    public short[] c() {
        return this.f47020g;
    }

    public short[][] d() {
        return this.f47019f;
    }

    public int e() {
        return this.f47016c;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f47014a == aVar.f() && this.f47015b == aVar.g() && this.f47016c == aVar.e() && qs.c.k(this.f47017d, aVar.a()) && qs.c.k(this.f47018e, aVar.b()) && qs.c.j(this.f47019f, aVar.d()) && qs.c.i(this.f47020g, aVar.c());
    }

    public int f() {
        return this.f47014a;
    }

    public int g() {
        return this.f47015b;
    }

    public short[][] h(short[] sArr) {
        int i10 = this.f47016c;
        int i11 = 0;
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) short.class, i10, i10 + 1);
        short[] sArr3 = new short[this.f47016c];
        for (int i12 = 0; i12 < this.f47016c; i12++) {
            for (int i13 = 0; i13 < this.f47014a; i13++) {
                for (int i14 = 0; i14 < this.f47014a; i14++) {
                    sArr3[i12] = qs.b.a(sArr3[i12], qs.b.e(qs.b.e(this.f47018e[i12][i13][i14], sArr[i13]), sArr[i14]));
                }
            }
        }
        for (int i15 = 0; i15 < this.f47016c; i15++) {
            for (int i16 = 0; i16 < this.f47016c; i16++) {
                for (int i17 = 0; i17 < this.f47014a; i17++) {
                    sArr2[i15][i16] = qs.b.a(sArr2[i15][i16], qs.b.e(this.f47017d[i15][i16][i17], sArr[i17]));
                }
            }
        }
        for (int i18 = 0; i18 < this.f47016c; i18++) {
            for (int i19 = 0; i19 < this.f47014a; i19++) {
                sArr3[i18] = qs.b.a(sArr3[i18], qs.b.e(this.f47019f[i18][i19], sArr[i19]));
            }
        }
        for (int i20 = 0; i20 < this.f47016c; i20++) {
            for (int i21 = this.f47014a; i21 < this.f47015b; i21++) {
                short[] sArr4 = sArr2[i20];
                int i22 = this.f47014a;
                sArr4[i21 - i22] = qs.b.a(this.f47019f[i20][i21], sArr2[i20][i21 - i22]);
            }
        }
        for (int i23 = 0; i23 < this.f47016c; i23++) {
            sArr3[i23] = qs.b.a(sArr3[i23], this.f47020g[i23]);
        }
        while (true) {
            int i24 = this.f47016c;
            if (i11 >= i24) {
                return sArr2;
            }
            sArr2[i11][i24] = sArr3[i11];
            i11++;
        }
    }

    public int hashCode() {
        return (((((((((((this.f47014a * 37) + this.f47015b) * 37) + this.f47016c) * 37) + org.bouncycastle.util.a.D0(this.f47017d)) * 37) + org.bouncycastle.util.a.D0(this.f47018e)) * 37) + org.bouncycastle.util.a.C0(this.f47019f)) * 37) + org.bouncycastle.util.a.A0(this.f47020g);
    }
}
