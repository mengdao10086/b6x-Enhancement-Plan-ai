package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes5.dex */
public class b extends org.bouncycastle.jcajce.util.c implements d {
    @Override // org.bouncycastle.cms.jcajce.d
    public org.bouncycastle.operator.jcajce.e f(zn.b bVar, PrivateKey privateKey) {
        return new org.bouncycastle.operator.jcajce.e(bVar, a.a(privateKey));
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public org.bouncycastle.operator.jcajce.i m(zn.b bVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2) {
        return new org.bouncycastle.operator.jcajce.i(bVar, a.a(privateKey), bArr, bArr2);
    }

    @Override // org.bouncycastle.cms.jcajce.d
    public cs.h0 o(zn.b bVar, SecretKey secretKey) {
        return new org.bouncycastle.operator.jcajce.k(bVar, secretKey);
    }
}
