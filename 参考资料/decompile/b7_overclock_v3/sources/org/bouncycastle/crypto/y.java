package org.bouncycastle.crypto;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SecureRandom f44769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f44770b;

    public y(SecureRandom secureRandom, int i10) {
        this.f44769a = n.g(secureRandom);
        this.f44770b = i10;
    }

    public SecureRandom a() {
        return this.f44769a;
    }

    public int b() {
        return this.f44770b;
    }
}
