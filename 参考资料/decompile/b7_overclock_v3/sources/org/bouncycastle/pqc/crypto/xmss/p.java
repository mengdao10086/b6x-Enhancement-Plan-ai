package org.bouncycastle.pqc.crypto.xmss;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public final class p extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f45936c;

    public p(d0 d0Var, SecureRandom secureRandom) {
        super(secureRandom, -1);
        this.f45936c = d0Var;
    }

    public d0 c() {
        return this.f45936c;
    }
}
