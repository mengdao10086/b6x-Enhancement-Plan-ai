package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f21281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final af.b f21282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f21283c;

    public a(af.b bVar) throws FormatException {
        int i10 = bVar.i();
        if (i10 < 8 || i10 > 144 || (i10 & 1) != 0) {
            throw FormatException.b();
        }
        this.f21283c = j(bVar);
        af.b bVarA = a(bVar);
        this.f21281a = bVarA;
        this.f21282b = new af.b(bVarA.m(), bVarA.i());
    }

    public static d j(af.b bVar) throws FormatException {
        return d.h(bVar.i(), bVar.m());
    }

    public final af.b a(af.b bVar) {
        int iF = this.f21283c.f();
        int iE = this.f21283c.e();
        if (bVar.i() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.f21283c.c();
        int iB = this.f21283c.b();
        int i10 = iF / iC;
        int i11 = iE / iB;
        af.b bVar2 = new af.b(i11 * iB, i10 * iC);
        for (int i12 = 0; i12 < i10; i12++) {
            int i13 = i12 * iC;
            for (int i14 = 0; i14 < i11; i14++) {
                int i15 = i14 * iB;
                for (int i16 = 0; i16 < iC; i16++) {
                    int i17 = ((iC + 2) * i12) + 1 + i16;
                    int i18 = i13 + i16;
                    for (int i19 = 0; i19 < iB; i19++) {
                        if (bVar.f(((iB + 2) * i14) + 1 + i19, i17)) {
                            bVar2.s(i15 + i19, i18);
                        }
                    }
                }
            }
        }
        return bVar2;
    }

    public d b() {
        return this.f21283c;
    }

    public byte[] c() throws FormatException {
        byte[] bArr = new byte[this.f21283c.g()];
        int i10 = this.f21281a.i();
        int iM = this.f21281a.m();
        int i11 = 0;
        boolean z10 = false;
        int i12 = 0;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i13 = 4;
        while (true) {
            if (i13 == i10 && i11 == 0 && !z10) {
                bArr[i12] = (byte) d(i10, iM);
                i13 -= 2;
                i11 += 2;
                i12++;
                z10 = true;
            } else {
                int i14 = i10 - 2;
                if (i13 == i14 && i11 == 0 && (iM & 3) != 0 && !z11) {
                    bArr[i12] = (byte) e(i10, iM);
                    i13 -= 2;
                    i11 += 2;
                    i12++;
                    z11 = true;
                } else if (i13 == i10 + 4 && i11 == 2 && (iM & 7) == 0 && !z12) {
                    bArr[i12] = (byte) f(i10, iM);
                    i13 -= 2;
                    i11 += 2;
                    i12++;
                    z12 = true;
                } else if (i13 == i14 && i11 == 0 && (iM & 7) == 4 && !z13) {
                    bArr[i12] = (byte) g(i10, iM);
                    i13 -= 2;
                    i11 += 2;
                    i12++;
                    z13 = true;
                } else {
                    do {
                        if (i13 < i10 && i11 >= 0 && !this.f21282b.f(i11, i13)) {
                            bArr[i12] = (byte) i(i13, i11, i10, iM);
                            i12++;
                        }
                        i13 -= 2;
                        i11 += 2;
                        if (i13 < 0) {
                            break;
                        }
                    } while (i11 < iM);
                    int i15 = i13 + 1;
                    int i16 = i11 + 3;
                    do {
                        if (i15 >= 0 && i16 < iM && !this.f21282b.f(i16, i15)) {
                            bArr[i12] = (byte) i(i15, i16, i10, iM);
                            i12++;
                        }
                        i15 += 2;
                        i16 -= 2;
                        if (i15 >= i10) {
                            break;
                        }
                    } while (i16 >= 0);
                    i13 = i15 + 3;
                    i11 = i16 + 1;
                }
            }
            if (i13 >= i10 && i11 >= iM) {
                break;
            }
        }
        if (i12 == this.f21283c.g()) {
            return bArr;
        }
        throw FormatException.b();
    }

    public final int d(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (h(i12, 0, i10, i11) ? 1 : 0) << 1;
        if (h(i12, 1, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i12, 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        int i17 = i11 - 1;
        if (h(0, i17, i10, i11)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        if (h(1, i17, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        if (h(2, i17, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        return h(3, i17, i10, i11) ? i20 | 1 : i20;
    }

    public final int e(int i10, int i11) {
        int i12 = (h(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (h(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(0, i11 - 4, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        if (h(0, i11 - 3, i10, i11)) {
            i15 |= 1;
        }
        int i16 = i15 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i16 |= 1;
        }
        int i17 = i16 << 1;
        int i18 = i11 - 1;
        if (h(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        return h(1, i18, i10, i11) ? i19 | 1 : i19;
    }

    public final int f(int i10, int i11) {
        int i12 = i10 - 1;
        int i13 = (h(i12, 0, i10, i11) ? 1 : 0) << 1;
        int i14 = i11 - 1;
        if (h(i12, i14, i10, i11)) {
            i13 |= 1;
        }
        int i15 = i13 << 1;
        int i16 = i11 - 3;
        if (h(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        int i18 = i11 - 2;
        if (h(0, i18, i10, i11)) {
            i17 |= 1;
        }
        int i19 = i17 << 1;
        if (h(0, i14, i10, i11)) {
            i19 |= 1;
        }
        int i20 = i19 << 1;
        if (h(1, i16, i10, i11)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (h(1, i18, i10, i11)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        return h(1, i14, i10, i11) ? i22 | 1 : i22;
    }

    public final int g(int i10, int i11) {
        int i12 = (h(i10 + (-3), 0, i10, i11) ? 1 : 0) << 1;
        if (h(i10 - 2, 0, i10, i11)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i10 - 1, 0, i10, i11)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(0, i11 - 2, i10, i11)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        int i16 = i11 - 1;
        if (h(0, i16, i10, i11)) {
            i15 |= 1;
        }
        int i17 = i15 << 1;
        if (h(1, i16, i10, i11)) {
            i17 |= 1;
        }
        int i18 = i17 << 1;
        if (h(2, i16, i10, i11)) {
            i18 |= 1;
        }
        int i19 = i18 << 1;
        return h(3, i16, i10, i11) ? i19 | 1 : i19;
    }

    public final boolean h(int i10, int i11, int i12, int i13) {
        if (i10 < 0) {
            i10 += i12;
            i11 += 4 - ((i12 + 4) & 7);
        }
        if (i11 < 0) {
            i11 += i13;
            i10 += 4 - ((i13 + 4) & 7);
        }
        if (i10 >= i12) {
            i10 -= i12;
        }
        this.f21282b.s(i11, i10);
        return this.f21281a.f(i11, i10);
    }

    public final int i(int i10, int i11, int i12, int i13) {
        int i14 = i10 - 2;
        int i15 = i11 - 2;
        int i16 = (h(i14, i15, i12, i13) ? 1 : 0) << 1;
        int i17 = i11 - 1;
        if (h(i14, i17, i12, i13)) {
            i16 |= 1;
        }
        int i18 = i16 << 1;
        int i19 = i10 - 1;
        if (h(i19, i15, i12, i13)) {
            i18 |= 1;
        }
        int i20 = i18 << 1;
        if (h(i19, i17, i12, i13)) {
            i20 |= 1;
        }
        int i21 = i20 << 1;
        if (h(i19, i11, i12, i13)) {
            i21 |= 1;
        }
        int i22 = i21 << 1;
        if (h(i10, i15, i12, i13)) {
            i22 |= 1;
        }
        int i23 = i22 << 1;
        if (h(i10, i17, i12, i13)) {
            i23 |= 1;
        }
        int i24 = i23 << 1;
        return h(i10, i11, i12, i13) ? i24 | 1 : i24;
    }
}
