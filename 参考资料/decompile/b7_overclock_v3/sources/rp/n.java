package rp;

import np.r0;
import np.s0;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.crypto.m0;

/* JADX INFO: loaded from: classes5.dex */
public class n implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m0 f49020g = or.b.h();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f49021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f49022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public r0 f49023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public s0 f49024k;

    public n(byte[] bArr) {
        this.f49021h = org.bouncycastle.util.a.p(bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        this.f49022i = z10;
        if (z10) {
            this.f49023j = (r0) kVar;
            this.f49024k = null;
        } else {
            this.f49023j = null;
            this.f49024k = (s0) kVar;
        }
        reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        s0 s0Var;
        if (this.f49022i || (s0Var = this.f49024k) == null) {
            throw new IllegalStateException("Ed448phSigner not initialised for verification");
        }
        if (114 == bArr.length) {
            return or.b.h0(bArr, 0, s0Var.getEncoded(), 0, this.f49021h, this.f49020g);
        }
        this.f49020g.reset();
        return false;
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        if (!this.f49022i || this.f49023j == null) {
            throw new IllegalStateException("Ed448phSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[64];
        if (64 != this.f49020g.f(bArr, 0, 64)) {
            throw new IllegalStateException("Prehash digest failed");
        }
        byte[] bArr2 = new byte[114];
        this.f49023j.g(1, this.f49021h, bArr, 0, 64, bArr2, 0);
        return bArr2;
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f49020g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f49020g.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f49020g.update(bArr, i10, i11);
    }
}
