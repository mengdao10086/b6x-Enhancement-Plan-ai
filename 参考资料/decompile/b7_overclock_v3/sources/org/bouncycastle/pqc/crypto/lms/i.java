package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class i implements js.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f45750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f45751b;

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (z10) {
            this.f45750a = (f) kVar;
        } else {
            this.f45751b = (g) kVar;
        }
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        try {
            return c.c(this.f45750a, bArr).getEncoded();
        } catch (IOException e10) {
            throw new IllegalStateException("unable to encode signature: " + e10.getMessage());
        }
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        try {
            g gVar = this.f45751b;
            return c.f(gVar, h.a(bArr2, gVar.e()), bArr);
        } catch (IOException e10) {
            throw new IllegalStateException("unable to decode signature: " + e10.getMessage());
        }
    }
}
