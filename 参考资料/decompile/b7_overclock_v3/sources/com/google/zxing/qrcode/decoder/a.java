package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final af.b f21592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f21593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f21594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f21595d;

    public a(af.b bVar) throws FormatException {
        int i10 = bVar.i();
        if (i10 < 21 || (i10 & 3) != 1) {
            throw FormatException.b();
        }
        this.f21592a = bVar;
    }

    public final int a(int i10, int i11, int i12) {
        return this.f21595d ? this.f21592a.f(i11, i10) : this.f21592a.f(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    public void b() {
        int i10 = 0;
        while (i10 < this.f21592a.m()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f21592a.i(); i12++) {
                if (this.f21592a.f(i10, i12) != this.f21592a.f(i12, i10)) {
                    this.f21592a.e(i12, i10);
                    this.f21592a.e(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    public byte[] c() throws FormatException {
        e eVarD = d();
        g gVarE = e();
        DataMask dataMask = DataMask.values()[eVarD.c()];
        int i10 = this.f21592a.i();
        dataMask.unmaskBitMatrix(this.f21592a, i10);
        af.b bVarA = gVarE.a();
        byte[] bArr = new byte[gVarE.h()];
        int i11 = i10 - 1;
        boolean z10 = true;
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i12 > 0) {
            if (i12 == 6) {
                i12--;
            }
            for (int i16 = 0; i16 < i10; i16++) {
                int i17 = z10 ? i11 - i16 : i16;
                for (int i18 = 0; i18 < 2; i18++) {
                    int i19 = i12 - i18;
                    if (!bVarA.f(i19, i17)) {
                        i14++;
                        i15 <<= 1;
                        if (this.f21592a.f(i19, i17)) {
                            i15 |= 1;
                        }
                        if (i14 == 8) {
                            bArr[i13] = (byte) i15;
                            i13++;
                            i14 = 0;
                            i15 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i12 -= 2;
        }
        if (i13 == gVarE.h()) {
            return bArr;
        }
        throw FormatException.b();
    }

    public e d() throws FormatException {
        e eVar = this.f21594c;
        if (eVar != null) {
            return eVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i10 = 0; i10 < 6; i10++) {
            iA2 = a(i10, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i11 = 5; i11 >= 0; i11--) {
            iA3 = a(8, i11, iA3);
        }
        int i12 = this.f21592a.i();
        int i13 = i12 - 7;
        for (int i14 = i12 - 1; i14 >= i13; i14--) {
            iA = a(8, i14, iA);
        }
        for (int i15 = i12 - 8; i15 < i12; i15++) {
            iA = a(i15, 8, iA);
        }
        e eVarA = e.a(iA3, iA);
        this.f21594c = eVarA;
        if (eVarA != null) {
            return eVarA;
        }
        throw FormatException.b();
    }

    public g e() throws FormatException {
        g gVar = this.f21593b;
        if (gVar != null) {
            return gVar;
        }
        int i10 = this.f21592a.i();
        int i11 = (i10 - 17) / 4;
        if (i11 <= 6) {
            return g.i(i11);
        }
        int i12 = i10 - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i13 = 5; i13 >= 0; i13--) {
            for (int i14 = i10 - 9; i14 >= i12; i14--) {
                iA2 = a(i14, i13, iA2);
            }
        }
        g gVarC = g.c(iA2);
        if (gVarC != null && gVarC.e() == i10) {
            this.f21593b = gVarC;
            return gVarC;
        }
        for (int i15 = 5; i15 >= 0; i15--) {
            for (int i16 = i10 - 9; i16 >= i12; i16--) {
                iA = a(i15, i16, iA);
            }
        }
        g gVarC2 = g.c(iA);
        if (gVarC2 == null || gVarC2.e() != i10) {
            throw FormatException.b();
        }
        this.f21593b = gVarC2;
        return gVarC2;
    }

    public void f() {
        if (this.f21594c == null) {
            return;
        }
        DataMask.values()[this.f21594c.c()].unmaskBitMatrix(this.f21592a, this.f21592a.i());
    }

    public void g(boolean z10) {
        this.f21593b = null;
        this.f21594c = null;
        this.f21595d = z10;
    }
}
