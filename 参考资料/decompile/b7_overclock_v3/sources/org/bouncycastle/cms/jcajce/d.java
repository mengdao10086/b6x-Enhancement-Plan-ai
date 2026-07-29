package org.bouncycastle.cms.jcajce;

import java.security.PrivateKey;
import javax.crypto.SecretKey;

/* JADX INFO: loaded from: classes5.dex */
public interface d extends org.bouncycastle.jcajce.util.d {
    org.bouncycastle.operator.jcajce.e f(zn.b bVar, PrivateKey privateKey);

    org.bouncycastle.operator.jcajce.i m(zn.b bVar, PrivateKey privateKey, byte[] bArr, byte[] bArr2);

    cs.h0 o(zn.b bVar, SecretKey secretKey);
}
