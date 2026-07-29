package cp;

import np.w1;
import np.z1;
import org.bouncycastle.crypto.InvalidCipherTextException;

/* JADX INFO: loaded from: classes5.dex */
public class a0 implements org.bouncycastle.crypto.l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f25171a = new z();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ip.j f25172b = new ip.j();

    @Override // org.bouncycastle.crypto.l0
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (kVar instanceof w1) {
            kVar = ((w1) kVar).a();
        }
        z1 z1Var = (z1) kVar;
        this.f25171a.a(z10, z1Var.a());
        this.f25172b.a(new np.v1(z1Var.a(), z1Var.b()));
    }

    @Override // org.bouncycastle.crypto.l0
    public String b() {
        return "GOST28147Wrap";
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] c(byte[] bArr, int i10, int i11) throws InvalidCipherTextException {
        int iD = i11 - this.f25172b.d();
        byte[] bArr2 = new byte[iD];
        this.f25171a.d(bArr, i10, bArr2, 0);
        this.f25171a.d(bArr, i10 + 8, bArr2, 8);
        this.f25171a.d(bArr, i10 + 16, bArr2, 16);
        this.f25171a.d(bArr, i10 + 24, bArr2, 24);
        byte[] bArr3 = new byte[this.f25172b.d()];
        this.f25172b.update(bArr2, 0, iD);
        this.f25172b.c(bArr3, 0);
        byte[] bArr4 = new byte[this.f25172b.d()];
        System.arraycopy(bArr, (i10 + i11) - 4, bArr4, 0, this.f25172b.d());
        if (org.bouncycastle.util.a.I(bArr3, bArr4)) {
            return bArr2;
        }
        throw new IllegalStateException("mac mismatch");
    }

    @Override // org.bouncycastle.crypto.l0
    public byte[] d(byte[] bArr, int i10, int i11) {
        this.f25172b.update(bArr, i10, i11);
        byte[] bArr2 = new byte[this.f25172b.d() + i11];
        this.f25171a.d(bArr, i10, bArr2, 0);
        this.f25171a.d(bArr, i10 + 8, bArr2, 8);
        this.f25171a.d(bArr, i10 + 16, bArr2, 16);
        this.f25171a.d(bArr, i10 + 24, bArr2, 24);
        this.f25172b.c(bArr2, i11);
        return bArr2;
    }
}
