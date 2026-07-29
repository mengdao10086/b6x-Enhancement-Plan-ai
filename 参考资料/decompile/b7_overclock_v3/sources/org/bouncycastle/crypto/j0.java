package org.bouncycastle.crypto;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j0 implements f, k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f44689a;

    public j0(f fVar) {
        this.f44689a = fVar;
    }

    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws DataLengthException {
        int i13 = i10 + i11;
        if (i13 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        }
        if (i12 + i11 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        while (i10 < i13) {
            bArr2[i12] = h(bArr[i10]);
            i12++;
            i10++;
        }
        return i11;
    }

    @Override // org.bouncycastle.crypto.k0
    public final byte f(byte b10) {
        return h(b10);
    }

    public abstract byte h(byte b10);

    public f i() {
        return this.f44689a;
    }
}
