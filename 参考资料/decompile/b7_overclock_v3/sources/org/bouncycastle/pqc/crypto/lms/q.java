package org.bouncycastle.pqc.crypto.lms;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class q extends org.bouncycastle.crypto.y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f45773c;

    public q(t tVar, SecureRandom secureRandom) {
        super(secureRandom, a0.c(tVar));
        this.f45773c = tVar;
    }

    public t c() {
        return this.f45773c;
    }
}
