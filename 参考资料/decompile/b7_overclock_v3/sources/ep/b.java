package ep;

import np.y0;
import org.bouncycastle.crypto.f;
import org.bouncycastle.crypto.k;
import org.bouncycastle.util.p;

/* JADX INFO: loaded from: classes5.dex */
public class b extends a {
    public b() {
        this(new cp.a());
    }

    public b(f fVar) {
        super(fVar);
        if (fVar.c() != 16) {
            throw new IllegalArgumentException("base cipher needs to be 128 bits");
        }
        if (p.d(d.f27087a) || p.d(d.f27088b)) {
            throw new UnsupportedOperationException("FF1 encryption disabled");
        }
    }

    @Override // ep.a
    public int a(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        System.arraycopy(this.f27086c.b() > 256 ? a.f(d.o(this.f27084a, this.f27086c.b(), this.f27086c.c(), a.g(bArr), i10, i11 / 2)) : d.n(this.f27084a, this.f27086c.b(), this.f27086c.c(), bArr, i10, i11), 0, bArr2, i12, i11);
        return i11;
    }

    @Override // ep.a
    public int b(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        System.arraycopy(this.f27086c.b() > 256 ? a.f(d.v(this.f27084a, this.f27086c.b(), this.f27086c.c(), a.g(bArr), i10, i11 / 2)) : d.u(this.f27084a, this.f27086c.b(), this.f27086c.c(), bArr, i10, i11), 0, bArr2, i12, i11);
        return i11;
    }

    @Override // ep.a
    public String c() {
        return "FF1";
    }

    @Override // ep.a
    public void d(boolean z10, k kVar) {
        this.f27085b = z10;
        this.f27086c = (y0) kVar;
        this.f27084a.a(!r3.d(), this.f27086c.a());
    }
}
