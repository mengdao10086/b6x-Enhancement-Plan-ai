package ip;

import np.n1;
import org.bouncycastle.crypto.a0;

/* JADX INFO: loaded from: classes5.dex */
public class a implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zo.d f35466a;

    public a(zo.d dVar) {
        this.f35466a = dVar;
    }

    @Override // org.bouncycastle.crypto.a0
    public void a(org.bouncycastle.crypto.k kVar) {
        org.bouncycastle.crypto.k kVarE = kVar instanceof n1 ? np.d.e(((n1) kVar).a()) : kVar;
        if (!(kVarE instanceof np.d)) {
            throw new IllegalArgumentException("Invalid parameter passed to Blake3Mac init - " + kVar.getClass().getName());
        }
        np.d dVar = (np.d) kVarE;
        if (dVar.d() == null) {
            throw new IllegalArgumentException("Blake3Mac requires a key parameter.");
        }
        this.f35466a.p(dVar);
    }

    @Override // org.bouncycastle.crypto.a0
    public String b() {
        return this.f35466a.b() + "Mac";
    }

    @Override // org.bouncycastle.crypto.a0
    public int c(byte[] bArr, int i10) {
        return this.f35466a.c(bArr, i10);
    }

    @Override // org.bouncycastle.crypto.a0
    public int d() {
        return this.f35466a.h();
    }

    @Override // org.bouncycastle.crypto.a0
    public void reset() {
        this.f35466a.reset();
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte b10) {
        this.f35466a.update(b10);
    }

    @Override // org.bouncycastle.crypto.a0
    public void update(byte[] bArr, int i10, int i11) {
        this.f35466a.update(bArr, i10, i11);
    }
}
