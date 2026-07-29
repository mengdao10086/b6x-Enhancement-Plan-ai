package org.bouncycastle.pqc.crypto.lms;

import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class y implements js.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f45800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f45801b;

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (z10) {
            this.f45800a = (u) kVar;
        } else {
            this.f45801b = (v) kVar;
        }
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        try {
            return m.c(this.f45800a, bArr).getEncoded();
        } catch (IOException e10) {
            throw new IllegalStateException("unable to encode signature: " + e10.getMessage());
        }
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        try {
            return m.e(this.f45801b, w.a(bArr2), bArr);
        } catch (IOException e10) {
            throw new IllegalStateException("unable to decode signature: " + e10.getMessage());
        }
    }
}
