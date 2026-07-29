package org.bouncycastle.pqc.crypto.lms;

import java.util.Objects;

/* JADX INFO: loaded from: classes6.dex */
public class a0 {
    public static void a(byte[] bArr, int i10, int i11, org.bouncycastle.crypto.s sVar) {
        sVar.update(bArr, i10, i11);
    }

    public static void b(byte[] bArr, org.bouncycastle.crypto.s sVar) {
        sVar.update(bArr, 0, bArr.length);
    }

    public static int c(t tVar) {
        Objects.requireNonNull(tVar, "lmsParameters cannot be null");
        LMSigParameters lMSigParametersB = tVar.b();
        return (1 << lMSigParametersB.c()) * lMSigParametersB.d();
    }

    public static void d(short s10, org.bouncycastle.crypto.s sVar) {
        sVar.update((byte) (s10 >>> 8));
        sVar.update((byte) s10);
    }

    public static void e(int i10, org.bouncycastle.crypto.s sVar) {
        sVar.update((byte) (i10 >>> 24));
        sVar.update((byte) (i10 >>> 16));
        sVar.update((byte) (i10 >>> 8));
        sVar.update((byte) i10);
    }
}
