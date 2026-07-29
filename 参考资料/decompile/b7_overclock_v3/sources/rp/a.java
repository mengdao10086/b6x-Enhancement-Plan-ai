package rp;

import java.math.BigInteger;
import np.w1;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.o f48966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f48967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f48968i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f48969j;

    public a(org.bouncycastle.crypto.o oVar, org.bouncycastle.crypto.s sVar) {
        this.f48966g = oVar;
        this.f48967h = sVar;
        this.f48968i = z.f49116a;
    }

    public a(org.bouncycastle.crypto.p pVar, org.bouncycastle.crypto.s sVar, b bVar) {
        this.f48966g = pVar;
        this.f48967h = sVar;
        this.f48968i = bVar;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f48969j = z10;
        np.c cVar = kVar instanceof w1 ? (np.c) ((w1) kVar).a() : (np.c) kVar;
        if (z10 && !cVar.c()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        }
        if (!z10 && cVar.c()) {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
        reset();
        this.f48966g.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        if (this.f48969j) {
            throw new IllegalStateException("DSADigestSigner not initialised for verification");
        }
        byte[] bArr2 = new byte[this.f48967h.h()];
        this.f48967h.c(bArr2, 0);
        try {
            BigInteger[] bigIntegerArrA = this.f48968i.a(g(), bArr);
            return this.f48966g.c(bArr2, bigIntegerArrA[0], bigIntegerArrA[1]);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        if (!this.f48969j) {
            throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[this.f48967h.h()];
        this.f48967h.c(bArr, 0);
        BigInteger[] bigIntegerArrB = this.f48966g.b(bArr);
        try {
            return this.f48968i.b(g(), bigIntegerArrB[0], bigIntegerArrB[1]);
        } catch (Exception unused) {
            throw new IllegalStateException("unable to encode signature");
        }
    }

    public BigInteger g() {
        org.bouncycastle.crypto.o oVar = this.f48966g;
        if (oVar instanceof org.bouncycastle.crypto.p) {
            return ((org.bouncycastle.crypto.p) oVar).getOrder();
        }
        return null;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f48967h.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f48967h.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f48967h.update(bArr, i10, i11);
    }
}
