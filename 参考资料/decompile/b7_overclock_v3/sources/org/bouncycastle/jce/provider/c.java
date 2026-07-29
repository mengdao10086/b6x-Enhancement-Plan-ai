package org.bouncycastle.jce.provider;

import np.m1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.crypto.q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.s f45405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f45406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f45407c;

    public c(org.bouncycastle.crypto.s sVar) {
        this.f45405a = sVar;
    }

    @Override // org.bouncycastle.crypto.q
    public void a(org.bouncycastle.crypto.r rVar) {
        if (!(rVar instanceof m1)) {
            throw new IllegalArgumentException("KDF parameters required for generator");
        }
        m1 m1Var = (m1) rVar;
        this.f45406b = m1Var.b();
        this.f45407c = m1Var.a();
    }

    @Override // org.bouncycastle.crypto.q
    public int b(byte[] bArr, int i10, int i11) throws DataLengthException, IllegalArgumentException {
        if (bArr.length - i11 < i10) {
            throw new OutputLengthException("output buffer too small");
        }
        long j10 = ((long) i11) * 8;
        if (j10 > ((long) this.f45405a.h()) * 8 * 2147483648L) {
            throw new IllegalArgumentException("Output length too large");
        }
        int iH = (int) (j10 / ((long) this.f45405a.h()));
        int iH2 = this.f45405a.h();
        byte[] bArr2 = new byte[iH2];
        for (int i12 = 1; i12 <= iH; i12++) {
            org.bouncycastle.crypto.s sVar = this.f45405a;
            byte[] bArr3 = this.f45406b;
            sVar.update(bArr3, 0, bArr3.length);
            this.f45405a.update((byte) (i12 & 255));
            this.f45405a.update((byte) ((i12 >> 8) & 255));
            this.f45405a.update((byte) ((i12 >> 16) & 255));
            this.f45405a.update((byte) ((i12 >> 24) & 255));
            org.bouncycastle.crypto.s sVar2 = this.f45405a;
            byte[] bArr4 = this.f45407c;
            sVar2.update(bArr4, 0, bArr4.length);
            this.f45405a.c(bArr2, 0);
            int i13 = i11 - i10;
            if (i13 > iH2) {
                System.arraycopy(bArr2, 0, bArr, i10, iH2);
                i10 += iH2;
            } else {
                System.arraycopy(bArr2, 0, bArr, i10, i13);
            }
        }
        this.f45405a.reset();
        return i11;
    }

    public org.bouncycastle.crypto.s c() {
        return this.f45405a;
    }
}
