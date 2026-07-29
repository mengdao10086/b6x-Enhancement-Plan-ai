package rp;

import np.w1;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class p implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.b f49027g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f49028h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49029i;

    public p(org.bouncycastle.crypto.b bVar, org.bouncycastle.crypto.s sVar) {
        this.f49027g = bVar;
        this.f49028h = sVar;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49029i = z10;
        np.c cVar = kVar instanceof w1 ? (np.c) ((w1) kVar).a() : (np.c) kVar;
        if (z10 && !cVar.c()) {
            throw new IllegalArgumentException("signing requires private key");
        }
        if (!z10 && cVar.c()) {
            throw new IllegalArgumentException("verification requires public key");
        }
        reset();
        this.f49027g.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        if (this.f49029i) {
            throw new IllegalStateException("GenericSigner not initialised for verification");
        }
        int iH = this.f49028h.h();
        byte[] bArr2 = new byte[iH];
        this.f49028h.c(bArr2, 0);
        try {
            byte[] bArrC = this.f49027g.c(bArr, 0, bArr.length);
            if (bArrC.length < iH) {
                byte[] bArr3 = new byte[iH];
                System.arraycopy(bArrC, 0, bArr3, iH - bArrC.length, bArrC.length);
                bArrC = bArr3;
            }
            return org.bouncycastle.util.a.I(bArrC, bArr2);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() throws DataLengthException, CryptoException {
        if (!this.f49029i) {
            throw new IllegalStateException("GenericSigner not initialised for signature generation.");
        }
        int iH = this.f49028h.h();
        byte[] bArr = new byte[iH];
        this.f49028h.c(bArr, 0);
        return this.f49027g.c(bArr, 0, iH);
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49028h.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49028h.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49028h.update(bArr, i10, i11);
    }
}
