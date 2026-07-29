package org.bouncycastle.cms.jcajce;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class o0 implements l0 {
    @Override // org.bouncycastle.cms.jcajce.l0
    public byte[] a(zn.b bVar, int i10, byte[] bArr) {
        try {
            return new nm.a(bVar, bArr, org.bouncycastle.util.o.k(i10)).v(gm.j.f29713a);
        } catch (IOException e10) {
            throw new IllegalStateException("Unable to create KDF material: " + e10);
        }
    }
}
