package org.bouncycastle.oer;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f45554c = {-128, 64, 32, 16, 8, 4, 2, 1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f45555a = new byte[1];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f45556b = 0;

    public void a() {
        int i10 = this.f45556b;
        this.f45556b = i10 + (i10 % 8);
    }

    public int b(OutputStream outputStream) throws IOException {
        int i10 = this.f45556b;
        int i11 = (i10 + (i10 % 8)) / 8;
        outputStream.write(this.f45555a, 0, i11);
        outputStream.flush();
        return i11;
    }

    public void c(int i10) {
        boolean z10 = false;
        for (int i11 = 4; i11 >= 0; i11--) {
            if (!z10 && ((-33554432) & i10) != 0) {
                z10 = true;
            }
            if (z10) {
                f(i11).h(i10, 32, 7);
            }
            i10 <<= 7;
        }
    }

    public void d(BigInteger bigInteger) {
        int iBitLength = (bigInteger.bitLength() + (bigInteger.bitLength() % 8)) / 8;
        BigInteger bigIntegerShiftLeft = BigInteger.valueOf(254L).shiftLeft(iBitLength * 8);
        boolean z10 = false;
        while (iBitLength >= 0) {
            if (!z10 && bigInteger.and(bigIntegerShiftLeft).compareTo(BigInteger.ZERO) != 0) {
                z10 = true;
            }
            if (z10) {
                f(iBitLength).h(bigInteger.and(bigIntegerShiftLeft).shiftRight(r3 - 8).intValue(), 8, 7);
            }
            bigInteger = bigInteger.shiftLeft(7);
            iBitLength--;
        }
    }

    public int e(OutputStream outputStream) throws IOException {
        int i10 = this.f45556b;
        int i11 = (i10 + (i10 % 8)) / 8;
        outputStream.write(this.f45555a, 0, i11);
        outputStream.flush();
        i();
        return i11;
    }

    public a f(int i10) {
        int i11 = this.f45556b;
        int i12 = i11 / 8;
        byte[] bArr = this.f45555a;
        if (i12 >= bArr.length) {
            byte[] bArr2 = new byte[bArr.length + 4];
            System.arraycopy(bArr, 0, bArr2, 0, i11 / 8);
            org.bouncycastle.util.a.n(this.f45555a);
            this.f45555a = bArr2;
        }
        if (i10 == 0) {
            byte[] bArr3 = this.f45555a;
            int i13 = this.f45556b;
            int i14 = i13 / 8;
            bArr3[i14] = (byte) ((~f45554c[i13 % 8]) & bArr3[i14]);
        } else {
            byte[] bArr4 = this.f45555a;
            int i15 = this.f45556b;
            int i16 = i15 / 8;
            bArr4[i16] = (byte) (f45554c[i15 % 8] | bArr4[i16]);
        }
        this.f45556b++;
        return this;
    }

    public void finalize() throws Throwable {
        i();
        super.finalize();
    }

    public a g(long j10, int i10) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            f(((1 << i11) & j10) > 0 ? 1 : 0);
        }
        return this;
    }

    public a h(long j10, int i10, int i11) {
        for (int i12 = i10 - 1; i12 >= i10 - i11; i12--) {
            f(((1 << i12) & j10) != 0 ? 1 : 0);
        }
        return this;
    }

    public void i() {
        org.bouncycastle.util.a.n(this.f45555a);
        this.f45556b = 0;
    }
}
