package ls;

import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s f40434a;

    public a(s sVar) {
        this.f40434a = sVar;
    }

    public final void a(byte[] bArr, byte[] bArr2) {
        byte b10 = 0;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = (bArr[i10] & 255) + (bArr2[i10] & 255) + b10;
            bArr[i10] = (byte) i11;
            b10 = (byte) (i11 >> 8);
        }
    }

    public final void b(byte[] bArr) {
        byte b10 = 1;
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int i11 = (bArr[i10] & 255) + b10;
            bArr[i10] = (byte) i11;
            b10 = (byte) (i11 >> 8);
        }
    }

    public byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        this.f40434a.update(bArr, 0, bArr.length);
        byte[] bArr3 = new byte[this.f40434a.h()];
        this.f40434a.c(bArr3, 0);
        a(bArr, bArr3);
        b(bArr);
        return bArr3;
    }
}
