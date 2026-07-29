package ep;

import np.n1;
import np.y0;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.k;
import org.bouncycastle.util.p;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a {
    public c() {
        this(new cp.a());
    }

    public c(f fVar) {
        super(fVar);
        if (fVar.c() != 16) {
            throw new IllegalArgumentException("base cipher needs to be 128 bits");
        }
        if (p.d(d.f27087a)) {
            throw new UnsupportedOperationException("FPE disabled");
        }
    }

    @Override // ep.a
    public int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        System.arraycopy(this.f27086c.b() > 256 ? a.f(d.r(this.f27084a, this.f27086c.b(), this.f27086c.c(), a.g(bArr), i10, i11 / 2)) : d.q(this.f27084a, this.f27086c.b(), this.f27086c.c(), bArr, i10, i11), 0, bArr2, i12, i11);
        return i11;
    }

    @Override // ep.a
    public int b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        System.arraycopy(this.f27086c.b() > 256 ? a.f(d.y(this.f27084a, this.f27086c.b(), this.f27086c.c(), a.g(bArr), i10, i11 / 2)) : d.x(this.f27084a, this.f27086c.b(), this.f27086c.c(), bArr, i10, i11), 0, bArr2, i12, i11);
        return i11;
    }

    @Override // ep.a
    public String c() {
        return "FF3-1";
    }

    @Override // ep.a
    public void d(boolean z10, k kVar) {
        this.f27085b = z10;
        this.f27086c = (y0) kVar;
        this.f27084a.a(!r4.d(), new n1(org.bouncycastle.util.a.L0(this.f27086c.a().a())));
        if (this.f27086c.c().length != 7) {
            throw new IllegalArgumentException("tweak should be 56 bits");
        }
    }
}
