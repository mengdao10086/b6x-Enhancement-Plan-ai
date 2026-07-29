package org.bouncycastle.cms.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import so.a1;

/* JADX INFO: loaded from: classes5.dex */
public class s extends a1 {
    public s(mm.z zVar, SecretKey secretKey) {
        super(zVar, new org.bouncycastle.operator.jcajce.l(secretKey));
    }

    public s(byte[] bArr, SecretKey secretKey) {
        this(new mm.z(bArr, null, null), secretKey);
    }

    public s b(String str) {
        ((org.bouncycastle.operator.jcajce.l) this.f50060b).e(str);
        return this;
    }

    public s c(Provider provider) {
        ((org.bouncycastle.operator.jcajce.l) this.f50060b).f(provider);
        return this;
    }

    public s d(SecureRandom secureRandom) {
        ((org.bouncycastle.operator.jcajce.l) this.f50060b).g(secureRandom);
        return this;
    }
}
