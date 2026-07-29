package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;
import org.bouncycastle.crypto.m0;

/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f45845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f45846b;

    public e(gm.y yVar, int i10) {
        Objects.requireNonNull(yVar, "digest == null");
        this.f45845a = c.a(yVar);
        this.f45846b = i10;
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = this.f45846b;
        if (length != i10) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i10) {
            return e(0, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i10 = this.f45846b;
        if (length != i10) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == i10 * 2) {
            return e(1, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong in length");
    }

    public byte[] c(byte[] bArr, byte[] bArr2) {
        if (bArr.length == this.f45846b * 3) {
            return e(2, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong key length");
    }

    public byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr.length != this.f45846b) {
            throw new IllegalArgumentException("wrong key length");
        }
        if (bArr2.length == 32) {
            return e(3, bArr, bArr2);
        }
        throw new IllegalArgumentException("wrong address length");
    }

    public final byte[] e(int i10, byte[] bArr, byte[] bArr2) {
        byte[] bArrT = k0.t(i10, this.f45846b);
        this.f45845a.update(bArrT, 0, bArrT.length);
        this.f45845a.update(bArr, 0, bArr.length);
        this.f45845a.update(bArr2, 0, bArr2.length);
        int i11 = this.f45846b;
        byte[] bArr3 = new byte[i11];
        org.bouncycastle.crypto.s sVar = this.f45845a;
        if (sVar instanceof m0) {
            ((m0) sVar).f(bArr3, 0, i11);
        } else {
            sVar.c(bArr3, 0);
        }
        return bArr3;
    }
}
