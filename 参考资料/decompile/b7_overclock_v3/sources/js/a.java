package js;

import np.w1;
import org.bouncycastle.crypto.e0;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class a implements e0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final s f36907g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f36908h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f36909i;

    public a(f fVar, s sVar) {
        this.f36908h = fVar;
        this.f36907g = sVar;
    }

    @Override // org.bouncycastle.crypto.e0
    public void a(boolean z10, k kVar) {
        this.f36909i = z10;
        np.c cVar = kVar instanceof w1 ? (np.c) ((w1) kVar).a() : (np.c) kVar;
        if (z10 && !cVar.c()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        }
        if (!z10 && cVar.c()) {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
        reset();
        this.f36908h.a(z10, kVar);
    }

    @Override // org.bouncycastle.crypto.e0
    public boolean d(byte[] bArr) {
        if (this.f36909i) {
            throw new IllegalStateException("DigestingMessageSigner not initialised for verification");
        }
        byte[] bArr2 = new byte[this.f36907g.h()];
        this.f36907g.c(bArr2, 0);
        return this.f36908h.d(bArr2, bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public byte[] e() {
        if (!this.f36909i) {
            throw new IllegalStateException("DigestingMessageSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[this.f36907g.h()];
        this.f36907g.c(bArr, 0);
        return this.f36908h.b(bArr);
    }

    @Override // org.bouncycastle.crypto.e0
    public void reset() {
        this.f36907g.reset();
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte b10) {
        this.f36907g.update(b10);
    }

    @Override // org.bouncycastle.crypto.e0
    public void update(byte[] bArr, int i10, int i11) {
        this.f36907g.update(bArr, i10, i11);
    }
}
