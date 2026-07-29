package org.bouncycastle.crypto;

import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f44662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f44663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f44664c;

    public static byte[] a(char[] cArr) {
        if (cArr == null || cArr.length <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[(cArr.length + 1) * 2];
        for (int i10 = 0; i10 != cArr.length; i10++) {
            int i11 = i10 * 2;
            bArr[i11] = (byte) (cArr[i10] >>> '\b');
            bArr[i11 + 1] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static byte[] b(char[] cArr) {
        if (cArr == null) {
            return new byte[0];
        }
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 != length; i10++) {
            bArr[i10] = (byte) cArr[i10];
        }
        return bArr;
    }

    public static byte[] c(char[] cArr) {
        return cArr != null ? Strings.n(cArr) : new byte[0];
    }

    public abstract k d(int i10);

    public abstract k e(int i10);

    public abstract k f(int i10, int i11);

    public int g() {
        return this.f44664c;
    }

    public byte[] h() {
        return this.f44662a;
    }

    public byte[] i() {
        return this.f44663b;
    }

    public void j(byte[] bArr, byte[] bArr2, int i10) {
        this.f44662a = bArr;
        this.f44663b = bArr2;
        this.f44664c = i10;
    }
}
