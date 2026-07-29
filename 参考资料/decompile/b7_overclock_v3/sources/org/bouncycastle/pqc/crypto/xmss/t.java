package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public final class t extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w f45949c;

    public t(w wVar, SecureRandom secureRandom) {
        super(secureRandom, -1);
        this.f45949c = wVar;
    }

    public w c() {
        return this.f45949c;
    }
}
