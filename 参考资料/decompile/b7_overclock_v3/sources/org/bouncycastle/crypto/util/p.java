package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f44759a = new ByteArrayOutputStream();

    public byte[] a() {
        return this.f44759a.toByteArray();
    }

    public byte[] b() {
        return c(8);
    }

    public byte[] c(int i10) {
        int size = this.f44759a.size() % i10;
        if (size != 0) {
            int i11 = i10 - size;
            for (int i12 = 1; i12 <= i11; i12++) {
                this.f44759a.write(i12);
            }
        }
        return this.f44759a.toByteArray();
    }

    public void d(int i10) {
        this.f44759a.write((i10 >>> 24) & 255);
        this.f44759a.write((i10 >>> 16) & 255);
        this.f44759a.write((i10 >>> 8) & 255);
        this.f44759a.write(i10 & 255);
    }

    public void e(BigInteger bigInteger) {
        f(bigInteger.toByteArray());
    }

    public void f(byte[] bArr) {
        d(bArr.length);
        try {
            this.f44759a.write(bArr);
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }

    public void g(byte[] bArr) {
        try {
            this.f44759a.write(bArr);
        } catch (IOException e10) {
            throw new IllegalStateException(e10.getMessage(), e10);
        }
    }

    public void h(String str) {
        f(Strings.i(str));
    }
}
