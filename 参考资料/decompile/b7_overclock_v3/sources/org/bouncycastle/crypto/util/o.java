package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f44757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44758b = 0;

    public o(byte[] bArr) {
        this.f44757a = bArr;
    }

    public o(byte[] bArr, byte[] bArr2) {
        this.f44757a = bArr2;
        for (int i10 = 0; i10 != bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.f44758b += bArr.length;
    }

    public byte[] a() {
        return org.bouncycastle.util.a.p(this.f44757a);
    }

    public boolean b() {
        return this.f44758b < this.f44757a.length;
    }

    public BigInteger c() {
        int iH = h();
        int i10 = this.f44758b;
        int i11 = i10 + iH;
        byte[] bArr = this.f44757a;
        if (i11 > bArr.length) {
            throw new IllegalArgumentException("not enough data for big num");
        }
        int i12 = iH + i10;
        this.f44758b = i12;
        return new BigInteger(1, org.bouncycastle.util.a.W(bArr, i10, i12));
    }

    public byte[] d() {
        int iH = h();
        if (iH == 0) {
            return new byte[0];
        }
        int i10 = this.f44758b;
        byte[] bArr = this.f44757a;
        if (i10 > bArr.length - iH) {
            throw new IllegalArgumentException("not enough data for block");
        }
        int i11 = iH + i10;
        this.f44758b = i11;
        return org.bouncycastle.util.a.W(bArr, i10, i11);
    }

    public byte[] e() {
        return f(8);
    }

    public byte[] f(int i10) {
        int i11;
        int iH = h();
        if (iH == 0) {
            return new byte[0];
        }
        int i12 = this.f44758b;
        byte[] bArr = this.f44757a;
        if (i12 > bArr.length - iH) {
            throw new IllegalArgumentException("not enough data for block");
        }
        if (iH % i10 != 0) {
            throw new IllegalArgumentException("missing padding");
        }
        int i13 = i12 + iH;
        this.f44758b = i13;
        if (iH > 0 && (i11 = bArr[i13 - 1] & 255) > 0 && i11 < i10) {
            i13 -= i11;
            int i14 = 1;
            int i15 = i13;
            while (i14 <= i11) {
                if (i14 != (this.f44757a[i15] & 255)) {
                    throw new IllegalArgumentException("incorrect padding");
                }
                i14++;
                i15++;
            }
        }
        return org.bouncycastle.util.a.W(this.f44757a, i12, i13);
    }

    public String g() {
        return Strings.c(d());
    }

    public int h() {
        int i10 = this.f44758b;
        byte[] bArr = this.f44757a;
        if (i10 > bArr.length - 4) {
            throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
        }
        int i11 = i10 + 1;
        this.f44758b = i11;
        int i12 = (bArr[i10] & 255) << 24;
        int i13 = i11 + 1;
        this.f44758b = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 16);
        int i15 = i13 + 1;
        this.f44758b = i15;
        int i16 = i14 | ((bArr[i13] & 255) << 8);
        this.f44758b = i15 + 1;
        return i16 | (bArr[i15] & 255);
    }

    public void i() {
        int iH = h();
        int i10 = this.f44758b;
        if (i10 > this.f44757a.length - iH) {
            throw new IllegalArgumentException("not enough data for block");
        }
        this.f44758b = i10 + iH;
    }
}
