package rp;

import np.o0;
import np.p0;
import org.bouncycastle.crypto.e0;

/* JADX INFO: loaded from: classes5.dex */
public class l implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final org.bouncycastle.crypto.s f49010g = or.a.i();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f49011h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49012i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o0 f49013j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p0 f49014k;

    public l(byte[] bArr) {
        this.f49011h = org.bouncycastle.util.a.p(bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49012i = z10;
        if (z10) {
            this.f49013j = (o0) kVar;
            this.f49014k = null;
        } else {
            this.f49013j = null;
            this.f49014k = (p0) kVar;
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        p0 p0Var;
        if (this.f49012i || (p0Var = this.f49014k) == null) {
            throw new IllegalStateException("Ed25519phSigner not initialised for verification");
        }
        if (64 == bArr.length) {
            return or.a.s0(bArr, 0, p0Var.getEncoded(), 0, this.f49011h, this.f49010g);
        }
        this.f49010g.reset();
        return false;
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        if (!this.f49012i || this.f49013j == null) {
            throw new IllegalStateException("Ed25519phSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[64];
        if (64 != this.f49010g.c(bArr, 0)) {
            throw new IllegalStateException("Prehash digest failed");
        }
        byte[] bArr2 = new byte[64];
        this.f49013j.g(2, this.f49011h, bArr, 0, 64, bArr2, 0);
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49010g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49010g.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49010g.update(bArr, i10, i11);
    }
}
